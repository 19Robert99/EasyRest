/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyrest;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

/**
 *
 * @author robert.talabishka
 */
public class NextFormMethot {

    public void showForm(String formname) throws IOException {
        
        Stage stage = new Stage();
        stage.close();
        
        Parent root1 = (Parent) FXMLLoader.load(getClass().getResource(formname));
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Другая форма");
        stage.setScene(new Scene(root1));
        stage.show();
    }

}
