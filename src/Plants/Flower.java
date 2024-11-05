package Plants;

import java.util.Objects;

public class Flower {
    private String color;
    private String size;
    private int petals;

    /**
     * Constructor for a Flower object
     * @param color The colour of the flower
     * @param size The size of the flower
     * @param petals The number of petals of the flower
     */
    public Flower(String color, String size, int petals) {
        this.color = color;
        this.size = size;
        this.petals = petals;
    }

    /**
     * get the color of the flower
     * @return color of the flower represented in a string
     */
    public String getColor() {
        return color;
    }

    /**
     * get the size of the flower
     * @return size of the flower represented in a string
     */
    public String getSize() {
        return size;
    }

    /**
     * get the petal count of the flower
     * @return petal count of the flower represented in a int
     */
    public int getPetals() {
        return petals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return petals == flower.petals && Objects.equals(color, flower.color) && Objects.equals(size, flower.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, size, petals);
    }
}
