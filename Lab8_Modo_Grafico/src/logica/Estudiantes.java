package logica;

public class Estudiantes {
	private String nombre;
    private String cedula;
    private String carrera;
    private String sexo;
    private double indice;

    public Estudiantes(String nombre, String cedula, String sexo, String carrera, double indice) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.sexo = sexo;
        this.carrera = carrera;
        this.indice = indice;
    }

    public String getNombre() {
    	return nombre;
    }
    
    public String getCedula() {
    	return cedula;
    }
    
    public String getCarrera() {
    	return carrera;
    }
    
    public String getSexo() {
    	return sexo;
    }
    
    public double getIndice() {
        return indice;
    }

}