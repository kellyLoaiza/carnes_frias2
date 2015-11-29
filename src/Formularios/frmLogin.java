package Formularios;

import Clases.Datos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

    
/**
 *Clase frmLogin
 * @author Kelly
 */
public class frmLogin extends JFrame {

    //Componentes
    private JLabel lblUsuario;
    private JLabel lblContrasena;
    private JLabel lblImagen;
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnAceptar;
    private JButton btnCancelar;

    //Atributos
    private Datos misDatos;
    
    /**
     * sirve para llevarle un valor a los datos
     *
     * @param datos objeto
     */
   
    public void setDatos(Datos datos) {
        misDatos = datos;
    }

    //Creamos Constructor
    public frmLogin() {

        //Propiedades
        setTitle("Ingreso al Sistema");
        setLayout(null);
        setSize(550, 250);
        setLocationRelativeTo(null);
        Icon icoImagen = new ImageIcon(getClass().getResource("/images/cerdologin.gif"));
        //esto hace que el formulario no se pueda cambiar de tamaño
        setResizable(false);

        //Esto hace que cuando se cierre el formulario se cierre toda la aplicacion
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creacion de los ICONOS
        Icon icoAceptar = new ImageIcon(getClass().getResource("/images/login.png"));
        Icon icoCancelar = new ImageIcon(getClass().getResource("/images/cerrarsesion.png"));
        //Creacion de Label y textField
        lblUsuario = new JLabel("Usuario:");
        txtUsuario = new JTextField(10);
        lblContrasena = new JLabel("Contraseña:");
        txtContrasena = new JPasswordField(10);
        lblImagen = new JLabel(icoImagen);
        btnAceptar = new JButton("Ingresar", icoAceptar);
        btnCancelar = new JButton("Cancelar", icoCancelar);

        //Ponemos los Objetos en el formulario
        add(lblUsuario);
        add(txtUsuario);

        add(lblContrasena);
        add(txtContrasena);

        add(btnAceptar);
        add(btnCancelar);
        add(lblImagen);

        //Propiedades de los botones
        btnAceptar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAceptar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnAceptar.setToolTipText("Iniciar Sesion");

        btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnCancelar.setToolTipText("Cancelar Ingreso al Sistema");

        //colocamos los objetos en el formulario con cordenadas
        lblUsuario.reshape(40, 50, 100, 20);
        txtUsuario.reshape(140, 50, 100, 20);
        lblImagen.reshape(270, 10, 200, 200);

        lblContrasena.reshape(40, 80, 100, 20);
        txtContrasena.reshape(140, 80, 100, 20);

        btnAceptar.reshape(40, 110, 100, 50);
        btnCancelar.reshape(160, 110, 100, 50);

        //Creamos eventos de los BOTONES
        btnAceptar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                btnAceptarActionPerformed(ae);
            }

            private void btnAceptarActionPerformed(ActionEvent ae) {

                //Validamos Usuarios
                if (txtUsuario.getText().equals("")) {

                    JOptionPane.showMessageDialog(rootPane, "Debe ingresar un Usuario");
                    txtUsuario.requestFocusInWindow();
                    return;
                }

                if (!misDatos.ValidarUsuario(txtUsuario.getText(), new String(txtContrasena.getPassword()))) {

                    JOptionPane.showMessageDialog(rootPane, "Usuario ó Contraseña Incorrectos");
                    txtUsuario.setText("");
                    txtContrasena.setText("");
                    txtUsuario.requestFocusInWindow();
                    return;
                }

                //Si todo sale bien abrimos el FORMULARIO PRINCIPAL
                setVisible(false);
                frmPrincipal miPrincipal = new frmPrincipal();
                miPrincipal.setExtendedState(MAXIMIZED_BOTH);
                miPrincipal.setDatos(misDatos);
                miPrincipal.setVisible(true);

            }
        });

        //Evento de BOTON CANCELAR
        btnCancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnCancelarActionPerformed(e);
            }

            private void btnCancelarActionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

    }

}
