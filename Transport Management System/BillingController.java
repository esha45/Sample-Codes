package sample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BillingController extends ArrivalController {

    @Override
    public void setDriverNumber() throws IOException, InterruptedException, SQLException {
        //      Registering the Driver
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
//      Getting the connection
        String oracleUrl = "jdbc:oracle:thin:@Rauf:1521:transpor";
//      giving Username & Password of database
        Connection con = DriverManager.getConnection(oracleUrl, "rauf", "rauf");
//      Will print after connection was successful
        System.out.println("Connection established Successfully");
        System.out.println(ArrivalController.estimatedfare);

        //      Using Statement Class to to execute SQL query
        Statement userHistory = con.createStatement();
        String userHistoryQuery = "INSERT into"+'"'+LoginPageController.emailinput+'"'+"values ('"+LocationController.sourceLocationinput+ "','" +LocationController.targetLocationinput+ "','" +RideType.rideType+ "','"+RideType.ridespec+ "','" +ArrivalController.estimatedfare+"')";
//      Using ResutlSet class to get result from SQL query
        userHistory.executeUpdate(userHistoryQuery);

        if(RideType.ridespec.equals("AC")) {

            Fare f1 = new Fare();
            String fare1 = String.valueOf(f1.acCarFair());

            System.out.println(RideType.rideType);
            driverName.setText(ArrivalController.drivername);
            driverNumber.setText(ArrivalController.drivernumber);
            vehicleNumber.setText(ArrivalController.vehiclenumber);
            destination.setText(LocationController.targetLocationinput);
            arrivalLocation.setText(LocationController.targetLocationinput);
            rideTime.setText(ArrivalController.rideestimatedtime);
            fare.setText(fare1);
        }

        if(RideType.ridespec.equals("NON-AC")) {

            Fare f1 = new Fare();
            String fare1 = String.valueOf(f1.nonAcCar());

            System.out.println(RideType.rideType);
            driverName.setText(ArrivalController.drivername);
            driverNumber.setText(ArrivalController.drivernumber);
            vehicleNumber.setText(ArrivalController.vehiclenumber);
            destination.setText(LocationController.targetLocationinput);
            arrivalLocation.setText(LocationController.targetLocationinput);
            rideTime.setText(ArrivalController.rideestimatedtime);
            fare.setText(fare1);
        }

        if(RideType.ridespec.equals("Within City")) {

            Fare f1 = new Fare();
            String fare1 = String.valueOf(f1.withinCity());

            System.out.println(RideType.rideType);
            driverName.setText(ArrivalController.drivername);
            driverNumber.setText(ArrivalController.drivernumber);
            vehicleNumber.setText(ArrivalController.vehiclenumber);
            destination.setText(LocationController.targetLocationinput);
            arrivalLocation.setText(LocationController.targetLocationinput);
            rideTime.setText(ArrivalController.rideestimatedtime);
            fare.setText(fare1);
        }

        if(RideType.ridespec.equals("Another City")) {

            Fare f1 = new Fare();
            String fare1 = String.valueOf(f1.anotherCity());

            System.out.println(RideType.rideType);
            driverName.setText(ArrivalController.drivername);
            driverNumber.setText(ArrivalController.drivernumber);
            vehicleNumber.setText(ArrivalController.vehiclenumber);
            destination.setText(LocationController.targetLocationinput);
            arrivalLocation.setText(LocationController.targetLocationinput);
            rideTime.setText(ArrivalController.rideestimatedtime);
            fare.setText(fare1);
        }
    }
}
