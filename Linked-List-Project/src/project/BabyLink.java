package project;

public class BabyLink {
	private BabyLink next;
	private String iData;
	
	public BabyLink(String iData) {
		this.iData = iData;
	}

	public BabyLink getNext() {
		return next;
	}

	public void setNext(BabyLink next) {
		this.next = next;
	}

	public String getiData() {
		return iData;
	}

	public void setiData(String iData) {
		this.iData = iData;
	}
	
	public void displayBabyLink() {
		System.out.println("{ " + iData + " }");
	}

}
