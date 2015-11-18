package mx.itson.banco.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mx.itson.banco.entidades.Ejecutivo;
import mx.itson.banco.persistencia.Consultar;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CrearEjecutivo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtPuesto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearEjecutivo frame = new CrearEjecutivo();
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
	public CrearEjecutivo() {
		setTitle("Nuevo Ejecutivo");
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
		
		JLabel lblPuesto = new JLabel("Puesto:");
		lblPuesto.setBounds(34, 85, 61, 16);
		contentPane.add(lblPuesto);
		
		txtPuesto = new JTextField();
		txtPuesto.setBounds(34, 103, 288, 33);
		contentPane.add(txtPuesto);
		txtPuesto.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(118, 148, 117, 29);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultar consultar = new Consultar();
				Ejecutivo ejecutivo = new Ejecutivo();
				ejecutivo.setNombre(txtNombre.getText());
				ejecutivo.setPuesto(txtPuesto.getText());
				consultar.GuardarEjecutivo(ejecutivo);
				Dashboard.rellenarTablaEjecutivos();
				
				dispose();
			}
		});
		contentPane.add(btnGuardar);
	}

}
