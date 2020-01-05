package ie.gmit.sw;

import java.util.Scanner;

public class Menu 
{
	//Call the scanner class and declare variables
	private Scanner s = new Scanner(System.in);
	private String option;
	private boolean keepGoing = true;
	
	//variables for the max words 
	private int numWords = 25;
	private int newNumWords;
	
	//variables for the image name
	private String imgName = "Default";
	private String newImgName;
	
	Parser p = new Parser();
	
	//show function to be called in menu
	public void show() throws Exception
	{
		while(keepGoing == true)
		{
			//call the printMenu and handle option
			printMenu();
			handle(option);
		}
	}
		
	//print out the print menu option for the user
	public void printMenu()
	{	
		System.out.println("|* Word Cloud Generator - Please choose one of the following *|");
		System.out.println("|=============================================================|");
		System.out.println("|1. Enter number of words to enter (Default = 35)             |");
		System.out.println("|2. Enter Image name (Default = default.png)                  |");
		System.out.println("|3. Select file or url                                        |");
		System.out.println("|4. Quit                                                      |");
		System.out.println("|=============================================================|");
		option = s.next();
		
	}
	
	//depending on the user input execute one of the following options
	public void handle(String option) throws Exception
	{	
		//exit the program
		if(option.equals("4"))
		{
			System.out.println("You have exited the program!");
			keepGoing = false;
		}
		//Ask the user to input the new amount of words to use
		else if(option.equals("1"))
		{
			
			System.out.println("Please enter the number of words you would like to be displayed: ");
			newNumWords = s.nextInt();
			
			this.numWords = newNumWords;
			
			System.out.println("The new number of words allowed is: " + this.numWords);
			
		}
		//ask the user to input the new image name
		else if(option.equals("2"))
		{
			
			System.out.println("Please enter the name of the image: ");
			newImgName = s.next();
			
			this.imgName = newImgName;
			
			System.out.println("The new image name is: " + this.imgName);
			
		}
		//ask for file or url and parse it, then print it to an image
		else if(option.equals("3"))
		{
			String fileName;
			String url;
			String fileOrUrl;
			
			System.out.println("Would you like to enter a file name or a url? ");
			fileOrUrl = s.next();

			if(fileOrUrl.equals("file"))
			{
				System.out.println("Please enter the file name: ");
				fileName = s.next().toLowerCase();
				p.Parse(fileName, numWords, imgName);
			}
			else if(fileOrUrl.equals("url"))
			{
				System.out.println("Please enter the url name: ");
				url = s.next().toLowerCase();
				p.urlParse(url, numWords, imgName);
			}
			else
			{
				System.out.println("Incorrect Option!!");
			}
			
		}
		
	}

}
