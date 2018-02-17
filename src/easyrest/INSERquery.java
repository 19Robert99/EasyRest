/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyrest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.fxml.FXML;

/**
 *
 * @author robert.talabishka
 */
public class INSERquery {

    @FXML
    static ArrayList<String> arr = new ArrayList<>();
    @FXML
    static String[] myArray = {};

    private static final String url = "jdbc:mysql://localhost:3306/star?useUnicode=true&characterEncoding=utf-8";

    private static final String user = "rob";

    private static final String password = "rob";

    // JDBC variables for opening and managing connection
    @FXML
    private static Connection con;
    @FXML
    private static Statement stmt;
    @FXML
    private static ResultSet rs;

    MainFormController mrcon;

    public void exquery(String enter_query) {
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
            // getting Statement object to execute query
            stmt = con.createStatement();
            // executing SELECT query                      
            stmt.execute(enter_query);
            

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try {
                con.close();
            } catch (SQLException se) {
            }
            try {
                stmt.close();
            } catch (SQLException se) {
            }

        }

    }
}
