import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> {
    protected Vector<E> data;

    // Constructor
    public VectorHeap() {
        data = new Vector<>();
    }

    // Insertar un elemento en la cola con prioridad
    public void add(E item) {
        data.add(item);
        percolateUp(data.size() - 1);
    }

    // Eliminar y devolver el elemento de mayor prioridad
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

    // Reorganizar hacia arriba
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

    // Reorganizar hacia abajo
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

    public boolean isEmpty() {
        return data.isEmpty();
    }    
}