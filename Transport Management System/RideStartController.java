package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class RideStartController extends ArrivalController{

    @Override
    public void setDriverNumber() throws IOException, InterruptedException {
        driverName.setText(ArrivalController.drivername);
        driverNumber.setText(ArrivalController.drivernumber);
        vehicleNumber.setText(ArrivalController.vehiclenumber);
        destination.setText(LocationController.targetLocationinput);
        arrivalLocation.setText(LocationController.sourceLocationinput);
        arrivalTime.setText(ArrivalController.arrivaltime);
        rideTime.setText(ArrivalController.rideestimatedtime);
    }

    @Override
    public void timer(MouseEvent event) throws InterruptedException, IOException {
        for (int i = 10; i >= 0; i--) {
            thread.sleep(1000);
            System.out.println(i);

            if (i == 0) {
                Parent toArrival = FXMLLoader.load(getClass().getResource("Billing.fxml"));
                Scene toArrival1 = new Scene(toArrival);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(toArrival1);
                window.show();
            }
        }
    }




}
