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

    public double getIndiceAcademico() {
        return indiceAcademico;
    }

    public String getNombre() {
        return nombre;
    }

}
