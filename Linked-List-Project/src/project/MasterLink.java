package project;

public class MasterLink {
	private MasterLink next;
	private MasterLink previous;
	private String iData;
	private BabyLinkedList babyList;

	public MasterLink(String word) {
		this.babyList = new BabyLinkedList();
		this.iData = word;
	}

	public MasterLink getNext() {
		return next;
	}

	public void setNext(MasterLink next) {
		this.next = next;
	}
	
	public MasterLink getPrevious() {
		return previous;
	}
	
	public void setPrevious(MasterLink previous) {
		this.previous = previous;
	}

	public String getiData() {
		return iData;
	}

	public void setiData(String iData) {
		this.iData = iData;
	}
	
	public BabyLinkedList getBabyList() {
		return babyList;
	}

	public void displayLink() {
		System.out.println("Key: " + iData);
		babyList.displayBabyList();
	}

}
