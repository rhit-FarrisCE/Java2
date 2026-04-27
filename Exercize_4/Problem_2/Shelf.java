package Exercize_4.Problem_2;

import java.util.ArrayList;

/**
 * Shelf<T> - A generic shelf class designed to hold only a specific type of media
 */
public class Shelf<T> {
    private ArrayList<T> items = new ArrayList<>();

    /**
     * Add an item to the shelf
     * @param item the item to add
     */
    public void add(T item) {
        items.add(item);
    }

    /**
     * Remove and return the last item from the shelf
     * @return the last item, or null if shelf is empty
     */
    public T take() {
        if (items.isEmpty()) {
            return null;
        }
        return items.remove(items.size() - 1);
    }

    /**
     * Get the current number of items on the shelf
     * @return the count of items
     */
    public int getCount() {
        return items.size();
    }

    /**
     * Get an item at a specific index
     * @param index the index of the item
     * @return the item at the index
     */
    public T get(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    /**
     * Check if the shelf is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
