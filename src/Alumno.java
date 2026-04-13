public class Alumno {
    String nombre;
    double nota;
    public Alumno(String nombre, double nota ) {
    this.nombre= nombre;
    this.nota=nota;
    }
    public String getNombre(){
        return nombre;

    }
    public double getNota(){
        return nota;

    }

    public String toString() {
        return nombre +"-"+ nota;
    }
}
