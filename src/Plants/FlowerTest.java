package Plants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {
    private static Flower createFlower(){
        return new Flower("white", "medium", 5);
    }

    @Test
    void getColor() {
        Flower flower = createFlower();
        assertEquals(flower.getColor(), "white");
    }

    @Test
    void getSize() {
        Flower flower = createFlower();
        assertEquals(flower.getSize(), "medium");
    }

    @Test
    void getPetals() {
        Flower flower = createFlower();
        assertEquals(flower.getPetals(), 5);
    }

    @Test
    void testEquals() {
        Flower flower = createFlower();
        Flower flower2 = createFlower();
        assertEquals(flower, flower2);
    }

    @Test
    void testHashCode() {
        Flower flower = createFlower();
        Flower flower2 = createFlower();
        assertEquals(flower.hashCode(), flower2.hashCode());
    }
}