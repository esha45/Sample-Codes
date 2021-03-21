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
import java.sql.*;

public class RegistrationFormController {

    @FXML
    public TextField email;

    @FXML
    public TextField firstname;

    @FXML
    public TextField lastname;

    @FXML
    public TextField newpassword;

    @FXML
    public TextField confirmpassword;

    @FXML
    public TextField contactnumber;

    public void backToLoginForm(MouseEvent event) throws IOException {
        Parent backToLoginForm = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene backToLoginForm1 = new Scene(backToLoginForm);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(backToLoginForm1);
        window.show();
    }

    public void toLoginPage(ActionEvent event) throws IOException, SQLException {

        //      Registering the Driver
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
//      Getting the connection
        String oracleUrl = "jdbc:oracle:thin:@Rauf:1521:transpor";
//      giving Username & Password of database
        Connection con = DriverManager.getConnection(oracleUrl, "rauf", "rauf");
//      Will print after connection was successful
        System.out.println("Connection established Successfully");

        String emailinput = email.getText();
        System.out.println(emailinput);

        String firstnamedinput = firstname.getText();
        System.out.println(firstnamedinput);

        String lastnameinput = lastname.getText();
        System.out.println(lastnameinput);

        String newpasswordinput = newpassword.getText();
        System.out.println(newpasswordinput);

        String confirmpasswordinput = confirmpassword.getText();
        System.out.println(confirmpasswordinput);

        String contactnumberinput = contactnumber.getText();
        System.out.println(confirmpasswordinput);

        //      Using Statement Class to to execute SQL query
        Statement email = con.createStatement();
        String emailQuery="select EMAIL from LOGIN where EMAIL = '"+emailinput+"'";
        System.out.println(emailQuery);
//      Using ResutlSet class to get result from SQL query
        ResultSet resultSetLogin = email.executeQuery(emailQuery);

        if(emailinput.isEmpty() || firstnamedinput.isEmpty() || lastnameinput.isEmpty() || newpasswordinput.isEmpty() || confirmpasswordinput.isEmpty() || contactnumberinput.isEmpty()){
            System.out.println("Field Empty");
            Parent emptyField = FXMLLoader.load(getClass().getResource("EmptyField.fxml"));
            Scene emptyField1 = new Scene(emptyField);

            Stage window = new Stage();

            window.setScene(emptyField1);
            window.show();
        }

        else if (resultSetLogin.next()) {
            String email1 = resultSetLogin.getString("EMAIL");
            System.out.println(email1);
            System.out.println("Already Registered");
            Parent userAlreadyRegistered = FXMLLoader.load(getClass().getResource("AlreadyRegistered.fxml"));
            Scene userAlreadyRegistered1 = new Scene(userAlreadyRegistered);

            Stage window1 = new Stage();

            window1.setScene(userAlreadyRegistered1);
            window1.show();


        }

        else if(newpasswordinput.equals(confirmpasswordinput)){

//      Using Statement Class to to execute SQL query
            Statement registration = con.createStatement();
            String registrationQuery="INSERT into LOGIN values ('"+confirmpasswordinput+"'"+",'"+emailinput+"','"+firstnamedinput+"','"+lastnameinput+"',"+"'"+contactnumberinput+"')";
            System.out.println(registrationQuery);
//      Using ResutlSet class to get result from SQL query
            registration.executeUpdate(registrationQuery);

            String sessionQuery1 = "Create table"+'"'+emailinput+'"'+" (sourceLocation char(30),targetLocation char(30), fare int, ridetype char(10) )";
            ResultSet resultSetSession1 = registration.executeQuery(sessionQuery1);

            Parent toLoginPage = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
            Scene toLoginPage1 = new Scene(toLoginPage);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(toLoginPage1);
            window.show();
        }

        else{
            System.out.println("Passwords do NOT match");
            Parent passwordnotmatch = FXMLLoader.load(getClass().getResource("PasswordDoNotMatch.fxml"));
            Scene passwordnotmatch1 = new Scene(passwordnotmatch);

            Stage window1 = new Stage();

            window1.setScene(passwordnotmatch1);
            window1.show();
        }

    }


}
