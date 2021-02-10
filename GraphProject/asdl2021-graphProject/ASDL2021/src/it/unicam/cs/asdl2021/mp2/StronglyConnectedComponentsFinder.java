/**
 * 
 */
package it.unicam.cs.asdl2021.mp2;

import java.util.*;

/**
 * Un oggetto di questa classe singoletto è un attore che trova le componenti
 * fortemente connesse in un grafo orientato che viene passato come parametro.
 * 
 * @author Template: Luca Tesei, Implementation: RICCARDO PIERINI - riccardo.pierini@studenti.unicam.it
 *
 */
public class StronglyConnectedComponentsFinder<L> {

    //stack utile per controllare i nodi visitati in ordine
    private Stack<GraphNode<L>> completedNodes;
    //risultato finale dell'algoritmo
    private Set<Set<GraphNode<L>>> stronglyConnectedComponents;

    /*
     * NOTA: per tutti i metodi che ritornano un set utilizzare la classe
     * HashSet<E> per creare l'insieme risultato. Questo garantisce un buon
     * funzionamento dei test JUnit che controllano l'uguaglianza tra insiemi
     */

    /**
     * Dato un grafo orientato determina l'insieme di tutte le componenti
     * fortemente connesse dello stesso.
     * 
     * @param g
     *              un grafo orientato
     * @return l'insieme di tutte le componenti fortemente connesse di g dove
     *         ogni componente fortemente connessa è rappresentata dall'insieme
     *         dei nodi che la compongono.
     * @throws IllegalArgumentException
     *                                      se il grafo passato non è orientato
     * @throws NullPointerException
     *                                      se il grafo passato è nullo
     */
    public Set<Set<GraphNode<L>>> findStronglyConnectedComponents(Graph<L> g) {
        if(g==null)
            throw new NullPointerException("Il grafo passato è nullo");
        if(!g.isDirected())
            throw new IllegalArgumentException("Il grafo passato non è orientato");
        stronglyConnectedComponents = new HashSet<>();
        completedNodes = new Stack<>();
        //comincio la prima visita per riempire in ordine lo stack
        firstDfs(g);
        Graph<L> transposeGraph=getTranspose(g);
        //resetto i nodi dello stack in bianchi per rifare un'altra visita
        for(GraphNode<L> node : completedNodes)
            node.setColor(0);
        //comincio la saconda visita per il grafo trasposto, individuando cosi le differenti componenti fortemente connesse
        secondeDfs(transposeGraph);
        return stronglyConnectedComponents;
    }

    //metodo che comincia la visita in profondità del grafo, per riempire lo stack dei nodi visitati nel giusto ordine
    private void firstDfs(Graph<L> graph){
        //resetto tutti i nodi a bianchi per indicare che ancora non sono stati visitati
        for(GraphNode<L> node : graph.getNodes())
            node.setColor(0);
        //comincia la visita in profondità per ogni nodo di graph
        for(GraphNode<L> node : graph.getNodes()){
            if(node.getColor()==0)
                findOrder(graph, node);
        }
    }

    //metodo che serve per aggiungere i nodi in ordine di scoperta nello stack
    private void findOrder(Graph<L> graph, GraphNode<L> node){
        node.setColor(1); //il nodo white è stato scoperto
        for (GraphNode<L> n : graph.getAdjacentNodesOf(node)) {
            //faccio la visita in profondità di tutti i nodi adiacenti di node che non sono già stati visitati
            if(n.getColor()==0) {
                findOrder(graph,n); //vado più in profondità
            }
        }
        //aggiungo il nodo completamente scoperto allo stack dei nodi completati
        completedNodes.add(node);
    }

    //metodo che visita il grafo trasposto in profondità per trovare le componenti fortemente connesse
    private void secondeDfs(Graph<L> graph) {
        //ripeto il metodo finchè lo stack non è vuoto
        while (!completedNodes.empty()) {
            //comincio la visita al contrario dall'ultimo nodo della coda
            GraphNode<L> node = completedNodes.pop();
            //se il nodo preso dallo stack è già stato visitato è già presente in una componente
            // fortemente connessa, quindi posso passare oltre
            if (node.getColor() == 0) {
                node.setColor(1); //il nodo è stato scoperto
                Set<GraphNode<L>> set = new HashSet<>(); //dichiaro una nuova componente fortemente connessa
                set.add(node); //aggiungo il primo nodo a questa componente
                for (GraphNode<L> n : graph.getAdjacentNodesOf(node)) {
                    //faccio la visita in profondità di tutti i nodi adiacenti di node che non sono già stati visitati
                    if (n.getColor() == 0) {
                        dfsTranspose(graph, n, set); //vado più in profondità
                    }
                }
                //arrivati a questo punto abbiamo una nuova componente fortemente connessa,
                // quindi aggiungo il set al risultato finale
                stronglyConnectedComponents.add(set);
            }
        }
    }

    private Set<GraphNode<L>> dfsTranspose(Graph<L> graph, GraphNode<L> node, Set<GraphNode<L>> set){
        node.setColor(1); //il nodo white è stato scoperto
        for (GraphNode<L> n : graph.getAdjacentNodesOf(node)) {
            //faccio la visita in profondità di tutti i nodi adiacenti di node che non sono già stati visitati
            if(n.getColor()==0)
                dfsTranspose(graph,n,set); //vado più in profondità
        }
        //aggiungo il nodo completamente visitato alla componente fortemente connessa chiamata in precedenza
        set.add(node);
        return set;
    }

    //metodo per ottenere la trasposta di un grafo (grafo con gli stessi nodi, ma con gli edge orientati nel senso opposto)
    private Graph<L> getTranspose(Graph<L> graph){
        Graph<L> transposeGraph=new MapAdjacentListDirectedGraph<>();
        for (GraphNode<L> node : graph.getNodes())
            transposeGraph.addNode(node);
        Set<GraphEdge<L>> edges=new HashSet<>();
        for (GraphEdge<L> edge : graph.getEdges()){
            GraphEdge<L> newEdge= new GraphEdge<L>(edge.getNode2(),edge.getNode1(),true);
            edges.add(newEdge);
        }
        for (GraphEdge<L> edge : edges)
            transposeGraph.addEdge(edge);
        return transposeGraph;
    }

}
