package it.unicam.cs.asdl2021.mp2;

/**
 *
 * Classe singoletto che implementa l'algoritmo di Prim per trovare un Minimum
 * Spanning Tree di un grafo non orientato, pesato e con pesi non negativi.
 *
 * L'algoritmo usa una coda di min priorità tra i nodi implementata dalla classe
 * TernaryHeapMinPriorityQueue. I nodi vengono visti come PriorityQueueElement
 * poiché la classe GraphNode<L> implementa questa interfaccia. Si noti che
 * nell'esecuzione dell'algoritmo è necessario utilizzare l'operazione di
 * decreasePriority.
 *
 * @author Template: Luca Tesei, Implementation: RICCARDO PIERINI - riccardo.pierini@studenti.unicam.it
 *
 * @param <L>
 *                etichette dei nodi del grafo
 *
 */
public class PrimMSP<L> {

    /*
     * Coda di priorità che va usata dall'algoritmo. La variabile istanza è
     * protected solo per scopi di testing JUnit.
     */
    protected TernaryHeapMinPriorityQueue queue;

    /**
     * Crea un nuovo algoritmo e inizializza la coda di priorità con una coda
     * vuota.
     */
    public PrimMSP() {
        this.queue = new TernaryHeapMinPriorityQueue();
    }

    /**
     * Utilizza l'algoritmo goloso di Prim per trovare un albero di copertura
     * minimo in un grafo non orientato e pesato, con pesi degli archi non negativi.
     * Dopo l'esecuzione del metodo nei nodi del grafo il campo previous deve
     * contenere un puntatore a un nodo in accordo all'albero di copertura
     * minimo calcolato, la cui radice è il nodo sorgente passato.
     *
     * @param g
     *              un grafo non orientato, pesato, con pesi non negativi
     * @param s
     *              il nodo del grafo g sorgente, cioè da cui parte il calcolo
     *              dell'albero di copertura minimo. Tale nodo sarà la radice
     *              dell'albero di copertura trovato
     *
     * @throw NullPointerException se il grafo g o il nodo sorgente s sono nulli
     * @throw IllegalArgumentException se il nodo sorgente s non esiste in g
     * @throw IllegalArgumentException se il grafo g è orientato, non pesato o
     *        con pesi negativi
     */
    @SuppressWarnings("unchecked")
    public void computeMSP(Graph<L> g, GraphNode<L> s) {
        if (g==null || s==null)
            throw new NullPointerException("Il grafo o il nodo sorgente sono nulli");
        if (!g.containsNode(s))
            throw new IllegalArgumentException("Il nodo sorgente non è presente in questo grafo");
        if (g.isDirected())
            throw new IllegalArgumentException("Il grafo non può essere orientato");
        for (GraphEdge<L> edge : g.getEdges()){
            if (!edge.hasWeight() || edge.getWeight()<0)
                throw new IllegalArgumentException("Almeno un edge non ha un peso o ne ha uno negativo");
        }
        //"resetto" tutti i nodi del grafo, ponendo il colore a 0, il precedente a 0 e mettendogli la priorità massima
        for(GraphNode<L> node : g.getNodes()) {
            node.setColor(0);
            node.setPriority(Double.MAX_VALUE);
            node.setPrevious(null);
        }
        //pongo la priorità a 0 dal nodo di partenza
        s.setPriority(0);
        //inserisco tutti i nodi del grafo nella queue
        for(GraphNode<L> node : g.getNodes())
            queue.insert(node);
        //finchè la coda ha almeno un elemento, faccio le operazioni di msp
        while(queue.size()!=0){
            //prendo il nodo con priorità minore e ristabilisco le proprietà del minheap
            GraphNode<L> current= (GraphNode<L>) queue.extractMinimum();
            current.setColor(1); //metto il colore ad 1 per segnarmi che questo nodo è uscito dall'heap
            //itero tutti i nodi adiacenti a current per vedere se hanno una priorità maggiore all'edge che li collegano a current
            for(GraphNode<L> node : g.getAdjacentNodesOf(current)){
                GraphEdge<L> edgeCurrentToNode=getCurrentEdge(g,current,node);
                //se node è ancora nell'heap e l'edge in questione ha una priorità minore di node,
                //current diventa il predecessore di node e gli assegno una nuova priorità sicuramente minore
                if(node.getColor()==0 && edgeCurrentToNode.getWeight()<node.getPriority()) {
                    //si può fare anche if(queue.getTernaryHeap().contains(node) invece della prima parte dell'if
                    node.setPrevious(current);
                    queue.decreasePriority(node, edgeCurrentToNode.getWeight());
                }
            }
        }
    }

    //metodo che mi permette di trovare l'edge che collega current a node (che esiste sicuramente poichè sono adiacenti)
    private GraphEdge<L> getCurrentEdge(Graph<L> graph, GraphNode<L> current, GraphNode<L> node ){
        GraphEdge<L> edgeCurrentToNode=null;
        for(GraphEdge<L> edge : graph.getEdgesOf(current)){
            if (edge.getNode1().equals(current) && edge.getNode2().equals(node) || edge.getNode1().equals(node) && edge.getNode2().equals(current))
                edgeCurrentToNode=edge;
        }
        return edgeCurrentToNode;
    }
}
