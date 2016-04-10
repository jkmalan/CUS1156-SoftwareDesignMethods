package com.jkmalan.Lab9.Registration;

public class University {

	public static void main(String[] args) {
		Registration reg = new Registration();
		FreshmanCenter fCenter = new FreshmanCenter();
		fCenter.doScheduling(reg);
		DeansOffice dOffice = new DeansOffice();
		dOffice.doScheduling(reg);
	}

}
