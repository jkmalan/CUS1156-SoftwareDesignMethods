package com.jkmalan.Lab9.Registration;

public class University {

	public static void main(String[] args) {
		FreshmanCenter fCenter = new FreshmanCenter();
		fCenter.doScheduling();
		DeansOffice dOffice = new DeansOffice();
		dOffice.doScheduling();
	}

}
