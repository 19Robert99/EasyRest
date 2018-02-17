/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyrest;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author robert.talabishka
 */
public class MainFormController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    ListView chat;
    @FXML
    TextArea mess;
    @FXML
    Button staff;
    
    MenuPanel menu =  new MenuPanel();
    
    static ArrayList<String> array = new ArrayList<>();
    public static final ObservableList chatlist = FXCollections.observableArrayList();

    
    static ArrayList<String> ent_arr = new ArrayList<>();

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        NextFormMethot newform = new NextFormMethot();
        newform.showForm("Setting.fxml");
    }
    
    @FXML
    private void SendMessage(ActionEvent event) throws IOException {
        
        Calendar dating = Calendar.getInstance();
        SimpleDateFormat formating = new SimpleDateFormat("HH:mm:ss");
        String time = formating.format(dating.getTime());
        
        INSERquery input_query = new INSERquery();
        String message =  mess.getText();  
        
        String query_mes = "INSERT INTO chat(Name,Message,Time) VALUES('Boss', '"+message+"','"+time+"')";
        
       
        input_query.exquery(query_mes);
        
        chat.scrollTo(0);
        
        mess.clear();
        messages();  
        
    }
    
    @FXML
    private void goStaff(ActionEvent event) throws IOException {
        menu.goStaff();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        messages();        
       
    }
    public void messages() {
        chatlist.clear();
        array.clear();
        Query query = new Query();

        String chquery = "SELECT Name,Message,Time FROM chat";
        
        array = query.exquery(chquery,3);
        for (int i = 0; i < array.size(); i++) {
            chatlist.add(array.get(i));
            System.out.println(chatlist.get(i));
        }
        chat.setItems(chatlist);   
    }
    

}
