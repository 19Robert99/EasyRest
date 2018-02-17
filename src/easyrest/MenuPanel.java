/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyrest;

import java.io.IOException;

/**
 *
 * @author robert.talabishka
 */
public class MenuPanel {
    
    public void goStaff() throws IOException{
        NextFormMethot newform = new NextFormMethot();
        newform.showForm("Staff.fxml");
    }
    
    public void main() throws IOException{
        NextFormMethot newform = new NextFormMethot();
        newform.showForm("MainForm.fxml");
    }
}
