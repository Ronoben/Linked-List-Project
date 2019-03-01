package project;

public class BabyLinkedList {
	private BabyLink first;

	public boolean isEmpty() {
		return first == null;
	}
	
	public BabyLink getFirst() {
		return first;
	}
	
	public BabyLink setFirst(BabyLink f) {
		return this.first = f;
	}

	public void insertFirst(String word) {
		BabyLink newLink = new BabyLink(word);
		newLink.setNext(first);
		first = newLink;
	}

	public BabyLink find(int key) {
		BabyLink current = first;
		while (current.getiData().equals(key)) {
			if (current.getNext() == null) {
				return null;
			} else {
				current = current.getNext();
			}
		}
		return current;
	}
	
	public void displayBabyList() {
		BabyLink current = first;
		while (current != null) {
			current.displayBabyLink();
			current = current.getNext();
		}
		System.out.println();
	}
	
	public BabyIterator getIterator() {
		return new BabyIterator(this);
	}

	public int getSize() {
		int c = 0;
		BabyLink current = first;
		while (current != null) {
			c++;
			current = current.getNext();
		}
		return c;
		
	}

}
