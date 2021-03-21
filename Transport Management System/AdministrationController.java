package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.*;

public class AdministrationController {

    @FXML
    public TextArea userArea;

    public void showUser() throws SQLException {
        //      Registering the Driver
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
//      Getting the connection
        String oracleUrl = "jdbc:oracle:thin:@Rauf:1521:transpor";
//      giving Username & Password of database
        Connection con = DriverManager.getConnection(oracleUrl, "rauf", "rauf");
//      Will print after connection was successful
        System.out.println("Connection established Successfully");

//      Using Statement Class to execute SQL query
        Statement showUser = con.createStatement();
        String showUserQuery="select EMAIL from LOGIN";
        System.out.println(showUserQuery);
//      Using ResutlSet class to get result from SQL query
        ResultSet resultSetLogin = showUser.executeQuery(showUserQuery);
        int count=0;
        while(resultSetLogin.next()) {

            String showUser1 = resultSetLogin.getString("EMAIL");
            System.out.println(showUser1);
            userArea.appendText(count+". "+showUser1+"\n");
            count++;


        }
    }

    public void logOff(ActionEvent event) throws IOException {
        Parent logOff = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene logOff1 = new Scene(logOff);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(logOff1);
        window.show();
    }


}
