package it.unicam.cs.asdl2021.mp2;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Class that provides an implementation of a "dynamic" min-priority queue based
 * on a ternary heap. "Dynamic" means that the priority of an element already
 * present in the queue may be decreased, so possibly this element may become
 * the new minumum element. The elements that can be inserted may be of any
 * class implementing the interface <code>PriorityQueueElement</code>. This
 * min-priority queue does not have capacity restrictions, i.e., it is always
 * possible to insert new elements and the number of elements is unbound.
 * Duplicated elements are permitted while <code>null</code> elements are not
 * permitted.
 * 
 * @author Template: Luca Tesei, Implementation: RICCARDO PIERINI - riccardo.pierini@studenti.unicam.it
 *
 */
public class TernaryHeapMinPriorityQueue {

    /*
     * ArrayList for representing the ternary heap. Use all positions, including
     * position 0 (the JUnit tests will assume so). You have to adapt
     * child/parent indexing formulas consequently.
     */
    private ArrayList<PriorityQueueElement> heap;

    /**
     * Create an empty queue.
     */
    public TernaryHeapMinPriorityQueue() {
        this.heap = new ArrayList<>();
    }

    /**
     * Return the current size of this queue.
     * 
     * @return the number of elements currently in this queue.
     */
    public int size() {
        return this.heap.size();
    }

    /**
     * Add an element to this min-priority queue. The current priority
     * associated with the element will be used to place it in the correct
     * position in the ternary heap. The handle of the element will also be set
     * accordingly.
     * 
     * @param element
     *                    the new element to add
     * @throws NullPointerException
     *                                  if the element passed is null
     */
    public void insert(PriorityQueueElement element) {
        if (element == null)
            throw new NullPointerException("L'elemento passato è nullo");
        this.heap.add(element);         //element viene temporaneamente aggiunto alla fine dell'heap list
        element.setHandle(this.heap.size() - 1);    //l'handle di element è momentaneamente quello dell'ultimo elemento del'heap
        int i = this.heap.size() - 1;
        while (i > 0) {
            //se la priorità di element è più alta di quella del genitore, scambio i due nodi, altrimenti va bene cosi
            if (this.heap.get(i).getPriority() < this.heap.get(getHandleParent(i)).getPriority()) {
                swapElements(i, getHandleParent(i));
                //salgo nell'heap e vado dal genitore di i
                i = getHandleParent(i);
            } else
                break;
        }
    }

    /**
     * Returns the current minimum element of this min-priority queue without
     * extracting it. This operation does not affect the ternary heap.
     * 
     * @return the current minimum element of this min-priority queue
     * 
     * @throws NoSuchElementException
     *                                    if this min-priority queue is empty
     */
    public PriorityQueueElement minimum() {
        if (this.heap.isEmpty())
            throw new NoSuchElementException("L'heap è vuoto");
        //l'elemento con priorità minore è sempre quello alla radice dell'heap
        return this.heap.get(0);
    }

    /**
     * Extract the current minimum element from this min-priority queue. The
     * ternary heap will be updated accordingly.
     * 
     * @return the current minimum element
     * @throws NoSuchElementException
     *                                    if this min-priority queue is empty
     */
    public PriorityQueueElement extractMinimum() {
        if (this.heap.isEmpty())
            throw new NoSuchElementException("L'heap è vuoto");
        PriorityQueueElement min = this.minimum();
        //quando viene rimosso un nodo come radice, lo sostituisco con l'ultima foglia dell'heap
        this.heap.set(0, this.heap.get(this.heap.size() - 1));
        this.heap.get(0).setHandle(0);
        //levo l'ultima foglia dell'heap, visto che l'elemento è già stato spostato all'inizio dell'heap
        this.heap.remove(this.heap.size() - 1);
        //ripristino le proprietà dell'heap
        heapify(0);
        //viene restituito il nodo inizialmente rimosso
        return min;
    }

    /**
     * Decrease the priority associated to an element of this min-priority
     * queue. The position of the element in the ternary heap must be changed
     * accordingly. The changed element may become the minimum element. The
     * handle of the element will also be changed accordingly.
     * 
     * @param element
     *                        the element whose priority will be decreased, it
     *                        must currently be inside this min-priority queue
     * @param newPriority
     *                        the new priority to assign to the element
     * 
     * @throws NoSuchElementException
     *                                      if the element is not currently
     *                                      present in this min-priority queue
     * @throws IllegalArgumentException
     *                                      if the specified newPriority is not
     *                                      strictly less than the current
     *                                      priority of the element
     */
    public void decreasePriority(PriorityQueueElement element,
            double newPriority) {
        if (!this.heap.contains(element))
            throw new NoSuchElementException("L'elemento non è contenuto in questo heap");
        if (newPriority > element.getPriority())
            throw new IllegalArgumentException("La priorità deve essere minore o uguale dell'attuale");
        int currentHandle = element.getHandle();
        this.heap.get(currentHandle).setPriority(newPriority);
        while (currentHandle > 0) {
            //vedo se element con la nuova priorità è minore del genitore, in caso lo sia bisogna scambiare i nodi, altrimenti va bene cosi
            if (this.heap.get(currentHandle).getPriority() < this.heap.get(getHandleParent(currentHandle)).getPriority()) {
                swapElements(currentHandle, getHandleParent(currentHandle));
                currentHandle = getHandleParent(currentHandle);
            } else
                break;
        }
    }

    /**
     * Erase all the elements from this min-priority queue. After this operation
     * this min-priority queue is empty.
     */
    public void clear() {
        this.heap.clear();
    }

    /**
     * Returns the parent's handle of parameter i
     * @param i  node's handle
     * @return  parent's handle of 'i'
     */
    private int getHandleParent(int i) {
        return (i - 1) / 3;
    }

    /**
     * Returns the left child's handle of parameter i
     * @param i  node's handle
     * @return  left's handle of 'i'
     */
    private int getHandleLeft(int i) {
        return (3 * i) + 1;
    }

    /**
     * Returns the center child's handle of parameter i
     * @param i  node's handle
     * @return  center's handle of 'i'
     */
    private int getHandleCenter(int i) {
        return (3 * i) + 2;
    }

    /**
     * Returns the right child's handle of parameter i
     * @param i  node's handle
     * @return  right's handle of 'i'
     */
    private int getHandleRight(int i) {
        return (3 * i) + 3;
    }

    /**
     * Swaps two elements in the heap, both their position in the arrayList "heap" and their handle too
     * @param i     first element to swap
     * @param j     second element to swap
     */
    private void swapElements(int i, int j) {
        PriorityQueueElement swapElement = this.heap.get(i);
        this.heap.set(i, this.heap.get(j));
        this.heap.set(j, swapElement);
        //sincronizzo l'handle dei nodi scambiati con l'indice dell'heap array corrispettivo
        int swapHandle = this.heap.get(i).getHandle();
        this.heap.get(i).setHandle(this.heap.get(j).getHandle());
        this.heap.get(j).setHandle(swapHandle);
    }

    /**
     * Resets minHeap properties
     * @param i    node's handle where the procedure starts
     */
    private void heapify(int i){
        int smallest=i;
        int left=getHandleLeft(i);
        int center=getHandleCenter(i);
        int right=getHandleRight(i);

        //controlla se l'heap ha un figlio sinistro e se esso ha una priorità minore del genitore diventa il più piccolo
        if(left<this.size() && this.heap.get(left).getPriority()<this.heap.get(smallest).getPriority())
            smallest=left;
        //controlla se l'heap ha un figlio centrale e se esso ha una priorità minore del genitore diventa il più piccolo
        if(center<this.size() && this.heap.get(center).getPriority()<this.heap.get(smallest).getPriority())
            smallest=center;
        //controlla se l'heap ha un figlio destro e se esso ha una priorità minore del genitore diventa il più piccolo
        if(right<this.size() && this.heap.get(right).getPriority()<this.heap.get(smallest).getPriority())
            smallest=right;
        //se il più piccolo non è il nodo di partenza, vengono scambiati gli handlers di i e smallest
        // e viene richiamato ricorsivamente il metodo heapify
        if(smallest!=i){
            swapElements(i,smallest);
            this.heapify(smallest);
        }
    }
    /*
     * This method is only for JUnit testing purposes.
     */
    protected ArrayList<PriorityQueueElement> getTernaryHeap() {
        return this.heap;
    }

}
