import java.util.PriorityQueue;

/**
 * Esta clase representa una cola con prioridad de pacientes en un sistema de atención de emergencias de un hospital.
 * Utiliza la clase PriorityQueue del Java Collection Framework para gestionar la prioridad de los pacientes.
 */
public class Priority_Queue {

    private PriorityQueue<Paciente> queue;

    /**
     * Constructor para crear una nueva instancia de Priority_Queue.
     * Inicializa la cola con prioridad vacía.
     */
    public Priority_Queue() {
        queue = new PriorityQueue<>();
    }

    /**
     * Agrega un paciente a la cola con prioridad.
     * @param paciente El paciente que se va a agregar a la cola.
     */
    public void add(Paciente paciente) {
        queue.add(paciente);
    }

    /**
     * Elimina y devuelve el próximo paciente de mayor prioridad de la cola con prioridad.
     * @return El próximo paciente de mayor prioridad, o null si la cola está vacía.
     */
    public Paciente remove() {
        return queue.poll();
    }

    /**
     * Comprueba si la cola con prioridad está vacía.
     * @return true si la cola está vacía, false si contiene elementos.
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }    
}