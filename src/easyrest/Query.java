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
public class Query {
    
    @FXML
    static ArrayList<String> arr = new ArrayList<>();
    @FXML
    static String[] myArray = {};

    private static final String url = "jdbc:mysql://localhost:3306/star";

    private static final String user = "rob";

    private static final String password = "rob";

    // JDBC variables for opening and managing connection
    @FXML
    private static Connection con;
    @FXML
    private static Statement stmt;
    @FXML
    private static ResultSet rs;
    
    static String  name = "";
    static String  mess = "";
    static String  images = "" ;
    static String  time = "" ;
    
    public ArrayList<String> exquery(String enter_query, int count){
        // TODO code application logic here
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
            // getting Statement object to execute query
            stmt = con.createStatement();
            // executing SELECT query
            rs = stmt.executeQuery(enter_query);
            

            while (rs.next()) {
                switch(count){
                    case 1:name = rs.getString(1);
                           break;
                    case 2:name = rs.getString(1);
                           mess = rs.getString(2);
                           break;
                    case 3:name = rs.getString(1);
                           mess = rs.getString(2);
                           time = rs.getString(3);                           
                           break;    
                }
                
                arr.add(name+"  "+mess+" "+time);
            }

          //  myArray = arr.toArray(new String[arr.size()]); // конвертируем ArrayList в массив
            
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
            try {
                rs.close();
            } catch (SQLException se) {
            }
        }
        return arr ;
        
    }
    
}
