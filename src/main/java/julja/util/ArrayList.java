package julja.util;

import java.util.Arrays;

public class ArrayList<E> {

	private static final int DEFAULT_CAPACITY = 100;
	private int size = 0;
	private Object[] list; 

	public ArrayList() {
		list = new Object[DEFAULT_CAPACITY];
	}

	public ArrayList(int capacity) {
		if (capacity < DEFAULT_CAPACITY || capacity > 10000)
			this.list = new Object[DEFAULT_CAPACITY];
		else
			this.list = new Object[capacity];
	}

	public int getSize() {
		return this.size;
	}

	@SuppressWarnings("unchecked")
	public E[] toArray(E[] arr) {
		if(arr.length < this.size) {
			return (E[]) Arrays.copyOf(this.list, this.size, arr.getClass());
		}
		System.arraycopy(this.list, 0, arr, 0, this.size);
		return arr;
	}


	public void add(E obj) {
		if (this.list.length == this.size) {
			int oldC = this.list.length;
			int newC = oldC + (oldC >> 1);
			Arrays.copyOf(this.list, newC);
		}
		this.list[this.size++] = obj;
	}
	
	@SuppressWarnings("unchecked")
	public E get(int idx) {
		if (idx >= 0 && idx <this.size) {
			return (E)this.list[idx];
		} else {
			return null;
		}
	}
}
