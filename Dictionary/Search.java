package Sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class Search {

    Dictionary d1 = new Dictionary();

    @FXML
    public TextField searchWord;

    @FXML
    public TextField meaning;

    public void search(ActionEvent event) throws IOException {
        int temp9 = Dictionary.words.size();
        for(int i=0;i<temp9;i++){
            d1.insert(Dictionary.words.get(i),Dictionary.meaning.get(i));

        }

        String word = searchWord.getText();
        String result = d1.search2(word,Dictionary.head);
        if(result=="Word Not found"){
            Parent wordNotFound = FXMLLoader.load(getClass().getResource("WordNotFound.fxml"));
            Scene wordNotFound1 = new Scene(wordNotFound);

            Stage window = new Stage();

            window.setScene(wordNotFound1);
            window.show();

        }
        else{
            meaning.setText(result);
        }

    }

    public void BacktoMain(ActionEvent event) throws IOException {
        Parent BacktoMain = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Scene BacktoMain1 = new Scene(BacktoMain);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(BacktoMain1);
        window.show();
    }
}
