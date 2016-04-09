package com.jkmalan.Lab1;

import java.util.Scanner;

/**
 * @author Bonnie MacKellar
 *
 */
public class Lab2Driver
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		CatManager catMgr = new CatManager();

		int numTabby = catMgr.countColors("tabby");
		int numSpotted = catMgr.countColors("spotted");
		System.out.println("There are " + numTabby + " tabby cats");
		System.out.println("There are " + numSpotted + " spotted cats");

        Cat newCat = new Cat("Marvin", "gray");
        catMgr.add(newCat);

		System.out.println("Enter the name of the cat you would like to find");
		String name =  input.next();
		Cat foundCat = catMgr.findThisCat(name);
		if (foundCat == null)
			System.out.println("did not find this cat");
		else
			foundCat.manyMeows(3);
		
		input.close();
	}

}
