import java.util.Vector;

/**
 * Esta clase implementa una cola con prioridad utilizando un vector subyacente.
 * Utiliza un heap para mantener la estructura de datos y asegurar la prioridad de los elementos.
 * @param <E> El tipo de elementos en la cola con prioridad, que debe ser comparable.
 */
public class VectorHeap<E extends Comparable<E>> {
    protected Vector<E> data;

    /**
     * Constructor para crear una nueva instancia de VectorHeap.
     * Inicializa el vector de datos como vacío.
     */
    public VectorHeap() {
        data = new Vector<>();
    }

    /**
     * Agrega un elemento a la cola con prioridad.
     * @param item El elemento que se va a agregar a la cola con prioridad.
     */
    public void add(E item) {
        data.add(item);
        percolateUp(data.size() - 1);
    }

    /**
     * Elimina y devuelve el elemento de mayor prioridad de la cola con prioridad.
     * @return El elemento de mayor prioridad, o null si la cola está vacía.
     */
    public E remove() {
        if (data.isEmpty())
            return null;
        E minVal = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1)
            pushDownRoot(0);
        return minVal;
    }

    /**
     * Reorganiza el heap hacia arriba para mantener la propiedad de heap después de agregar un elemento.
     * @param leaf El índice del nodo que se está insertando en el heap.
     */
    protected void percolateUp(int leaf) {
        int parent = (leaf - 1) / 2;
        E value = data.get(leaf);
        while (leaf > 0 && value.compareTo(data.get(parent)) < 0) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = (leaf - 1) / 2;
        }
        data.set(leaf, value);
    }

    /**
     * Reorganiza el heap hacia abajo para mantener la propiedad de heap después de eliminar el elemento de mayor prioridad.
     * @param root El índice del nodo raíz del heap.
     */
    protected void pushDownRoot(int root) {
        E value = data.get(root);
        int heapSize = data.size();
        while (root < heapSize) {
            int childpos = 2 * root + 1;
            if (childpos < heapSize) {
                if ((childpos + 1 < heapSize) && (data.get(childpos + 1).compareTo(data.get(childpos)) < 0)) {
                    childpos++;
                }
                if (data.get(childpos).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root, value);
                    return;
                }
            } else {
                data.set(root, value);
                return;
            }
        }
    }

    /**
     * Comprueba si la cola con prioridad está vacía.
     * @return true si la cola está vacía, false si contiene elementos.
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }    

     /**
     * Obtiene el tamaño de la cola con prioridad.
     * @return El número de elementos en la cola con prioridad.
     */
    public int size() {
        return data.size();
    }
}