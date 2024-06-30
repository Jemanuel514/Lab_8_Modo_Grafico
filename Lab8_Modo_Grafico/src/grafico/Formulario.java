//Importación del paquete
package grafico;

//Importación de elementos de diseño
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//Importación clases de lógica
import logica.Estudiantes;
import logica.Becas;

//Otras importaciones
import java.util.ArrayList;

//Clase Formulario
public class Formulario extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//Elementos dinámicos de interfaz
	private JPanel contenedor;				//Contenedor de elementos
	private JTextField textNombre;
	private JTextField textCedula;
	private JTextField textIndice;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;
	private JComboBox<String> comboBoxCarreras;
	
	//Atributos de estudiante	
	private Estudiantes estudiante;
	private ArrayList<Estudiantes> estudiantes;

	//Ejecución de ventana
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Constructor: encargado de instanciar y configurar los elementos de la interfaz
	public Formulario() {
		//Inicialización de la lista
		estudiantes = new ArrayList<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 552);
		
		
		//CONFIGURACIÓN DEL CONTENEDOR
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedor);
		contenedor.setLayout(null);
		 
		
		//CONFIGURACIÓN DE ETIQUETAS
		JLabel etiquetaInformacion = new JLabel("Información de estudiantes");
		etiquetaInformacion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		etiquetaInformacion.setBounds(277, 10, 271, 62);
		contenedor.add(etiquetaInformacion);
		
		JLabel etiquetaNombre = new JLabel("Nombre:");
		etiquetaNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		etiquetaNombre.setBounds(21, 82, 95, 22);
		contenedor.add(etiquetaNombre);
		
		JLabel etiquetaCedula = new JLabel("Cédula:");
		etiquetaCedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
		etiquetaCedula.setBounds(21, 172, 95, 22);
		contenedor.add(etiquetaCedula);
		
		JLabel etiquetaCarrera = new JLabel("Carrera:");
		etiquetaCarrera.setFont(new Font("Tahoma", Font.PLAIN, 18));
		etiquetaCarrera.setBounds(21, 261, 95, 22);
		contenedor.add(etiquetaCarrera);
		
		JLabel etiquetaIndice = new JLabel("Indice:");
		etiquetaIndice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		etiquetaIndice.setBounds(21, 350, 95, 22);
		contenedor.add(etiquetaIndice);
		
		JLabel etiquetaSexo = new JLabel("Sexo:");
		etiquetaSexo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		etiquetaSexo.setBounds(21, 438, 95, 22);
		contenedor.add(etiquetaSexo);
		
		
		//CONFIGURACIÓN DE CAMPOS DE TEXTO
		textNombre = new JTextField();
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textNombre.setBounds(141, 84, 153, 19);
		contenedor.add(textNombre);
		
		textCedula = new JTextField();
		textCedula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCedula.setColumns(10);
		textCedula.setBounds(141, 174, 153, 19);
		contenedor.add(textCedula);
		
		textIndice = new JTextField();
		textIndice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textIndice.setColumns(10);
		textIndice.setBounds(141, 351, 153, 19);
		contenedor.add(textIndice);
		
		
		//CONFIGURACIÓN DE MENÚ DESPLEGABLE
		comboBoxCarreras = new JComboBox<String>();
		comboBoxCarreras.setModel(new DefaultComboBoxModel<String>(new String[] {"Ingeniería Civil", "Ingeniería Eléctrica", "Ingeniería Industrial", "Ingeniería en Sistemas", "Ingeniería Mecánica", "Ingeniería Marítima"}));
		comboBoxCarreras.setBounds(141, 262, 153, 21);
		comboBoxCarreras.setSelectedIndex(-1);
		contenedor.add(comboBoxCarreras);
		
		
		//CONFIGURACIÓN DE BOTONES DE SELECCIÓN
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnMasculino.setBounds(135, 439, 105, 21);
		contenedor.add(rdbtnMasculino);
		
		rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnFemenino.setBounds(268, 439, 105, 21);
		contenedor.add(rdbtnFemenino);
		
		//Agrupación de botones de selección: no se pueden seleccionar ambos
		ButtonGroup grupoSexo = new ButtonGroup();
		grupoSexo.add(rdbtnMasculino);
		grupoSexo.add(rdbtnFemenino);
		
		
		//CONFIGURACIÓN DE BOTONES
		JButton btnGuardar = new JButton("Guardar Datos");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGuardar.setBounds(480, 432, 184, 34);
		btnGuardar.addActionListener(new ActionListener() {			//Acción al presionar el botón
			public void actionPerformed(ActionEvent e) {
				guardarDatos();
			}
		});
		contenedor.add(btnGuardar);

		JButton btnReportes = new JButton("Mostrar Reportes");
		btnReportes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReportes.setBounds(689, 432, 184, 34);
        btnReportes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {			//Acción al presionar el botón
                dispose();
                Becas beca = new Becas();
                
                for (Estudiantes estudiante : estudiantes) {
                    beca.agregarEstudiante(estudiante);
                }
                
                Reportes reporte = new Reportes();
                reporte.setVisible(true);
                reporte.mostrarBecados(beca);
            }
        });
        contenedor.add(btnReportes);
        
	} //Fin del constructor
	
	//Métodos de la ventana
	private void guardarDatos() {
		try {
			//Obtener los datos ingresados por el usuario
		    String nombre = textNombre.getText();
		    String cedula = textCedula.getText();
		    String carrera = (String) comboBoxCarreras.getSelectedItem();
		    double indice = Double.parseDouble(textIndice.getText());
		        
	        //Obtención del sexo
	        String sexo;
	        if (rdbtnMasculino.isSelected()) {
				sexo = "Masculino";
			} else if (rdbtnFemenino.isSelected()) {
				sexo = "Femenino";
			} else {
				JOptionPane.showMessageDialog(this, "Ingrese el sexo del estudiante.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
	        
	        //Validación de índice
	        if (indice < 0 || indice > 3) {
	        	JOptionPane.showMessageDialog(this, "Por favor, ingrese índice válido.", "Error", JOptionPane.ERROR_MESSAGE);
	        	return;
	        }
	        
	        //Guardado de información del estudiante
	        estudiante = new Estudiantes(nombre, cedula, sexo, carrera, indice);
	        estudiantes.add(estudiante);
	        System.out.println("Información del estudiante guardada: " + estudiante.toString());
           
	        //Mensaje de confirmación 
	        JOptionPane.showMessageDialog(this, "Información guardada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

	        //Reinicio de campos de texto
	        textNombre.setText("");
	        textCedula.setText("");
	        textIndice.setText("");
	        comboBoxCarreras.setSelectedIndex(-1); 
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Por favor, ingrese datos válidos para Índice.", "Error", JOptionPane.ERROR_MESSAGE);
		}
				
	}
		
}
