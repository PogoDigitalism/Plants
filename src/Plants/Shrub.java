package Plants;

public class Shrub extends Plant{
    /**
     * Construct a Plant subclass
     *
     * @param name      name of the Plant
     * @param latinName latin name of the Plant
     * @param range     size range of the plant [minSize, maxSize]
     */
    public Shrub(String name, String latinName, int[] range) {
        super(name, latinName, range);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
