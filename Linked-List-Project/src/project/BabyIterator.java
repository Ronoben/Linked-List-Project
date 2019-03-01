package project;

public class BabyIterator {
	private BabyLink current;
	private BabyLink previous;
	private BabyLinkedList ourList; // our linked list

	public BabyIterator(BabyLinkedList list) {
		ourList = list;
		reset();
	}

	public void reset() {
		current = ourList.getFirst();
		previous = null;
	}

	public boolean atEnd() {
		return current.getNext() == null;
	}

	public void nextLink() { // iterator moving down one link at a time
		previous = current;
		current = current.getNext();
	}

	public BabyLink getCurrent() {
		return current;
	}

	public void insertAfter(String dd) {
		BabyLink newLink = new BabyLink(dd);
		if (ourList.isEmpty()) {
			ourList.setFirst(newLink);
			current = newLink;
		} else {
			newLink.setNext(current.getNext());
			current.setNext(newLink);
			nextLink();
		}
	}

}
