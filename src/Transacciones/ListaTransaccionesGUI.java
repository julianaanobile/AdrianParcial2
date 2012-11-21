/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Transacciones;

/**
 *
 * @author aDRiaN
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ListaTransaccionesGUI extends JFrame implements ActionListener   {
 private Transacciones listaTransaccion;
 private Cuentas listaCuentas;
 private JLabel lbCuenta, lbFecha1, lbTipoTransaccion,lbTipoCuenta, lbMonto, lbSaldo;
 private JTextField tfCuenta, tfFecha, tfMonto; 
 private JComboBox cbTipoTransaccion,  cbTipoCuenta;
 private JPanel panelPrincipal, panelContenedor, panelInicio, panelAgregar, panelBuscarCuenta, panelMostrarCuentas ,panelMostrarTransacciones;
 private CardLayout cardLayout;  // manejador de paneles
 private JButton botonAgregar, botonBuscar;
 private JTextArea areaMostrarTransacciones;
 private JTextArea areaMostrarCuentas;
 private JTextField tfCuenta2;
 private JTextField tfFechaApertura;
 private JTextField tfNombreCliente;
 private JTextField tfTipoCuentaCliente;
 private JTextField tfSaldo;

 public ListaTransaccionesGUI() //COnstructor de la Clase
   {
   
       super("Transacciones");  // llama al constructor de JFrame, pone titulo a la ventana
       
       listaTransaccion =new Transacciones(); // inicailizamos objteo LIstas
       listaCuentas = new Cuentas();
       panelPrincipal = new JPanel(); //inicializo panel principal y el manejador cardlayoud
       cardLayout = new CardLayout();
       AgregarCuentas();
       
       construyePanelInicio (); // llamo al metodo que construye el panel de inicio que solo pinta el fondo de blanco
       construyePanelAgregar(); // construye el panel de agregar departament
       construyePanelBuscarCuenta();
       construyePanelMostrarCuentas();
       construyePanelMostrar();
       
       construyePanelPrincipal(); // construye el panel que me maneja los paneles 
       
       this.add(panelPrincipal); 
       
       // Crear MENU
       JMenu menuArchivo = new JMenu("Archivo"); // crea menu archivo
       menuArchivo.setMnemonic('A');  // establece el nemónico a A
                        
   
       //crear elementos del Menu
       
       //manejar elemento Agregar Departamento
       JMenuItem elementoAgregar = new JMenuItem("Agregar Transaccion");
       menuArchivo.add(elementoAgregar); //agrega elemento al Menu archivo
       elementoAgregar.addActionListener(
               new ActionListener() { //clase interna anónima

          
            public void actionPerformed(ActionEvent e) 
            {

             cardLayout.show(panelPrincipal, "Panel 2"); // si hacen clic en Archivo, muestra panel 2, es decir, panelAgregar
              
            }
        });
       
       
        JMenuItem elementoBuscar = new JMenuItem("Buscar Cuenta");
       menuArchivo.add(elementoBuscar); //agrega elemento al Menu archivo
       elementoBuscar.addActionListener(
               new ActionListener() { //clase interna anónima

          
            public void actionPerformed(ActionEvent e) {
                
                cardLayout.show(panelPrincipal, "Panel 4");
             
            }
        });
       
       JMenuItem elementoMostrarCuentas = new JMenuItem("Mostrar Cuentas");
       menuArchivo.add(elementoMostrarCuentas); //agrega elemento al Menu archivo
       elementoMostrarCuentas.addActionListener(
               new ActionListener() { //clase interna anónima

          
            public void actionPerformed(ActionEvent e) {
            cardLayout.show(panelPrincipal, "Panel 5");
            String listado = listaCuentas.mostrarLista();
            areaMostrarCuentas.setText(listado);
            }
        });
       
       JMenuItem elementoMostrarTransacciones = new JMenuItem("Mostrar Transacciones");
       menuArchivo.add(elementoMostrarTransacciones); //agrega elemento al Menu archivo
       elementoMostrarTransacciones.addActionListener(
               new ActionListener() { //clase interna anónima

          
            public void actionPerformed(ActionEvent e) {
             cardLayout.show(panelPrincipal, "Panel 6");
             
            String listado = listaTransaccion.mostrarLista();
            areaMostrarTransacciones.setText(listado);
            }
        });
   
       
    JMenuBar barra = new JMenuBar();
    setJMenuBar(barra);
    barra.add(menuArchivo);
       
   }
   
   private void construyePanelInicio ()
   {   
       panelContenedor = new JPanel();
       panelContenedor.setBackground(Color.WHITE);    //pinta el fondo blanco    
       panelInicio = new JPanel (new FlowLayout());
       panelInicio.setBackground(Color.WHITE);
       panelContenedor.add(panelInicio);      
      
   }
   
    private void construyePanelPrincipal(){
        panelPrincipal.setLayout(cardLayout);
        panelPrincipal.add(panelContenedor, "Panel 1");
        panelPrincipal.add(panelAgregar, "Panel 2");
        panelPrincipal.add(panelBuscarCuenta, "Panel 4");
        panelPrincipal.add(panelMostrarCuentas, "Panel 5");
        panelPrincipal.add(panelMostrarTransacciones, "Panel 6");

    }
    
    private void construyePanelAgregar()
    {       
        panelAgregar = new JPanel(); // manejador grid 3 filas y dos columnas, acomoda los elemetos
       JPanel  panelAux = new JPanel(new GridLayout(5,2));
        panelAgregar.setBackground(Color.WHITE);
        panelAux.setBackground(Color.WHITE);   
        //en orden que se agrega
        
        panelAgregar.setBorder(BorderFactory.createEmptyBorder( 40,50,50,50));  // pone borde
        lbCuenta = new JLabel("Numero de Cuenta");
        tfCuenta = new JTextField("");
        lbFecha1 = new JLabel("Fecha");       
        tfFecha = new JTextField();
        lbTipoTransaccion = new JLabel("Tipo de Transaccion");  
        String [] transaccionesArray = {"Consignacion","Retiro"};
        cbTipoTransaccion = new JComboBox(transaccionesArray);
        lbTipoCuenta = new JLabel("Tipo de Cuenta");
        String [] cuentasArray = {"ahorro","Corriente"};
        cbTipoCuenta = new JComboBox(cuentasArray);
        lbMonto = new JLabel("Monto");
        tfMonto = new JTextField();
        
        
        botonAgregar  = new JButton("Agregar");
        botonAgregar.addActionListener(this); //agregar escucha al boton
        
        panelAux.add(lbCuenta);
        panelAux.add(tfCuenta);
        
        panelAux.add(lbFecha1);
        panelAux.add(tfFecha);
        
        panelAux.add(lbTipoTransaccion);
        panelAux.add(cbTipoTransaccion);
        
        panelAux.add(lbTipoCuenta);
        panelAux.add(cbTipoCuenta);
        
        panelAux.add(lbMonto);
        panelAux.add(tfMonto);
        
        panelAgregar.add(panelAux);
        panelAgregar.add(botonAgregar);
              
    }
    
     private void construyePanelBuscarCuenta()
   {
         
       panelBuscarCuenta = new JPanel(new BorderLayout());
       JPanel panelAux = new JPanel(new GridLayout(2,2));
       JPanel panelAux2= new JPanel (new GridLayout(4,2));
       panelBuscarCuenta.setBackground(Color.WHITE);
//       panelCambiarDatos.setBorder(BorderFactory.createEmptyBorder(60, 50, 80, 50));  // pone borde
       lbCuenta = new JLabel("Numero de Cuenta");
       lbFecha1  = new JLabel("Fecha Apertura");
       lbTipoTransaccion  = new JLabel("Nombre Cliente");
       lbTipoCuenta  = new JLabel("Tipo de Cuenta");
       lbSaldo  = new JLabel("Saldo");
      
       tfCuenta2 = new JTextField();
       botonBuscar = new JButton("Buscar Cuenta");
       botonBuscar.addActionListener(this); //agregar escucha al boton
       
                         
       // campos a modificar 
       
       tfFechaApertura = new JTextField();
       tfNombreCliente = new JTextField();
       tfTipoCuentaCliente = new JTextField();
       tfSaldo = new JTextField();
              
       // agregar al panel
       panelAux.add(lbCuenta);
       panelAux.add(tfCuenta2);
       panelAux.add(botonBuscar);
       
       panelAux2.add(lbFecha1);
       panelAux2.add(tfFechaApertura);
       
       panelAux2.add(lbTipoTransaccion);
       panelAux2.add(tfNombreCliente);
       
       panelAux2.add(lbTipoCuenta);
       panelAux2.add(tfTipoCuentaCliente);
       
       panelAux2.add(lbSaldo);
       panelAux2.add(tfSaldo);
       
       panelBuscarCuenta.add(panelAux, BorderLayout.NORTH);
       panelBuscarCuenta.add(panelAux2, BorderLayout.CENTER);
                 
   }

    private void construyePanelMostrarCuentas() 
    {
        panelMostrarCuentas = new JPanel();
        areaMostrarCuentas = new JTextArea(8,40);
        panelMostrarCuentas.add(areaMostrarCuentas);

    }

    private void construyePanelMostrar() 
    {
    
        panelMostrarTransacciones = new JPanel();
        areaMostrarTransacciones = new JTextArea(8,40);
        panelMostrarTransacciones.add(areaMostrarTransacciones);

    }
    
    public void limpiarCampos()
    { //Limpia los jtexfFields
        tfCuenta.setText("");
        cbTipoCuenta.setSelectedIndex(0);
        tfFecha.setText("");
        cbTipoTransaccion.setSelectedIndex(0);
        tfMonto.setText("");
        
        
    }
 public static void main (String arg[])
   {
       ListaTransaccionesGUI lista = new ListaTransaccionesGUI();
       lista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       lista.setSize(500, 250);
       lista.setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource()== botonAgregar)
        {   
            
            try{ //para capturar la excpecion,..encierra el código donde puede ocurrir una excepcion
            if (!tfCuenta.getText().equals("")||  //valida que los campos no esten vacios
                  !tfFecha.getText().equals("")||  //valida que los campos no esten vacios
                  !tfMonto.getText().equals(" ")  ){
                int cuenta = Integer.parseInt(tfCuenta.getText());
                
                String fecha = tfFecha.getText();
                String tipotransaccion = (String) cbTipoTransaccion.getSelectedItem();
                String tipoCuenta = (String) cbTipoCuenta.getSelectedItem();
                int monto = Integer.parseInt(tfMonto.getText());
                
                NodoCuentas nodoCuenta = listaCuentas.buscarNodo(cuenta);          
                
                if(nodoCuenta== null&&tipotransaccion.equals("Retiro")){
                    JOptionPane.showMessageDialog(null, "No existe la cuenta, entonces no es posible hacer el retiro");
                    return;
                }
                
                if(nodoCuenta!= null && tipotransaccion.equals("Retiro")){
                    if(nodoCuenta.saldo<monto){
                        JOptionPane.showMessageDialog(null, "No tiene suficiente saldo para hacer la transaccion");
                        return;
                    }
                }
                
                if(nodoCuenta == null){
                    String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del nuevo cliente");
                    nodoCuenta = listaCuentas.insertarFinal(cuenta, fecha, nombreCliente, tipoCuenta, 0);
                }
                
                listaTransaccion.insertarFinal(cuenta, fecha, tipotransaccion, tipoCuenta, monto);
                
                if(tipotransaccion.equals("Retiro")){
                    nodoCuenta.saldo = nodoCuenta.saldo - monto;
                } else {
                    nodoCuenta.saldo = nodoCuenta.saldo + monto;
                }
                
                listaCuentas.eliminarPosicion(listaCuentas.obtenerPosXcod(nodoCuenta.NoCuenta));
                listaCuentas.insertarFinal(nodoCuenta.NoCuenta, nodoCuenta.fecha_apertura, nodoCuenta.Nombre_Cliente, nodoCuenta.tipo_de_cuenta, nodoCuenta.saldo);
                
                JOptionPane.showMessageDialog(null, "Transaccion ejecutada");
                limpiarCampos();
            }
            }catch(NumberFormatException nfe)  //excepción que captura si el codigo no es numero NumberFormatException
            {
               JOptionPane.showMessageDialog(null, "El numero de cuenta y el monto debe ser numerico");
            }
                                
        }
        
       if (e.getSource() == botonBuscar){
           int codigo = Integer.parseInt(tfCuenta2.getText());
       // buscar cuenta por numero de cuenta a traves del jtextfield
       
           NodoCuentas nodoCuenta = listaCuentas.buscarNodo(codigo);          
                        
           if(nodoCuenta == null){
               JOptionPane.showMessageDialog(null, "No existe la cuenta "+codigo);
               tfFechaApertura.setText(""); // Limpia los campos por si hay algo
               tfNombreCliente.setText("");
               tfTipoCuentaCliente.setText("");
               tfSaldo.setText("");
           } else {
               tfFechaApertura.setText(nodoCuenta.fecha_apertura); // setear los campos
               tfNombreCliente.setText(nodoCuenta.Nombre_Cliente);
               tfTipoCuentaCliente.setText(nodoCuenta.tipo_de_cuenta);
               tfSaldo.setText(String.valueOf(nodoCuenta.saldo));
           }
       }
    }

    private void AgregarCuentas() {
        listaCuentas.insertarPrimero(111111, "15/05/2005", "Juanito Perencejo", "Ahorros", 52000);
        listaCuentas.insertarPrimero(222222, "20/01/2009", "Pedro Perez", "Ahorros", 85000);
        listaCuentas.insertarPrimero(333333, "18/11/2007", "Maria Gonzales", "Ahorros", 770000);
        listaCuentas.insertarPrimero(555555, "03/08/2010", "Ana Agudelo", "Ahorros", 43000);
        listaCuentas.insertarPrimero(666666, "03/08/2010", "Jessica Lozano", "Ahorros", 521000);
    }
    
}
