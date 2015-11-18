package mx.itson.banco.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.itson.banco.entidades.Cliente;
import mx.itson.banco.persistencia.Consultar;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCliente frame = new CrearCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CrearCliente() {
		setTitle("Nuevo Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 370, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(34, 31, 61, 16);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(34, 47, 288, 33);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(34, 85, 61, 16);
		contentPane.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(34, 103, 288, 33);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultar consultar = new Consultar();
				Cliente cliente = new Cliente();
				cliente.setNombre(txtNombre.getText());
				cliente.setCorreo(txtCorreo.getText());
				consultar.GuardarCliente(cliente);
				Dashboard.rellenarTablaClientes();
				
				dispose();
			}
		});
		btnGuardar.setBounds(118, 148, 117, 29);
		contentPane.add(btnGuardar);
	}

}
