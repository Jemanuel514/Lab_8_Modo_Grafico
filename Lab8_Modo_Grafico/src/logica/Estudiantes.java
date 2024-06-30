package logica;



public class Estudiantes {
	private String nombre;
    private String cedula;
    private String sexo;
    private String carrera;
    private double indiceAcademico;

    public Estudiantes(String nombre, String cedula, String sexo, String carrera, double indiceAcademico) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.sexo = sexo;
        this.carrera = carrera;
        this.indiceAcademico = indiceAcademico;
    }

    public double getIndice() {
        return indiceAcademico;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getCedula() {
        return cedula;
    }
    public String getSexo() {
    	return sexo;
    }
    public String getCarrera() {
    	return carrera;
    }
    

}
