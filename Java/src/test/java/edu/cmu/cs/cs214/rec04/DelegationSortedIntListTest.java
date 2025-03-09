package edu.cmu.cs.cs214.rec04;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DelegationSortedIntListTest {

    private DelegationSortedIntList list1;
    private DelegationSortedIntList list2;

    @Before
    public void setUp() {
        list1 = new DelegationSortedIntList();
        list2 = new DelegationSortedIntList();
    }

    /**
     * Tests for the add() method.
     */
    @Test
    public void testAdd() {
        // add 5 elements to our list.
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(4);
        list1.add(2);

        // check that the total number of elements added is 5.
        assertTrue(list1.getTotalAdded() == 5);

        // helper function that prints out the contents of an IntegerList
        printList(list1);
    }

    /**
     * Test for the addAll() method.
     */
    @Test
    public void testAddAll() {
        // add 5 elements to our first list.
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(4);
        list1.add(2);

        // check that the total number of elements added is 5.
        assertTrue(list1.getTotalAdded() == 5);

        // add 2 elements to a second list.
        list2.add(3);
        list2.add(0);

        // check that the total number of elements added is 2.
        assertTrue(list2.getTotalAdded() == 2);

        // add the first list (5 elements) to our second list (2 elements).
        list2.addAll(list1);

        // check that the total number of elements added to our second list is 7.
        assertTrue(list2.getTotalAdded() == 7);
    }

    /**
     * Test for the remove() method.
     */
    @Test
    public void testRemove() {
        // add elements to the list
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(4);
        list1.add(2);

        // remove an element
        list1.remove(2);

        // check that the total number of elements added is 4 (since 1 element was removed)
        assertTrue(list1.getTotalAdded() == 4);
        assertTrue(list1.size() == 4); // the size of the list should be reduced by 1

        // check that the element 2 was removed
        assertFalse(contains(list1, 2)); // helper function to check if the list contains an element
    }

    /**
     * Test for the removeAll() method.
     */
    @Test
    public void testRemoveAll() {
        // add elements to list1
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(4);
        list1.add(2);

        // add elements to list2
        list2.add(2);
        list2.add(3);

        // remove all elements in list2 from list1
        list1.removeAll(list2);

        // check that the total number of elements added is 3 (since 2 elements were removed)
        assertTrue(list1.getTotalAdded() == 3);
        assertTrue(list1.size() == 3); // the size of the list should be reduced by 2

        // check that elements 2 and 3 were removed
        assertFalse(contains(list1, 2));
        assertFalse(contains(list1, 3));
    }

    /**
     * Helper function to check if a list contains a specific element.
     * @param list The list to search in.
     * @param num The number to check.
     * @return true if the number is in the list, false otherwise.
     */
    private boolean contains(IntegerList list, int num) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * A helper function that prints out the contents of an IntegerList.
     * @param list IntegerList to be printed out.
     */
    private void printList(IntegerList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print(", ");
        }
        System.out.println();
    }
}