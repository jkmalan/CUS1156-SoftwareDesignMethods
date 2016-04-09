package com.jkmalan.Lab1;

import java.util.ArrayList;

/**
 * This class represents a group of cats. The cats are created when the CatManager is created
 * although more cats can be added later.
 *
 * @author Bonnie MacKellar
 * @author jkmalan (aka John Malandrakis)
 *
 */
public class CatManager
{
	private ArrayList<Cat> myCats;

	public CatManager() {
		myCats = new ArrayList<Cat>();

		Cat cat = new Cat("Fifi", "black");
		myCats.add(cat);
		cat = new Cat("Fluffy", "spotted");
		myCats.add(cat);
		cat = new Cat("Josephine", "tabby");
		myCats.add(cat);
		cat = new Cat("Biff", "tabby");
		myCats.add(cat);
		cat = new Cat("Bumpkin", "white");
		myCats.add(cat);
		cat = new Cat("Spot", "spotted");
		myCats.add(cat);
		cat = new Cat("Lulu", "tabby");
		myCats.add(cat);
	}

	/**
	 * Adds a cat to the group
	 * 
	 * @param aCat The Cat object to add
	 */
	public void add(Cat aCat) {
		myCats.add(aCat);
	}


	/**
	 * Returns the first cat whose name matches or null if not found
	 * 
	 * @param name The name of the cat to search for
	 * @return The Cat object or null if not found
	 */
	public Cat findThisCat(String name) {
		for (Cat cat : myCats) {
			if (cat.getName().equals(name))
				return cat;
		}
		return null;
	}

	/**
	 * Returns the number of cats of a certain color
	 *
	 * @param color The color to search for
	 * @return The number of cats with
	 */
	public int countColors(String color) {
		int counter = 0;
		for (Cat cat : myCats) {
			if (cat.getColor().equals(color))
				counter++;
		}
		return counter;
	}
}
