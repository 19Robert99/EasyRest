/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyrest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.security.MessageDigest;
import java.sql.*;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.*;

/**
 *
 * @author robert.talabishka
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    static ArrayList<String> arr = new ArrayList<>();
    @FXML
    static String[] myArray = {};

    private static final String url = "jdbc:mysql://localhost:3306/star";

    private static final String user = "root";

    private static final String passwordad = "";

    // JDBC variables for opening and managing connection
    @FXML
    private static Connection con;
    @FXML
    private static Statement stmt;
    @FXML
    private static ResultSet rs;

    //  static String log;
    @FXML
    public static String pas;
    @FXML
    public static String log;

    @FXML
    private TextField login;
    @FXML
    private TextField password;
    @FXML
    private Button btn;
    @FXML
    EasyRest er;


    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        log = login.getText();
        pas = password.getText();
        rez();
    }

    public static String getSha256(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(value.getBytes());
            return bytesToHex(md.digest());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte b : bytes) {
            result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }

    public void rez() throws IOException {
        // TODO code application logic here
        String heshpas = getSha256(pas);
        String query = "SELECT email,password FROM users WHERE email = '" + log + "' AND password = '" + heshpas + "'";

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, passwordad);
            // getting Statement object to execute query
            stmt = con.createStatement();
            // executing SELECT query
            rs = stmt.executeQuery(query);

            if (rs.isBeforeFirst()) {

                NextFormMethot newform = new NextFormMethot();
                newform.showForm("MainForm.fxml");

            } else {
                JOptionPane.showMessageDialog(null, "Логин или пароль неправильный", null, JOptionPane.OK_CANCEL_OPTION);
            }

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
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
