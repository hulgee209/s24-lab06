package edu.cmu.cs.cs214.rec04;

/**
 * Main class for testing DelegationSortedIntList and InheritanceSortedIntList.
 */
public class Main {
    public static void main(String[] args) {
        IntegerList list1 = new DelegationSortedIntList();
        IntegerList list2 = new InheritanceSortedIntList();

        // Add elements to list1
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(4);
        list1.add(2);

        printList("DelegationSortedIntList", list1);
        System.out.println("Total added: " + ((DelegationSortedIntList) list1).getTotalAdded());

        // Add elements to list2
        list2.add(3);
        list2.add(0);
        list2.addAll(list1);

        printList("InheritanceSortedIntList", list2);
        System.out.println("Total added: " + ((InheritanceSortedIntList) list2).getTotalAdded());
    }

    private static void printList(String name, IntegerList list) {
        System.out.print(name + " contents: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}