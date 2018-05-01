/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olx;

import View.Cadastro;
import View.Principal;
import View.Login;

/**
 *
 * @author gabri
 */
public class OLX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Login login = new Login();
        login.setVisible(true);
        
        
        //Cadastro cadastro = new Cadastro();
        //cadastro.setVisible(true);
        
        Principal cd = new Principal();
        cd.setVisible(true);
        
        
        // TODAS AS TELAS TEM TAMANHO PADRÃO DE (1300,730)
    }
    
}
