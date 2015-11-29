package Clases;

import Formularios.frmLogin;


public class CarnesFrias {

   
    public static void main(String[] args) {
        
        /**
         * Creamos objetos de la clase Datos y se lo pasa a todos los formularios
         */
        
        Datos misDatos = new Datos();
        
        /**
         * Creamos objetos de la clase frmLogin
         */
        frmLogin miLogin = new frmLogin();
        
        //para que el formulario salga centrado
        miLogin.setLocationRelativeTo(null);
        
        /**
         * Le estamos pasando los datos de la clase Datos a login
         */
        miLogin.setDatos(misDatos);
        miLogin.setVisible(true);
    }
    
}
