/**
 * 
 */
package it.unicam.cs.asdl2021.mp2;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 * Implementazione della classe astratta {@code Graph<L>} che realizza un grafo
 * orientato. Non sono accettate etichette dei nodi null e non sono accettate
 * etichette duplicate nei nodi (che in quel caso sono lo stesso nodo).
 * 
 * Per la rappresentazione viene usata una variante della rappresentazione con
 * liste di adiacenza. A differenza della rappresentazione standard si usano
 * strutture dati più efficienti per quanto riguarda la complessità in tempo
 * della ricerca se un nodo è presente (pseudocostante, con tabella hash) e se
 * un arco è presente (pseudocostante, con tabella hash). Lo spazio occupato per
 * la rappresentazione risultà tuttavia più grande di quello che servirebbe con
 * la rappresentazione standard.
 * 
 * Le liste di adiacenza sono rappresentate con una mappa (implementata con
 * tabelle hash) che associa ad ogni nodo del grafo i nodi adiacenti. In questo
 * modo il dominio delle chiavi della mappa è l'insieme dei nodi, su cui è
 * possibile chiamare il metodo contains per testare la presenza o meno di un
 * nodo. Ad ogni chiave della mappa, cioè ad ogni nodo del grafo, non è
 * associata una lista concatenata dei nodi collegati, ma un set di oggetti
 * della classe GraphEdge<L> che rappresentano gli archi uscenti dal nodo: in
 * questo modo la rappresentazione riesce a contenere anche l'eventuale peso
 * dell'arco (memorizzato nell'oggetto della classe GraphEdge<L>). Per
 * controllare se un arco è presenta basta richiamare il metodo contains in
 * questo set. I test di presenza si basano sui metodi equals ridefiniti per
 * nodi e archi nelle classi GraphNode<L> e GraphEdge<L>.
 * 
 * Questa classe non supporta le operazioni di rimozione di nodi e archi e le
 * operazioni indicizzate di ricerca di nodi e archi.
 * 
 * @author Template: Luca Tesei, Implementation: RICCARDO PIERINI - riccardo.pierini@studenti.unicam.it
 *
 * @param <L>
 *                etichette dei nodi del grafo
 */
public class MapAdjacentListDirectedGraph<L> extends Graph<L> {

    /*
     * Le liste di adiacenza sono rappresentate con una mappa. Ogni nodo viene
     * associato con l'insieme degli archi uscenti. Nel caso in cui un nodo non
     * abbia archi uscenti è associato con un insieme vuoto. La variabile
     * istanza è protected solo per scopi di test JUnit.
     */
    protected final Map<GraphNode<L>, Set<GraphEdge<L>>> adjacentLists;

    /*
     * NOTA: per tutti i metodi che ritornano un set utilizzare la classe
     * HashSet<E> per creare l'insieme risultato. Questo garantisce un buon
     * funzionamento dei test JUnit che controllano l'uguaglianza tra insiemi
     */
    
    /**
     * Crea un grafo vuoto.
     */
    public MapAdjacentListDirectedGraph() {
        this.adjacentLists = new HashMap<>();
    }

    @Override
    public int nodeCount() {
        return this.adjacentLists.size();
    }

    @Override
    public int edgeCount() {
        int countEdges=0;
        Set<GraphNode<L>> nodes = this.adjacentLists.keySet();
        for (GraphNode<L> n : nodes)
            countEdges += this.adjacentLists.get(n).size();
        return countEdges;
    }

    @Override
    public void clear() {
        this.adjacentLists.clear();
    }

    @Override
    public boolean isDirected() {
        return true;
    }

    @Override
    public Set<GraphNode<L>> getNodes() {
        return this.adjacentLists.keySet();
    }

    @Override
    public boolean addNode(GraphNode<L> node) {
        if (node==null)
            throw new NullPointerException("Il nodo passato è nullo");
        if (this.containsNode(node))
            return false;
        //inserisco nell'adjacent list il nuovo nodo, con una nuova lista di adiacenza vuota
        this.adjacentLists.put(node, new HashSet<>());
        return true;
    }

    @Override
    public boolean removeNode(GraphNode<L> node) {
        if (node == null)
            throw new NullPointerException(
                    "Tentativo di rimuovere un nodo null");
        throw new UnsupportedOperationException(
                "Rimozione dei nodi non supportata");
    }

    @Override
    public boolean containsNode(GraphNode<L> node) {
        if (node==null)
            throw new NullPointerException("Il nodo cercato è nullo");
        if (this.adjacentLists.containsKey(node))
            return true;
        return false;
    }

    @Override
    public GraphNode<L> getNodeOf(L label) {
        if (label==null)
            throw new NullPointerException("L'etichetta cercata è nullo");
        Set<GraphNode<L>> nodes = this.adjacentLists.keySet();
        for (GraphNode<L> n : nodes) {
            if (n.getLabel().equals(label))
                return n;
        }
        return null;
    }

    @Override
    public int getNodeIndexOf(L label) {
        if (label == null)
            throw new NullPointerException(
                    "Tentativo di ricercare un nodo con etichetta null");
        throw new UnsupportedOperationException(
                "Ricerca dei nodi con indice non supportata");
    }

    @Override
    public GraphNode<L> getNodeAtIndex(int i) {
        throw new UnsupportedOperationException(
                "Ricerca dei nodi con indice non supportata");
    }

    @Override
    public Set<GraphNode<L>> getAdjacentNodesOf(GraphNode<L> node) {
        if (node==null)
            throw new NullPointerException("Il nodo cercato è nullo");
        if (!this.containsNode(node))
            throw new IllegalArgumentException("Il nodo cercato non esiste");
        Set<GraphNode<L>> result = new HashSet<>();
        // Trovo gli archi adiacenti uscenti
        Set<GraphEdge<L>> edges = this.adjacentLists.get(node);
        // Aggiungo al risultato i nodi collegati dagli archi adiacenti
        for (GraphEdge<L> e : edges)
            result.add(e.getNode2());
        return result;
    }

    @Override
    public Set<GraphNode<L>> getPredecessorNodesOf(GraphNode<L> node) {
        if (node==null)
            throw new NullPointerException("Il nodo cercato è nullo");
        if (!this.containsNode(node))
            throw new IllegalArgumentException("Il nodo cercato non esiste");
        Set<GraphNode<L>> result = new HashSet<>();
        // cerco tutti gli archi che entrano in node e inserisco i nodi sorgente nel risultato
        Set<GraphEdge<L>> inEdges = this.getIngoingEdgesOf(node);
        for (GraphEdge<L> e : inEdges)
            result.add(e.getNode1());
        return result;
    }

    @Override
    public Set<GraphEdge<L>> getEdges() {
        Set<GraphEdge<L>> result = new HashSet<>();
        Set<GraphNode<L>> nodes = this.adjacentLists.keySet();
        // Scorro tutti i nodi e aggiungo nell'insieme risultato i relativi archi
        for (GraphNode<L> n : nodes)
            result.addAll(this.adjacentLists.get(n));
        return result;
    }

    @Override
    public boolean addEdge(GraphEdge<L> edge) {
        if (edge==null)
            throw new NullPointerException("L'arco cercato è nullo");
        if (!edge.isDirected())
            throw new IllegalArgumentException("L'arco cercato non è orientato");
        if (!this.containsNode(edge.getNode1()) || !this.containsNode(edge.getNode2()))
            throw new IllegalArgumentException("Almeno uno dei due nodi corrispondenti non esiste");
        // Inserisco l'arco nella lista di adiacenza del nodo sorgente, controllando che già non esista
        if(this.containsEdge(edge))
            return false;
        return this.adjacentLists.get(edge.getNode1()).add(edge);
    }

    @Override
    public boolean removeEdge(GraphEdge<L> edge) {
        throw new UnsupportedOperationException(
                "Rimozione degli archi non supportata");
    }

    @Override
    public boolean containsEdge(GraphEdge<L> edge) {
        if (edge==null)
            throw new NullPointerException("L'arco cercato è nullo");
        // Controllo se i nodi esistono
        if (!this.adjacentLists.containsKey(edge.getNode1()) || !this.adjacentLists.containsKey(edge.getNode2()))
            throw new IllegalArgumentException("Almeno uno dei due nodi corrispondenti non esiste");
        // Cerco l'arco nella lista di adiacenza del nodo sorgente
        return this.adjacentLists.get(edge.getNode1()).contains(edge);
    }

    @Override
    public Set<GraphEdge<L>> getEdgesOf(GraphNode<L> node) {
        if (node==null)
            throw new NullPointerException("Il nodo cercato è nullo");
        if (!this.containsNode(node))
            throw new IllegalArgumentException("Il nodo cercato non esiste");
        return this.adjacentLists.get(node);
    }

    @Override
    public Set<GraphEdge<L>> getIngoingEdgesOf(GraphNode<L> node) {
        if (node==null)
            throw new NullPointerException("Il nodo cercato è nullo");
        if (!this.containsNode(node))
            throw new IllegalArgumentException("Il nodo cercato non esiste");
        Set<GraphEdge<L>> result = new HashSet<>();
        // cerco fra tutti gli archi quelli che entrano in node e li inserisco nel risultato
        Set<GraphEdge<L>> allEdges = this.getEdges();
        for (GraphEdge<L> e : allEdges)
            if (e.getNode2().equals(node))
                result.add(e);
        return result;
    }
}
