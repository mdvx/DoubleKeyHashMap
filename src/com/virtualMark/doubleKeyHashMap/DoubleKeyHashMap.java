package com.virtualMark.doubleKeyHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DoubleKeyHashMap<T1, T2, T3> {

	private HashMap<Pair<T1, T2>, T3> hashMap;

	public DoubleKeyHashMap() {
		hashMap = new HashMap<Pair<T1, T2>, T3>();
	}

	@SuppressWarnings("hiding")
	class Pair<T1, T2> {
		T1 key1;
		T2 key2;

		Pair() {
			super();
		}

		Pair(T1 key1, T2 key2) {
			this.key1 = key1;
			this.key2 = key2;
		}

		@Override
		public int hashCode() {
			return this.key1.hashCode() + this.key2.hashCode();
		}

		@Override
		public boolean equals(Object obj) {

			if (obj == this)
				return true;
			if (!(obj instanceof Pair)) {
				return false;
			}
			@SuppressWarnings("unchecked")
			Pair<T1, T2> pair = (Pair<T1, T2>) obj;

			if (this.key1.equals(pair.key1) && this.key2.equals(pair.key2)) {
				return true;
			}
			return false;
		}
	}

	public T3 put(T1 key1, T2 key2, T3 value) {
		T3 previouseValue = null;
		previouseValue = this.hashMap.get(new Pair<T1, T2>(key1, key2));
		this.hashMap.put(new Pair<T1, T2>(key1, key2), value);
		return previouseValue;
	}

	public T3 get(T1 key1, T2 key2) {
		T3 value = null;
		value = this.hashMap.get(new Pair<T1, T2>(key1, key2));
		return value;
	}

	public T3 remove(T1 key1, T2 key2) {
		T3 previouseValue = null;
		previouseValue = this.hashMap.get(new Pair<T1, T2>(key1, key2));
		this.hashMap.remove(new Pair<T1, T2>(key1, key2));
		return previouseValue;
	}

	public boolean containsKey(T1 key1, T2 key2) {
		return this.hashMap.containsKey(new Pair<T1, T2>(key1, key2));
	}

	public Set<Pair<T1, T2>> keySet() {
		Set<Pair<T1, T2>> keySet;
		keySet = this.hashMap.keySet();
		return keySet;
	}

	public int size() {
		return this.hashMap.size();
	}
	
	public Iterator<Pair<T1, T2>> iterator(){
		return this.keySet().iterator();
	}

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer("{\n");
		Set<Pair<T1, T2>> keySet = this.keySet();
		Iterator<Pair<T1, T2>> itr = keySet.iterator();
		while (itr.hasNext()) {
			Pair<T1, T2> keyPair = (Pair<T1, T2>) itr.next();
			stringBuffer.append("   [" + keyPair.key1 + ", " + keyPair.key2 + "] = "
					+ this.hashMap.get(new Pair<T1, T2>(keyPair.key1, keyPair.key2)));
			if(itr.hasNext()) {
				stringBuffer.append(",\n");
			}
		}
		stringBuffer.append("\n}");
		return stringBuffer.toString();
	}

}
