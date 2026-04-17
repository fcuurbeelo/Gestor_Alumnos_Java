import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int opcion;

    ArrayList<Alumno> alumnos = new ArrayList<>();

    do {

        // MENÚ PRINCIPAL
        IO.println("\n==================================");
        IO.println("        GESTOR DE ALUMNOS");
        IO.println("==================================");

        IO.println("1. Añadir alumno");
        IO.println("2. Ver alumnos");
        IO.println("3. Eliminar alumnos");
        IO.println("4. Contar aprobados y suspendidos");
        IO.println("5. Calcular media");
        IO.println("6. Salir");

        System.out.print("\nSeleccione una opción: ");
        opcion = sc.nextInt();

        // AÑADIR ALUMNO
        if (opcion == 1) {
            sc.nextLine();

            IO.println("\n--- NUEVO ALUMNO ---");
            IO.println("Introduzca el nombre del alumno:");
            String nombre = sc.nextLine();

            IO.println("Introduzca la nota (0-10):");
            double nota = sc.nextDouble();

            Alumno a = new Alumno(nombre, nota);
            alumnos.add(a);
        }

        // VER ALUMNOS
        if (opcion == 2) {
            int opcionMostar;

            do {
                IO.println("\n------ CONSULTA DE ALUMNOS ------");

                IO.println("1. Mostrar todos los alumnos");
                IO.println("2. Buscar alumno por nombre");
                IO.println("3. Buscar alumno por nota");
                IO.println("4. Volver al menú");

                System.out.print("\nSeleccione una opción: ");
                opcionMostar = sc.nextInt();

                // MOSTRAR TODOS
                if (opcionMostar == 1) {
                    IO.println("\n--- LISTADO DE ALUMNOS ---");
                    for (Alumno alumno : alumnos) {
                        System.out.println("- " + alumno);
                    }
                }

                // BUSCAR POR NOMBRE
                if (opcionMostar == 2) {
                    sc.nextLine();
                    IO.println("Ingrese el nombre del alumno a buscar:");
                    String buscarNombre = sc.nextLine();

                    boolean encontrado = false;

                    for (Alumno a : alumnos) {
                        if (a.getNombre().equalsIgnoreCase(buscarNombre)) {
                            IO.println(a);
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        IO.println("No se ha encontrado ningún alumno con ese nombre");
                    }
                }

                // BUSCAR POR NOTA
                if (opcionMostar == 3) {

                    IO.println("Ingrese la nota del alumno:");
                    double buscarNota = sc.nextDouble();

                    boolean encontrado = false;

                    for (Alumno a : alumnos) {
                        if (Double.compare(a.getNota(), buscarNota) == 0) {
                            IO.println(a);
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        IO.println("No hay ningún alumno con esa nota");
                    }
                }

            } while (opcionMostar != 4);
        }

        // ELIMINAR ALUMNOS
        if (opcion == 3) {
            int opcionEliminar;

            do {
                IO.println("\n------ ELIMINAR ALUMNOS ------");

                IO.println("1. Eliminar alumno por nombre");
                IO.println("2. Eliminar alumno por nota");
                IO.println("3. Volver al menú");

                System.out.print("\nSeleccione una opción: ");
                opcionEliminar = sc.nextInt();

                // ELIMINAR POR NOMBRE
                if (opcionEliminar == 1) {
                    sc.nextLine();

                    IO.println("Ingrese el nombre del alumno a eliminar:");
                    String eliminarNombre = sc.nextLine();

                    Iterator<Alumno> it = alumnos.iterator();

                    while (it.hasNext()) {
                        Alumno i = it.next();

                        if (i.getNombre().equalsIgnoreCase(eliminarNombre)) {
                            it.remove();
                            IO.println("Alumno eliminado correctamente ✔");
                        }
                    }
                }

                // ELIMINAR POR NOTA
                if (opcionEliminar == 2) {

                    IO.println("Ingrese la nota del alumno a eliminar:");
                    double eliminarNota = sc.nextDouble();

                    Iterator<Alumno> it = alumnos.iterator();

                    while (it.hasNext()) {
                        Alumno i = it.next();

                        if (Double.compare(i.getNota(), eliminarNota) == 0) {
                            IO.println("Se ha eliminado el alumno: " + i);
                            it.remove();
                        }
                    }
                }

            } while (opcionEliminar != 3);
        }

        // ESTADÍSTICAS
        if (opcion == 4) {

            int aprobados = 0;
            int suspendidos = 0;

            for (Alumno a : alumnos) {
                if (a.getNota() >= 5) {
                    aprobados++;
                } else {
                    suspendidos++;
                }
            }

            IO.println("\n--- ESTADÍSTICAS ---");
            IO.println("Aprobados: " + aprobados);
            IO.println("Suspendidos: " + suspendidos);
        }

        // MEDIA
        if (opcion == 5) {

            double suma = 0;

            for (Alumno a : alumnos) {
                suma += a.getNota();
            }

            if (alumnos.size() > 0) {
                IO.println("\n--- MEDIA DE NOTAS ---");
                IO.println("La media es: " + (suma / alumnos.size()));
            } else {
                IO.println("No hay alumnos registrados");
            }
        }

    } while (opcion != 6);
}