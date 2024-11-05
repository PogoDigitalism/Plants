package Plants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TreeTest {
    private static Tree createTree(){
        int[] i = {20, 70};
        return new Tree("TestTree", "TestusTriatus", i);
    }
    @Test
    void testEquals() {
        Tree tree = createTree();

        int[] i = {20, 70};

        assertEquals(tree, new Tree("TestTree", "TestusTriatus", i));
    }

    @Test
    void testHashCode() {
        Tree tree = createTree();

        int[] i = {20, 70};
        assertEquals(tree.hashCode(), new Tree("TestTree", "TestusTriatus", i).hashCode());
    }
}