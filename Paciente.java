/**
 * Esta clase representa a un paciente en el sistema de atención de emergencias de un hospital.
 * Cada paciente tiene un nombre, un síntoma y un código de emergencia que indica su prioridad de atención.
 */
public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private char codigoEmergencia;

    /**
     * Constructor para crear una instancia de Paciente con los datos proporcionados.
     * @param nombre El nombre del paciente.
     * @param sintoma La descripción del síntoma del paciente.
     * @param codigoEmergencia El código de emergencia del paciente (A-E).
     */
    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    /**
     * Método getter para obtener el nombre del paciente.
     * @return El nombre del paciente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método getter para obtener el síntoma del paciente.
     * @return La descripción del síntoma del paciente.
     */
    public String getSintoma() {
        return sintoma;
    }

    /**
     * Método getter para obtener el código de emergencia del paciente.
     * @return El código de emergencia del paciente.
     */
    public char getCodigoEmergencia() {
        return codigoEmergencia;
    }

    /**
     * Método compareTo para comparar pacientes según su código de emergencia.
     * @param otro El otro paciente con el que se va a comparar.
     * @return Un valor negativo si este paciente tiene mayor prioridad, cero si son iguales, o un valor positivo si el otro paciente tiene mayor prioridad.
     */
    @Override
    public int compareTo(Paciente otro) {
        return Character.compare(this.codigoEmergencia, otro.codigoEmergencia);
    }

    /**
     * Método toString para obtener una representación en forma de cadena de este paciente.
     * @return Una cadena que representa el nombre, síntoma y código de emergencia del paciente.
     */
    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}