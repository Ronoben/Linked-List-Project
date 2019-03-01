package project;

public class MasterIterator {
	private MasterLink current;
	private MasterLinkedList ourList; // our linked list

	public MasterIterator(MasterLinkedList list) {
		ourList = list;
		reset();
	}

	public void reset() {
		current = ourList.getFirst();
	}

	public boolean atEnd() {
		return current.getNext() == null;
	}

	public void nextLink() { // iterator moving down one link at a time
		current = current.getNext();
	}

	public MasterLink getCurrent() {
		return current;
	}

//	public void insertAfter(String word, String babyWord) {
//		MasterLink newLink = new MasterLink(word);
//		newLink.getBabyList().insertFirst(babyWord);
//		if (ourList.isEmpty()) {
//			ourList.setFirst(newLink);
//			current = newLink;
//		} else {
//			newLink.setNext(current.getNext());
//			current.setNext(newLink);
//			nextLink();
//		}
//
//	}

}
