import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Esta clase contiene el método principal para ejecutar el sistema de atención de pacientes en la sección de Emergencias de un hospital.
 * Lee los datos de un archivo de texto, crea instancias de pacientes y los agrega a una cola con prioridad, luego muestra los pacientes al médico en orden de prioridad.
 */
public class Main {

    /**
     * Método principal que ejecuta el sistema de atención de pacientes en la sección de Emergencias de un hospital.
     * Lee los datos de un archivo de texto, crea instancias de pacientes y los agrega a una cola con prioridad, luego muestra los pacientes al médico en orden de prioridad.
     * @param args Los argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Lectura del archivo pacientes.txt y procesamiento de los datos
        try {
            Scanner scanner = new Scanner(new File("pacientes.txt"));
            VectorHeap<Paciente> vectorHeap = new VectorHeap<>();
            Priority_Queue pacientePriorityQueue = new Priority_Queue();

            while (scanner.hasNextLine()) {
                String[] pacienteInfo = scanner.nextLine().split(",");
                String nombre = pacienteInfo[0].trim();
                String sintoma = pacienteInfo[1].trim();
                char codigoEmergencia = pacienteInfo[2].trim().charAt(0);
                Paciente paciente = new Paciente(nombre, sintoma, codigoEmergencia);
                vectorHeap.add(paciente);
                pacientePriorityQueue.add(paciente);
            }
            scanner.close();

            // Retirar y mostrar pacientes según su prioridad
            System.out.println("\nListado de pacientes para el doctor:");
            while (!vectorHeap.isEmpty()) {
                System.out.println(vectorHeap.remove());
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: Archivo no encontrado.");
            e.printStackTrace();
        }
    }
}
