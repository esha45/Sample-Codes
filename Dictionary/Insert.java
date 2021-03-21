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

public class Insert {

    Dictionary d1 = new Dictionary();

    @FXML
    public TextField word;

    @FXML
    public TextField meaning;

    public void insert() throws IOException {
        String word1 = word.getText();
        String meaning1 = meaning.getText();

        if(word1.isEmpty() || meaning1.isEmpty()){
            Parent pleaseInsert = FXMLLoader.load(getClass().getResource("PleaseInsert.fxml"));
            Scene pleaseInsert1 = new Scene(pleaseInsert);

            Stage window = new Stage();

            window.setScene(pleaseInsert1);
            window.show();
        }
        else {
            String result = d1.insert(word1,meaning1);
            if(result == "The word Already exist") {
                Parent wordAlreadyExist = FXMLLoader.load(getClass().getResource("WordAlreadyExist.fxml"));
                Scene wordAlreadyExist1 = new Scene(wordAlreadyExist);

                Stage window = new Stage();

                window.setScene(wordAlreadyExist1);
                window.show();
            } else {
                Dictionary.words.add(word1);
                Dictionary.meaning.add(meaning1);
                Parent wordInserted = FXMLLoader.load(getClass().getResource("WordInserted.fxml"));
                Scene wordInserted1 = new Scene(wordInserted);

                Stage window = new Stage();

                window.setScene(wordInserted1);
                window.show();
            }
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
