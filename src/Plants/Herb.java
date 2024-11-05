package Plants;

import java.util.Objects;

public class Herb extends Plant{
    private boolean isEdible;
    private String tasteNotes;

    /**
     * Construct a Plant subclass
     *
     * @param name      name of the Plant
     * @param latinName latin name of the Plant
     * @param range     size range of the plant [minSize, maxSize]
     */
    public Herb(String name, String latinName, int[] range) {
        super(name, latinName, range);
    }

    /**
     * Set edibility data of the Herb object
     * @param isEdible boolean to set whether the Herb is edible
     * @param tasteNotes String that holds taste information about the Herb
     */
    public void setEdibility(boolean isEdible, String tasteNotes) {
        this.isEdible = isEdible;
        this.tasteNotes = tasteNotes;
    }

    /**
     * convert the Herb class into an output representable Object
     * @return String a string that displays info about the Herb class
     */
    @Override
    public String toString() {
        String baseString = "";

        if (isEdible) {
            baseString += "This plant is safe to eat. ";
        } else {
            baseString += "This plant is NOT safe to eat. ";
        }

        return super.toString() + baseString + tasteNotes + "\n";
    }

    /**
     * check whether the Herb is edible
     * @return boolean whether the Herb is edible
     */
    public boolean isEdible() {
        return isEdible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Herb herb = (Herb) o;
        return isEdible == herb.isEdible && Objects.equals(tasteNotes, herb.tasteNotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isEdible, tasteNotes);
    }
}
