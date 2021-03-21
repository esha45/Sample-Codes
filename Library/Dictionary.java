public class Dictionary extends Book{
	private String sourceLang;
	private String targetLang;

	public Dictionary(String title, String[] authors, String sLang, String tLang){
		super(title, authors);
		this.sourceLang = sLang;
		this.targetLang = tLang;
	}

}