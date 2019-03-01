package project;

public class MasterLinkedList {
	private MasterLink first;
	private MasterLink last;

	public MasterLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertAfter(String word, String babyWord) {
		MasterLink newLink = find(word);
		if (newLink == null) {
			newLink = new MasterLink(word);
			if (isEmpty()) {
				first = newLink;
			} else {
				last.setNext(newLink);
				newLink.setPrevious(last);
			}
			last = newLink;
		}
		newLink.getBabyList().insertFirst(babyWord);
	}

	public MasterLink find(String key) {
		MasterLink current = first;
		if(isEmpty()){
			return null;
		}
		while (!current.getiData().equals(key)) {
			if (current.getNext() == null) {
				return null;
			} else {
				current = current.getNext();
			}
		}
		return current;
	}

	public MasterLink getFirst() {
		return first;
	}

	public MasterLink setFirst(MasterLink f) {
		return this.first = f;
	}

//	public MasterIterator getIterator() {
//		return new MasterIterator(this);
//	}

	public void displayList() {
		MasterLink current = first;
		while (current != null) {
			current.displayLink();
			current = current.getNext();
		}
		System.out.println();
	}

}
