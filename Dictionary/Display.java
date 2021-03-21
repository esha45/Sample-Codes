package Sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class Display {

    Dictionary d1 = new Dictionary();

    public static String word;
    public static String meaning;

    @FXML
    public TextArea show;

    public void BacktoMain(ActionEvent event) throws IOException {
        Parent BacktoMain = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Scene BacktoMain1 = new Scene(BacktoMain);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(BacktoMain1);
        window.show();
    }

    public void showAll(ActionEvent event){
        int temp9 = Dictionary.words.size();
        for(int i=0;i<temp9;i++){
            d1.insert(Dictionary.words.get(i),Dictionary.meaning.get(i));
        }
        d1.display(d1.head);
        show.setText("Words\t"+"|");
        show.appendText("\tMeanings\n");
        show.appendText("_____________________________");
        for(int i=0;i<Dictionary.words.size();i++){
            show.appendText(Dictionary.words.get(i)+" "+"\t"+"|"+"\t");
            show.appendText(Dictionary.meaning.get(i)+"\n");
        }
    }
}
