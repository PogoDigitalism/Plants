package Plants;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public abstract class Plant {
    private String name;
    private String latinName;
    private int[] range;

    private boolean hasFlowers;
    private Flower flower;

    /**
     * Construct a Plant subclass
     * @param name name of the Plant
     * @param latinName latin name of the Plant
     * @param range size range of the plant [minSize, maxSize]
     */
    public Plant(String name, String latinName, int[] range) {
        this.name = name;
        this.latinName = latinName;
        this.range = range;
    }

    /**
     * Increases the size range of the plants
     * @param factor the factor by how much to increase the range. Must be >= 1.0
     * @return return the Plant as object
     */
    public Plant increaseRange(double factor) {
        this.range[0] = (int) Math.round((double) this.range[0] * factor);
        this.range[1] = (int) Math.round((double) this.range[1] * factor);

        return this;
    }

    /**
     * Read the data of the info chunk for a single plant and turn it into an Object
     * @param scanner scanner that must have the info string chunk as its content
     * @return a subclass of Plant that matches the identifier in the info chunk
     */
    public static Plant read(Scanner scanner) {
        String[] baseInfo = scanner.nextLine().split("; ");
        String[] metaInfo = baseInfo[0].split(": ");
        PlantType plantType = PlantType.valueOf(metaInfo[0]);
        String name = metaInfo[1];
        String latinName = baseInfo[1];

        String[] strSizeRange = baseInfo[2].replace("(", "").replace(")", "").split(", ");
        int[] sizeRange = new int[2];
        for (int i = 0; i < strSizeRange.length; i++) {
            sizeRange[i] = Integer.parseInt(strSizeRange[i]);
        }

        Plant plant = null;
        switch (plantType) {
            case HERB:
                plant = new Herb(name, latinName, sizeRange);
                break;
            case TREE:
                plant = new Tree(name, latinName, sizeRange);
                break;
            case SHRUB:
                plant = new Shrub(name, latinName, sizeRange);
                break;
        }

        scanner.useDelimiter("\\r?\\n(?=FLOWER DETAILS|EDIBILITY)");
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (next.contains("FLOWER DETAILS")) {
                String[] parsedFlowerInfo = next
                        .replace("FLOWER DETAILS: ", "")
                        .split("; ");
                int petals = Integer.parseInt(parsedFlowerInfo[2].replace(" petals", ""));
                plant.setFlower(new Flower(parsedFlowerInfo[0], parsedFlowerInfo[1], petals));
            } else { // it must be EDIBILITY in this case
                String[] edibilityInfo = next.split("; ");
                String strIsEdible = edibilityInfo[0].split(": ")[1];
                Herb herb = (Herb) plant; // can never produce a ClassCastException
                herb.setEdibility(strIsEdible.equals("Yes"), edibilityInfo[1]);
            }
        }
        return plant;
    }

    /**
     * get the name of the plant
     * @return name of the plant represented in a string
     */
    public String getName() {
        return name;
    }

    /**
     * get the latin name of the plant
     * @return latin name of the plant represented in a string
     */
    public String getLatinName() {
        return latinName;
    }

    /**
     * get the size range of the plant
     * @return int array of length 2 [minSize, maxSize]
     */
    public int[] getRange() {
        return range;
    }

    /**
     * use in combination with the method hasFlowers, get the flower
     * @return returns null if it has no flowers
     */
    public Flower getFlower() {
        return flower;
    }

    /**
     * set the Flower object for this Plant, sets hasFlowers to true
     */
    public void setFlower(Flower flower) {
        this.hasFlowers = true;
        this.flower = flower;
    }

    /**
     * does the plant have flowers
     * @return boolean whether the plant has flowers or not
     */
    public boolean hasFlowers() {
        return hasFlowers;
    }

    /**
     * convert the Plant class into an output representable Object
     * @return String a string that displays info about the Plant class
     */
    @Override
    public String toString() {
        String className = getClass().getSimpleName();

        String baseString = className +
                " named " + name + " (latin: " + latinName + "), typical size between " +
                range[0] + "cm and " + range[1] + "cm.\n";

        if (hasFlowers) {
            baseString += "This plant has " + flower.getSize() + ", " + flower.getColor() + " flowers with "+
                    flower.getPetals() + " petals.\n";
        } else {
            baseString += "This plant does not have flowers.\n";
        }
        return baseString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return hasFlowers == plant.hasFlowers && Objects.equals(name, plant.name) && Objects.equals(latinName, plant.latinName) && Objects.deepEquals(range, plant.range) && Objects.equals(flower, plant.flower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, latinName, Arrays.hashCode(range), hasFlowers, flower);
    }
}
