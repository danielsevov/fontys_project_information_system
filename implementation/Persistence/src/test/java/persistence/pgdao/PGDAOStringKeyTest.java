package persistence.pgdao;


import entities.Company;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.dao.DAO;

import javax.sql.DataSource;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

/**
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public class PGDAOStringKeyTest extends DBTestHelpers {

    @BeforeAll
    static void checkDataSource() {
        DataSource ds = PGJDBCUtils.getTestDataSource("test_db");
        assumeThat(ds).isNotNull();
    }

    DAO<Company, String> cDao;

    @BeforeEach
    public void setup() {
        loadDatabase();
        cDao = daof.createDao(Company.class);

    }

    Company intel = new Company("INTC", "Intel", "USA", "Santa Clara",
            "2200 Mission College Blvd", "CA 95052");
    Company amd = new Company("AMD", "Advanced Micro Devices", "USA",
            "Santa Clara",
            "2485 Augustine Drive", "CA 95054");

    Company fontys = new Company("FNTS", "Fontys Hogescholen", "Netherlands",
            "Venlo", "Tegelseweg 255", "5912 BG");

    @Test
    public void testSave() {

        int size = cDao.size();
        Company savedC = cDao.save(intel).get();
        int size2 = cDao.size();

        assertThat(size2).as("added").isEqualTo(size + 1);
        assertThat(savedC.getName()).isEqualTo(intel.getName());
    }

    @Test
    public void testDelete() {
        int size = cDao.size();
        Company savedC = cDao.save(amd).get();
        int size2 = cDao.size();
        cDao.deleteEntity(savedC);
        int size3 = cDao.size();

        assertThat(size + 1 == size2 && size == size3).as("in and gone").isTrue();
    }

    @Test
    public void testUpdate() {
        Company sFontys = cDao.save(fontys).get();

        sFontys.setAddress("Hulsterweg 6");
        sFontys.setPostcode("5912 PL");

        cDao.update(sFontys);

        Company dFontys = cDao.get(cDao.extractId(sFontys)).get();

        assertThat(dFontys.getPostcode()).isEqualTo(sFontys.getPostcode());
        Collection<Company> all = cDao.getAll();
        assertThat(all.isEmpty()).isFalse();
    }

    @Test
    public void testSanityAnCoverage() {
        assertThat(cDao.toString().isEmpty()).isFalse();
        assertThat(cDao.size()).isEqualTo(0);
    }
}
