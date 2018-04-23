package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" +dbPort + "/" + dbName;

        Class.forName("com.mysql.jddc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUsers(String firstName, String lastName, String privateCode, String group,
                            String userName, String password){
        String insert = "INSERT INTO" + Const.USER_TABLE + "(" +
                Const.USER_FIRSTNAME + "," + Const.USER_LASTNAME + "," +
                Const.USER_PRIVATECODE + "," + Const.USER_GROUP + "," +
                Const.USER_USERNAME + "," + Const.USER_PASSWORD + "," +
                ")" + "VALUES(?, ?, ?, ?, ?, ?)";

        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, firstName);
            prSt.setString(2, lastName);
            prSt.setString(3, privateCode);
            prSt.setString(4, group);
            prSt.setString(5, userName);
            prSt.setString(6, password);

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
