import java.time.LocalTime;
public class Test{
	public static void main(String args[]){
		Library lib = new Library("MAJU-CL", LocalTime.now(), LocalTime.now(), 100);
		lib.addNovel("AmarBail", new String[]{"Umera Ahmed"}, "Urdu");
		lib.addNovel("Pinjar", new String[]{""}, "Punjabi");
		lib.addNovel("The Alchemist", new String[]{"Paulo Coelho"}, "Protoguese");
		lib.addDictionary("Oxford Urdu-Eng Dictionay", new String[]{"Shan ul Haq Haqqi"}, "English", "Urdu");
		lib.addDictionary("Panjabi-English Dicitionay", new String[]{"Bhai Maya Singh", "Najam Sethi"}, "Punjabi", "Englsih");
		lib.showCollection();

	}
}