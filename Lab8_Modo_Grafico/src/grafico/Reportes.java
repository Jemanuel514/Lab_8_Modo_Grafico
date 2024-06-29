package grafico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import logica.Becas;
import logica.Estudiantes;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Reportes extends JFrame {
	private JTextArea textAreaBecados;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reportes frame = new Reportes();
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
	class TableExample extends JFrame {
	    private JTable table;
	    private DefaultTableModel model;

	    public TableExample() {
	        
	       

	        // Crear el modelo de la tabla
	        model = new DefaultTableModel();
	        model.addColumn("Nombre");
	        model.addColumn("Cedula");
	        model.addColumn("Carrera");
	        model.addColumn("Indice");
	        model.addColumn("Sexo");

	        // Crear la tabla
	        table = new JTable(model);
	        public void añadirFila(Object[] estudiante) {
	        	 model.addRow(estudiante);
	   
	        }
	        

	        // Añadir los datos de la lista al modelo de la tabla
	      
	        }
	    
	    }
	
	
	
	public Reportes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reportes");
		lblNewLabel.setBounds(238, 10, 149, 46);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Estudiantes Becados:");
		lblNewLabel_1.setBounds(52, 106, 221, 35);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1);
		
		textAreaBecados = new JTextArea();
		textAreaBecados.setEditable(false);
		textAreaBecados.setBounds(52, 151, 184, 220);
		contentPane.add(textAreaBecados);
		
		textField = new JTextField();
		textField.setBounds(106, 58, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cédula");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(52, 59, 51, 14);
		contentPane.add(lblNewLabel_2);
		
		
		
		TableExample tablaEstudiantes = new TableExample();
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ingeniería Civil", "Ingeniería Eléctrica", "Ingeniería Industrial", "Ingeniería en Sistemas", "Ingeniería Mecánica", "Ingeniería Marítima"}));
		comboBox.setBounds(328, 57, 184, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Carrera");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(274, 61, 49, 14);
		contentPane.add(lblNewLabel_3);

		
	void mostrarBecados(Becas becas) {
        System.out.println("Estudiantes becados obtenidos: " + becas.obtenerEstudiantesBecados().size());
        
        for (Estudiantes estudiante : becas.obtenerEstudiantesBecados()) {
        	Object[] datosEstudiante = {estudiante.getNombre(), estudiante.getCedula(), estudiante.getCarrera(), estudiante.getIndiceAcademico(), estudiante.getSexo()};
        	tablaEstudiantes.añadirFila(datosEstudiante);
        }

	
    }
}
