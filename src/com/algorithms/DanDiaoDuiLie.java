package com.algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class DanDiaoDuiLie {

	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5,6,7};
		IncressQueue qu = new IncressQueue();
		
		for(int i=0;i<arr.length;i++){
			qu.addNode(arr[i], i);
			
			if(i<2)
				continue;
			
			System.out.println(qu.getLastVal());
			
		}
		
	}

}

class QueueNode implements Comparable<QueueNode> {
	int val;
	int index;

	public QueueNode(int v, int i) {
		val = v;
		index = i;
	}

	@Override
	public int compareTo(QueueNode o) {
		return this.val - o.val;
	}

}

class IncressQueue {
	ArrayList<QueueNode> container;

	public IncressQueue() {
		container = new ArrayList<>();
	}

	public void addNode(int v, int i) {
		QueueNode newNode = new QueueNode(v, i);
		int index = Collections.binarySearch(container, newNode);
//		System.out.println(index);
//		System.out.println(container.size());
		if (index >= 0)
			return;
		container.add(-index-1, newNode);
	}

	public void deleteLast() {
		container.remove(container.size() - 1);
	}

	public int getLastVal() {
		return container.get(container.size() - 1).val;
	}

	public int getLastIndex() {
		return container.get(container.size() - 1).index;
	}
}