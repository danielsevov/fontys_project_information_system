package businesslogic;

import businessentitiesapi.Entity;
import businesslogic.testutils.ManagerFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import persistence.dao.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * @author Nils Theres {@code n.theres@student.fontys.nl}
 */
@ExtendWith(MockitoExtension.class)
abstract class ManagerTestBase<M extends ManagerImplBase<T>, T extends Entity> {
    @Mock
    DAO<T, Integer> dao;
    @Spy
    Map<Integer, T> cache = new HashMap<>();
    ManagerFactory<M, T> factory;

    /**
     * Retrieve a {@link ManagerFactory} for this test.
     *
     * @return the manager factory
     */
    final ManagerFactory<M, T> helper() {
        if (factory == null) {
            factory = new ManagerFactory<>(this::entityCreator) {
                @Override
                public M createManager() {
                    return managerCreator();
                }
            };
        }
        return factory;
    }

    /**
     * Create a new entity with an id.
     *
     * @param id the id of the new entity.
     * @return the new entity instance
     */
    abstract T entityCreator(int id);

    /**
     * Create a new manager instance for this test.
     *
     * @return the new manager instance
     */
    abstract M managerCreator();

    /**
     * Get the first entity from the factory.
     *
     * @return the first entity
     */
    T firstEntity() {
        return helper().getFirstEntity();
    }

    /**
     * Get all test values.
     *
     * @return all test values
     */
    List<T> allValues() {
        return helper().getTestValues();
    }

    /**
     * Get the current manager for this test.
     *
     * @return the current manager
     */
    M getManager() {
        return helper().createManager(cache, dao);
    }

    @Test
    void testGetInMap() {
        cache.put(0, firstEntity());
        var got = getManager().get(0);
        assertThat(got).get().isEqualTo(firstEntity());
    }

    @Test
    void testGetNotInMap() {
        when(dao.get(0)).thenReturn(Optional.of(firstEntity()));
        var got = getManager().get(0);
        verify(dao).get(0);
        verify(cache).put(0, firstEntity());
        assertThat(got).get().isEqualTo(firstEntity());
    }

    @Test
    void testGetByColumnValues() {
        var answer = allValues().subList(1, 3);
        when(dao.getByColumnValues("test", "test")).thenReturn(answer);
        var got = getManager().getByColumnValues("test", "test");
        verify(dao).getByColumnValues("test", "test");
        verify(cache, times(2)).put(anyInt(), any());
        assertThat(got).isEqualTo(answer);
    }

    @Test
    void testGetAllInMap() {
        allValues().forEach(v -> cache.put(v.getId(), v));
        var got = getManager().getAll();
        verify(dao, never()).getAll();
        assertThat(got).isEqualTo(allValues());
    }

    @Test
    void testGetAllNotInMap() {
        when(dao.getAll()).thenReturn(allValues());
        var got = getManager().getAll();
        verify(dao).getAll();
        verify(cache, times(allValues().size())).put(anyInt(), any());
        assertThat(got).isEqualTo(allValues());
    }

    @Test
    void testSave() {
        when(dao.save(firstEntity())).thenReturn(Optional.of(firstEntity()));
        var got = getManager().save(firstEntity());
        verify(cache).put(firstEntity().getId(), firstEntity());
        assertThat(got).get().isEqualTo(firstEntity());
    }

    @Test
    void testUpdate() {
        // 'Update' the first entity.
        var updatedEntity = helper().createEntityWithId(0);
        when(dao.update(firstEntity())).thenReturn(updatedEntity);
        var got = getManager().update(firstEntity());
        verify(cache).put(0, updatedEntity);
        // hard instance check to bypass T.equals
        assertThat(got).isSameAs(updatedEntity);
    }

    @Test
    void testDeleteEntity() {
        cache.put(firstEntity().getId(), firstEntity());
        getManager().deleteEntity(firstEntity());
        verify(cache).remove(firstEntity().getId());
        assertThat(cache.containsKey(firstEntity().getId())).isFalse();
    }

    @Test
    void testDeleteById() {
        cache.put(firstEntity().getId(), firstEntity());
        getManager().deleteById(firstEntity().getId());
        verify(cache).remove(firstEntity().getId());
        assertThat(cache.containsKey(firstEntity().getId())).isFalse();
    }


    @Test
    void testSaveAllVarArg() {
        var all = allValues();
        var subList = all.subList(0, 2);
        when(dao.saveAll(all.get(0), all.get(1), all.get(2))).thenAnswer(i -> subList);
        var got = getManager().saveAll(all.get(0), all.get(1), all.get(2));
        verify(cache, times(subList.size())).put(anyInt(), any());
        assertThat(got).isEqualTo(subList);
    }

    @Test
    void testSaveAllList() {
        var all = allValues();
        when(dao.saveAll(all)).thenAnswer(i -> all);
        var got = getManager().saveAll(all);
        verify(cache, times(all.size())).put(anyInt(), any());
        assertThat(got).isEqualTo(got);
    }


    @Test
    void testDeleteAllVarArg() {
        var subList = allValues().subList(0, 2);
        subList.forEach(v -> cache.put(v.getId(), v));
        getManager().deleteAll(subList.get(0), subList.get(1));
        verify(cache, times(2)).remove(anyInt());
    }

    @Test
    void testDeleteAllList() {
        var subList = allValues().subList(0, 2);
        subList.forEach(v -> cache.put(v.getId(), v));
        getManager().deleteAll(subList);
        verify(cache, times(2)).remove(anyInt());
        assertThat(cache.isEmpty()).isTrue();
    }

    @Test
    void testAnyQuery() {
        when(dao.anyQuery("test", "test")).thenReturn(allValues());
        var got = getManager().anyQuery("test", "test");
        verify(cache, times(allValues().size())).put(anyInt(), any());
        assertThat(got).isEqualTo(allValues());
    }


    @Test
    void testGetAllMatching() {
        allValues().forEach(v -> cache.put(v.getId(), v));
        var got = getManager().getAllMatching(v -> v.getId() > 0);
        assertThat(got).isEqualTo(allValues().subList(1, 10));
    }

    @Test
    void testUpdateColumnFor() {
        var updatedEntity = helper().createEntityWithId(0);
        when(dao.updateColumn(firstEntity(), "test", "test")).thenReturn(updatedEntity);
        var got = getManager().updateColumnFor(firstEntity(), "test", "test");
        verify(cache).put(0, updatedEntity);
        // hard instance check to bypass T.equals
        assertThat(got).isSameAs(updatedEntity);
    }

    @ParameterizedTest
    @CsvSource({
            "Hiii,hi,true",
            "Hi,Hi,true",
            "Hi,Ho,false",
            "Hi,hi,true",
            "Hello,ll,true",
            "Hello there,there,true",
            "Hello,no,false"
    })
    void testFindMatch(String source, String searchTerm, boolean expectedResult) {
        var result = getManager().findMatch(source, searchTerm);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testSearch() {
        allValues().forEach(v -> cache.put(v.getId(), v));
        // All managers support searching by ID.
        var got = getManager().search("This should never return anything");
        assertThat(got).isEmpty();
    }
}
