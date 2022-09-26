package genericmapper;

import java.util.Objects;

/**
 * Simple key object pair to help mappings. Candidate record from Java >= 16.
 *
 * @author Pieter van den Hombergh {@code pieter.van.den.hombergh@gmail.com}
 */
public class FieldPair {

    private final String key;
    private final Object value;

    public FieldPair(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String key() {
        return key;
    }

    public Object value() {
        return value;//        var expectedStream = 
    }

    /**
     * Is value null. To filter.
     *
     * @return null-ness
     */
    public boolean hasNullValue() {
        return null == value;
    }

    /**
     * Hash code based on key only.
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.key);
        return hash;
    }

    /**
     * Equals based on key only
     *
     * @param obj other
     * @return true if this.key==other.key
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FieldPair other = (FieldPair) obj;
        return Objects.equals(this.key, other.key);
    }


    @Override
    public String toString() {
        return "FieldPair{" + "key=" + key + ", value=" + value
                + " ("
                + ((value != null) ? value.getClass().getName() : "?") + ")"
                + '}';
    }

}
