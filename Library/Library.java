import java.time.LocalTime;
public class Library{
	private String name;
	private LocalTime openTime;
	private LocalTime closeTime;
	private float membershipFee;
	private int capacity;
	private int bookIndex;
	private Book[] collection;

	public Library(String name, LocalTime open, LocalTime close, int cap){
		this.name = name;
		this.openTime = open;
		this.closeTime = close;
		this.capacity = cap;
		this.collection = new Book[this.capacity];
		this.bookIndex = 0;
	}

	public void addDictionary(String title, String[] authors, String sLang, String tLang){
		if(this.bookIndex < this.capacity){
			this.collection[this.bookIndex] = new Dictionary(title, authors, sLang, tLang);
			this.bookIndex ++;
		}
	}

	public void addNovel(String title, String[] authors, String lang){
		if(this.bookIndex < this.capacity){
			this.collection[this.bookIndex] = new Novel(title, authors, lang);
			this.bookIndex ++;
		}
	}

	public void showCollection(){
		for(Book b : this.collection){
			if(b != null){
				System.out.println(b.toString());
			}
		}
	}
}