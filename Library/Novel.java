public class Novel extends Book{
	private String language;

	public Novel(String title, String[] authors, String lang){
		super(title, authors);
		this.language = lang;
	}

	@Override
	public String toString(){
		return "Book{" + "title=" + super.getTitle() + ", authors=" + super.getAuthors() + ", Language=" + this.language + "}";
	}

}