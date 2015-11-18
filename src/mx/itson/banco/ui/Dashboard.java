package mx.itson.banco.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mx.itson.banco.entidades.Cliente;
import mx.itson.banco.entidades.Credito;
import mx.itson.banco.entidades.Ejecutivo;
import mx.itson.banco.persistencia.Consultar;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Dashboard {

	private JFrame frmEndeudatron;
	private static JTable tblEjecutivo;
	private static JTable tblCliente;
	private JTextField txtCantidad;
	private JTextField txtTasaDeInteres;
	static Consultar consultar = new Consultar();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.frmEndeudatron.setVisible(true);
					rellenarTablaClientes();
					rellenarTablaEjecutivos();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Crea el modelo para la tabla de clientes
	 */
	static DefaultTableModel modelCliente = new DefaultTableModel(
			new Object[][] {},
			new String[] {
					"id","nombre"
			}
	);
	
	/**
	 * Crea el modelo para la tabla de ejecutivos
	 */
	static DefaultTableModel modelEjecutivo = new DefaultTableModel(
			new Object[][] {},
			new String[] {
					"id","nombre"
			}
	);
	
	/**
	 * Rellena la tabla con los clientes traidos desde la Base de datos
	 */
	public static void  rellenarTablaClientes(){
		 for (int i = 0; i < tblCliente.getRowCount(); i++) {
	           modelCliente.removeRow(i);
	           i-=1;
	       }
		List<Cliente> cliente = consultar.obtenerClientes();	
		int filas = cliente.size();
		String [][] clienteString = new String[filas][2];
		int i = 0;
		for( Cliente in : cliente)
		{
			String id = String.valueOf(in.getId());
			String nombre = in.getNombre();
			
			clienteString[i][0] = id;
			clienteString[i][1] = nombre;
			i++;
			

		}
		for (int row = 0; row < clienteString.length; row++) {
            for (int idx = 0; idx < clienteString.length; idx++) {
                modelCliente.addRow(clienteString[idx]);
                
            }break; 
        }
		
		tblCliente.setModel(modelCliente);
		
	}

	/**
	 * Rellena la tabla con los ejecutivos traidos desde la Base de datos
	 */
	public static void  rellenarTablaEjecutivos(){
		 for (int i = 0; i < tblEjecutivo.getRowCount(); i++) {
	           modelEjecutivo.removeRow(i);
	           i-=1;
	       }
		List<Ejecutivo> ejecutivo = consultar.obtenerEjecutivos();
		int filas = ejecutivo.size();
		String [][] ejecutivoString = new String[filas][2];
		int i = 0;
		for( Ejecutivo in : ejecutivo)
		{
			String id = String.valueOf(in.getId());
			String nombre = in.getNombre();
			
			ejecutivoString[i][0] = id;
			ejecutivoString[i][1] = nombre;
			i++;
			

		}
		for (int row = 0; row < ejecutivoString.length; row++) {
            for (int idx = 0; idx < ejecutivoString.length; idx++) {
                modelEjecutivo.addRow(ejecutivoString[idx]);
                
            }break; 
        }
		
		tblEjecutivo.setModel(modelEjecutivo);
		
	}
	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEndeudatron = new JFrame();
		frmEndeudatron.setTitle("Endeudatron");
		frmEndeudatron.setBounds(100, 100, 860, 540);
		frmEndeudatron.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEndeudatron.getContentPane().setLayout(null);
		
		tblEjecutivo = new JTable();
		tblEjecutivo.setBounds(33, 306, 169, 175);
		frmEndeudatron.getContentPane().add(tblEjecutivo);
		
		tblCliente = new JTable();
		tblCliente.setBounds(33, 69, 169, 191);
		frmEndeudatron.getContentPane().add(tblCliente);
		
		JLabel lblEndeudarA = new JLabel("Endeudar a:");
		lblEndeudarA.setBounds(33, 46, 82, 16);
		frmEndeudatron.getContentPane().add(lblEndeudarA);
		
		JLabel lblEndeudadoPor = new JLabel("Endeudado por:");
		lblEndeudadoPor.setBounds(33, 278, 107, 16);
		frmEndeudatron.getContentPane().add(lblEndeudadoPor);
		
		JButton btnCliente = new JButton("+");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCliente ventana = new CrearCliente();
				ventana.setVisible(true);
			}
		});
		btnCliente.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnCliente.setForeground(new Color(102, 205, 170));
		btnCliente.setBounds(161, 41, 41, 29);
		frmEndeudatron.getContentPane().add(btnCliente);
		
		JButton btnEjecutivo = new JButton("+");
		btnEjecutivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearEjecutivo ventana = new CrearEjecutivo();
				ventana.setVisible(true);
				
			}
		});
		btnEjecutivo.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnEjecutivo.setForeground(new Color(102, 205, 170));
		btnEjecutivo.setBounds(161, 272, 41, 29);
		frmEndeudatron.getContentPane().add(btnEjecutivo);
		
		JLabel lblDeuda = new JLabel("Deuda");
		lblDeuda.setBounds(489, 46, 61, 16);
		frmEndeudatron.getContentPane().add(lblDeuda);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(322, 68, 69, 16);
		frmEndeudatron.getContentPane().add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(322, 85, 130, 26);
		frmEndeudatron.getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblTasaDeInteres = new JLabel("Tasa de Interes:");
		lblTasaDeInteres.setBounds(614, 68, 99, 16);
		frmEndeudatron.getContentPane().add(lblTasaDeInteres);
		
		txtTasaDeInteres = new JTextField();
		txtTasaDeInteres.setBounds(665, 85, 48, 26);
		frmEndeudatron.getContentPane().add(txtTasaDeInteres);
		txtTasaDeInteres.setColumns(10);
		
		JLabel lblMotivo = new JLabel("Motivo:");
		lblMotivo.setBounds(322, 151, 61, 16);
		frmEndeudatron.getContentPane().add(lblMotivo);
		
		JTextArea txtMotivo = new JTextArea();
		txtMotivo.setBounds(322, 179, 399, 151);
		frmEndeudatron.getContentPane().add(txtMotivo);
		
		JButton btnEndeudar = new JButton("Endeudar :D");
		btnEndeudar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					double cantidad = Double.parseDouble(txtCantidad.getText());
					double tasa = Double.parseDouble(txtTasaDeInteres.getText());
					String motivo = txtMotivo.getText();
					int idCliente = Integer.parseInt(String.valueOf(modelCliente.getValueAt(tblCliente.getSelectedRow(), 0)));
					int idEjecutivo = Integer.parseInt(String.valueOf(modelEjecutivo.getValueAt(tblEjecutivo.getSelectedRow(), 0)));
					
					consultar.Endeudar(cantidad, tasa, idCliente, idEjecutivo, motivo);
					
					JOptionPane.showMessageDialog(null, "Endeudado");
					txtCantidad.setText("");
					txtTasaDeInteres.setText("");
					txtMotivo.setText("");
				}catch(Exception err){
					System.out.println(err);
				}
				
			}
		});
		btnEndeudar.setBounds(464, 368, 117, 29);
		frmEndeudatron.getContentPane().add(btnEndeudar);
	}
}
