package ie.gmit.sw;

//import all classes
import java.io.*;
import java.util.*;

//Calling the jsoup class and document
//The jsoup jar has been referenced in the referenced library
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Parser {
	
	//Declaring and initializing the local variables that will be used in this class
	private BufferedReader br;
	private Document f;
	private String text;
	private int count = 0;
	private String imgName = "sample";
	
	// path to the file
	private static final String IGNORE_FILE = "./ignorewords.txt";

	//HashSet<String> hash = new HashSet<String>();
	//I used an arrayList because it was easier and less complicated to use
	//It also was the only thing i could use to print out the image
	private ArrayList<String> update = new  ArrayList<>();
	private ArrayList<String> hash = new ArrayList<String>();
	private HashMap<String, Integer> wordFreq = new HashMap<>();

	//parse the file while comparing it to the ignorewords.txt
	public void Parse(String file, int maxWords, String imgName) throws Exception {

		try
		{
			// reads the file in
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));
			String next = null;
			//int count=0;
			
			//start clock for running time
			long start = System.currentTimeMillis();
	
			//compare the file to the ignorewords.txt
			ignore();
			
			// O(n^2)
			while ((next = br.readLine()) != null) {
	
				// Add every word in the line to an array,while deleting any 
				// commas, full stops and any other symbols in the file while also using spaces as delimiters.
				String[] words = next.toLowerCase().replaceAll("[^A-Za-z0-9 ]", "").split(" ");
	
				for (String word : words) {
	
					//searching is 0(n)
					if (!hash.contains(word)) {
	
						//System.out.println(word);
						updateMap(word);
						count++;
					}
				}
			}
			
			//if the file is empty then print out the words and the running time
			if(count == 0)
			{
				System.out.println();
				System.out.println(count + " unique words found!");
				System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms");
				System.out.println("Time Complexity 0(n) where n: " + update.size()) ;
				System.out.println();
			}
			else//print out the running times and the image
			{
				System.out.println();
				System.out.println(count + " unique words found!");
				System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms");
				System.out.println("Time Complexity 0(n) where n: " + update.size()) ;
				
				//create the image
				ReallySimpleWordCloud wc = new ReallySimpleWordCloud();
				wc.GenerateImage(hash, update, maxWords, imgName);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("file name is Incorrect");
		}
	}

	//parse url here 
	public void urlParse(String site, int maxWords, String imgName){
		
		try {
			if (site.startsWith("http://") || site.startsWith("https://")) {
				
				//gets the url and parses it 
				String doc = Jsoup.connect(site).get().html();
				f = Jsoup.parse(doc);
				// then we get the text from the body of html 
				text = f.body().text();
				
			}
		
			//https://stackoverflow.com/questions/39702017/how-can-i-create-a-bufferedreader-from-a-string
			// here i have a reader
			Reader inputString = new StringReader(text);
			// text converted to reader is buffered 
			br = new BufferedReader(inputString);

			// TODO Auto-generated method stub
			String next = null;
			
			//start clock for running time
			long start = System.currentTimeMillis();
			
			//compare against the ignore file
			ignore();
			
			// O(n^2)
			while ((next = br.readLine()) != null) {

				// Add every word in the line to an array,while deleting any 
				// commas, full stops and any other symbols in the file while also using spaces as delimiters.
				String[] words = next.toLowerCase().replaceAll("[^A-Za-z0-9 ]", "").split(" ");

				for (String word : words) {

					//searching is 0(n)
					if (!hash.contains(word)) {

						//System.out.println(word);
						updateMap(word);
						count++;
					}
				}
			}
			
			//if the file is empty then print out the words and the running time
			if(count == 0)
			{
				System.out.println();
				System.out.println(count + " unique words found!");
				System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms");
				System.out.println("Time Complexity 0(n) where n: " + update.size()) ;
				System.out.println();
			}
			else//print out the running times and the image
			{
				System.out.println();
				System.out.println(count + " unique words found!");
				System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms");
				System.out.println("Time Complexity 0(n) where n: " + update.size()) ;
				
				//create the image
				ReallySimpleWordCloud wc = new ReallySimpleWordCloud();
				wc.GenerateImage(hash, update, maxWords, imgName);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Url Entered is Incorrect");
		}
		

	}

	//compare the file to the ignore file
	public void ignore() throws IOException {

		BufferedReader ignore = new BufferedReader(new FileReader((IGNORE_FILE)));

		String next = null;

		// O(n^2)
		while ((next = ignore.readLine()) != null) {
			
			
			String[] words = next.toLowerCase().replaceAll("[^A-Za-z0-9 ]", "").split(" ");
			
			for (String word : words) {
				hash.add(word);
			}
		}
		//close the bufferReader
		ignore.close();
	}

	public void updateMap(String word) {

		//adding to an arrayList is 0(1)
		update.add(word);
		
		//If the word already exists in the Map, the frequency of the word is incremented.
		//or else if this the first occurrence of this word then set the frequency to 1
		int count = wordFreq.containsKey(word) ? wordFreq.get(word) : 1;
		wordFreq.put(word, count++);
		//print out the word and its frequency
		System.out.println(word + " = " + count);
	}
}
