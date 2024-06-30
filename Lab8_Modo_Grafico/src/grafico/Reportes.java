//Importación de paquetes
package grafico;

//Importación de elementos de diseño
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

//Importación de clases de lógica
import logica.Becas;
import logica.Estudiantes;

//Otras importaciones
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

//Clase Reportes
public class Reportes extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//Elementos dinámicos de interfaz
	private JPanel contenedor;						//Contenedor de elementos
	private JTable datosEstudiantes;
	private DefaultTableModel  modeloTabla;
	private JTextField textCedula;
	private JComboBox<String> comboBoxCarreras;
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
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedor);
		contenedor.setLayout(null);
		
		//CONFIGURACIÓN DE ETIQUETAS
		JLabel etiquetaReportes = new JLabel("Reportes");
		etiquetaReportes.setBounds(238, 10, 149, 46);
		etiquetaReportes.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contenedor.add(etiquetaReportes);
		
		JLabel etiquetaEstudiantesBecados = new JLabel("Estudiantes Becados:");
		etiquetaEstudiantesBecados.setBounds(52, 106, 221, 35);
		etiquetaEstudiantesBecados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contenedor.add(etiquetaEstudiantesBecados);
		
		JLabel etiquetaCedula = new JLabel("Cédula");
		etiquetaCedula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etiquetaCedula.setBounds(52, 59, 51, 14);
		contenedor.add(etiquetaCedula);
		
		JLabel etiquetaCarrera = new JLabel("Carrera");
		etiquetaCarrera.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etiquetaCarrera.setBounds(274, 61, 49, 14);
		contenedor.add(etiquetaCarrera);
		
		JLabel etiquetaSexo = new JLabel("Sexo");
		etiquetaSexo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etiquetaSexo.setBounds(274, 86, 49, 22);
		contenedor.add(etiquetaSexo);
		
		//CONFIGURACIÓN DE CAMPOS DE TEXTO
		textCedula = new JTextField();
		textCedula.setBounds(106, 58, 130, 20);
		textCedula.addKeyListener(new KeyAdapter() {				//Acción al ingresar una cédula
			public void keyReleased(KeyEvent e) {
				filtro();
			}
		});
		contenedor.add(textCedula);
		
		//CONFIGURACIÓN DE MENÚ DESPLEGABLE
		comboBoxCarreras = new JComboBox<String>();
		comboBoxCarreras.setModel(new DefaultComboBoxModel<String>(new String[] {"Todos","Ingeniería Civil", "Ingeniería Eléctrica", "Ingeniería Industrial", "Ingeniería en Sistemas", "Ingeniería Mecánica", "Ingeniería Marítima"}));
		comboBoxCarreras.setBounds(328, 57, 184, 22);
		comboBoxCarreras.addActionListener(new ActionListener() {	//Acción al seleccionar una carrera
			public void actionPerformed(ActionEvent e) {
				filtro();
			}
		});
		contenedor.add(comboBoxCarreras);
		
		comboBoxSexo = new JComboBox<String>();
		comboBoxSexo.setModel(new DefaultComboBoxModel<String>(new String[] {"Todos", "Masculino", "Femenino"}));
		comboBoxSexo.setBounds(328, 90, 184, 20);
		comboBoxSexo.addActionListener(new ActionListener() {		//Acción al seleccionar un sexo
			public void actionPerformed(ActionEvent e) {
				filtro();
			}
		});
		contenedor.add(comboBoxSexo);
		
		//CONFIGURACIÓN DE TABLA
		//Tabla
		datosEstudiantes = new JTable();
		datosEstudiantes.setBounds(24, 151, 603, 254);
		contenedor.add(datosEstudiantes);
		
		//Modelo de tabla
		modeloTabla = new DefaultTableModel();
		modeloTabla.setColumnIdentifiers(new String[] {"Nombre", "Cédula", "Carrera", "Índice", "Sexo"});
		datosEstudiantes.setModel(modeloTabla);
		
		//CONFIGURACIÓN DE BOTONES
		JButton btnFormulario = new JButton("Volver al Formulario");
		btnFormulario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFormulario.setBounds(24, 415, 155, 21);
		btnFormulario.addActionListener(new ActionListener() {			//Acción al presionar el botón
			public void actionPerformed(ActionEvent e) {
				dispose();
				Formulario formulario = new Formulario();
				formulario.setVisible(true);
			}
		});
		contenedor.add(btnFormulario);
		
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
	        filtros.add(RowFilter.regexFilter(filtroSexo, 4)); // Índice 4 para la columna de sexo
	    }
	    
	    RowFilter<Object, Object> filtroCompuesto = RowFilter.andFilter(filtros);
	    sorter.setRowFilter(filtroCompuesto);
	}
}
