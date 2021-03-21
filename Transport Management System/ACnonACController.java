package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class ACnonACController {

    public void backToVechicleSelection(MouseEvent event) throws IOException {
        Parent backToVechicleSelection = FXMLLoader.load(getClass().getResource("VehicleSelection.fxml"));
        Scene backToVechicleSelection1 = new Scene(backToVechicleSelection);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(backToVechicleSelection1);
        window.show();
    }


    public void location(ActionEvent event) throws IOException {
        RideType.rideType = "Car";
        Parent location = FXMLLoader.load(getClass().getResource("Location.fxml"));
        Scene location1= new Scene(location);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(location1);
        window.show();
    }

    public void gettypeAC(){
        RideType.ridespec="AC";
    }

    public void gettypeNONAC(){
        RideType.ridespec="NON-AC";
    }





}
