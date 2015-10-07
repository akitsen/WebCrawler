/*
Copyright 2015
    Westmont College (c/o Donald J. Patterson)
 */

package textProcessing.crawler.a;

//This magic generic foo makes sure T1 and T2 are themselves comparable
public class TwoGram<T extends Comparable<? super T>> extends Pair<T, T>
		implements Comparable<TwoGram<T>> {

	public TwoGram(T first, T second) {
		super(first, second);
	}

	public void setFirst(T first) {
		super.key = first;
	}

	public T getFirst() {
		return super.key;
	}

	public void setSecond(T second) {
		super.value = second;
	}

	public T getSecond() {
		return super.value;
	}
	

	/**
	 * Helper function for compareTo that handles nulls
	 * @param t1, first token to compare
	 * @param t2, second token to compare
	 * @return -1 if t1 should come first, 0 for a tie, 1 if t2 should comefirst
	 */
	private int compareTokens(T t1, T t2) {
		if((t1 == null) && (t2 == null)){
			// Everything is null
			return 0;
		}
		else{
			// At least one of tokens is not null
			if(t1 == null){
				return -1;
			}
			else if(t2 == null){
				return 1;
			}
			else{
				return t1.compareTo(t2);
			}
		}
	}

	@Override
	// This would be trivial except for the possibilities of nulls
	public int compareTo(TwoGram<T> o) {
		if( o == null){
			//Nulls come first
			return 1;
		}
		else{
			T f1 = this.getFirst();
			T f2 = o.getFirst();
			int f = compareTokens(f1,f2);
			if(f != 0){
				return f;
			}
			else{
				T s1 = this.getSecond();
				T s2 = o.getSecond();
				return(compareTokens(s1,s2));
			}
		}
	}

}
