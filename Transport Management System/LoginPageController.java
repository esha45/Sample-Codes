package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;
//---------------------------------------------------------------------------------------------------------------------
public class LoginPageController {

    public static String emailinput;

//  Email Text field ID:email
    @FXML
    public TextField email;

//  Password Text field ID:password
    @FXML
    public TextField password;

    public void vehicleSelection(ActionEvent event) throws IOException, SQLException {

//      Getting User input from email textfield
        emailinput = email.getText();
        System.out.println("User Email input : " + emailinput);

//      Getting User input from passworfield
        String passwordinput = password.getText();
        System.out.println("User Password input : " + passwordinput);

//      if this condition becomes true you will login as admin
        if (emailinput.equals("admin") && passwordinput.equals("admin")) {
            Parent administration = FXMLLoader.load(getClass().getResource("Administration.fxml"));
            Scene administration1 = new Scene(administration);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(administration1);
            window.show();
        } else {

//      Registering the Driver
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
//      Getting the connection
            String oracleUrl = "jdbc:oracle:thin:@Rauf:1521:transpor";
//      giving Username & Password of database
            Connection con = DriverManager.getConnection(oracleUrl, "rauf", "rauf");
//      Will print after connection was successful
            System.out.println("Connection established Successfully");

//      Using Statement Class to execute SQL query
//      Retrieving user input detail from database
            Statement login = con.createStatement();
            String loginQuery = "select EMAIL,PASSWORD from LOGIN where EMAIL = '" + emailinput + "'" + "and PASSWORD ='" + passwordinput + "'";
            System.out.println(loginQuery);
//      Using ResutlSet class to get result from SQL query
            ResultSet resultSetLogin = login.executeQuery(loginQuery);

//          If you leave any field empty then a popup window will open
            if (emailinput.isEmpty() || passwordinput.isEmpty()) {
                System.out.println("Field Empty");
                Parent emptyField = FXMLLoader.load(getClass().getResource("EmptyField.fxml"));
                Scene emptyField1 = new Scene(emptyField);

                Stage window = new Stage();

                window.setScene(emptyField1);
                window.show();
            }

//      Validating User's entered detail from database
            else if (resultSetLogin.next()) {
                String email1 = resultSetLogin.getString("EMAIL");
                String pasword1 = resultSetLogin.getString("PASSWORD");
                System.out.println("Login Email : " + email1);
                System.out.println("Login Password : " + pasword1);
                System.out.println("Successfully Login");

//              Verifying is user's table already present or not
                String sessionQuery = "select * from all_objects where OBJECT_NAME=" + "'" + emailinput + "'";
                ResultSet resultSetSession = login.executeQuery(sessionQuery);

//              If table present then Table Already exist print.
                if (resultSetSession.next()) {
                    System.out.println("Table Already exist");
                } else {
//                  Else Create User table to maintain user history
                    String sessionQuery1 = "Create table" + '"' + emailinput + '"' + " (sourceLocation char(30),targetLocation char(30), Vehicle char(5), ridetype char(10) , fare int )";
                    ResultSet resultSetSession1 = login.executeQuery(sessionQuery1);
                }

//              Then proceed to Vehicle selection page
                Parent vehicleSelection = FXMLLoader.load(getClass().getResource("VehicleSelection.fxml"));
                Scene vechicleSelection1 = new Scene(vehicleSelection);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(vechicleSelection1);
                window.show();
            }

//      Alter box popup when user enter wrong email or password
            else {
                System.out.println("Login Attempt Unsuccessfull");
                Parent vehicleSelection = FXMLLoader.load(getClass().getResource("InvalidPassword.fxml"));
                Scene vechicleSelection1 = new Scene(vehicleSelection);

                Stage window = new Stage();

                window.setScene(vechicleSelection1);
                window.show();
            }
        }
    }

//  Will proceed to Registration page
    public void registrationForm(ActionEvent event) throws IOException {
        Parent registrationForm = FXMLLoader.load(getClass().getResource("RegistrationForm.fxml"));
        Scene registrationForm1 = new Scene(registrationForm);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(registrationForm1);
        window.show();
    }
}
