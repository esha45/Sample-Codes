package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class WithinCityAnotherCityController {

    public void backToVechicleSelection(MouseEvent event) throws IOException {
        Parent backToVechicleSelection = FXMLLoader.load(getClass().getResource("VehicleSelection.fxml"));
        Scene backToVechicleSelection1 = new Scene(backToVechicleSelection);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(backToVechicleSelection1);
        window.show();
    }


    public void location(ActionEvent event) throws IOException, SQLException {

        RideType.rideType="Bus";

        Parent location = FXMLLoader.load(getClass().getResource("Location.fxml"));
        Scene location1= new Scene(location);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(location1);
        window.show();
    }

    public void getTypeWithinCity(){
        RideType.ridespec="Within City";
    }

    public void getTypeAnotherCity(){
        RideType.ridespec="Another City";
    }
}
