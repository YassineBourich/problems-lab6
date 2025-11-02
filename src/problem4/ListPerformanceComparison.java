package problem4;

import java.util.*;

public class ListPerformanceComparison {

    private static final int SIZE = 100_000;        // total elements
    private static final int OPERATIONS = 10_000;   // random operations to test

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();


        System.out.println("---- Performance Comparison ----");

        System.out.println("---- Populate both lists ----");
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(2);
            ((LinkedList<Integer>)linkedList).addLast(2);
        }

        // 2️⃣ Random insertions and deletions
        testRandomInsertDelete(arrayList, "ArrayList");
        testRandomInsertDelete(linkedList, "LinkedList");

        // 3️⃣ Sequential insertions/deletions at beginning and end
        testSequentialInsertDelete(arrayList, "ArrayList");
        testSequentialInsertDelete(linkedList, "LinkedList");

        // 4️⃣ Random access test
        testRandomAccess(arrayList, "ArrayList");
        testRandomAccess(linkedList, "LinkedList");
    }

    // ------------------------------------------------------------

    private static void testRandomInsertDelete(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        // Many random insertion and deletion
        for (int i = 0; i < OPERATIONS; i++) {
            list.add(random.nextInt(SIZE - 10 + 1) + 10, 10);
        }

        /*for (int i = 0; i < OPERATIONS; i++) {
            list.remove(random.nextInt(SIZE - 10 + 1) + 10);
        }*/

        long end = System.nanoTime();
        System.out.printf("%s - Random insert/delete: %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------

    private static void testSequentialInsertDelete(List<Integer> list, String name) {
        long start = System.nanoTime();

        // Insertions at beginning and end

        if (name.equals("ArrayList")) {
            for (int i = 0; i < OPERATIONS; i++) {
                list.add(3);
                list.add(0, 4);
            }
        } else {
            for (int i = 0; i < OPERATIONS; i++) {
                ((LinkedList<Integer>)list).addFirst(3);
                ((LinkedList<Integer>)list).addLast(4);
            }
        }

        // Deletions at beginning and end

        if (name.equals("ArrayList")) {
            for (int i = 0; i < OPERATIONS; i++) {
                list.remove(0);
                list.remove(list.size() - 1);
            }
        } else {
            for (int i = 0; i < OPERATIONS; i++) {
                ((LinkedList<Integer>)list).removeFirst();
                ((LinkedList<Integer>)list).removeLast();
            }
        }

        long end = System.nanoTime();
        System.out.printf("%s - Sequential insert/delete (start/end): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }

    // ------------------------------------------------------------

    private static void testRandomAccess(List<Integer> list, String name) {
        Random random = new Random();
        long start = System.nanoTime();

        long sum = 0;
        // sum of the all elements in the list
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        long end = System.nanoTime();
        System.out.printf("%s - Random access (get): %.3f ms%n",
                name, (end - start) / 1_000_000.0);
    }
}

/*
A sample of output:
---- Performance Comparison ----
---- Populate both lists ----
ArrayList - Random insert/delete: 184.526 ms
LinkedList - Random insert/delete: 2190.933 ms
ArrayList - Sequential insert/delete (start/end): 307.096 ms
LinkedList - Sequential insert/delete (start/end): 4.233 ms
ArrayList - Random access (get): 12.693 ms
LinkedList - Random access (get): 8469.598 ms

We observe that:
- the random insertion and deletion is faster in ArrayList than in LinkedList
- the sequential insertion and deletion is faster in LinkedList than in ArrayList
- the random access is faster in ArrayList than in LinkedList

This due to the structure of the list used, the ArrayList is optimal for random access
because the items are arranged in memory and they are accessed only by a simple calculation, whereas
accessing an item in a linked list must be done by going throught all item until that item. The same
reason for random insert and delete, because these operations require access to that position first.
In other hand, since the first and last pointers are stored for linked list, it is faster to perform
operation on the start and the end of linked list.
 */