package Formularios;

import Clases.Datos;
import Clases.DesktopConFondo;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar.Separator;

/**
 *Clase frmPrincipal
 * @author Kelly 
 */

public class frmPrincipal extends JFrame {

    //Objetos
    private JMenuBar mnbMenu;
    private JMenu mnuArchivo;
    private JMenu mnuFactura;
    private JMenu mnuAyuda;

    private JMenuItem mnuArchivoClientes;
    private JMenuItem mnuArchivoProductos;
    private JMenuItem mnuArchivoUsuarios;
    private JMenuItem mnuArchivoSalir;
    private Separator mnuSeparador;

    private JMenuItem mnuFacturaReporteFactura;
    private JMenuItem mnuFacturaNuevaFactura;

    private JMenuItem mnuAyudaAyuda;
    private JMenuItem mnuAyudaAcercade;
    private JDesktopPane dpnEscritorio;
    
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


    public frmPrincipal() {

        //Propiedades del formulario
        setTitle("Carnes Frias");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);

        //definicion de iconos
        Icon icoArchivo = new ImageIcon(getClass().getResource("/images/archivo.png"));
        Icon icoArchivoClientes = new ImageIcon(getClass().getResource("/images/clientes.png"));
        Icon icoArchivoProductos = new ImageIcon(getClass().getResource("/images/productos.png"));
        Icon icoArchivoUsuarios = new ImageIcon(getClass().getResource("/images/usuarios.png"));
        Icon icoArchivoSalir = new ImageIcon(getClass().getResource("/images/salir.png"));

        Icon icoFactura = new ImageIcon(getClass().getResource("/images/factura.png"));
        Icon icoFacturaNueva = new ImageIcon(getClass().getResource("/images/nuevafactura.png"));
        Icon icoFacturaReporte = new ImageIcon(getClass().getResource("/images/reportefactura.png"));

        Icon icoAyuda = new ImageIcon(getClass().getResource("/images/ayuda.png"));
        Icon icoAyudaAyuda = new ImageIcon(getClass().getResource("/images/ayudaayuda.png"));
        Icon icoAyudaAcercade = new ImageIcon(getClass().getResource("/images/acercade.png"));

        //Creacion de los menus
        mnbMenu = new JMenuBar();

        mnuArchivo = new JMenu("Archivo");
        mnuArchivo.setIcon(icoArchivo);

        mnuArchivoClientes = new JMenuItem("Clientes");
        mnuArchivoClientes.setIcon(icoArchivoClientes);

        mnuArchivoProductos = new JMenuItem("Productos");
        mnuArchivoProductos.setIcon(icoArchivoProductos);

        mnuArchivoUsuarios = new JMenuItem("Usuarios");
        mnuArchivoUsuarios.setIcon(icoArchivoUsuarios);

        mnuArchivoSalir = new JMenuItem("Salir");
        mnuArchivoSalir.setIcon(icoArchivoSalir);

        mnuFactura = new JMenu("Factura");
        mnuFactura.setIcon(icoFactura);

        mnuFacturaNuevaFactura = new JMenuItem("Factura Nueva");
        mnuFacturaNuevaFactura.setIcon(icoFacturaNueva);

        mnuFacturaReporteFactura = new JMenuItem("Reporte Factura");
        mnuFacturaReporteFactura.setIcon(icoFactura);

        mnuAyuda = new JMenu("Ayuda");
        mnuAyuda.setIcon(icoAyuda);

        mnuAyudaAcercade = new JMenuItem("Acerca De");
        mnuAyudaAcercade.setIcon(icoAyudaAcercade);

        mnuAyudaAyuda = new JMenuItem("Ayuda");
        mnuAyudaAyuda.setIcon(icoAyudaAyuda);

        mnuSeparador = new Separator();

        //Armamos MENUS
        mnuArchivo.add(mnuArchivoClientes);
        mnuArchivo.add(mnuArchivoProductos);
        mnuArchivo.add(mnuArchivoUsuarios);
        mnuArchivo.add(mnuSeparador);
        mnuArchivo.add(mnuArchivoSalir);
        mnbMenu.add(mnuArchivo);

        mnuFactura.add(mnuFacturaNuevaFactura);
        mnuFactura.add(mnuFacturaReporteFactura);
        mnbMenu.add(mnuFactura);

        mnuAyuda.add(mnuAyudaAcercade);
        mnuAyuda.add(mnuAyudaAyuda);
        mnbMenu.add(mnuAyuda);

        setJMenuBar(mnbMenu);

        //Creamos el desktoppane
        dpnEscritorio = new DesktopConFondo();
        ((DesktopConFondo) dpnEscritorio).setImagen("/images/Fondo.gif");
        setContentPane(dpnEscritorio);

        //Creamos eventos de los Menus
        mnuArchivoClientes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                mnuArchivoClientesActionPerformed(ae);
            }

            private void mnuArchivoClientesActionPerformed(ActionEvent ae) {

            }
        });

        mnuArchivoProductos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                mnuArchivoProductosActionPerformed(ae);
            }

            private void mnuArchivoProductosActionPerformed(ActionEvent ae) {

            }
        });

        mnuArchivoUsuarios.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                mnuArchivoUsuariosActionPerformed(ae);
            }

            private void mnuArchivoUsuariosActionPerformed(ActionEvent ae) {

                frmUsuarios misUsuarios = new frmUsuarios();
                misUsuarios.setDatos(misDatos);
                dpnEscritorio.add(misUsuarios);
                misUsuarios.show();
            }
        });

        mnuArchivoSalir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                mnuArchivoSalirActionPerformed(ae);
            }

            private void mnuArchivoSalirActionPerformed(ActionEvent ae) {

                System.exit(0);
            }
        });

        mnuFacturaNuevaFactura.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                mnuFacturaNuevaFacturaActionPerformed(ae);
            }

            private void mnuFacturaNuevaFacturaActionPerformed(ActionEvent ae) {

            }
        });

        mnuFacturaReporteFactura.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                mnuFacturaReporteFacturaActionPerformed(ae);
            }

            private void mnuFacturaReporteFacturaActionPerformed(ActionEvent ae) {

            }
        });

        mnuAyudaAcercade.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                mnuAyudaAcercadeActionPerformed(ae);
            }

            private void mnuAyudaAcercadeActionPerformed(ActionEvent ae) {

            }
        });

        mnuAyudaAyuda.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                mnuAyudaAyudaActionPerformed(ae);
            }

            private void mnuAyudaAyudaActionPerformed(ActionEvent ae) {

            }
        });

    }
}
