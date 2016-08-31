package com.data_structer;

import java.util.ArrayList;
import java.util.HashMap;

public final class Insert_Delete_GetRandom_O_1__Duplicates_allowed_381 {

	public static void main(String[] args) {

	}

}

class RandomizedCollection {
	HashMap<Integer, ArrayList<Integer>> map;
	ArrayList<Integer> list;
	java.util.Random r = new java.util.Random();

	public RandomizedCollection() {
		map = new HashMap<Integer, ArrayList<Integer>>();
		list = new ArrayList<Integer>();
	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		list.add(val);
		if (map.containsKey(val)) {
			ArrayList<Integer> li = map.get(val);
			li.add(list.size() - 1);
			map.put(val, li);
			return false;
		} else {
			ArrayList<Integer> li = new ArrayList<>();
			li.add(list.size() - 1);
			map.put(val, li);
			return true;
		}
	}

	/**
	 * Removes a value from the collection. Returns true if the collection
	 * contained the specified element.
	 */
	public boolean remove(int val) {
		if (map.containsKey(val)) {
			ArrayList<Integer> li = map.get(val);

			int last_index = li.get(li.size()-1);
			li.remove(li.size()-1);

			if (last_index == list.size() - 1) {
				// do
			}else{
				int last_val = list.get(list.size()-1);
				ArrayList<Integer> last_li = map.get(last_val);
				list.set(last_index, last_val);
				last_li.remove((Integer)(list.size()-1));
				last_li.add(last_index);
			}
			list.remove(list.size()-1);
			
			if (li.size() == 0)
				map.remove(val);
			
			return true;
		} else {
			return false;
		}
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		int index = r.nextInt(list.size());
		return list.get(index);
	}
}