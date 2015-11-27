package Formularios;

import Clases.Datos;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;


/**
 * Esta es la clase frmUsuario
 * @author Kelly
 */
public class frmUsuarios extends JInternalFrame {

    private JLabel lblIDUsuario;
    private JLabel lblPerfil;
    private JLabel lblNombres;
    private JLabel lblApellidos;
    private JLabel lblContrasena;
    private JLabel lblConfirmacion;
    private JLabel lblMensaje;
    private JLabel lblImagen;

    private JTextField txtIDUsuario;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JPasswordField txtContrasena;
    private JPasswordField txtConfirmacion;
    private JComboBox cmbPerfil;

    private JButton btnNuevo;
    private JButton btnModificar;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JButton btnBorrar;
    private JButton btnBuscar;

    private JTable tabla;
    private DefaultTableModel miTabla;
    private JScrollPane scrollTabla;

    //Arreglo del comboBox
    private String perfil[] = {"Administrador", "Empleado"};

    //Atributos
    private Datos misDatos;

    public void setDatos(Datos datos) {
        misDatos = datos;
    }

    //Creamos el constructor
    public frmUsuarios() {
   //Definimos propiedades del formulario

        //se puede cerrar el formulario
        setClosable(true);

        //se puede minimizar el formulario
        setIconifiable(true);

        //No se puede cambiar de tamaño
        setResizable(false);

        setTitle("Usuarios");
        setLayout(null);
        setSize(940, 500);

        Icon icoImagen = new ImageIcon(getClass().getResource("/images/usuario.gif"));

        //Creamos Componentes
        lblIDUsuario = new JLabel("Id Usuario: *");
        txtIDUsuario = new JTextField(10);

        lblPerfil = new JLabel("Perfil: *");
        cmbPerfil = new JComboBox(perfil);

        lblNombres = new JLabel("Nombres: *");
        txtNombres = new JTextField(10);

        lblApellidos = new JLabel("Apellidos: *");
        txtApellidos = new JTextField(10);

        lblContrasena = new JLabel("Contraseña: *");
        txtContrasena = new JPasswordField(10);

        lblConfirmacion = new JLabel("Confirmar: *");
        txtConfirmacion = new JPasswordField(10);

        lblMensaje = new JLabel("Campos Obligatorios *");

        lblImagen = new JLabel(icoImagen);
        //ponemos imagen

        btnNuevo = new JButton("Nuevo");
        btnGuardar = new JButton("Guardar");
        btnBorrar = new JButton("Borrar");
        btnCancelar = new JButton("Cancelar");
        btnModificar = new JButton("Modificar");
        btnBuscar = new JButton("Buscar");

        tabla = new JTable();
        scrollTabla = new JScrollPane();

        scrollTabla.setViewportView(tabla);

        //Adicion de los componentes
        add(lblIDUsuario);
        add(txtIDUsuario);
        add(lblPerfil);
        add(cmbPerfil);
        add(lblNombres);
        add(txtNombres);
        add(lblApellidos);
        add(txtApellidos);
        add(lblContrasena);
        add(txtContrasena);
        add(lblConfirmacion);
        add(txtConfirmacion);
        add(lblMensaje);
        add(btnGuardar);
        add(btnCancelar);
        add(btnNuevo);
        add(btnBorrar);
        add(btnBuscar);
        add(scrollTabla);
        add(lblImagen);

        //Colocamos los componentes en el formulario
        lblImagen.reshape(550, 30, 400, 400);
        
        lblIDUsuario.reshape(20, 20, 110, 20);
        txtIDUsuario.reshape(130, 20, 100, 20);

        lblPerfil.reshape(300, 20, 120, 20);
        cmbPerfil.reshape(400, 20, 100, 20);

        lblNombres.reshape(20, 45, 110, 20);
        txtNombres.reshape(130, 45, 370, 20);

        lblApellidos.reshape(20, 70, 110, 20);
        txtApellidos.reshape(130, 70, 370, 20);

        lblContrasena.reshape(20, 95, 110, 20);
        txtContrasena.reshape(130, 95, 100, 20);

        lblConfirmacion.reshape(300, 95, 110, 20);
        txtConfirmacion.reshape(400, 95, 100, 20);

        lblMensaje.reshape(20, 140, 400, 20);

        btnGuardar.reshape(20, 170, 100, 30);
        btnCancelar.reshape(130, 170, 100, 30);
        btnNuevo.reshape(240, 170, 100, 30);
        btnModificar.reshape(300, 170, 100, 30);
        btnBuscar.reshape(350, 170, 100, 30);
        btnBorrar.reshape(460, 170, 100, 30);

        scrollTabla.reshape(20, 215, 540, 460);

        //Eventos del Formulario
        addInternalFrameListener(new InternalFrameListener() {

            @Override
            public void internalFrameOpened(InternalFrameEvent ife) {

                formInternalFrameOpened(ife);
            }

            @Override
            public void internalFrameClosing(InternalFrameEvent ife) {
            }

            @Override
            public void internalFrameClosed(InternalFrameEvent ife) {
            }

            @Override
            public void internalFrameIconified(InternalFrameEvent ife) {
            }

            @Override
            public void internalFrameDeiconified(InternalFrameEvent ife) {
            }

            @Override
            public void internalFrameActivated(InternalFrameEvent ife) {
            }

            @Override
            public void internalFrameDeactivated(InternalFrameEvent ife) {
            }

            private void formInternalFrameOpened(InternalFrameEvent ife) {

                llenarTabla();
            }

        });

    }

    private void llenarTabla() {

        String titulos[] = {"ID Usuario", "Perfil", "Nombres", "Apellidos"};
        String registro[] = new String[4];
        miTabla = new DefaultTableModel(null, titulos);

        for (int i = 0; i < misDatos.numeroUsuarios(); i++) {

            //en la posicion cero cargamos el codigo del usuario y asi sucesivamente
            registro[0] = misDatos.getUsuarios()[i].getIdUsuario();
            registro[1] = misDatos.getUsuarios()[i].getNombres();
            registro[2] = misDatos.getUsuarios()[i].getApellidos();
            registro[3] = "" + misDatos.getUsuarios()[i].getPerfil();

            miTabla.addRow(registro);

        }
        tabla.setModel(miTabla);

    }

}
