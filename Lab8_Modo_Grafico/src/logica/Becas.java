package logica;
import java.util.ArrayList;

public class Becas {
	private static final int MAX_ESTUDIANTES = 100;
    private ArrayList<Estudiantes> estudiantes;

    public Becas() {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiantes estudiante) {
        if (estudiantes.size() < MAX_ESTUDIANTES) {
            estudiantes.add(estudiante);
        } else {
            System.out.println("No se puede agregar más estudiantes. Límite alcanzado.");
        }
    }

    public ArrayList<Estudiantes> obtenerEstudiantesBecados() {
        ArrayList<Estudiantes> estudiantesBecados = new ArrayList<>();

        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getIndice() >= 2.0) {
                estudiantesBecados.add(estudiante);
            }
        }

        return estudiantesBecados;
    }

}
