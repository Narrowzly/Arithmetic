package c1;

public class Stack<Item> {
	private int size;
	private Item[] items = (Item[])new Object[1];
	public boolean isEmpty() {
		return size == 0;
	}
	public int size() {
		return size;
	}
	public void resize(int n) {
		Item[] temp = (Item[])new Object[n];
		System.arraycopy(items, 0, temp, 0, Math.min(temp.length, items.length));
		items = temp;
	}
	public void push(Item item) {
		if(size==items.length) resize(2*items.length);
		items[size++] = item;	
	}
	public Item pop(){
		Item item = items[--size];
		items[size] = null;
		if(size>0&&size==items.length/4) resize(items.length/2);//直接操作length的
		return item;
	}
}

