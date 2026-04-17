public class Alumno {

    // Atributos del alumno
    String nombre;
    double nota;

    // Constructor: inicializa el alumno con nombre y nota
    public Alumno(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    // Devuelve el nombre del alumno
    public String getNombre() {
        return nombre;
    }

    // Devuelve la nota del alumno
    public double getNota() {
        return nota;
    }

    // Representación en texto del objeto Alumno
    @Override
    public String toString() {
        return nombre + " - " + nota;
    }
}