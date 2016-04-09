package com.jkmalan.Lab8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Contains MenuItems and an Iterator
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class DinerMenu {

    static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;
    private MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        addItem("Vegetarian BLT",
                "(Fakin') Bacon with lettuce & tomato on whole wheat",
                true,
                2.99);

        addItem("BLT",
                "Bacon with lettuce & tomato on whole wheat",
                false,
                2.99);

        addItem("Soup of the day",
                "Soup of the day, with a side of potato salad",
                false,
                3.29);

        addItem("Hotdog",
                "A hot dog, with saurkraut, relish, onions, topped with cheese",
                false,
                3.05);

        addItem("Steamed Veggies and Brown Rice",
                "Steamed vegetables over brown rice",
                true,
                3.99);

        addItem("Pasta",
                "Spaghetti with Marinara Sauce, and a slice of sourdough bread",
                true,
                3.89);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);

        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full!  Can't add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }

    public Iterator<MenuItem> createIterator() {
        return new DinerMenuIterator();
    }

    public class DinerMenuIterator implements Iterator<MenuItem> {

        private int index = 0;

        @Override
        public MenuItem next() {
            if (!hasNext()) {
                throw new NoSuchElementException("There is no element at this index");
            }

            return menuItems[index++];
        }

        @Override
        public boolean hasNext() {
            return menuItems.length != index;
        }

        @Override
        public void remove() {
            if (index <= 0) {
                throw new IllegalStateException("You cannot remove an element before the first next() call");
            }

            for (int i = --index; i < menuItems.length - 1; i++) {
                menuItems[i] = menuItems[i + 1];
            }
            menuItems = Arrays.copyOf(menuItems, menuItems.length - 1);
        }

    }

}
