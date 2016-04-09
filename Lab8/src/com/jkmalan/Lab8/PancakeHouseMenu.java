package com.jkmalan.Lab8;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Contains MenuItems and an Iterator
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class PancakeHouseMenu {

    private ArrayList<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<MenuItem>();

        addItem("K&B's Pancake Breakfast",
                "Pancakes with scrambled eggs, and toast",
                true,
                2.99);

        addItem("Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                2.99);

        addItem("Blueberry Pancakes",
                "Pancakes made with fresh blueberries, and blueberry syrup",
                true,
                3.49);

        addItem("Waffles",
                "Waffles, with your choice of blueberries or strawberries",
                true,
                3.59);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public Iterator<MenuItem> createIterator() {
        return new PancakeMenuIterator();
    }

    public class PancakeMenuIterator implements Iterator<MenuItem> {

        private Iterator<MenuItem> iter = menuItems.iterator();

        @Override
        public MenuItem next() {
            return iter.next();
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        @Override
        public void remove() {
            iter.remove();
        }

    }

}
