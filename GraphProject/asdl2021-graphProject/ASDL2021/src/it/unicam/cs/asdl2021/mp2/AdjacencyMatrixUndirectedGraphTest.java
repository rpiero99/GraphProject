package it.unicam.cs.asdl2021.mp2;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/*
    @author - Riccardo Pierini 105131
    @project - asdl2021-codice-mp2-traccia
 */
class AdjacencyMatrixUndirectedGraphTest {

   /* @org.junit.jupiter.api.Test
    void nodeCount() {
        AdjacencyMatrixUndirectedGraph<Integer> graph=new AdjacencyMatrixUndirectedGraph();
        GraphNode<Integer> node= new GraphNode<>(39);
        GraphNode<Integer> node1= new GraphNode<>(31);
        GraphNode<Integer> node2= new GraphNode<>(5);
        graph.addNode(node);
        assertFalse(graph.isEmpty());
        graph.addNode(node1);
        graph.addNode(node2);
        assertFalse(graph.nodeCount()==2);
        assertTrue(graph.nodeCount()==3);
    }

    @org.junit.jupiter.api.Test
    void addNode() {
        AdjacencyMatrixUndirectedGraph<Integer> graph=new AdjacencyMatrixUndirectedGraph();
        GraphNode<Integer> node= new GraphNode<>(39);
        assertThrows(NullPointerException.class, () -> graph.addNode(null));
        GraphNode<Integer> node1= new GraphNode<>(31);
        GraphNode<Integer> node2= new GraphNode<>(5);
        assertTrue(graph.addNode(node));
        assertTrue(graph.addNode(node1));
        assertFalse(graph.addNode(node1));
        assertTrue(graph.addNode(node2));
    }

    @org.junit.jupiter.api.Test
    void containsNode() {
        AdjacencyMatrixUndirectedGraph<Integer> graph=new AdjacencyMatrixUndirectedGraph();
        GraphNode<Integer> node= new GraphNode<>(39);
        GraphNode<Integer> node1= new GraphNode<>(31);
        GraphNode<Integer> node2= new GraphNode<>(5);
        graph.addNode(node);
        graph.addNode(node2);
        assertThrows(NullPointerException.class, () -> graph.containsNode(null));
        assertTrue(graph.containsNode(node));
        assertFalse(graph.containsNode(node1));
        assertTrue(graph.containsNode(node2));
    }

    @org.junit.jupiter.api.Test
    void getNodeOf() {
        AdjacencyMatrixUndirectedGraph<Integer> graph=new AdjacencyMatrixUndirectedGraph();
        GraphNode<Integer> node= new GraphNode<>(39);
        GraphNode<Integer> node1= new GraphNode<>(31);
        GraphNode<Integer> node2= new GraphNode<>(5);
        graph.addNode(node);
        graph.addNode(node1);
        graph.addNode(node2);
        assertThrows(NullPointerException.class, () -> graph.getNodeOf(null));
        assertTrue(graph.getNodeOf(31)==node1);
        assertFalse(graph.getNodeOf(39)==node2);
    }

    @org.junit.jupiter.api.Test
    void getNodeIndexOf() {
        AdjacencyMatrixUndirectedGraph<Integer> graph=new AdjacencyMatrixUndirectedGraph();
        GraphNode<Integer> node= new GraphNode<>(39);
        GraphNode<Integer> node1= new GraphNode<>(31);
        GraphNode<Integer> node2= new GraphNode<>(5);
        graph.addNode(node);
        graph.addNode(node1);
        graph.addNode(node2);
        assertThrows(NullPointerException.class, () -> graph.getNodeIndexOf(null));
        assertThrows(IllegalArgumentException.class, () -> graph.getNodeIndexOf(34));
        assertTrue(graph.getNodeIndexOf(31)==1);
        assertFalse(graph.getNodeIndexOf(5)==1);
    }

    @org.junit.jupiter.api.Test
    void getNodeAtIndex() {
        AdjacencyMatrixUndirectedGraph<Integer> graph=new AdjacencyMatrixUndirectedGraph();
        GraphNode<Integer> node= new GraphNode<>(77);
        GraphNode<Integer> node1= new GraphNode<>(19);
        GraphNode<Integer> node2= new GraphNode<>(11);
        graph.addNode(node);
        graph.addNode(node1);
        graph.addNode(node2);
        assertThrows(IndexOutOfBoundsException.class, () -> graph.getNodeAtIndex(3));
        assertEquals(graph.getNodeAtIndex(2),node2);
        assertNotEquals(graph.getNodeAtIndex(2),node);
        assertEquals(graph.getNodeAtIndex(1),node1);
        assertEquals(graph.getNodeAtIndex(0),node);
    }

    @org.junit.jupiter.api.Test
    void getAdjacentNodesOf() {
        AdjacencyMatrixUndirectedGraph<Integer> graph=new AdjacencyMatrixUndirectedGraph();
        GraphNode<Integer> node= new GraphNode<>(77);
        GraphNode<Integer> node1= new GraphNode<>(19);
        GraphNode<Integer> node2= new GraphNode<>(11);
        GraphNode<Integer> node3= new GraphNode<>(17);
        graph.addNode(node);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        GraphEdge<Integer> edge=new GraphEdge<>(node,node1,false);
        GraphEdge<Integer> edge1=new GraphEdge<>(node1,node2,false);
        GraphEdge<Integer> edge2=new GraphEdge<>(node2,node3,false);
        GraphEdge<Integer> edge3=new GraphEdge<>(node1,node1,false);
        graph.addEdge(edge);
        graph.addEdge(edge1);
        graph.addEdge(edge2);
        graph.addEdge(edge3);
        Set<GraphNode<Integer>> result=graph.getAdjacentNodesOf(node1);
        assertTrue(result.size()==3);
    }

    @org.junit.jupiter.api.Test
    void getEdges() {
        AdjacencyMatrixUndirectedGraph<Integer> graph=new AdjacencyMatrixUndirectedGraph();
        GraphNode<Integer> node= new GraphNode<>(77);
        GraphNode<Integer> node1= new GraphNode<>(19);
        GraphNode<Integer> node2= new GraphNode<>(11);
        GraphNode<Integer> node3= new GraphNode<>(17);
        graph.addNode(node);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        GraphEdge<Integer> edge=new GraphEdge<>(node,node1,false);
        GraphEdge<Integer> edge1=new GraphEdge<>(node1,node2,false);
        GraphEdge<Integer> edge2=new GraphEdge<>(node2,node3,false);
        graph.addEdge(edge);
        graph.addEdge(edge1);
        graph.addEdge(edge2);
        Set<GraphEdge<Integer>> result=graph.getEdges();
        assertTrue(result.size()==3);
    }

    @org.junit.jupiter.api.Test
    void addEdge() {
        AdjacencyMatrixUndirectedGraph<Integer> graph=new AdjacencyMatrixUndirectedGraph();
        GraphNode<Integer> node= new GraphNode<>(77);
        GraphNode<Integer> node1= new GraphNode<>(19);
        GraphNode<Integer> node2= new GraphNode<>(11);
        GraphNode<Integer> node3= new GraphNode<>(17);
        GraphNode<Integer> node4= new GraphNode<>(22);
        graph.addNode(node);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        GraphEdge<Integer> edge=new GraphEdge<>(node,node1,false);
        GraphEdge<Integer> edge1=new GraphEdge<>(node1,node2,false);
        GraphEdge<Integer> edge2=new GraphEdge<>(node1,node2,true);
        GraphEdge<Integer> edge3=null;
        GraphEdge<Integer> edge4=new GraphEdge<>(node2,node4,false);
        assertTrue(graph.addEdge(edge));
        assertTrue(graph.addEdge(edge1));
        assertThrows(IllegalArgumentException.class, () -> graph.addEdge(edge2));
        assertThrows(NullPointerException.class, () -> graph.addEdge(edge3));
        assertThrows(IllegalArgumentException.class, () -> graph.addEdge(edge4));
    }

    @org.junit.jupiter.api.Test
    public final void testAddEdgeNull() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<>();
        GraphNode<String> ns = new GraphNode<>("s");
        g.addNode(ns);
        assertThrows(NullPointerException.class, () ->g.addEdge(null));
    }

    @org.junit.jupiter.api.Test
    public final void testAddEdgeIllegal1() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        // g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<>(ns,
                nu, true);
        assertThrows(IllegalArgumentException.class, () ->g.addEdge(esu));
    }

    @org.junit.jupiter.api.Test
    public final void testAddEdgeIllegal2() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<String>(ns,
                nu, true);
        assertThrows(IllegalArgumentException.class, () ->g.addEdge(esu));
    }


    @org.junit.jupiter.api.Test
    void containsEdge() {
        AdjacencyMatrixUndirectedGraph<Integer> graph=new AdjacencyMatrixUndirectedGraph();
        GraphNode<Integer> node= new GraphNode<>(77);
        GraphNode<Integer> node1= new GraphNode<>(19);
        GraphNode<Integer> node2= new GraphNode<>(11);
        GraphNode<Integer> node3= new GraphNode<>(17);
        graph.addNode(node);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        GraphEdge<Integer> edge=new GraphEdge<>(node,node1,false);
        GraphEdge<Integer> edge1=new GraphEdge<>(node1,node2,false);
        GraphEdge<Integer> edge2=new GraphEdge<>(node2,node3,false);
        assertFalse(graph.containsEdge(edge));
        graph.addEdge(edge);
        graph.addEdge(edge1);
        assertTrue(graph.containsEdge(edge));
        assertTrue(graph.containsEdge(edge1));
        assertFalse(graph.containsEdge(edge2));
    }

    @org.junit.jupiter.api.Test
    void getEdgesOf() {
        AdjacencyMatrixUndirectedGraph<Integer> graph=new AdjacencyMatrixUndirectedGraph();
        GraphNode<Integer> node= new GraphNode<>(77);
        GraphNode<Integer> node1= new GraphNode<>(19);
        GraphNode<Integer> node2= new GraphNode<>(11);
        GraphNode<Integer> node3= new GraphNode<>(17);
        graph.addNode(node);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        GraphEdge<Integer> edge=new GraphEdge<>(node,node1,false);
        GraphEdge<Integer> edge1=new GraphEdge<>(node1,node2,false);
        GraphEdge<Integer> edge2=new GraphEdge<>(node2,node3,false);
        graph.addEdge(edge);
        graph.addEdge(edge1);
        graph.addEdge(edge2);
        Set<GraphEdge<Integer>> result=graph.getEdgesOf(node1);
        assertTrue(result.size()==2);
    }

    @org.junit.jupiter.api.Test
    public final void testGetEdgesGraphNodeOfVNull() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<String>(ns,
                nu, false);
        g.addEdge(esu);
        assertThrows(NullPointerException.class, () ->g.getEdgesOf(null));
    }

    @org.junit.jupiter.api.Test
    public final void testGetEdgesGraphNodeOfVIllegal() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphNode<String> acab = new GraphNode<String>("f");
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, false);
        g.addEdge(esu);
        assertThrows(IllegalArgumentException.class, () ->g.getEdgesOf(acab));
    }*/
  /* AdjacencyMatrixUndirectedGraph<String> adjMatrix = new AdjacencyMatrixUndirectedGraph<>();

    GraphNode<String> n1 = new GraphNode<>("a");
    GraphNode<String> n2 = new GraphNode<>("b");
    GraphNode<String> n3 = new GraphNode<>("c");
    GraphNode<String> n4 = new GraphNode<>("d");
    GraphNode<String> n5 = new GraphNode<>("e");
    GraphNode<String> n6 = new GraphNode<>("f");
    GraphNode<String> n7 = new GraphNode<>("g");

    GraphEdge<String> a1 = new GraphEdge<>(n1, n6, false);
    GraphEdge<String> a2 = new GraphEdge<>(n6, n3, false);
    GraphEdge<String> a3 = new GraphEdge<>(n3, n5, false);
    GraphEdge<String> a4 = new GraphEdge<>(n5, n4, false);
    GraphEdge<String> a5 = new GraphEdge<>(n3, n4, false);
    GraphEdge<String> a6 = new GraphEdge<>(n4, n2, false);
    GraphEdge<String> a7 = new GraphEdge<>(n3, n2, false);
    GraphEdge<String> a8 = new GraphEdge<>(n4, n4, false);

    @Test
    void nodeCount() {
        assertEquals(0, adjMatrix.nodeCount());

        assertTrue(adjMatrix.addNode(n1));
        assertEquals(1, adjMatrix.nodeCount());

        assertTrue(adjMatrix.addNode(n2));
        assertEquals(2, adjMatrix.nodeCount());

        assertTrue(adjMatrix.addNode(n3));
        assertEquals(3, adjMatrix.nodeCount());
    }

    @Test
    void edgeCount() {
        this.adjMatrix.addNode(n1);
        this.adjMatrix.addNode(n3);
        this.adjMatrix.addNode(n6);

        assertEquals(0, adjMatrix.edgeCount());

        assertTrue(adjMatrix.addEdge(a1));
        assertEquals(1, adjMatrix.edgeCount());

        assertTrue(adjMatrix.addEdge(a2));
        assertEquals(2, adjMatrix.edgeCount());
    }

    @Test
    void addNode() {
        assertEquals(0, adjMatrix.nodeCount());

        assertTrue(adjMatrix.addNode(n1));
        assertEquals(1, adjMatrix.nodeCount());

        assertTrue(adjMatrix.addNode(n2));
        assertEquals(2, adjMatrix.nodeCount());

        assertTrue(adjMatrix.addNode(n3));
        assertEquals(3, adjMatrix.nodeCount());

        assertFalse(adjMatrix.addNode(n3));
        assertEquals(3, adjMatrix.nodeCount());

        assertThrows(NullPointerException.class, () -> adjMatrix.addNode(null));
    }

    @Test
    void containsNode() {
        adjMatrix.addNode(n1);
        adjMatrix.addNode(n2);
        adjMatrix.addNode(n3);

        assertTrue(adjMatrix.containsNode(n1));
        assertTrue(adjMatrix.containsNode(n2));
        assertTrue(adjMatrix.containsNode(n3));
        assertFalse(adjMatrix.containsNode(n4));

        assertThrows(NullPointerException.class, () -> adjMatrix.addNode(null));
    }

    @Test
    void getNodeOf() {
        this.adjMatrix.addNode(n1);

        assertEquals(this.adjMatrix.getNodeOf("a"), n1);

        assertNull(this.adjMatrix.getNodeOf("b"));

        assertThrows(NullPointerException.class, () -> this.adjMatrix.getNodeOf(null));
    }

    @Test
    void getNodeIndexOf() {
        this.adjMatrix.addNode(n1);
        this.adjMatrix.addNode(n2);
        this.adjMatrix.addNode(n3);

        assertEquals(this.adjMatrix.getNodeIndexOf("a"), 0);
        assertEquals(this.adjMatrix.getNodeIndexOf("b"), 1);
        assertEquals(this.adjMatrix.getNodeIndexOf("c"), 2);

        assertThrows(NullPointerException.class, () -> this.adjMatrix.getNodeIndexOf(null));

        assertThrows(IllegalArgumentException.class, () -> this.adjMatrix.getNodeIndexOf("d"));
    }

    @Test
    void getNodeAtIndex() {
        this.adjMatrix.addNode(n1);
        this.adjMatrix.addNode(n2);
        this.adjMatrix.addNode(n3);

        assertEquals(this.adjMatrix.getNodeAtIndex(0), n1);
        assertEquals(this.adjMatrix.getNodeAtIndex(1), n2);
        assertEquals(this.adjMatrix.getNodeAtIndex(2), n3);

        assertThrows(IndexOutOfBoundsException.class, () -> this.adjMatrix.getNodeAtIndex(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> this.adjMatrix.getNodeAtIndex(3));
    }

    @Test
    void getAdjacentNodesOf() {
        this.adjMatrix.addNode(n1);
        this.adjMatrix.addNode(n2);
        this.adjMatrix.addNode(n3);
        this.adjMatrix.addNode(n4);
        this.adjMatrix.addNode(n5);
        this.adjMatrix.addNode(n6);

        this.adjMatrix.addEdge(a1);
        this.adjMatrix.addEdge(a2);
        this.adjMatrix.addEdge(a3);
        this.adjMatrix.addEdge(a4);
        this.adjMatrix.addEdge(a5);
        this.adjMatrix.addEdge(a6);
        this.adjMatrix.addEdge(a7);
        this.adjMatrix.addEdge(a8);

        Set<GraphNode<String>> adjNodes = this.adjMatrix.getAdjacentNodesOf(n4);
        assertFalse(adjNodes.contains(n1));
        assertTrue(adjNodes.contains(n2));
        assertTrue(adjNodes.contains(n3));
        assertTrue(adjNodes.contains(n4));
        assertTrue(adjNodes.contains(n5));
        assertFalse(adjNodes.contains(n6));

        assertThrows(IllegalArgumentException.class, () -> this.adjMatrix.getAdjacentNodesOf(n7));
        assertThrows(NullPointerException.class, () -> this.adjMatrix.getAdjacentNodesOf(null));
    }

    @Test
    void getEdges(){
        this.adjMatrix.addNode(n1);
        this.adjMatrix.addNode(n3);
        this.adjMatrix.addNode(n4);
        this.adjMatrix.addNode(n5);
        this.adjMatrix.addNode(n6);

        Set<GraphEdge<String>> edges = new HashSet<>();
        assertEquals(this.adjMatrix.getEdges(), edges);

        edges.add(a1);
        this.adjMatrix.addEdge(a1);
        assertEquals(this.adjMatrix.getEdges(), edges);

        edges.add(a2);
        this.adjMatrix.addEdge(a2);
        assertEquals(this.adjMatrix.getEdges(), edges);

        edges.add(a3);
        assertNotEquals(this.adjMatrix.getEdges(), edges);

        this.adjMatrix.addEdge(a4);
        assertNotEquals(this.adjMatrix.getEdges(), edges);
    }

    @Test
    void addEdge() {
        this.adjMatrix.addNode(n2); //index: 0
        this.adjMatrix.addNode(n3); //index: 1
        this.adjMatrix.addNode(n4); //index: 2
        this.adjMatrix.addNode(n5); //index: 3

        this.adjMatrix.addEdge(a3); //matrix[1][3], matrix[3][1]
        this.adjMatrix.addEdge(a4); //matrix[2][3], matrix[3][2]
        this.adjMatrix.addEdge(a5); //matrix[1][2], matrix[2][1]
        this.adjMatrix.addEdge(a6); //matrix[0][2], matrix[2][0]
        this.adjMatrix.addEdge(a7); //matrix[0][1], matrix[1][0]

        assertEquals(this.adjMatrix.matrix.get(1).get(3), a3);
        assertEquals(this.adjMatrix.matrix.get(3).get(1), a3);

        assertEquals(this.adjMatrix.matrix.get(2).get(3), a4);
        assertEquals(this.adjMatrix.matrix.get(3).get(2), a4);

        assertEquals(this.adjMatrix.matrix.get(1).get(2), a5);
        assertEquals(this.adjMatrix.matrix.get(2).get(1), a5);

        assertEquals(this.adjMatrix.matrix.get(0).get(2), a6);
        assertEquals(this.adjMatrix.matrix.get(2).get(0), a6);

        assertEquals(this.adjMatrix.matrix.get(1).get(0), a7);
        assertEquals(this.adjMatrix.matrix.get(0).get(1), a7);
    }

    @Test
    void containsEdge() {
        this.adjMatrix.addNode(n1);
        this.adjMatrix.addNode(n3);
        this.adjMatrix.addNode(n4);
        this.adjMatrix.addNode(n5);
        this.adjMatrix.addNode(n6);

        this.adjMatrix.addEdge(a1);
        this.adjMatrix.addEdge(a3);
        this.adjMatrix.addEdge(a5);

        assertTrue(this.adjMatrix.containsEdge(a1));
        assertFalse(this.adjMatrix.containsEdge(a2));
        assertTrue(this.adjMatrix.containsEdge(a3));
        assertFalse(this.adjMatrix.containsEdge(a4));
        assertTrue(this.adjMatrix.containsEdge(a5));

        assertThrows(NullPointerException.class, () -> this.adjMatrix.containsEdge(null));
        assertThrows(IllegalArgumentException.class, () -> this.adjMatrix.containsEdge(a6));
    }

    @Test
    void getEdgesOf() {
        this.adjMatrix.addNode(n2);
        this.adjMatrix.addNode(n3);
        this.adjMatrix.addNode(n4);
        this.adjMatrix.addNode(n5);

        this.adjMatrix.addEdge(a4);
        this.adjMatrix.addEdge(a5);
        this.adjMatrix.addEdge(a6);
        this.adjMatrix.addEdge(a8);

        Set<GraphEdge<String>> n4Edges = new HashSet<>();
        n4Edges.add(a4);
        n4Edges.add(a5);
        n4Edges.add(a6);
        n4Edges.add(a8);

        assertEquals(this.adjMatrix.getEdgesOf(n4), n4Edges);
        assertEquals(this.adjMatrix.getEdgesOf(n4).size(), 4);

        assertThrows(NullPointerException.class, () -> this.adjMatrix.getEdgesOf(null));
        assertThrows(IllegalArgumentException.class, () -> this.adjMatrix.getEdgesOf(n6));
    }*/
   @Test
   final void testNodeCount() {
       Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
       assertEquals(0, g.nodeCount());
       g.addNode(new GraphNode<String>("s"));
       assertEquals(1, g.nodeCount());
       g.addNode(new GraphNode<String>("u"));
       assertEquals(2, g.nodeCount());
   }

    @Test
    final void testEdgeCount() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
        assertEquals(0, g.edgeCount());
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        assertEquals(0, g.edgeCount());
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, false, 10.1);
        g.addEdge(esu);
        assertEquals(1, g.edgeCount());
        g.addEdge(esu);
        assertEquals(1, g.edgeCount());
        GraphNode<String> nx = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<String>(ns, nx, false, 5.12);
        g.addEdge(esx);
        assertEquals(2, g.edgeCount());
    }

    @Test
    final void testClear() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
        assertTrue(g.isEmpty());
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        assertFalse(g.isEmpty());
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, false, 10.1);
        g.addEdge(esu);
        assertFalse(g.isEmpty());
        g.clear();
        assertTrue(g.isEmpty());
    }

    @Test
    final void testIsDirected() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
        assertFalse(g.isDirected());
    }

    @Test
    final void testGetNodes() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
        Set<GraphNode<String>> nodes = g.getNodes();
        assertTrue(nodes.isEmpty());
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        nodes = g.getNodes();
        Set<GraphNode<String>> testNodes = new HashSet<GraphNode<String>>();
        GraphNode<String> nsTest = new GraphNode<String>("s");
        GraphNode<String> nuTest = new GraphNode<String>("u");
        testNodes.add(nuTest);
        testNodes.add(nsTest);
        assertTrue(nodes.equals(testNodes));
        GraphNode<String> nuTestBis = new GraphNode<String>("u");
        g.addNode(nuTestBis);
        nodes = g.getNodes();
        assertTrue(nodes.equals(testNodes));
    }

    @Test
    final void testAddNode() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
        assertThrows(NullPointerException.class, () -> g.addNode(null));
        GraphNode<String> ns = new GraphNode<String>("s");
        GraphNode<String> nsTest = new GraphNode<String>("s");
        assertFalse(g.containsNode(ns));
        g.addNode(ns);
        assertTrue(g.containsNode(nsTest));
        GraphNode<String> nu = new GraphNode<String>("u");
        GraphNode<String> nuTest = new GraphNode<String>("u");
        g.addNode(nu);
        assertTrue(g.containsNode(nuTest));
    }

    @Test
    final void testContainsNode() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
        assertThrows(NullPointerException.class, () -> g.containsNode(null));
        GraphNode<String> ns = new GraphNode<String>("s");
        GraphNode<String> nsTest = new GraphNode<String>("s");
        assertFalse(g.containsNode(nsTest));
        g.addNode(ns);
        assertTrue(g.containsNode(nsTest));
    }

    @Test
    final void testGetNodeOf() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
        assertThrows(NullPointerException.class, () -> g.getNodeOf(null));
        GraphNode<String> ns = new GraphNode<String>("s");
        ns.setColor(1);
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphNode<String> node = g.getNodeOf("s");
        assertEquals("s", node.getLabel());
        assertEquals(1, node.getColor());
        node = g.getNodeOf("u");
        assertEquals("u", node.getLabel());
        assertEquals(0, node.getColor());
        assertTrue(g.getNodeOf("p") == null);
    }

    @Test
    final void testGetNodeIndexOf() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
        assertThrows(NullPointerException.class, () -> g.getNodeIndexOf(null));
        GraphNode<String> ns = new GraphNode<String>("s");
        ns.setColor(1);
        g.addNode(ns);
        assertTrue(g.getNodeIndexOf("s") == 0);
        assertThrows(IllegalArgumentException.class,
                () -> g.getNodeIndexOf("u"));
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        assertTrue(g.getNodeIndexOf("u") == 1);
        assertTrue(g.getNodeIndexOf("s") == 0);
    }

    @Test
    final void testGetNodeAtIndex() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
        assertThrows(IndexOutOfBoundsException.class,
                () -> g.getNodeAtIndex(0));
        GraphNode<String> ns = new GraphNode<String>("s");
        ns.setColor(1);
        g.addNode(ns);
        assertThrows(IndexOutOfBoundsException.class,
                () -> g.getNodeAtIndex(1));
        GraphNode<String> nsTest = new GraphNode<String>("s");
        assertTrue(nsTest.equals(g.getNodeAtIndex(0)));
        assertTrue(g.getNodeAtIndex(0).getColor() == 1);
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        assertThrows(IndexOutOfBoundsException.class,
                () -> g.getNodeAtIndex(2));
        GraphNode<String> nuTest = new GraphNode<String>("u");
        assertTrue(nuTest.equals(g.getNodeAtIndex(1)));
    }

    @Test
    final void testGetAdjacentNodesOf() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
        assertThrows(NullPointerException.class,
                () -> g.getAdjacentNodesOf(null));
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        Set<GraphNode<String>> adjNodes = new HashSet<GraphNode<String>>();
        assertTrue(g.getAdjacentNodesOf(ns).equals(adjNodes));
        GraphNode<String> nsTest = new GraphNode<String>("s");
        GraphNode<String> nu = new GraphNode<String>("u");
        GraphNode<String> nuTest = new GraphNode<String>("u");
        assertThrows(IllegalArgumentException.class,
                () -> g.getAdjacentNodesOf(nu));
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, false, 10.1);
        g.addEdge(esu);
        GraphNode<String> nx = new GraphNode<String>("x");
        GraphNode<String> nxTest = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<String>(ns, nx, false, 5.12);
        g.addEdge(esx);
        adjNodes.add(nxTest);
        adjNodes.add(nuTest);
        assertTrue(g.getAdjacentNodesOf(nsTest).equals(adjNodes));
        adjNodes.clear();
        adjNodes.add(nsTest);
        assertTrue(g.getAdjacentNodesOf(nxTest).equals(adjNodes));
        assertTrue(g.getAdjacentNodesOf(nuTest).equals(adjNodes));
        GraphNode<String> np = new GraphNode<String>("p");
        GraphNode<String> npTest = new GraphNode<String>("p");
        g.addNode(np);
        adjNodes.clear();
        assertTrue(g.getAdjacentNodesOf(npTest).equals(adjNodes));
    }

    @Test
    final void testGetEdges() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        Set<GraphEdge<String>> edgesTest = new HashSet<GraphEdge<String>>();
        assertTrue(g.getEdges().equals(edgesTest));
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, false);
        g.addEdge(esu);
        GraphEdge<String> esuTest = new GraphEdge<String>(nu, ns, false);
        edgesTest.add(esuTest);
        assertTrue(g.getEdges().equals(edgesTest));
        GraphNode<String> nx = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<String>(ns, nx, false, 5.12);
        g.addEdge(esx);
        GraphEdge<String> eux = new GraphEdge<String>(nu, nx, false, 2.05);
        g.addEdge(eux);
        GraphEdge<String> exu = new GraphEdge<String>(nx, nu, false, 3.04);
        g.addEdge(exu);
        edgesTest.add(eux);
        edgesTest.add(esx);
        edgesTest.add(exu);
        assertTrue(g.getEdges().equals(edgesTest));
        g.clear();
        edgesTest.clear();
        assertTrue(g.getEdges().equals(edgesTest));
    }

    @Test
    final void testAddEdge() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
        assertThrows(NullPointerException.class, () -> g.addEdge(null));
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        assertThrows(IllegalArgumentException.class,
                () -> g.addEdge(new GraphEdge<String>(ns, nu, false)));
        assertThrows(IllegalArgumentException.class,
                () -> g.addEdge(new GraphEdge<String>(nu, ns, false)));
        g.addNode(nu);
        assertThrows(IllegalArgumentException.class,
                () -> g.addEdge(new GraphEdge<String>(ns, nu, true)));
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, false);
        assertTrue(g.addEdge(esu));
        assertTrue(g.containsEdge(new GraphEdge<String>(ns, nu, false)));
        assertFalse(g.addEdge(new GraphEdge<String>(nu, ns, false, 6.0)));
    }

    @Test
    final void testContainsEdge() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
        assertThrows(NullPointerException.class,
                () -> g.containsEdge(null));
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        assertThrows(IllegalArgumentException.class,
                () -> g.containsEdge(new GraphEdge<String>(ns, nu, false)));
        assertThrows(IllegalArgumentException.class,
                () -> g.containsEdge(new GraphEdge<String>(nu, ns, false)));
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, false);
        assertFalse(g.containsEdge(new GraphEdge<String>(ns, nu, false)));
        g.addEdge(esu);
        assertTrue(g.containsEdge(new GraphEdge<String>(ns, nu, false)));
    }

    @Test
    final void testGetEdgesOf() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        Set<GraphEdge<String>> edgesTest = new HashSet<GraphEdge<String>>();
        assertThrows(NullPointerException.class,
                () -> g.getEdgesOf(null));
        GraphNode<String> nu = new GraphNode<String>("u");
        assertThrows(IllegalArgumentException.class,
                () -> g.getEdgesOf(nu));
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, false);
        g.addEdge(esu);
        GraphNode<String> nx = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<String>(ns, nx, false, 5.12);
        g.addEdge(esx);
        GraphEdge<String> eux = new GraphEdge<String>(nu, nx, false, 2.05);
        g.addEdge(eux);
        GraphNode<String> ny = new GraphNode<String>("y");
        g.addNode(ny);
        GraphEdge<String> exy = new GraphEdge<String>(nx, ny, false, 2.0);
        g.addEdge(exy);
        GraphEdge<String> eys = new GraphEdge<String>(ny, ns, false, 7.03);
        g.addEdge(eys);
        GraphNode<String> nw = new GraphNode<String>("w");
        g.addNode(nw);
        edgesTest.add(esu);
        edgesTest.add(esx);
        edgesTest.add(eys);
        assertTrue(g.getEdgesOf(ns).equals(edgesTest));
        edgesTest.clear();
        edgesTest.add(eux);
        edgesTest.add(exy);
        edgesTest.add(new GraphEdge<String>(nx, ns, false));
        assertTrue(g.getEdgesOf(nx).equals(edgesTest));
        edgesTest.clear();
        assertTrue(g.getEdgesOf(nw).equals(edgesTest));
    }

    @Test
    final void testAdjacencyMatrixUndirectedGraph() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
        assertTrue(g.isEmpty());
    }

    @Test
    final void testSize() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
        assertTrue(g.size() == 0);
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        assertTrue(g.size() == 1);
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        assertTrue(g.size() == 2);
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, false);
        g.addEdge(esu);
        assertTrue(g.size() == 3);
        GraphNode<String> nx = new GraphNode<String>("x");
        g.addNode(nx);
        assertTrue(g.size() == 4);
        GraphEdge<String> esx = new GraphEdge<String>(ns, nx, false, 5.12);
        g.addEdge(esx);
        assertTrue(g.size() == 5);
        GraphEdge<String> eux = new GraphEdge<String>(nu, nx, false, 2.05);
        g.addEdge(eux);
        assertTrue(g.size() == 6);
        g.addEdge(new GraphEdge<String>(nx, nu, false, 2.05));
        assertTrue(g.size() == 6);
        g.clear();
        assertTrue(g.size() == 0);
    }

    @Test
    final void testIsEmpty() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
        assertTrue(g.isEmpty());
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        assertFalse(g.isEmpty());
        g.clear();
        assertTrue(g.isEmpty());
    }

    @Test
    final void testGetDegreeOf() {
        Graph<String> g = new AdjacencyMatrixUndirectedGraph<String>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        assertTrue(g.getDegreeOf(ns) == 0);
        assertThrows(NullPointerException.class,
                () -> g.getDegreeOf(null));
        GraphNode<String> nu = new GraphNode<String>("u");
        assertThrows(IllegalArgumentException.class,
                () -> g.getDegreeOf(nu));
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, false);
        g.addEdge(esu);
        GraphNode<String> nx = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<String>(ns, nx, false, 5.12);
        g.addEdge(esx);
        GraphEdge<String> exu = new GraphEdge<String>(nx, nu, false, 3.04);
        g.addEdge(exu);
        GraphNode<String> ny = new GraphNode<String>("y");
        g.addNode(ny);
        GraphEdge<String> exy = new GraphEdge<String>(nx, ny, false, 2.0);
        g.addEdge(exy);
        GraphEdge<String> eys = new GraphEdge<String>(ny, ns, false, 7.03);
        g.addEdge(eys);
        GraphNode<String> nw = new GraphNode<String>("w");
        g.addNode(nw);
        GraphEdge<String> euw = new GraphEdge<String>(nu, nw, false, 7.07);
        g.addEdge(euw);
        GraphNode<String> nz = new GraphNode<String>("z");
        g.addNode(nz);
        GraphEdge<String> ezy = new GraphEdge<String>(nz, ny, false, 7.107);
        g.addEdge(ezy);
        assertTrue(g.getDegreeOf(ns)==3);
        assertTrue(g.getDegreeOf(nu)==3);
        assertTrue(g.getDegreeOf(nx)==3);
        assertTrue(g.getDegreeOf(ny)==3);
        assertTrue(g.getDegreeOf(nz)==1);
        assertTrue(g.getDegreeOf(nw)==1);
    }

}