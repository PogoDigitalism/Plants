package Utils;

import Plants.Herb;
import Plants.Plant;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A class with Filter utility functions for the Plant and Flower classes.
 */
public class Filter {
    /**
     * Filter through the Plant list by Plant size
     * @param plantList the list of Plants to filter through
     * @param size growth size to filter the Plants at
     * @return a List of Plants that can grow the specified size
     */
    public static List<Plant> filterBySize(List<Plant> plantList, int size) {
        return plantList.stream()
                .filter(plant -> plant.getRange()[0] <= size && size <= plant.getRange()[1]).collect(Collectors.toList());
    }

    /**
     * Filter through the Plant list by its Flower (if it has flowers)
     * @param plantList the list of Plants to filter through
     * @param color color of Flower to filter the Plants at
     * @return a List of Plants that have a Flower in the specified color
     */
    public static List<Plant> filterByColor(List<Plant> plantList, String color) {
        return plantList.stream()
                .filter(plant -> plant.hasFlowers() && plant.getFlower().getColor().equals(color)).collect(Collectors.toList());
    }

    /**
     * Filter through the Plant list by edibility
     * @param plantList the list of Plants to filter through
     * @param edible parameter to filter on edibility, true is filter out if not edible
     * @return a List of (Herb) Plants that are edible depending on the given edible parameter
     */
    public static List<Plant> filterByEdibility(List<Plant> plantList, boolean edible) {
        return plantList.stream()
                .filter(plant -> plant instanceof Herb && ((Herb) plant).isEdible()).collect(Collectors.toList());
    }
}
