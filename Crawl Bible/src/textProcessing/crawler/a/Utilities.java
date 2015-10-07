package textProcessing.crawler.a;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * A collection of utility methods for text processing.
 */
public class Utilities{
	/**
	 * Reads the input text file and splits it into alphanumeric tokens.
	 * Returns an ArrayList of these tokens, ordered according to their
	 * occurrence in the original text file.
	 * 
	 * Non-alphanumeric characters delineate tokens, and are discarded.
	 *
	 * Words are also normalized to lower case. 
	 * 
	 * Example:
	 * 
	 * Given this input string
	 * "An input string, this is! (or is it?)"
	 * 
	 * The output list of strings should be
	 * ["an", "input", "string", "this", "is", "or", "is", "it"]
	 * 
	 * @param input The file to read in and tokenize.
	 * @return The list of tokens (words) from the input file, ordered by occurrence.
	 */
	public static ArrayList<String> tokenizeFile(String input){

		ArrayList<String> outStrings = new ArrayList<String>();  // initialize the list to hold the tokens

		String line = input;
		// go through the file
		// code below copied in part from: http://docs.oracle.com/javase/7/docs/api/java/util/StringTokenizer.html
		String[] test = line.split("[^a-zA-Z0-9]+"); // idea for "[^a-zA-Z0-9]+" taken from: http://alvinalexander.com/blog/post/java/remove-non-alphanumeric-characters-java-string
		// add each alphanumeric token to the list
		for (int i = 0; i < test.length; i++){
			outStrings.add(test[i].toLowerCase());  // normalize the tokens to be all lowercase
		}
		return outStrings;  // return the list of tokens
	}


	/**
	 * Takes a list of {@link Frequency}s and prints it to out. It also
	 * prints out the total number of items, and the total number of unique items.
	 * 
	 * Example one:
	 * 
	 * Given the input list of word frequencies
	 * ["sentence:2", "the:1", "this:1", "repeats:1",  "word:1"]
	 * 
	 * The following should be printed to standard out
	 * 
	 * Total item count: 6
	 * Unique item count: 5
	 * 
	 * sentence	2
	 * the		1
	 * this		1
	 * repeats	1
	 * word		1
	 * 
	 * 
	 * Example two:
	 * 
	 * Given the input list of 2-gram frequencies
	 * ["you think:2", "how you:1", "know how:1", "think you:1", "you know:1"]
	 * 
	 * The following should be printed to standard out
	 * 
	 * Total item count: 6
	 * Unique item count: 5
	 * 
	 * you think	2
	 * how you		1
	 * know how		1
	 * think you	1
	 * you know		1
	 * @param <T>, the type of the thing whose frequencies you are counting
	 * 
	 * @param frequencies A list of frequencies.
	 */
	public static <T extends Comparable<T>> void printFrequencies(BufferedWriter out, List<Frequency<T>> frequencies) {

		int total = 0;      // initialize the variable to hold the total item count
		// find the count of each item and add it to the running total
		for (int i = 0; i < frequencies.size(); i++){
			total += frequencies.get(i).getFrequency();	// add the current frequency total to the running total
		}

		// method for writing to standard output adapted from: http://stackoverflow.com/questions/4405078/how-to-write-to-standard-output-using-bufferedwriter
		try{
			out.write("Total item count:  " + total + "\n");   // print out the total item count
			out.write("Unique item count: " + frequencies.size() + "\n\n"); // print out the unique item count

			// print each item in the list of frequencies
			for (int i = 0; i < frequencies.size(); i++){
				Frequency<T> displayToken = frequencies.get(i); // place the ith token in displayToken
				out.write(String.format("%-15s", displayToken.getToken().toString()) + displayToken.getFrequency() + "\n"); // print out the token and corresponding frequency value
			}
			out.flush();            // flush the writer
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
