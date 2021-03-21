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

public class Update {

    Dictionary d1 = new Dictionary();

    @FXML
    public TextField word;

    @FXML
    public TextField meaning;

    public void update() throws IOException {

        String word1 = word.getText();
        String meaning1 = meaning.getText();

        if(word1.isEmpty() || meaning1.isEmpty()){
            Parent update = FXMLLoader.load(getClass().getResource("PleaseInsert.fxml"));
            Scene update1 = new Scene(update);

            Stage window = new Stage();

            window.setScene(update1);
            window.show();
        }
        else {
            int temp9 = Dictionary.words.size();
            for(int i=0;i<temp9;i++){
                d1.insert(Dictionary.words.get(i),Dictionary.meaning.get(i));
            }

            String result = d1.update(word1,meaning1);
            if(result == "The given word doesn't exists") {
                Parent wordNotFound = FXMLLoader.load(getClass().getResource("WordNotFound.fxml"));
                Scene wordNotFound1 = new Scene(wordNotFound);

                Stage window = new Stage();

                window.setScene(wordNotFound1);
                window.show();
            }
            else {
                Parent wordInserted = FXMLLoader.load(getClass().getResource("WordUpdated.fxml"));
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
