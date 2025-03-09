package edu.cmu.cs.cs214.rec04;

public class DelegationSortedIntList implements IntegerList {
    private final SortedIntList sortedList = new SortedIntList();
    private int totalAdded = 0;

    @Override
    public boolean add(int num) {
        totalAdded++;
        return sortedList.add(num);
    }

    @Override
    public boolean addAll(IntegerList list) {
        totalAdded += list.size();
        return sortedList.addAll(list);
    }

    @Override
    public int get(int index) {
        return sortedList.get(index);
    }

    @Override
    public int size() {
        return sortedList.size();
    }

    public int getTotalAdded() {
        return totalAdded;
    }

    @Override
    public boolean remove(int num) {
        // If the element exists and is removed, decrement totalAdded
        if (sortedList.contains(num)) {
            totalAdded--;
            return sortedList.remove(num);
        }
        return false;
    }

    @Override
    public boolean removeAll(IntegerList list) {
        // Iterate through the list and remove elements, updating totalAdded
        boolean result = false;
        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
            if (sortedList.contains(element)) {
                totalAdded--;
                result = sortedList.remove(element) || result;
            }
        }
        return result;
    }
}