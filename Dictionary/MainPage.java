package Sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainPage {

    Dictionary d1 = new Dictionary();

    public void search(ActionEvent event) throws IOException {
        Parent search = FXMLLoader.load(getClass().getResource("Search.fxml"));
        Scene search1 = new Scene(search);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(search1);
        window.show();
    }

    public void insert(ActionEvent event) throws IOException {
        Parent insert = FXMLLoader.load(getClass().getResource("Insert.fxml"));
        Scene insert1 = new Scene(insert);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(insert1);
        window.show();
    }

    public void update(ActionEvent event) throws IOException {
        Parent update = FXMLLoader.load(getClass().getResource("Update.fxml"));
        Scene update1 = new Scene(update);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(update1);
        window.show();
    }

    public void delete(ActionEvent event) throws IOException {
        Parent delete = FXMLLoader.load(getClass().getResource("Delete.fxml"));
        Scene delete1 = new Scene(delete);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(delete1);
        window.show();
    }

    public void display(ActionEvent event) throws IOException {
        Parent display = FXMLLoader.load(getClass().getResource("Display.fxml"));
        Scene display1 = new Scene(display);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(display1);
        window.show();
    }

    public void exit(ActionEvent event){
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();
    }
}
