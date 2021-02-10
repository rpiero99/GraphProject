package it.unicam.cs.asdl2021.mp2;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/*
    @author - Riccardo Pierini 105131
    @project - asdl2021-codice-mp2-traccia
 */
class MapAdjacentListDirectedGraphTest {

  /*  @org.junit.jupiter.api.Test
    public final void testNodeCount() {
        Graph<String> g = new MapAdjacentListDirectedGraph<>();
        assertEquals(0, g.nodeCount());
        g.addNode(new GraphNode<String>("s"));
        assertEquals(1, g.nodeCount());
        g.addNode(new GraphNode<String>("u"));
        assertEquals(2, g.nodeCount());
    }

    @org.junit.jupiter.api.Test
    public final void testEdgeCount() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        assertEquals(0, g.edgeCount());
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        assertEquals(0, g.edgeCount());
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<>(ns,
                nu,  true);
        g.addEdge(esu);
        assertEquals(1, g.edgeCount());
        g.addEdge(esu);
        assertEquals(1, g.edgeCount());
        GraphNode<String> nx = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<>(ns,
                nx,  true);
        g.addEdge(esx);
        assertEquals(2, g.edgeCount());
    }

    @org.junit.jupiter.api.Test
    public final void testSize() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        assertEquals(0, g.size());
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        assertEquals(1, g.size());
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<>(ns,
                nu, true, 10.1);
        g.addEdge(esu);
        assertEquals(3, g.size());
        g.addEdge(esu);
        assertEquals(3, g.size());
        GraphNode<String> nx = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<>(ns,
                nx, true);
        g.addEdge(esx);
        assertEquals(5, g.size());
    }

    @org.junit.jupiter.api.Test
    public final void testIsEmpty() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        assertEquals(true, g.isEmpty());
        g.addNode(new GraphNode<String>("s"));
        assertEquals(false, g.isEmpty());
    }

    @org.junit.jupiter.api.Test
    public final void testClear() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<>(ns,
                nu, true);
        g.addEdge(esu);
        //g.addEdge(esu);
        GraphNode<String> nx = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<>(ns,
                nx, true, 5.12);
        g.addEdge(esx);
        assertEquals(false, g.isEmpty());
        g.clear();
        assertEquals(true, g.isEmpty());
    }

    @org.junit.jupiter.api.Test
    public final void testIsDirected() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        assertEquals(true, g.isDirected());
    }

    @org.junit.jupiter.api.Test
    public final void testGetNodes() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        Set<GraphNode<String>> nodes = g.getNodes();
        assertEquals(true, nodes.isEmpty());
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
        assertEquals(true, nodes.equals(testNodes));
        GraphNode<String> nuTestBis = new GraphNode<String>("u");
        g.addNode(nuTestBis);
        nodes = g.getNodes();
        assertEquals(true, nodes.equals(testNodes));
    }

    @org.junit.jupiter.api.Test
    public final void testAddNode() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        GraphNode<String> nsTest = new GraphNode<String>("s");
        assertEquals(false, g.containsNode(ns));
        g.addNode(ns);
        assertEquals(true, g.containsNode(nsTest));
        GraphNode<String> nu = new GraphNode<String>("u");
        GraphNode<String> nuTest = new GraphNode<String>("u");
        g.addNode(nu);
        assertEquals(true, g.containsNode(nuTest));
    }

    @org.junit.jupiter.api.Test
    public final void testAddNodeNull() {
        Graph<String> g = new MapAdjacentListDirectedGraph<>();
        assertThrows(NullPointerException.class, () ->g.addNode(null));
    }

    @org.junit.jupiter.api.Test
    public final void testContainsNodeNull() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        assertThrows(NullPointerException.class, () ->g.containsNode(null));
    }

    @org.junit.jupiter.api.Test
    public final void testContainsNode() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        GraphNode<String> nsTest = new GraphNode<String>("s");
        assertEquals(false, g.containsNode(nsTest));
        g.addNode(ns);
        assertEquals(true, g.containsNode(nsTest));
    }

    @org.junit.jupiter.api.Test
    public final void testGetNodeIndexNull() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        assertThrows(NullPointerException.class, () ->g.getNodeIndexOf(null));
    }

    @org.junit.jupiter.api.Test
    public final void testGetAdjacentNodeNull() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        assertThrows(NullPointerException.class, () ->g.getAdjacentNodesOf(null));
    }

    @org.junit.jupiter.api.Test
    public final void testGetAdjacentNodesIllegal() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        assertThrows(IllegalArgumentException.class, () ->g.getAdjacentNodesOf(nu));
    }

    @org.junit.jupiter.api.Test
    public final void testGetAdjacentNodes() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        Set<GraphNode<String>> adjNodes = new HashSet<GraphNode<String>>();
        assertEquals(true, g.getAdjacentNodesOf(ns).equals(adjNodes));
        GraphNode<String> nsTest = new GraphNode<String>("s");
        GraphNode<String> nu = new GraphNode<String>("u");
        GraphNode<String> nuTest = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<>(ns,
                nu,  true, 10.1);
        g.addEdge(esu);
        GraphNode<String> nx = new GraphNode<String>("x");
        GraphNode<String> nxTest = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<>(ns,
                nx, true, 5.12);
        g.addEdge(esx);
        adjNodes.add(nxTest);
        adjNodes.add(nuTest);
        assertEquals(true, g.getAdjacentNodesOf(nsTest).equals(adjNodes));
    }

    @org.junit.jupiter.api.Test
    public final void testgetPredecessorNodesOfNull() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        assertThrows(NullPointerException.class, () ->g.getPredecessorNodesOf(null));
    }

    @org.junit.jupiter.api.Test
    public final void testgetPredecessorNodesOfIllegal() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        assertThrows(IllegalArgumentException.class, () ->g.getPredecessorNodesOf(nu));
    }

    @org.junit.jupiter.api.Test
    public final void testgetPredecessorNodesOf() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        Set<GraphNode<String>> predNodes = new HashSet<GraphNode<String>>();
        assertEquals(true, g.getPredecessorNodesOf(ns).equals(predNodes));
        GraphNode<String> nsTest = new GraphNode<String>("s");
        GraphNode<String> nu = new GraphNode<String>("u");
        GraphNode<String> nuTest = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<>(ns,
                nu, true, 10.1);
        g.addEdge(esu);
        GraphNode<String> nx = new GraphNode<String>("x");
        GraphNode<String> nxTest = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<>(ns,
                nx, true, 5.12);
        g.addEdge(esx);
        GraphEdge<String> eux = new GraphEdge<>(nu,
                nx, true, 2.05);
        g.addEdge(eux);
        GraphEdge<String> exu = new GraphEdge<>(nx,
                nu, true, 3.04);
        g.addEdge(exu);
        assertEquals(true, g.getPredecessorNodesOf(ns).equals(predNodes));
        GraphNode<String> ny = new GraphNode<String>("y");
        GraphNode<String> nyTest = new GraphNode<String>("y");
        g.addNode(ny);
        GraphEdge<String> exy = new GraphEdge<>(nx,
                ny,  true, 2.0);
        g.addEdge(exy);
        GraphEdge<String> eys = new GraphEdge<>(ny,
                ns,  true, 7.03);
        g.addEdge(eys);
        predNodes.add(nyTest);
        assertEquals(true, g.getPredecessorNodesOf(nsTest).equals(predNodes));
        predNodes.clear();
        predNodes.add(nsTest);
        predNodes.add(nxTest);
        assertEquals(true, g.getPredecessorNodesOf(nuTest).equals(predNodes));
        predNodes.clear();
        predNodes.add(nsTest);
        predNodes.add(nuTest);
        assertEquals(true, g.getPredecessorNodesOf(nxTest).equals(predNodes));
        predNodes.clear();
        predNodes.add(nxTest);
        assertEquals(true, g.getPredecessorNodesOf(nyTest).equals(predNodes));
    }

    @org.junit.jupiter.api.Test
    public final void testGetEdges() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        Set<GraphEdge<String>> edgesTest = new HashSet<>();
        assertEquals(true, g.getEdges().equals(edgesTest));
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<>(ns,
                nu, true, 10.1);
        g.addEdge(esu);
        edgesTest.add(esu);
        assertEquals(true, g.getEdges().equals(edgesTest));
        GraphNode<String> nx = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<>(ns,
                nx, true, 5.12);
        g.addEdge(esx);
        GraphEdge<String> eux = new GraphEdge<>(nu,
                nx, true, 2.05);
        g.addEdge(eux);
        GraphEdge<String> exu = new GraphEdge<>(nx,
                nu, true, 3.04);
        g.addEdge(exu);
        edgesTest.add(eux);
        edgesTest.add(esx);
        edgesTest.add(exu);
        assertEquals(true, g.getEdges().equals(edgesTest));
        GraphNode<String> ny = new GraphNode<>("y");
        g.addNode(ny);
        GraphEdge<String> exy = new GraphEdge<>(nx,
                ny, true, 2.0);
        g.addEdge(exy);
        GraphEdge<String> eys = new GraphEdge<>(ny,
                ns, true, 7.03);
        g.addEdge(eys);
        edgesTest.add(eys);
        edgesTest.add(exy);
        assertEquals(true, g.getEdges().equals(edgesTest));
    }

    @org.junit.jupiter.api.Test
    public final void testAddEdgeNull() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        assertThrows(NullPointerException.class, () ->g.addEdge(null));
    }

    @org.junit.jupiter.api.Test
    public final void testAddEdgeIllegal1() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        // g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<>(ns,
                nu, true, 10.1);
        assertThrows(IllegalArgumentException.class, () ->g.addEdge(esu));
    }

    @org.junit.jupiter.api.Test
    public final void testAddEdgeIllegal2() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<>(ns,
                nu,false, 10.1);
        assertThrows(IllegalArgumentException.class, () ->g.addEdge(esu));
    }

    @org.junit.jupiter.api.Test
    public final void testAddEdge() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        Set<GraphEdge<String>> edgesTest = new HashSet<>();
        Set<GraphEdge<String>> edges = g.getEdges();
        assertEquals(true, edges.equals(edgesTest));
        GraphEdge<String> esu = new GraphEdge<>(ns,
                nu,  true, 10.1);
        g.addEdge(esu);
        GraphEdge<String> esuTest = new GraphEdge<>(
                ns, nu, true, 10.1);
        assertEquals(true, g.containsEdge(esuTest));
        edgesTest.add(esuTest);
        edges = g.getEdges();
        assertEquals(true, edges.equals(edgesTest));
    }

    @org.junit.jupiter.api.Test
    public final void testContainsEdgeNull() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<>(ns,
                nu,true, 10.1);
        GraphEdge<String> esuTest = new GraphEdge<>(
                ns, nu, true, 10.1);
        assertThrows(NullPointerException.class, () ->g.containsEdge(null));
        g.addEdge(esu);
        assertEquals(true, g.containsEdge(esuTest));
    }

    @org.junit.jupiter.api.Test
    public final void testContainsEdgeIllegal() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        // g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<>(ns,
                nu, true, 10.1);
        assertThrows(IllegalArgumentException.class, () -> g.containsEdge(esu));
    }

    @org.junit.jupiter.api.Test
    public final void testContainsEdge() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<>(ns,
                nu, true, 10.1);
        GraphEdge<String> esuTest = new GraphEdge<>(
                ns, nu, true, 10.1);
        assertEquals(false, g.containsEdge(esuTest));
        g.addEdge(esu);
        assertEquals(true, g.containsEdge(esuTest));
    }

    @org.junit.jupiter.api.Test
    public final void testGetEdgesGraphNodeOfVNull() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<>(ns,
                nu, true, 10.1);
        g.addEdge(esu);
        assertThrows(NullPointerException.class, () ->g.getEdgesOf(null));
    }

    @org.junit.jupiter.api.Test
    public final void testGetEdgesGraphNodeOfVIllegal() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphNode<String> naz = new GraphNode<String>("az");
        //g.addNode(naz);
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, true, 10.1);
        g.addEdge(esu);
        assertThrows(IllegalArgumentException.class, () ->g.getEdgesOf(naz));
    }

    @org.junit.jupiter.api.Test
    public final void testGetEdgesGraphNodeOfV() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        Set<GraphEdge<String>> edgesTest = new HashSet<>();
        Set<GraphEdge<String>> edges = g.getEdgesOf(ns);
        assertEquals(true, edges.equals(edgesTest));
        GraphEdge<String> esu = new GraphEdge<>(ns,
                nu, true, 10.1);
        g.addEdge(esu);
        GraphEdge<String> esuTest = new GraphEdge<>(
                ns, nu, true, 10.1);
        edgesTest.add(esuTest);
        edges = g.getEdgesOf(ns);
        assertEquals(true, edges.equals(edgesTest));
        GraphNode<String> nx = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<>(ns,
                nx, true, 5.12);
        g.addEdge(esx);
        GraphEdge<String> esxTest = new GraphEdge<>(
                ns, nx,true, 5.12);
        edgesTest.add(esxTest);
        edges = g.getEdgesOf(ns);
        assertEquals(true, edges.equals(edgesTest));
    }

    @org.junit.jupiter.api.Test
    public final void testGetIngoingEdgesNull() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<>(ns,
                nu, true, 10.1);
        g.addEdge(esu);
        assertThrows(NullPointerException.class, () ->g.getIngoingEdgesOf(null));
    }

    @org.junit.jupiter.api.Test
    public final void testGetIngoingEdgesIllegal() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        // g.addNode(nu);
        assertThrows(IllegalArgumentException.class, () ->g.getIngoingEdgesOf(nu));
    }

    @org.junit.jupiter.api.Test
    public final void testGetIngoingEdges() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        Set<GraphEdge<String>> ingoingEdgesTest = new HashSet<>();
        assertEquals(true, g.getIngoingEdgesOf(ns).equals(ingoingEdgesTest));
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<>(ns,
                nu, true, 10.1);
        GraphEdge<String> esuTest = new GraphEdge<>(
                ns, nu, true, 10.1);
        g.addEdge(esu);
        GraphNode<String> nx = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<>(ns,
                nx,  true, 5.12);
        GraphEdge<String> esxTest = new GraphEdge<>(
                ns, nx, true, 5.12);
        g.addEdge(esx);
        GraphEdge<String> eux = new GraphEdge<>(nu,
                nx, true, 2.05);
        GraphEdge<String> euxTest = new GraphEdge<>(
                nu, nx,  true, 2.05);
        g.addEdge(eux);
        GraphEdge<String> exu = new GraphEdge<>(nx,
                nu,  true, 3.04);
        GraphEdge<String> exuTest = new GraphEdge<>(
                nx, nu,  true, 3.04);
        g.addEdge(exu);
        GraphNode<String> ny = new GraphNode<String>("y");
        g.addNode(ny);
        GraphEdge<String> exy = new GraphEdge<>(nx,
                ny, true, 2.0);
        GraphEdge<String> exyTest = new GraphEdge<>(
                nx, ny,  true, 2.0);
        g.addEdge(exy);
        GraphEdge<String> eys = new GraphEdge<>(ny,
                ns,  true, 7.03);
        GraphEdge<String> eysTest = new GraphEdge<>(
                ny, ns,  true, 7.03);
        g.addEdge(eys);
        ingoingEdgesTest.add(eysTest);
        assertEquals(true, g.getIngoingEdgesOf(ns).equals(ingoingEdgesTest));
        ingoingEdgesTest.clear();
        ingoingEdgesTest.add(exyTest);
        assertEquals(true, g.getIngoingEdgesOf(ny).equals(ingoingEdgesTest));
        ingoingEdgesTest.clear();
        ingoingEdgesTest.add(esxTest);
        ingoingEdgesTest.add(euxTest);
        assertEquals(true, g.getIngoingEdgesOf(nx).equals(ingoingEdgesTest));
        ingoingEdgesTest.clear();
        ingoingEdgesTest.add(esuTest);
        ingoingEdgesTest.add(exuTest);
        assertEquals(true, g.getIngoingEdgesOf(nu).equals(ingoingEdgesTest));
    }

    @org.junit.jupiter.api.Test
    public final void testGetNodeNull() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        assertThrows(NullPointerException.class, () ->g.getNodeOf(null));
    }

    @org.junit.jupiter.api.Test
    public final void testGetNode() {
            Graph<String> g = new MapAdjacentListDirectedGraph<>();
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

    }*/
  @Test
  final void testNodeCount() {
      Graph<String> g = new MapAdjacentListDirectedGraph<String>();
      assertEquals(0, g.nodeCount());
      g.addNode(new GraphNode<String>("s"));
      assertEquals(1, g.nodeCount());
      g.addNode(new GraphNode<String>("u"));
      assertEquals(2, g.nodeCount());
  }

    @Test
    final void testEdgeCount() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        assertEquals(0, g.edgeCount());
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        assertEquals(0, g.edgeCount());
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, true, 10.1);
        g.addEdge(esu);
        assertEquals(1, g.edgeCount());
        g.addEdge(esu);
        assertEquals(1, g.edgeCount());
        GraphNode<String> nx = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<String>(ns, nx, true, 5.12);
        g.addEdge(esx);
        assertEquals(2, g.edgeCount());
    }

    @Test
    final void testClear() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        assertTrue(g.isEmpty());
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        assertFalse(g.isEmpty());
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, true, 10.1);
        g.addEdge(esu);
        assertFalse(g.isEmpty());
        g.clear();
        assertTrue(g.isEmpty());
    }

    @Test
    final void testIsDirected() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        assertTrue(g.isDirected());
    }

    @Test
    final void testGetNodes() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
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
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
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
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        assertThrows(NullPointerException.class, () -> g.containsNode(null));
        GraphNode<String> ns = new GraphNode<String>("s");
        GraphNode<String> nsTest = new GraphNode<String>("s");
        assertFalse(g.containsNode(nsTest));
        g.addNode(ns);
        assertTrue(g.containsNode(nsTest));
    }

    @Test
    final void testGetNodeOf() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
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
    final void testGetAdjacentNodesOf() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
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
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, true, 10.1);
        g.addEdge(esu);
        GraphNode<String> nx = new GraphNode<String>("x");
        GraphNode<String> nxTest = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<String>(ns, nx, true, 5.12);
        g.addEdge(esx);
        adjNodes.add(nxTest);
        adjNodes.add(nuTest);
        assertTrue(g.getAdjacentNodesOf(nsTest).equals(adjNodes));
    }

    @Test
    final void testGetPredecessorNodesOf() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        assertThrows(NullPointerException.class,
                () -> g.getPredecessorNodesOf(null));
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        Set<GraphNode<String>> predNodes = new HashSet<GraphNode<String>>();
        assertTrue(g.getPredecessorNodesOf(ns).equals(predNodes));
        GraphNode<String> nsTest = new GraphNode<String>("s");
        GraphNode<String> nu = new GraphNode<String>("u");
        GraphNode<String> nuTest = new GraphNode<String>("u");
        assertThrows(IllegalArgumentException.class,
                () -> g.getPredecessorNodesOf(nu));
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, true);
        g.addEdge(esu);
        GraphNode<String> nx = new GraphNode<String>("x");
        GraphNode<String> nxTest = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<String>(ns, nx, true, 5.12);
        g.addEdge(esx);
        GraphEdge<String> eux = new GraphEdge<String>(nu, nx, true, 2.05);
        g.addEdge(eux);
        GraphEdge<String> exu = new GraphEdge<String>(nx, nu, true, 3.04);
        g.addEdge(exu);
        assertTrue(g.getPredecessorNodesOf(ns).equals(predNodes));
        GraphNode<String> ny = new GraphNode<String>("y");
        GraphNode<String> nyTest = new GraphNode<String>("y");
        g.addNode(ny);
        GraphEdge<String> exy = new GraphEdge<String>(nx, ny, true, 2.0);
        g.addEdge(exy);
        GraphEdge<String> eys = new GraphEdge<String>(ny, ns, true, 7.03);
        g.addEdge(eys);
        predNodes.add(nyTest);
        assertTrue(g.getPredecessorNodesOf(nsTest).equals(predNodes));
        predNodes.clear();
        predNodes.add(nsTest);
        predNodes.add(nxTest);
        assertTrue(g.getPredecessorNodesOf(nuTest).equals(predNodes));
        predNodes.clear();
        predNodes.add(nsTest);
        predNodes.add(nuTest);
        assertTrue(g.getPredecessorNodesOf(nxTest).equals(predNodes));
        predNodes.clear();
        predNodes.add(nxTest);
        assertTrue(g.getPredecessorNodesOf(nyTest).equals(predNodes));
    }

    @Test
    final void testGetEdges() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        Set<GraphEdge<String>> edgesTest = new HashSet<GraphEdge<String>>();
        assertTrue(g.getEdges().equals(edgesTest));
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, true);
        g.addEdge(esu);
        edgesTest.add(esu);
        assertTrue(g.getEdges().equals(edgesTest));
        GraphNode<String> nx = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<String>(ns, nx, true, 5.12);
        g.addEdge(esx);
        GraphEdge<String> eux = new GraphEdge<String>(nu, nx, true, 2.05);
        g.addEdge(eux);
        GraphEdge<String> exu = new GraphEdge<String>(nx, nu, true, 3.04);
        g.addEdge(exu);
        edgesTest.add(eux);
        edgesTest.add(esx);
        edgesTest.add(exu);
        assertTrue(g.getEdges().equals(edgesTest));
        GraphNode<String> ny = new GraphNode<String>("y");
        g.addNode(ny);
        GraphEdge<String> exy = new GraphEdge<String>(nx, ny, true, 2.0);
        g.addEdge(exy);
        GraphEdge<String> eys = new GraphEdge<String>(ny, ns, true, 7.03);
        g.addEdge(eys);
        edgesTest.add(eys);
        edgesTest.add(exy);
        assertTrue(g.getEdges().equals(edgesTest));
        g.clear();
        edgesTest.clear();
        assertTrue(g.getEdges().equals(edgesTest));
    }

    @Test
    final void testAddEdge() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        assertThrows(NullPointerException.class,
                () -> g.addEdge(null));
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        assertThrows(IllegalArgumentException.class,
                () -> g.addEdge(new GraphEdge<String>(ns, nu, true)));
        assertThrows(IllegalArgumentException.class,
                () -> g.addEdge(new GraphEdge<String>(nu, ns, true)));
        g.addNode(nu);
        assertThrows(IllegalArgumentException.class,
                () -> g.addEdge(new GraphEdge<String>(ns, nu, false)));
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, true);
        g.addEdge(esu);
        assertTrue(g.containsEdge(new GraphEdge<String>(ns, nu, true)));
    }

    @Test
    final void testContainsEdge() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        assertThrows(NullPointerException.class,
                () -> g.containsEdge(null));
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        GraphNode<String> nu = new GraphNode<String>("u");
        assertThrows(IllegalArgumentException.class,
                () -> g.containsEdge(new GraphEdge<String>(ns, nu, true)));
        assertThrows(IllegalArgumentException.class,
                () -> g.containsEdge(new GraphEdge<String>(nu, ns, true)));
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, true);
        assertFalse(g.containsEdge(new GraphEdge<String>(ns, nu, true)));
        g.addEdge(esu);
        assertTrue(g.containsEdge(new GraphEdge<String>(ns, nu, true)));
    }

    @Test
    final void testGetEdgesOf() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        Set<GraphEdge<String>> edgesTest = new HashSet<GraphEdge<String>>();
        assertThrows(NullPointerException.class,
                () -> g.getEdgesOf(null));
        GraphNode<String> nu = new GraphNode<String>("u");
        assertThrows(IllegalArgumentException.class,
                () -> g.getEdgesOf(nu));
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, true);
        g.addEdge(esu);
        GraphNode<String> nx = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<String>(ns, nx, true, 5.12);
        g.addEdge(esx);
        GraphEdge<String> eux = new GraphEdge<String>(nu, nx, true, 2.05);
        g.addEdge(eux);
        GraphEdge<String> exu = new GraphEdge<String>(nx, nu, true, 3.04);
        g.addEdge(exu);
        GraphNode<String> ny = new GraphNode<String>("y");
        g.addNode(ny);
        GraphEdge<String> exy = new GraphEdge<String>(nx, ny, true, 2.0);
        g.addEdge(exy);
        GraphEdge<String> eys = new GraphEdge<String>(ny, ns, true, 7.03);
        g.addEdge(eys);
        GraphNode<String> nw = new GraphNode<String>("w");
        g.addNode(nw);
        GraphEdge<String> euw = new GraphEdge<String>(nu, nw, true, 7.07);
        g.addEdge(euw);
        edgesTest.add(esu);
        edgesTest.add(esx);
        assertTrue(g.getEdgesOf(ns).equals(edgesTest));
        edgesTest.clear();
        edgesTest.add(exu);
        edgesTest.add(exy);
        assertTrue(g.getEdgesOf(nx).equals(edgesTest));
        edgesTest.clear();
        edgesTest.add(eys);
        assertTrue(g.getEdgesOf(ny).equals(edgesTest));
        edgesTest.clear();
        assertTrue(g.getEdgesOf(nw).equals(edgesTest));
    }

    @Test
    final void testGetIngoingEdgesOf() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        Set<GraphEdge<String>> edgesTest = new HashSet<GraphEdge<String>>();
        assertThrows(NullPointerException.class,
                () -> g.getIngoingEdgesOf(null));
        GraphNode<String> nu = new GraphNode<String>("u");
        assertThrows(IllegalArgumentException.class,
                () -> g.getIngoingEdgesOf(nu));
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, true);
        g.addEdge(esu);
        GraphNode<String> nx = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<String>(ns, nx, true, 5.12);
        g.addEdge(esx);
        GraphEdge<String> eux = new GraphEdge<String>(nu, nx, true, 2.05);
        g.addEdge(eux);
        GraphEdge<String> exu = new GraphEdge<String>(nx, nu, true, 3.04);
        g.addEdge(exu);
        GraphNode<String> ny = new GraphNode<String>("y");
        g.addNode(ny);
        GraphEdge<String> exy = new GraphEdge<String>(nx, ny, true, 2.0);
        g.addEdge(exy);
        GraphEdge<String> eys = new GraphEdge<String>(ny, ns, true, 7.03);
        g.addEdge(eys);
        GraphNode<String> nw = new GraphNode<String>("w");
        g.addNode(nw);
        GraphEdge<String> euw = new GraphEdge<String>(nu, nw, true, 7.07);
        g.addEdge(euw);
        GraphNode<String> nz = new GraphNode<String>("z");
        g.addNode(nz);
        GraphEdge<String> ezy = new GraphEdge<String>(nz, ny, true, 7.107);
        g.addEdge(ezy);
        edgesTest.add(esu);
        edgesTest.add(exu);
        assertTrue(g.getIngoingEdgesOf(nu).equals(edgesTest));
        edgesTest.clear();
        edgesTest.add(euw);
        assertTrue(g.getIngoingEdgesOf(nw).equals(edgesTest));
        edgesTest.clear();
        assertTrue(g.getIngoingEdgesOf(nz).equals(edgesTest));
    }

    @Test
    final void testMapAdjacentListDirectedGraph() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        assertTrue(g.isEmpty());
    }

    @Test
    final void testSize() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        assertTrue(g.size() == 0);
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        assertTrue(g.size() == 1);
        GraphNode<String> nu = new GraphNode<String>("u");
        g.addNode(nu);
        assertTrue(g.size() == 2);
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, true);
        g.addEdge(esu);
        assertTrue(g.size() == 3);
        GraphNode<String> nx = new GraphNode<String>("x");
        g.addNode(nx);
        assertTrue(g.size() == 4);
        GraphEdge<String> esx = new GraphEdge<String>(ns, nx, true, 5.12);
        g.addEdge(esx);
        assertTrue(g.size() == 5);
        GraphEdge<String> eux = new GraphEdge<String>(nu, nx, true, 2.05);
        g.addEdge(eux);
        assertTrue(g.size() == 6);
        g.clear();
        assertTrue(g.size() == 0);
    }

    @Test
    final void testIsEmpty() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        assertTrue(g.isEmpty());
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        assertFalse(g.isEmpty());
        g.clear();
        assertTrue(g.isEmpty());
    }

    @Test
    final void testGetDegreeOf() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        GraphNode<String> ns = new GraphNode<String>("s");
        g.addNode(ns);
        assertTrue(g.getDegreeOf(ns) == 0);
        assertThrows(NullPointerException.class,
                () -> g.getDegreeOf(null));
        GraphNode<String> nu = new GraphNode<String>("u");
        assertThrows(IllegalArgumentException.class,
                () -> g.getDegreeOf(nu));
        g.addNode(nu);
        GraphEdge<String> esu = new GraphEdge<String>(ns, nu, true);
        g.addEdge(esu);
        GraphNode<String> nx = new GraphNode<String>("x");
        g.addNode(nx);
        GraphEdge<String> esx = new GraphEdge<String>(ns, nx, true, 5.12);
        g.addEdge(esx);
        GraphEdge<String> eux = new GraphEdge<String>(nu, nx, true, 2.05);
        g.addEdge(eux);
        GraphEdge<String> exu = new GraphEdge<String>(nx, nu, true, 3.04);
        g.addEdge(exu);
        GraphNode<String> ny = new GraphNode<String>("y");
        g.addNode(ny);
        GraphEdge<String> exy = new GraphEdge<String>(nx, ny, true, 2.0);
        g.addEdge(exy);
        GraphEdge<String> eys = new GraphEdge<String>(ny, ns, true, 7.03);
        g.addEdge(eys);
        GraphNode<String> nw = new GraphNode<String>("w");
        g.addNode(nw);
        GraphEdge<String> euw = new GraphEdge<String>(nu, nw, true, 7.07);
        g.addEdge(euw);
        GraphNode<String> nz = new GraphNode<String>("z");
        g.addNode(nz);
        GraphEdge<String> ezy = new GraphEdge<String>(nz, ny, true, 7.107);
        g.addEdge(ezy);
        assertTrue(g.getDegreeOf(ns)==3);
        assertTrue(g.getDegreeOf(nu)==4);
        assertTrue(g.getDegreeOf(nx)==4);
        assertTrue(g.getDegreeOf(ny)==3);
        assertTrue(g.getDegreeOf(nz)==1);
        assertTrue(g.getDegreeOf(nw)==1);
    }

}