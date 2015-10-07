/*
Copyright 2015
    Westmont College (c/o Prof. Donald J. Patterson)
 */

package textProcessing.crawler.a;


public class Pair<T1, T2>{
	protected T1 key;
	protected T2 value;

	public Pair(T1 k, T2 v) {
		key = k;
		value = v;
	}

	public T1 getKey() {
		return key;
	}

	public T2 getValue() {
		return value;
	}

	public String toString() {
		return (key.toString() + " " + value.toString());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getKey() == null) ? 0 : getKey().hashCode());
		result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		Pair<T1,T2> other = (Pair<T1, T2>) obj;
		if (getKey() == null) {
			if (other.getKey() != null)
				return false;
		} else if (!getKey().equals(other.getKey()))
			return false;
		if (getValue() == null) {
			if (other.getValue() != null)
				return false;
		} else if (!getValue().equals(other.getValue()))
			return false;
		return true;
	}
}
