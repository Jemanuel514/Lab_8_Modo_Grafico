//Importación de paquetes
package grafico;

//Importación de elementos de diseño
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

//Importación de clases de lógica
import logica.Becas;
import logica.Estudiantes;

//Otras importaciones
import java.util.ArrayList;
import java.util.List;

//Clase Reportes
public class Reportes extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//Elementos de interfaz (solo se crean para entradas de datos)
	private JPanel contentPane;		//Contenedor de elementos
	private JTextField textCedula;
	private JComboBox<String> comboBoxCarreras;
	private DefaultTableModel  modeloTabla;
	private JTable datosEstudiantes;
	private JComboBox<String> comboBoxSexo;
	
	//Ejecución de ventana
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

	//Constructor: encargado de instanciar y configurar elementos de la interfaz
	public Reportes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 483);
		
		//CONFIGURACIÓN DEL CONTENEDOR
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//CONFIGURACIÓN DE ETIQUETAS
		JLabel etiquetaReportes = new JLabel("Reportes");
		etiquetaReportes.setBounds(238, 10, 149, 46);
		etiquetaReportes.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(etiquetaReportes);
		
		JLabel etiquetaEstudiantesBecados = new JLabel("Estudiantes Becados:");
		etiquetaEstudiantesBecados.setBounds(52, 106, 221, 35);
		etiquetaEstudiantesBecados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(etiquetaEstudiantesBecados);
		
		JLabel etiquetaCedula = new JLabel("Cédula");
		etiquetaCedula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etiquetaCedula.setBounds(52, 59, 51, 14);
		contentPane.add(etiquetaCedula);
		
		JLabel etiquetaCarrera = new JLabel("Carrera");
		etiquetaCarrera.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etiquetaCarrera.setBounds(274, 61, 49, 14);
		contentPane.add(etiquetaCarrera);
		
		//CONFIGURACIÓN DE CAMPOS DE TEXTO
		textCedula = new JTextField();
		textCedula.setBounds(106, 58, 130, 20);
		textCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//Acción ejecutada al presionar el botón
				filtro();
			}
		});
		contentPane.add(textCedula);
		
		
		//CONFIGURACIÓN DE MENÚ DESPLEGABLE
		comboBoxCarreras = new JComboBox<String>();
		comboBoxCarreras.setModel(new DefaultComboBoxModel<String>(new String[] {"Todos","Ingeniería Civil", "Ingeniería Eléctrica", "Ingeniería Industrial", "Ingeniería en Sistemas", "Ingeniería Mecánica", "Ingeniería Marítima"}));
		comboBoxCarreras.setBounds(328, 57, 184, 22);
		comboBoxCarreras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Acción ejecutada al presionar el botón
				filtro();
			}
		});
		
		contentPane.add(comboBoxCarreras);
		
		//CONFIGURACIÓN DE TABLA
		//Tabla
		datosEstudiantes = new JTable();
		datosEstudiantes.setBounds(24, 151, 603, 285);
		contentPane.add(datosEstudiantes);
		
		//Modelo de tabla
		modeloTabla = new DefaultTableModel();
		modeloTabla.setColumnIdentifiers(new String[] {"Nombre", "Cédula", "Carrera", "Índice", "Sexo"});
		datosEstudiantes.setModel(modeloTabla);
		
		JLabel lblNewLabel = new JLabel("Sexo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(274, 86, 49, 22);
		contentPane.add(lblNewLabel);
		
		comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Masculino", "Femenino"}));
		comboBoxSexo.setBounds(328, 90, 184, 20);
		comboBoxSexo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Acción ejecutada al presionar el botón
				filtro();
			}
		});
		contentPane.add(comboBoxSexo);
		
		
	} //Fin del constructor

	//Métodos de ventana
	void mostrarBecados(Becas beca) {
        System.out.println("Estudiantes becados obtenidos: " + beca.obtenerEstudiantesBecados().size());
        
        for (Estudiantes estudiante : beca.obtenerEstudiantesBecados()) {
        	Object[] datosEstudiante = {estudiante.getNombre(), estudiante.getCedula(), estudiante.getCarrera(), estudiante.getIndice(), estudiante.getSexo()};
        	modeloTabla.addRow(datosEstudiante);
        }

    }
	
	
	void filtro() {
		DefaultTableModel modelo = (DefaultTableModel) datosEstudiantes.getModel();
	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
	    datosEstudiantes.setRowSorter(sorter);
	    
	    List<RowFilter<Object, Object>> filtros = new ArrayList<>();

	    String filtroCedula = textCedula.getText();
	    if (!filtroCedula.equals("")) {
	        filtros.add(RowFilter.regexFilter("^" + filtroCedula, 1)); // Índice 1 para la columna de cédula
	    }

	    String filtroCarrera = (String) comboBoxCarreras.getSelectedItem();
	    if (!filtroCarrera.equals("Todos")) {
	        filtros.add(RowFilter.regexFilter(filtroCarrera, 2)); // Índice 2 para la columna de carrera
	    }

	    String filtroSexo = (String) comboBoxSexo.getSelectedItem();
	    if (!filtroSexo.equals("Todos")) {
	        filtros.add(RowFilter.regexFilter(filtroSexo, 4)); // Índice 2 para la columna de sexo
	    }
	    
	    RowFilter<Object, Object> filtroCompuesto = RowFilter.andFilter(filtros);
	    sorter.setRowFilter(filtroCompuesto);
	}
}
