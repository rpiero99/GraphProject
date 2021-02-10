/**
 * 
 */
package it.unicam.cs.asdl2021.mp2;

import java.util.*;

/**
 * Classe che implementa un grafo non orientato tramite matrice di adiacenza.
 * Non sono accettate etichette dei nodi null e non sono accettate etichette
 * duplicate nei nodi (che in quel caso sono lo stesso nodo).
 * 
 * I nodi sono indicizzati da 0 a nodeCoount() - 1 seguendo l'ordine del loro
 * inserimento (0 è l'indice del primo nodo inserito, 1 del secondo e così via)
 * e quindi in ogni istante la matrice di adiacenza ha dimensione nodeCount() *
 * nodeCount(). La matrice, sempre quadrata, deve quindi aumentare di dimensione
 * ad ogni inserimento di un nodo. Per questo non è rappresentata tramite array
 * ma tramite ArrayList.
 * 
 * Gli oggetti GraphNode<L>, cioè i nodi, sono memorizzati in una mappa che
 * associa ad ogni nodo l'indice assegnato in fase di inserimento. Il dominio
 * della mappa rappresenta quindi l'insieme dei nodi.
 * 
 * Gli archi sono memorizzati nella matrice di adiacenza. A differenza della
 * rappresentazione standard con matrice di adiacenza, la posizione i,j della
 * matrice non contiene un flag di presenza, ma è null se i nodi i e j non sono
 * collegati da un arco e contiene un oggetto della classe GraphEdge<L> se lo
 * sono. Tale oggetto rappresenta l'arco. Un oggetto uguale (secondo equals) e
 * con lo stesso peso (se gli archi sono pesati) deve essere presente nella
 * posizione j, i della matrice.
 * 
 * Questa classe non supporta i metodi di cancellazione di nodi e archi, ma
 * supporta tutti i metodi che usano indici, utilizzando l'indice assegnato a
 * ogni nodo in fase di inserimento.
 * 
 * @author Template: Luca Tesei, Implementation: RICCARDO PIERINI - riccardo.pierini@studenti.unicam.it
 *
 */
public class AdjacencyMatrixUndirectedGraph<L> extends Graph<L> {
    /*
     * Le seguenti variabili istanza sono protected al solo scopo di agevolare
     * il JUnit testing
     */

    // Insieme dei nodi e associazione di ogni nodo con il proprio indice nella
    // matrice di adiacenza
    protected Map<GraphNode<L>, Integer> nodesIndex;

    // Matrice di adiacenza, gli elementi sono null o oggetti della classe
    // GraphEdge<L>. L'uso di ArrayList permette alla matrice di aumentare di
    // dimensione gradualmente ad ogni inserimento di un nuovo nodo.
    protected ArrayList<ArrayList<GraphEdge<L>>> matrix;

    //contatore per gli archi, che aumenta quando viene aggiunto un arco e decrementato quando uno viene tolto
    private int contEdges;

    //contatore per i nodi, xhe aumenta quando viene aggiunto un nodo e decrementato quando uno viene tolto
    private int contNodes;

    /*
     * NOTA: per tutti i metodi che ritornano un set utilizzare la classe
     * HashSet<E> per creare l'insieme risultato. Questo garantisce un buon
     * funzionamento dei test JUnit che controllano l'uguaglianza tra insiemi
     */
    
    /**
     * Crea un grafo vuoto.
     */
    public AdjacencyMatrixUndirectedGraph() {
        this.matrix = new ArrayList<>();
        this.nodesIndex = new HashMap<>();
        this.contEdges=0;
        this.contNodes=0;
    }

    @Override
    public int nodeCount() {
        return this.contNodes;
    }

    @Override
    public int edgeCount() {
        return this.contEdges;
    }

    @Override
    public void clear() {
        this.matrix = new ArrayList<>();
        this.nodesIndex = new HashMap<>();
        this.contEdges=0;
        this.contNodes=0;
    }

    @Override
    public boolean isDirected() {
        return false;
    }

    @Override
    public Set<GraphNode<L>> getNodes() {
        return this.nodesIndex.keySet();
    }

    @Override
    public boolean addNode(GraphNode<L> node) {
        if (node==null)
            throw new NullPointerException("Il nodo passato è nullo");
        if (this.containsNode(node))
            return false;
        //inserisco il nodo nell'hashmap
        this.nodesIndex.put(node,this.nodeCount());
        this.contNodes++;
        //ridimensiono la matrice a causa dell'inserimento di un nuovo nodo
        //aggiungo una arraylist vuota alla matrice
        this.matrix.add(new ArrayList<>());
        //controllo che tutte le arraylist in matrix abbiano tutte la stessa dimensione
        // per mantenere la proprietà di essere quadrata della matrice
        for (ArrayList<GraphEdge<L>> list: this.matrix){
            //calcolo il numero di null che devo aggiungere alla list
            // per assicurare che abbia la stessa dimensione della matrice
            int diff=contNodes-list.size();
            for (int i=0; i<diff;i++)
                //in caso un'arraylist sia troppo piccola, viene riempita di elementi null
                list.add(null);
        }
        return true;
    }

    @Override
    public boolean removeNode(GraphNode<L> node) {
        throw new UnsupportedOperationException(
                "Remove di nodi non supportata");
    }

    @Override
    public boolean containsNode(GraphNode<L> node) {
        if (node==null)
            throw new NullPointerException("Il nodo cercato è nullo");
        if (this.nodesIndex.containsKey(node))
            return true;
        return false;
    }

    @Override
    public GraphNode<L> getNodeOf(L label) {
        if (label==null)
            throw new NullPointerException("L'etichetta cercata è nulla");
        Set<GraphNode<L>> nodes = this.getNodes();
        for (GraphNode<L> n : nodes)
            if (n.getLabel().equals(label))
                return n;
        return null;
    }

    @Override
    public int getNodeIndexOf(L label) {
        if (label==null)
            throw new NullPointerException("L'etichetta cercata è nulla");
        if (this.getNodeOf(label)==null)
            throw new IllegalArgumentException("Non esiste un nodo con quest'etichetta");
        Set<GraphNode<L>> nodes = this.getNodes();
        int index=0;
        //cerco nella mia map il nodo con la stessa label e ne prendo l'indice grazie alle proprietà di hashmap
        for (GraphNode<L> n : nodes){
            if (n.getLabel().equals(label))
               index=this.nodesIndex.get(n);
        }
        return index;
    }

    @Override
    public GraphNode<L> getNodeAtIndex(int i) {
        if(i>=nodeCount() || i<0)
            throw new IndexOutOfBoundsException("L'indice passato è maggiore della dimensione dell'hash set");
        //sfrutto la proprietà di hashmap per prendere la chiave, dato il suo value corrispondente (l'indice i)
        for (Map.Entry<GraphNode<L>, Integer> entry : this.nodesIndex.entrySet()){
            if (entry.getValue()==i)
                return entry.getKey();
        }
        return null;
    }

    @Override
    public Set<GraphNode<L>> getAdjacentNodesOf(GraphNode<L> node) {
        if (node==null)
            throw new NullPointerException("Il nodo cercato è nullo");
        if (!this.containsNode(node))
            throw new IllegalArgumentException("Il nodo cercato non esiste");
        Set<GraphNode<L>> nodes = new HashSet<>();
        //aggiungo al set di nodi tutti quei nodi nei quali si trova l'accoppiamento con node
        for(GraphEdge<L> edge : this.getEdges()){
            if(edge.getNode1().equals(node))
                nodes.add(edge.getNode2());
            else if(edge.getNode2().equals(node))
                nodes.add(edge.getNode1());
        }
        return nodes;
    }

    @Override
    public Set<GraphNode<L>> getPredecessorNodesOf(GraphNode<L> node) {
        throw new UnsupportedOperationException(
                "Operazione non supportata in un grafo non orientato");
    }

    @Override
    public Set<GraphEdge<L>> getEdges() {
        Set<GraphEdge<L>> result = new HashSet<>();
        //grazie alla proprietà di set non verranno inseriti nel set i duplicati degli edge
        for (ArrayList<GraphEdge<L>> list : this.matrix){
            for (GraphEdge<L> edge: list){
                if (edge!=null){
                    result.add(edge);
                }
            }
        }
        return result;
    }

    @Override
    public boolean addEdge(GraphEdge<L> edge) {
        if (edge==null)
            throw new NullPointerException("L'arco cercato è nullo");
        if (edge.isDirected())
            throw new IllegalArgumentException("L'arco cercato è orientato");
        if (!this.containsNode(edge.getNode1())  || !this.containsNode(edge.getNode2()))
            throw new IllegalArgumentException("Almeno uno dei due nodi corrispondenti non esiste");
        if (this.containsEdge(edge))
            return false;
        int indexNode1=this.getNodeIndexOf(edge.getNode1().getLabel());
        int indexNode2=this.getNodeIndexOf(edge.getNode2().getLabel());
        ArrayList<GraphEdge<L>> edges1=matrix.get(indexNode1);
        edges1.set(indexNode2,edge);
        matrix.set(indexNode1,edges1);
        if(indexNode1!=indexNode2){
            ArrayList<GraphEdge<L>> edges2=matrix.get(indexNode2);
            edges2.set(indexNode1,edge);
            matrix.set(indexNode2,edges2);
        }
        contEdges++;
        return true;
    }

    @Override
    public boolean removeEdge(GraphEdge<L> edge) {
        throw new UnsupportedOperationException(
                "Operazione di remove non supportata in questa classe");
    }

    @Override
    public boolean containsEdge(GraphEdge<L> edge) {
        if (edge==null)
            throw new NullPointerException("L'arco cercato è nullo");
        //controllo se i nodi collegati da quest'arco esistano
        if (!this.nodesIndex.containsKey(edge.getNode1())  || !this.nodesIndex.containsKey(edge.getNode2()))
            throw new IllegalArgumentException("Almeno uno dei due nodi corrispondenti non esiste");
        //se la matrice è vuota è ovvio che non contenga l'arco
        if (matrix.isEmpty())
            return false;
        for (ArrayList<GraphEdge<L>> edge1D : this.matrix){
            if(edge1D.contains(edge))
                return true;
        }
        return false;
    }

    @Override
    public Set<GraphEdge<L>> getEdgesOf(GraphNode<L> node) {
        if (node==null)
            throw new NullPointerException("Il nodo passato è nullo");
        if (!this.containsNode(node))
            throw new IllegalArgumentException("Il nodo passato non esiste nel grafo");
        Set<GraphEdge<L>> result=new HashSet<>();
        //vengono aggiunti al set tutti gli edge il cui node1 o node2 è uguale a node
        for (GraphEdge<L> edge : this.getEdges()){
            if(edge.getNode1().equals(node) || edge.getNode2().equals(node))
                result.add(edge);
        }
        return result;
    }

    @Override
    public Set<GraphEdge<L>> getIngoingEdgesOf(GraphNode<L> node) {
        throw new UnsupportedOperationException(
                "Operazione non supportata in un grafo non orientato");
    }

}
