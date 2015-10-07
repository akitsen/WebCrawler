package textProcessing.crawler.a;

/**
 * Basic class for pairing a word/2-gram/palindrome with its frequency.
 * 
 * DO NOT MODIFY THIS CLASS (but you can subclass it)
 */
public class Frequency<T extends Comparable<T>> {
    private final T token;
	private int frequency;
	
	public Frequency(T token) {
		this.token = token;
		this.frequency = 0;
	}
	
	public Frequency(T token, int frequency) {
		this.token = token;
		this.frequency = frequency;
	}
	
	public T getToken() {
		return token;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public void incrementFrequency() {
		frequency++;
	}
	
	@Override
	public String toString() {
		return token.toString() + ":" + frequency;
	}
}
