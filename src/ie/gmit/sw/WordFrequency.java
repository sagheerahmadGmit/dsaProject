package ie.gmit.sw;

import java.util.*;

public class WordFrequency implements Comparable<WordFrequency> {
	
	private String word;
	private int frequency;

	//Getters and Setters for word and frequency
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	//compareTo method for comparable
	@Override
	public int compareTo(WordFrequency arg0) {
		return 0;
	}
}
