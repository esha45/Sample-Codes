import java.time.LocalTime;

public class Book{
	private String title;
	private String[] authors;
	private int edition;
	private int pages;

	public Book(String title, String[] authors){
		this.title = title;
		this.authors = authors;
	}

	public String getTitle(){ return this.title; }
	public String[] getAuthors(){ return this.authors; }

	@Override
	public String toString(){
		return "Book{" + "title=" + this.title + ", authors=" + this.authors + "}";
	}
}