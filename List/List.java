// *******************************************************************************
//                           CSE 360 - Final Project
//
//                              Raquel Lippincott
//								  Fatima Naveed
//								 Alexander Panza
//								  Abraham Perez
//
//                                MWF 1:30-2:20
//                                 Dr. Calliss
// *******************************************************************************

import java.util.Arrays;

public class List {
	
	/**
	* List.java - The List object is used to store dictionary words in an
	* ArrayList-like data structure. So, Every time the array is completely
	* filled, the array is copied over to a larger array. The words are stored 
	* in alphabetical order (does not consider capitalization). It is possible 
	* to add words, search for a word, get the number of words, etc.
	*/
	
	// Data members **************************************************************
	private int size;
	private int numWords;
	public String[] ourList;
	
	
	// Constructors **************************************************************
	public List()
	{
		size = 100;
		numWords = 0;
		ourList = new String[100];
	}
	
	
	// Methods **************************************************************
	/**
	 * getSize
	 * Returns the current size of the dynamic List object
	 * @return integer - current size of the List object
	 */
	public int getSize()
	{
		return size;
	}
	
	
	/**
	 * getNumWords
	 * Returns the number of words currently stored in the List object
	 * @return integer - number of words in the List object
	 */
	public int getNumWords()
	{
		return numWords;
	}
	
	
	/**
	 * getOurList{
	 * Returns the current array being used to store the words in the List object
	 * @return String - current List object array (static)
	 */
	public String[] getOurList()
	{
		return ourList;
	}
	
	
	/**
	 * get{
	 * Returns the String being stored at that index
	 * @param index - Integer of the desired String.
	 * @return String - the String currently stored at the given index. If the
	 * 					index does not contain a word or is out of bounds, it
	 * 					will return an empty String. 
	 */
	public String get(int index)
	{
		String str = "";
		if (index < numWords && index >= 0)
			str = ourList[index];
		return str;
	}
	
	
	/**
	 * add{
	 * Adds a new String to the array, while keeping the array sorted.
	 * If the array is already full, it will copy the array over to a bigger
	 * array. If the new String already exists in the array, it won't add anything.
	 * @param str - String that is to be added to the array
	 */
	public void add(String str)
	{
		if (numWords == 0){
			ourList[0] = str;
			numWords++;
		}
		else{
			if (numWords >= size-1)
			{
				System.out.println("BLEHH");
				// Array is full, make bigger copy
				
				// Make temp variable to hold current array
				String[] temp = new String[size];
				temp = Arrays.copyOf(ourList, size);
				
				// Update size of ourList
				ourList = new String[size + 100];
				size += 100;
				
				// Copy everything over
				ourList = Arrays.copyOf(temp, size);  // Fills the last 100 values with empty Strings
			}
			
			// Use Binary-Search to locate the position at which str should be added
			int first = 0;
			int last = numWords - 1;
			int middle = (first + last)/2;
			
			int insertIndex = -1;
			
			Boolean found = false;
			
			// Binary-Search
			while (first <= last)
			{
				if (ourList[middle].compareToIgnoreCase(str) < 0)
				{
					first = middle + 1;
				}
				
				else if (ourList[middle].compareToIgnoreCase(str) == 0)
				{
					// str is already in the dictionary. Do not add.
					found = true;
					break;	
				}
				
				else 
				{
					last = middle - 1;
				}
				middle = (first + last)/2;
			}
			
			// If str is unique, see if it should be inserted before or after middle.
			if (!found)
			{
				if (ourList[middle].compareToIgnoreCase(str) > 0)
					insertIndex = middle;
				else 
					insertIndex = middle + 1;
				
				for (int i=(numWords); i>=insertIndex; i--)
					ourList[i+1] = ourList[i];
				
				ourList[insertIndex] = str;
				numWords++;
			}
		}
	}
	
	
	/**
	 * find{
	 * Returns the index of the given String.
	 * @param str - String to be found.
	 * @return integer - the location of the given String in the array.
	 * 					 If the String does not exist in the array, this
	 * 					 value will be -1. 
	 */
	public int find(String str)
	{
		int index = -1;
		
		int first = 0;
		int last = numWords - 1;
		int middle = (first + last)/2;
			
		// Binary-Search
		while (first <= last)
		{
			if (ourList[middle].compareToIgnoreCase(str) < 0)
				first = middle + 1;
			else if (ourList[middle].compareToIgnoreCase(str) == 0){
				index = middle;
				break;	
			}
			else 
				last = middle - 1;
			middle = (first + last)/2;
		}
		
		// Returns index of found String. Otherwise, if not found, returns -1.
		return index;
	}
	
	
	/**
	 * toString{
	 * @return String - a String containing all dictionary words separated by a 
	 * 					newline. 
	 */
	public String toString()
	{
		String str = "";
		
		if (numWords > 0)
			str += ourList[0];
		
		for (int i=1; i<numWords; i++)
		{
			str += "\n";
			str += ourList[i];
		}
		
		return str;
	}	
}
