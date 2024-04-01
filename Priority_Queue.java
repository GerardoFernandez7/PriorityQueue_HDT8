import java.util.PriorityQueue;

public class Priority_Queue {

    private PriorityQueue<Paciente> queue;

    public Priority_Queue() {
        queue = new PriorityQueue<>();
    }

    public void add(Paciente paciente) {
        queue.add(paciente);
    }

    public Paciente remove() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }    
}