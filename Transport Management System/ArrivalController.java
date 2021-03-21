package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ArrivalController {
    static Thread thread = new Thread();

    public static String drivername = "Zohaib Ali";
    public static String drivernumber = "0300-123456";
    public static String vehiclenumber = "ATT-555";
    public static String rideestimatedtime = "1:00 Minutes";
    public static String arrivaltime = "10:00";
    public static String estimatedfare;

    @FXML
    public TextField driverName;
    @FXML
    public TextField driverNumber;
    @FXML
    public TextField vehicleNumber;
    @FXML
    public TextField destination;
    @FXML
    public TextField arrivalLocation;
    @FXML
    public TextField arrivalTime;
    @FXML
    public TextField rideEstimatedTime;
    @FXML
    public TextField estimatedFare;
    @FXML
    public TextField rideTime;
    @FXML
    public TextField fare;

    public void setDriverNumber() throws IOException, InterruptedException, SQLException {
        Fare f1 = new Fare();

        if(RideType.rideType.equals("Car") && RideType.ridespec.equals("AC")){
            float acFare = f1.acCarFair();
            String acFare1 = String.valueOf(acFare);
            estimatedfare=acFare1;
            estimatedFare.setText(acFare1);
        }

        if(RideType.rideType.equals("Car") && RideType.ridespec.equals("NON-AC")){
            float nonAcFare = f1.nonAcCar();
            String nonAcFare1 = String.valueOf(nonAcFare);
            estimatedfare=nonAcFare1;
            estimatedFare.setText(nonAcFare1);
        }

        if(RideType.rideType.equals("Bus") && RideType.ridespec.equals("Within City")){
            float withinCityFare = f1.withinCity();
            String withiCityFare1 = String.valueOf(withinCityFare);
            estimatedfare=withiCityFare1;
            estimatedFare.setText(withiCityFare1);
        }

        if(RideType.rideType.equals("Bus") && RideType.ridespec.equals("Another City")){
            float anotherCityFare = f1.anotherCity();
            String anotherCityFare1 = String.valueOf(anotherCityFare);
            estimatedfare=anotherCityFare1;
            estimatedFare.setText(anotherCityFare1);
        }


        driverName.setText(drivername);
        driverNumber.setText(drivernumber);
        vehicleNumber.setText(vehiclenumber);
        destination.setText(LocationController.targetLocationinput);
        arrivalLocation.setText(LocationController.sourceLocationinput);
        arrivalTime.setText(arrivaltime);
        rideEstimatedTime.setText(rideestimatedtime);

    }

    public void timer(MouseEvent event) throws InterruptedException, IOException {
        for (int i = 5; i >= 0; i--) {
            thread.sleep(1000);
            System.out.println(i);

            if (i == 0) {
                Parent toArrival = FXMLLoader.load(getClass().getResource("RideStart.fxml"));
                Scene toArrival1 = new Scene(toArrival);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(toArrival1);
                window.show();
            }
        }
    }
}