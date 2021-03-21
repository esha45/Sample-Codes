package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class VehicleSelectionController {
    public void acNonAC(ActionEvent event) throws IOException {
        Parent acNonAC = FXMLLoader.load(getClass().getResource("ACnonAC.fxml"));
        Scene acNonAC1 = new Scene(acNonAC);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(acNonAC1);
        window.show();
    }

    public void withincityanothercity(ActionEvent event) throws IOException {
        Parent withincityanothercity = FXMLLoader.load(getClass().getResource("WithinCityAnotherCity.fxml"));
        Scene withincityanothercity1 = new Scene(withincityanothercity);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(withincityanothercity1);
        window.show();
    }

    public void logOff(ActionEvent event) throws IOException {
        Parent logOff = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene logOff1 = new Scene(logOff);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(logOff1);
        window.show();
    }
}
