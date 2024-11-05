package Plants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ShrubTest {
    private static Shrub createShrub(){
        int[] i = {10, 40};
        return new Shrub("TestShrub", "TestusShrubus", i);
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }
}