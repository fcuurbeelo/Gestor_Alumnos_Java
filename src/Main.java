import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int opcion;

    ArrayList<Alumno> alumnos = new ArrayList<>();
    do {
        IO.println("1. Añadir alumno");
        IO.println("2. Ver alumnos");
        IO.println("3.Eliminar alumnos");
        IO.println("4.Contar aprobados y suspendidos");
        IO.println("5.Hacer media");
        IO.println("6. Salir");
        opcion = sc.nextInt();

        if (opcion == 1) {
            sc.nextLine();
            IO.println("Introduzca el nombre");
            String nombre = sc.nextLine();
            IO.println("Introduzca la nota");
            double nota = sc.nextDouble();
            Alumno a = new Alumno(nombre, nota);
            alumnos.add(a);
        }
        if (opcion == 2) {
            int opcionMostar;
            do {
                IO.println("1. Enseñar todos");
                IO.println("2. Buscar por nombre");
                IO.println("3. Buscar por nota");
                IO.println("4. Volver al menu");

                opcionMostar = sc.nextInt();
                if (opcionMostar == 1) {
                    for (Alumno alumno : alumnos) {
                        System.out.println(alumno);


                    }
                }

                if (opcionMostar == 2) {
                    sc.nextLine();
                    IO.println("Ingerese el Nombre del alumno:");
                    String buscarNombre = sc.nextLine();
                    boolean encontrado= false;
                    for (Alumno a : alumnos) {
                        if (a.getNombre().equalsIgnoreCase(buscarNombre)) {
                            IO.println(a);
                            encontrado=true;


                        }

                    }
                    if(!encontrado){

                        IO.println("El alumno no existe");
                    }
                }

                if (opcionMostar == 3){

                    IO.println("Ingerese la nota del alumno:");
                    double buscarNota =sc.nextDouble();
                    boolean encontrado= false;

                    for (Alumno a : alumnos) {

                        if ( Double.compare(a.getNota(),buscarNota ) == 0) {

                            IO.println(a);
                            encontrado = true;

                        }

                    }
                    if(!encontrado){

                        IO.println("No hay ningun alumno con esa nota");
                    }
                }



            }

            while (opcionMostar != 4);

        }
        if (opcion== 3) {
            int opcionEliminar;
            do {

                IO.println("1. Eliminar por nombre");
                IO.println("2. Eliminar por nota");
                IO.println("3. Volver al menu");

                opcionEliminar = sc.nextInt();

                if (opcionEliminar == 1) {
                    sc.nextLine();
                    IO.println("Ingerese el Nombre del alumno:");
                    String eliminarNombre = sc.nextLine();
                    Iterator<Alumno> it = alumnos.iterator();
                    while (it.hasNext()) {
                        Alumno i = it.next();
                        if (i.getNombre().equalsIgnoreCase(eliminarNombre)) {
                            IO.println("Se ha elimnado correctamente");
                            it.remove();
                        }

                    }
                }
                    if (opcionEliminar == 2) {
                        IO.println("Ingerese la nota del alumno:");
                        double eliminarNota = sc.nextDouble();
                        Iterator<Alumno> it = alumnos.iterator();
                        while (it.hasNext()) {
                            Alumno i = it.next();
                            if (Double.compare(i.getNota(), eliminarNota) == 0) {
                                IO.println("Se ha elimino a  "+i.toString());
                                it.remove();
                            }
                        }


                    }





                }

            while (opcionEliminar != 3);

        }



            } while (opcion != 4);

        }