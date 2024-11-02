package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int start = 1000;
    private static final int finish = 2000;
    private static final int ELEMS_POINT_5 = 100000;
    private static final int ELEMS_POINT_6 = 1000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *          unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> numbersArray = new ArrayList<>();
        for (int i = start; i < finish; i++) {
            numbersArray.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> numbersLinkedList = new LinkedList<>(numbersArray);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp;
        temp = numbersArray.getFirst();
        numbersArray.set(start - numbersArray.size(), numbersArray.getLast());
        numbersArray.set(finish - numbersArray.size() - 1, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (int i : numbersArray) {
            System.out.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long timeArray = System.nanoTime();
        for (int i = 1; i <= ELEMS_POINT_5; i++) {
            numbersArray.addFirst(i);
        }
        timeArray = System.nanoTime() - timeArray;
        var millis = TimeUnit.NANOSECONDS.toMillis(timeArray);
        System.out.println(// NOPMD
                "Inserting "
                        + ELEMS_POINT_5
                        + " ints in an Array List took: "
                        + timeArray
                        + "ns ("
                        + millis
                        + "ms)");

        long timeLinkedList = System.nanoTime();
        for (int i = 1; i <= ELEMS_POINT_5; i++) {
            numbersLinkedList.addFirst(i);
        }
        timeLinkedList = System.nanoTime() - timeLinkedList;
        millis = TimeUnit.NANOSECONDS.toMillis(timeLinkedList);
        System.out.println(// NOPMD
                "Inserting "
                        + ELEMS_POINT_5
                        + " ints in a Linked List took: "
                        + timeLinkedList
                        + "ns ("
                        + millis
                        + "ms)");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        long timeReadArr = System.nanoTime();
        int readElementFromArray = 0;
        for (int i = 1; i <= ELEMS_POINT_6; i++) {
            readElementFromArray = numbersArray.get(numbersArray.size() / 2);
        }
        timeReadArr = System.nanoTime() - timeReadArr;
        millis = TimeUnit.NANOSECONDS.toMillis(timeReadArr);
        System.out.println(// NOPMD
                "Reading "
                        + ELEMS_POINT_6
                        + " times the element "
                        + readElementFromArray
                        + " from an Array List took: "
                        + timeReadArr
                        + "ns ("
                        + millis
                        + "ms)");

        long timeReadLink = System.nanoTime();
        int readElementFromLinkedList = 0;
        for (int i = 1; i <= ELEMS_POINT_6; i++) {
            readElementFromLinkedList = numbersLinkedList.get(numbersLinkedList.size() / 2);
        }
        timeReadLink = System.nanoTime() - timeReadLink;
        millis = TimeUnit.NANOSECONDS.toMillis(timeReadLink);
        System.out.println(// NOPMD
                "Reading "
                        + ELEMS_POINT_6
                        + " times the element "
                        + readElementFromLinkedList
                        + " from a Linked List took: "
                        + timeReadLink
                        + "ns ("
                        + millis
                        + "ms)");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> continentalPopulationMap = new HashMap<>();
        continentalPopulationMap.put("Africa", 1110635000L);
        continentalPopulationMap.put("Americas", 972005000L);
        continentalPopulationMap.put("Antartica", 0L);
        continentalPopulationMap.put("Asia", 4298723000L);
        continentalPopulationMap.put("Europe", 742452000L);
        continentalPopulationMap.put("Oceania", 38304000L);

        /*
         * 8) Compute the population of the world
         */
        long worldPopulation = 0;
        for (long l : continentalPopulationMap.values()) {
            worldPopulation += l;
        }
        System.out.println("The population of the world is: "
                + worldPopulation);
    }
}
