import static org.junit.Assert.*;
import org.junit.Test;

public class VectorHeapTests {

    @Test
    public void testAdd() {
        VectorHeap<Paciente> vectorHeap = new VectorHeap<>();
        vectorHeap.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        vectorHeap.add(new Paciente("Maria Ramirez", "apendicitis", 'A'));
        vectorHeap.add(new Paciente("Carmen Sarmientos", "dolores de parto", 'B'));

        assertEquals(3, vectorHeap.size());
    }

    @Test
    public void testRemove() {
        VectorHeap<Paciente> vectorHeap = new VectorHeap<>();
        vectorHeap.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        vectorHeap.add(new Paciente("Maria Ramirez", "apendicitis", 'A'));
        vectorHeap.add(new Paciente("Carmen Sarmientos", "dolores de parto", 'B'));

        Paciente removedPaciente = vectorHeap.remove();

        assertEquals("Maria Ramirez", removedPaciente.getNombre());
        assertEquals("apendicitis", removedPaciente.getSintoma());
        assertEquals('A', removedPaciente.getCodigoEmergencia());
        assertEquals(2, vectorHeap.size());
    }
}
