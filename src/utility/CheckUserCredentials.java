package utility;

import db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckUserCredentials {

    private Connection conn;
    private Statement statement;          //
    private ResultSet resultSet;          //execute query

    public Boolean isUserValid(String email,String password,String role, String loginType) throws SQLException {

        boolean isLoginOk =false;

        conn = DBConnection.getConnection();
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select "+role+loginType+","+role+"Password from "+role+" where "+role+loginType+" = '"+email+
                "' and " +role +"Password = '"+password+"';");

        //select adminEmail, adminPassword from admin where adminEmail = 'aa@gmail.com' and adminPassword = 'aa';

        if (resultSet.next()){
            isLoginOk = true;
        }

        return isLoginOk;
    }
}
