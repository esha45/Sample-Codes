package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LocationController {

    public static String sourceLocationinput;
    public static String targetLocationinput;

    @FXML
    public TextField sourceLocation;

    @FXML
    public TextField targetLocation;

    public void backToVeACnonAC(MouseEvent event) throws IOException {
        Parent backToVeACnonAC = FXMLLoader.load(getClass().getResource("ACnonAC.fxml"));
        Scene backToVeACnonAC1 = new Scene(backToVeACnonAC);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(backToVeACnonAC1);
        window.show();
    }

    public void toArrival(MouseEvent event) throws IOException, InterruptedException, SQLException {


        sourceLocationinput = sourceLocation.getText();
        System.out.println(sourceLocationinput);
        targetLocationinput = targetLocation.getText();
        System.out.println(targetLocationinput);

        if(sourceLocationinput.isEmpty() || targetLocationinput.isEmpty()){
            System.out.println("Field Empty");
            Parent emptyField = FXMLLoader.load(getClass().getResource("EmptyField.fxml"));
            Scene emptyField1 = new Scene(emptyField);

            Stage window = new Stage();

            window.setScene(emptyField1);
            window.show();
        }

        else {

            //      Registering the Driver
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
//      Getting the connection
            String oracleUrl = "jdbc:oracle:thin:@Rauf:1521:transpor";
//      giving Username & Password of database
            Connection con = DriverManager.getConnection(oracleUrl, "rauf", "rauf");
//      Will print after connection was successful
            System.out.println("Connection established Successfully");

            //      Using Statement Class to to execute SQL query
            Statement location = con.createStatement();
            String locationQuery = "INSERT into LOCATION values ('" + LoginPageController.emailinput + "','" + sourceLocationinput + "','" + targetLocationinput + "')";
            System.out.println(locationQuery);
//      Using ResutlSet class to get result from SQL query
            location.executeUpdate(locationQuery);

            Parent toArrival = FXMLLoader.load(getClass().getResource("Arrival.fxml"));
            Scene toArrival1 = new Scene(toArrival);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(toArrival1);
            window.show();
        }
    }
}








