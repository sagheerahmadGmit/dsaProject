package ie.gmit.sw;

import java.util.*; 

public class Runner {

	public static void main(String[] args) throws Throwable {
		
		//Call the menu class and the show function
		//The show function outputs the menu for the user and allows
		//the user to pick an option and change the picture around
		
		System.out.println();
		System.out.println("|Please read the README.txt for instructions                  |");
		System.out.println("|Or please follow steps 1 - 4 to generate image               |");
		System.out.println("|=============================================================|");
		System.out.println();
		
		new Menu().show();
		
	}

}
