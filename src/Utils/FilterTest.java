package Utils;

import Plants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterTest {
    private static List<Plant> getPlantList(){
        List<Plant> myList = new ArrayList<>();

        int[] i = {50, 300};
        Shrub shrub = new Shrub("Shrubg", "Shubraious", i);


        int[] i2 = {400, 1000};
        Tree tree = new Tree("treedd", "treeadaye", i2);
        tree.setFlower(new Flower("white", "medium", 6));

        int[] i3 = {100, 450};
        Herb herb = new Herb("herbar", "hubrad", i3);
        herb.setEdibility(true, "testhaha");

        myList.add(shrub);
        myList.add(tree);
        myList.add(herb);

        return myList;
    }

    @org.junit.jupiter.api.Test
    void filterBySize() {
        List<Plant> myList = getPlantList();

        List<Plant> testList = new ArrayList<>();
        int[] i = {50, 300};
        Shrub shrub = new Shrub("Shrubg", "Shubraious", i);

        int[] i3 = {100, 450};
        Herb herb = new Herb("herbar", "hubrad", i3);
        herb.setEdibility(true, "testhaha");

        testList.add(herb);
        testList.add(shrub);

        List<Plant> filtered = Filter.filterBySize(myList, 120);
        assertTrue(filtered.equals(testList));
    }

    @org.junit.jupiter.api.Test
    void filterByColor() {
        List<Plant> myList = getPlantList();

        List<Plant> testList = new ArrayList<>();
        int[] i2 = {400, 1000};
        Tree tree = new Tree("treedd", "treeadaye", i2);
        tree.setFlower(new Flower("white", "medium", 6));
        testList.add(tree);

        assertEquals(testList, Filter.filterByColor(myList, "white"));
    }

    @org.junit.jupiter.api.Test
    void filterByEdibility() {
        List<Plant> myList = getPlantList();

        List<Plant> testList = new ArrayList<>();

        int[] i3 = {100, 450};
        Herb herb = new Herb("herbar", "hubrad", i3);
        herb.setEdibility(true, "testhaha");
        testList.add(herb);
        assertEquals(testList, Filter.filterByEdibility(myList, true));
    }
}