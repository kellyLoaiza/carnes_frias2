package Clases;

public class Datos {

    private int maxUsu = 50;
    private Usuario misUsuarios[] = new Usuario[maxUsu];
    private int contUsu = 0;

    //Constructor de la clase datos
    public Datos() {
        cargarUsuarios();
        
    }
    
    

    public boolean ValidarUsuario(String usuario, String contrasena) {

        if (usuario.equalsIgnoreCase("alex") && contrasena.equals("123")) {
            return true;
        } else {
            return false;
        }

    }

    private void cargarUsuarios(){
        Usuario miUsuario;
        
        miUsuario = new Usuario("1", "Pepe","Perez", "1234", 0);
        //Meter este Usuario al arreglo de usuarios
        misUsuarios[contUsu] = miUsuario;
        contUsu++;
        
        miUsuario = new Usuario("2", "casimiro","te cojo", "12345", 1);
        //Meter este Usuario al arreglo de usuarios
        misUsuarios[contUsu] = miUsuario;
        contUsu++;
        
        miUsuario = new Usuario("3", "marco","tulio", "123456", 0);
        //Meter este Usuario al arreglo de usuarios
        misUsuarios[contUsu] = miUsuario;
        contUsu++;
        
    }
    
    public int numeroUsuarios(){
        return contUsu;
    }
    
    //este metodo nos va a devolver un arreglo de todos los usuarios
    public Usuario[] getUsuarios(){
    
        return misUsuarios;
}
}

