package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int ELEMS = 100_000;
    private static final int TO_MS = 1_000_000;
    
    private static final int TO_READ = 1000;

    private UseCollection() {
    }
    
    public static long headInsertTest(List<Integer> list, int n) {
    	long time = System.nanoTime();
        /*
         * Run the benchmark
         */
        for (int i = 1; i <= n; i++) {
            list.add(0, i);
        }
        /*
         * Compute the time and print result
         */
        return System.nanoTime() - time;
    }
    
    public static long readTest(List<Integer> list,  int n) {
    	long time = System.nanoTime();
        /*
         * Run the benchmark
         */
        for (int i = 0; i < n; i++) {
            list.get(list.size() / 2);
        }
        /*
         * Compute the time and print result
         */
        return System.nanoTime() - time;
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	List<Integer> list = new ArrayList<>();
    	for(var i = 1000; i < 2000; i++) {
    		list.add(i);
    	}
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	List<Integer> llist = new LinkedList<>(list);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	var temp = list.get(0);
		list.set(0, temp);
		list.set(list.size() - 1, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for(var elem : list) {
    		System.out.println(elem);
    	}
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	// ArrayList
    	long time = headInsertTest(list, ELEMS);
        System.out.println("Inserting " + ELEMS
                + " int in a ArrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
        //System.out.println(list);
        // Linked
        time = headInsertTest(llist, ELEMS);
        System.out.println("Inserting " + ELEMS
                + " int in a LinkedList took " + time
                + "ns (" + time / TO_MS + "ms)");
        //System.out.println(llist);
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = readTest(list, TO_READ);
        System.out.println("Reading " + TO_READ
                + " of a ArrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
        //System.out.println(list);
        
        
        time = readTest(llist, TO_READ);
        System.out.println("Reading " + TO_READ
                + " of a LinkedList took " + time
                + "ns (" + time / TO_MS + "ms)");
        //System.out.println(llist);
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
        Map<String, Long> populations = new HashMap<>();
        populations.put("Africa", 1_110_635_000L);
        populations.put("Americas", 972_005_000L);
        populations.put("Antartica", 0L);
        populations.put("Asia", 4_298_723_000L);
        populations.put("Europe", 742_452_000L);
        populations.put("Oceania", 138_304_000L);
        /*
         * 8) Compute the population of the world
         */
        long worldPopulation = 0;
        for(var i : populations.values()) {
        	worldPopulation += i;
        }
        System.out.println("The world population is: " + worldPopulation);
    }
}
