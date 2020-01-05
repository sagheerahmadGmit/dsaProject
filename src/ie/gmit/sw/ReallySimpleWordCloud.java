package ie.gmit.sw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class ReallySimpleWordCloud {
	
	//declare variables
	private int randomFont;
	private int randomColor;
	private int xAxis;
	private int yAxis;

	public void GenerateImage(ArrayList<String> ignoreWords, ArrayList<String> updatedWords, int maxWords, String imgName) throws Exception {
	
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		BufferedImage image = new BufferedImage(600, 300, BufferedImage.TYPE_3BYTE_BGR);
		Graphics graphics = image.getGraphics();
		//graphics.setColor(Color.red);
		graphics.setFont(font);
		//graphics.drawString("Data Structures", 0, 100);
		
		//Call the random class
		Random rand = new Random();
		
		//for loop to print out the words to the image
		for(int i = 0; i < maxWords; i++)
		{
			//System.out.println(hash);
			
			//pick a random colour and font everytime the for loop runs
			randomFont =rand.nextInt(2);
			randomColor = rand.nextInt(8);
			xAxis = rand.nextInt(600);
			yAxis = rand.nextInt(300);
			
			//shuffle and randomize the words is well
			Collections.shuffle(updatedWords); 
			
			//assign fonts and colors
			if(randomFont == 0)
			{
				font = new Font(Font.SANS_SERIF, Font.ITALIC, 20);
			}
			else if(randomFont == 1)
			{
				font = new Font(Font.MONOSPACED, Font.PLAIN, 20);
			}
			else if(randomFont == 2)
			{
				font = new Font(Font.MONOSPACED, Font.BOLD, 20);
			}
			
			if(randomColor == 0)
			{
				graphics.setColor(Color.yellow);
			}
			else if(randomColor == 1)
			{
				graphics.setColor(Color.blue);
				}
			else if(randomColor == 2)
			{
				graphics.setColor(Color.red);
			}
			else if(randomColor == 3)
			{
				graphics.setColor(Color.cyan);
			}
			else if(randomColor == 4)
			{
				graphics.setColor(Color.green);
				}
			else if(randomColor == 5)
			{
				graphics.setColor(Color.ORANGE);
			}
			else if(randomColor == 6)
			{
				graphics.setColor(Color.magenta);
			}
			else if(randomColor == 7)
			{
				graphics.setColor(Color.white);
			}
			else if(randomColor == 8)
			{
				graphics.setColor(Color.gray);
			}
			//output the word to the image
			graphics.drawString(updatedWords.get(i), xAxis, yAxis);
		}
		
		System.out.println("\nThe Image is being generated!!");
		
		//name the file and allocate memory
		graphics.dispose();
		ImageIO.write(image, "png", new File(imgName + ".png"));
		
		System.out.println("\nThe Image has been generated and is now in the folder\n");
	}
	
}