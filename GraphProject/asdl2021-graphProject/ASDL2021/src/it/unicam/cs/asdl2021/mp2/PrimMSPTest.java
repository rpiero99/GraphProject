package it.unicam.cs.asdl2021.mp2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    @author - Riccardo Pierini 105131
    @project - asdl2021-codice-mp2-traccia
 */
class PrimMSPTest {

/*    @Test
    void computeMSP() {
        Graph<String> gr = new AdjacencyMatrixUndirectedGraph<>();
        GraphNode<String> a = new GraphNode<>("a");
        gr.addNode(a);
        GraphNode<String> b = new GraphNode<>("b");
        gr.addNode(b);
        GraphNode<String> c = new GraphNode<>("c");
        gr.addNode(c);
        GraphNode<String> d = new GraphNode<>("d");
        gr.addNode(d);
        GraphNode<String> e = new GraphNode<>("e");
        gr.addNode(e);
        GraphNode<String> f = new GraphNode<>("f");
        gr.addNode(f);
        GraphNode<String> g = new GraphNode<>("g");
        gr.addNode(g);
        GraphNode<String> h = new GraphNode<>("h");
        gr.addNode(h);
        GraphNode<String> i = new GraphNode<>("i");
        gr.addNode(i);
        gr.addEdge(new GraphEdge<>(a, b, false, 4));
        gr.addEdge(new GraphEdge<>(a, h, false, 8));
        gr.addEdge(new GraphEdge<>(b, h, false, 11));
        gr.addEdge(new GraphEdge<>(b, c, false, 8));
        gr.addEdge(new GraphEdge<>(c, i, false, 2));
        gr.addEdge(new GraphEdge<>(c, d, false, 7));
        gr.addEdge(new GraphEdge<>(c, f, false, 4));
        gr.addEdge(new GraphEdge<>(d, f, false, 14));
        gr.addEdge(new GraphEdge<>(d, e, false, 9));
        gr.addEdge(new GraphEdge<>(e, f, false, 10));
        gr.addEdge(new GraphEdge<>(f, g, false, 2));
        gr.addEdge(new GraphEdge<>(g, i, false, 6));
        gr.addEdge(new GraphEdge<>(g, h, false, 1));
        gr.addEdge(new GraphEdge<>(h, i, false, 7));
        PrimMSP<String> alg = new PrimMSP<>();
        alg.computeMSP(gr, a);
        for (GraphNode<String> node : gr.getNodes()) {
            System.out.println(node.toString());
        }
        assertNull(a.getPrevious());
        assertEquals(b.getPrevious(), a);
        assertEquals(c.getPrevious(), f);
        assertEquals(d.getPrevious(), c);
        assertEquals(e.getPrevious(), d);
        assertEquals(f.getPrevious(), g);
        assertEquals(g.getPrevious(), h);
        assertEquals(h.getPrevious(), a);
        assertEquals(i.getPrevious(), c);
    }

    @Test
    void computeMSP2(){
        Graph<String> gr = new AdjacencyMatrixUndirectedGraph<>();
        GraphNode<String> a = new GraphNode<>("a");
        gr.addNode(a);
        GraphNode<String> b = new GraphNode<>("b");
        gr.addNode(b);
        GraphNode<String> c = new GraphNode<>("c");
        gr.addNode(c);
        GraphNode<String> d = new GraphNode<>("d");
        gr.addNode(d);
        GraphNode<String> e = new GraphNode<>("e");
        gr.addNode(e);
        GraphNode<String> f = new GraphNode<>("f");
        gr.addNode(f);
        GraphNode<String> g = new GraphNode<>("g");
        gr.addNode(g);

        gr.addEdge(new GraphEdge<>(a, b, false, 10));
        //gr.addEdge(new GraphEdge<>(a, c, true,5)); //da provare per l'illegal
        gr.addEdge(new GraphEdge<>(a, g, false, 1));
        gr.addEdge(new GraphEdge<>(a, e, false, 2));
        gr.addEdge(new GraphEdge<>(a, f, false, 3));
        gr.addEdge(new GraphEdge<>(b, f, false, 2));
        gr.addEdge(new GraphEdge<>(b, c, false, 6));
        gr.addEdge(new GraphEdge<>(b, d, false, 11));
        gr.addEdge(new GraphEdge<>(c, g, false, 4));
        gr.addEdge(new GraphEdge<>(c, d, false, 7));
        gr.addEdge(new GraphEdge<>(d, e, false, 2));
        gr.addEdge(new GraphEdge<>(e, g, false, 5));
        gr.addEdge(new GraphEdge<>(e, f, false, 8));

        PrimMSP<String> alg = new PrimMSP<>();
        alg.computeMSP(gr, a);

        assertNull(a.getPrevious());
        assertEquals(b.getPrevious(), f);
        assertEquals(c.getPrevious(), g);
        assertEquals(d.getPrevious(), e);
        assertEquals(e.getPrevious(), a);
        assertEquals(f.getPrevious(), a);
        assertEquals(g.getPrevious(), a);
    }

    @Test
    void computeMSP3(){
        Graph<String> gr = new AdjacencyMatrixUndirectedGraph<>();
        GraphNode<String> a = new GraphNode<>("a");
        gr.addNode(a);
        GraphNode<String> b = new GraphNode<>("b");
        gr.addNode(b);
        GraphNode<String> c = new GraphNode<>("c");
        gr.addNode(c);
        GraphNode<String> d = new GraphNode<>("d");
        gr.addNode(d);
        GraphNode<String> e = new GraphNode<>("e");
        gr.addNode(e);
        GraphNode<String> f = new GraphNode<>("f");
        gr.addNode(f);
        gr.addEdge(new GraphEdge<>(a, d, false, 4));
        gr.addEdge(new GraphEdge<>(d, c, false, 8.5));
        gr.addEdge(new GraphEdge<>(b, d, false, 11));
        gr.addEdge(new GraphEdge<>(b, e, false, 8));
        gr.addEdge(new GraphEdge<>(f, e, false, 2));
        gr.addEdge(new GraphEdge<>(c, f, false, 2));
        PrimMSP<String> alg = new PrimMSP<>();
        alg.computeMSP(gr, a);
        for (GraphNode<String> node : gr.getNodes()) {
            System.out.println(node.toString());
        }
        assertNull(a.getPrevious());
        assertEquals(e, b.getPrevious());
        assertEquals(d, c.getPrevious());
        assertEquals(a, d.getPrevious());
        assertEquals(f, e.getPrevious());
        assertEquals(c, f.getPrevious());
    }


    @Test
    void illegalCompute1(){
        Graph<String> gr = new AdjacencyMatrixUndirectedGraph<>();
        GraphNode<String> a = new GraphNode<>("a");
        gr.addNode(a);
        GraphNode<String> b = new GraphNode<>("b");
        gr.addNode(b);
        GraphNode<String> c = new GraphNode<>("c");
        gr.addNode(c);
        GraphNode<String> d = new GraphNode<>("d");
        gr.addNode(d);
        GraphNode<String> e = new GraphNode<>("e");
        gr.addNode(e);
        GraphNode<String> f = new GraphNode<>("f");
        gr.addNode(f);
        GraphNode<String> g = new GraphNode<>("g");
        gr.addNode(g);
        GraphNode<String> h = new GraphNode<>("h"); //da provare per l'illegal
        gr.addEdge(new GraphEdge<>(a, b, false, 10));
        gr.addEdge(new GraphEdge<>(a, g, false, 1));
        gr.addEdge(new GraphEdge<>(a, e, false, 2));
        gr.addEdge(new GraphEdge<>(a, f, false, 3));
        gr.addEdge(new GraphEdge<>(b, f, false, 2));
        gr.addEdge(new GraphEdge<>(b, c, false, 6));
        gr.addEdge(new GraphEdge<>(b, d, false, 11));
        gr.addEdge(new GraphEdge<>(c, g, false, 4));
        gr.addEdge(new GraphEdge<>(c, d, false, 7));
        gr.addEdge(new GraphEdge<>(d, e, false, 2));
        gr.addEdge(new GraphEdge<>(e, g, false, 5));
        gr.addEdge(new GraphEdge<>(e, f, false, 8));

        PrimMSP<String> alg = new PrimMSP<>();
        assertThrows(IllegalArgumentException.class, () ->alg.computeMSP(gr,h));
    }

    @Test
    void illegalCompute2(){
        Graph<String> gr = new AdjacencyMatrixUndirectedGraph<>();
        GraphNode<String> a = new GraphNode<>("a");
        gr.addNode(a);
        GraphNode<String> b = new GraphNode<>("b");
        gr.addNode(b);
        GraphNode<String> c = new GraphNode<>("c");
        gr.addNode(c);
        GraphNode<String> d = new GraphNode<>("d");
        gr.addNode(d);
        GraphNode<String> e = new GraphNode<>("e");
        gr.addNode(e);
        GraphNode<String> f = new GraphNode<>("f");
        gr.addNode(f);
        GraphNode<String> g = new GraphNode<>("g");
        gr.addNode(g);

        gr.addEdge(new GraphEdge<>(a, b, false, 10));
        gr.addEdge(new GraphEdge<>(a, g, false, 1));
        gr.addEdge(new GraphEdge<>(a, e, false, 2));
        gr.addEdge(new GraphEdge<>(a, f, false, 3));
        gr.addEdge(new GraphEdge<>(b, f, false, 2));
        gr.addEdge(new GraphEdge<>(b, c, false, 6));
        gr.addEdge(new GraphEdge<>(b, d, false, 11));
        gr.addEdge(new GraphEdge<>(c, g, false, 4));
        gr.addEdge(new GraphEdge<>(c, d, false, 7));
        gr.addEdge(new GraphEdge<>(d, e, false, 2));
        gr.addEdge(new GraphEdge<>(e, g, false, 5));
        gr.addEdge(new GraphEdge<>(e, f, false, -3));

        PrimMSP<String> alg = new PrimMSP<>();
        assertThrows(IllegalArgumentException.class, () ->alg.computeMSP(gr,a));
    }

    @Test
    void illegalCompute3(){
        Graph<String> gr = new AdjacencyMatrixUndirectedGraph<>();
        GraphNode<String> a = new GraphNode<>("a");
        gr.addNode(a);
        GraphNode<String> b = new GraphNode<>("b");
        gr.addNode(b);
        GraphNode<String> c = new GraphNode<>("c");
        gr.addNode(c);
        GraphNode<String> d = new GraphNode<>("d");
        gr.addNode(d);
        GraphNode<String> e = new GraphNode<>("e");
        gr.addNode(e);
        GraphNode<String> f = new GraphNode<>("f");
        gr.addNode(f);
        GraphNode<String> g = new GraphNode<>("g");
        gr.addNode(g);

        gr.addEdge(new GraphEdge<>(a, b, false));
        gr.addEdge(new GraphEdge<>(a, g, false, 1));
        gr.addEdge(new GraphEdge<>(a, e, false, 2));
        gr.addEdge(new GraphEdge<>(a, f, false, 3));
        gr.addEdge(new GraphEdge<>(b, f, false, 2));
        gr.addEdge(new GraphEdge<>(b, c, false, 6));
        gr.addEdge(new GraphEdge<>(b, d, false, 11));
        gr.addEdge(new GraphEdge<>(c, g, false, 4));
        gr.addEdge(new GraphEdge<>(c, d, false, 7));
        gr.addEdge(new GraphEdge<>(d, e, false, 2));
        gr.addEdge(new GraphEdge<>(e, g, false, 5));
        gr.addEdge(new GraphEdge<>(e, f, false));

        PrimMSP<String> alg = new PrimMSP<>();
        assertThrows(IllegalArgumentException.class, () ->alg.computeMSP(gr,a));
    }

    @Test
    void nullCompute(){
        Graph<String> g=null;
        GraphNode<String> a = new GraphNode<>("a");
        PrimMSP<String> alg = new PrimMSP<>();
        assertThrows(NullPointerException.class, () ->alg.computeMSP(g,a));
    }*/
@Test
final void testExceptions() {
    PrimMSP<String> alg = new PrimMSP<String>();
    assertThrows(NullPointerException.class, () -> alg.computeMSP(null, null));
    Graph<String> gr = new AdjacencyMatrixUndirectedGraph<String>();
    GraphNode<String> a = new GraphNode<String>("a");
    gr.addNode(a);
    assertThrows(NullPointerException.class, () -> alg.computeMSP(gr, null));
    assertThrows(NullPointerException.class, () -> alg.computeMSP(null, a));
    GraphNode<String> b = new GraphNode<String>("b");
    assertThrows(IllegalArgumentException.class, () -> alg.computeMSP(gr, b));
    gr.addNode(b);
    GraphNode<String> c = new GraphNode<String>("c");
    gr.addNode(c);
    GraphNode<String> d = new GraphNode<String>("d");
    gr.addNode(d);
    GraphNode<String> e = new GraphNode<String>("e");
    gr.addNode(e);
    GraphNode<String> f = new GraphNode<String>("f");
    gr.addNode(f);
    GraphNode<String> g = new GraphNode<String>("g");
    gr.addNode(g);
    GraphNode<String> h = new GraphNode<String>("h");
    gr.addNode(h);
    GraphNode<String> i = new GraphNode<String>("i");
    gr.addNode(i);
    gr.addEdge(new GraphEdge<String>(a, b, false, 4));
    gr.addEdge(new GraphEdge<String>(a, h, false, 8.5));
    gr.addEdge(new GraphEdge<String>(b, h, false, 11));
    gr.addEdge(new GraphEdge<String>(b, c, false, 8));
    gr.addEdge(new GraphEdge<String>(c, i, false, 2));
    gr.addEdge(new GraphEdge<String>(c, d, false, 7));
    gr.addEdge(new GraphEdge<String>(c, f, false, 4));
    gr.addEdge(new GraphEdge<String>(d, f, false, 14));
    gr.addEdge(new GraphEdge<String>(d, e, false));
    gr.addEdge(new GraphEdge<String>(e, f, false, 10));
    gr.addEdge(new GraphEdge<String>(f, g, false, 2));
    gr.addEdge(new GraphEdge<String>(g, i, false, 6));
    gr.addEdge(new GraphEdge<String>(g, h, false, 1));
    gr.addEdge(new GraphEdge<String>(h, i, false, 7));
    assertThrows(IllegalArgumentException.class, () -> alg.computeMSP(gr, b));
    gr.clear();
    gr.addNode(a);
    gr.addNode(b);
    gr.addNode(c);
    gr.addNode(d);
    gr.addNode(e);
    gr.addNode(f);
    gr.addNode(g);
    gr.addNode(h);
    gr.addNode(i);
    gr.addEdge(new GraphEdge<String>(a, b, false, 4));
    gr.addEdge(new GraphEdge<String>(a, h, false, 8.5));
    gr.addEdge(new GraphEdge<String>(b, h, false, 11));
    gr.addEdge(new GraphEdge<String>(b, c, false, 8));
    gr.addEdge(new GraphEdge<String>(c, i, false, 2));
    gr.addEdge(new GraphEdge<String>(c, d, false, 7));
    gr.addEdge(new GraphEdge<String>(c, f, false, 4));
    gr.addEdge(new GraphEdge<String>(d, f, false, 14));
    gr.addEdge(new GraphEdge<String>(d, e, false, 9));
    gr.addEdge(new GraphEdge<String>(e, f, false, 10));
    gr.addEdge(new GraphEdge<String>(f, g, false, 2));
    gr.addEdge(new GraphEdge<String>(g, i, false, -6));
    gr.addEdge(new GraphEdge<String>(g, h, false, 1));
    gr.addEdge(new GraphEdge<String>(h, i, false, 7));
    assertThrows(IllegalArgumentException.class, () -> alg.computeMSP(gr, b));
    Graph<String> gr1 = new MapAdjacentListDirectedGraph<String>();
    gr1.addNode(a);
    assertThrows(IllegalArgumentException.class, () -> alg.computeMSP(gr1, a));
}

    @Test
    final void testFindMSP1() {
        Graph<String> gr = new AdjacencyMatrixUndirectedGraph<String>();
        GraphNode<String> a = new GraphNode<String>("a");
        gr.addNode(a);
        GraphNode<String> b = new GraphNode<String>("b");
        gr.addNode(b);
        GraphNode<String> c = new GraphNode<String>("c");
        gr.addNode(c);
        GraphNode<String> d = new GraphNode<String>("d");
        gr.addNode(d);
        GraphNode<String> e = new GraphNode<String>("e");
        gr.addNode(e);
        GraphNode<String> f = new GraphNode<String>("f");
        gr.addNode(f);
        GraphNode<String> g = new GraphNode<String>("g");
        gr.addNode(g);
        GraphNode<String> h = new GraphNode<String>("h");
        gr.addNode(h);
        GraphNode<String> i = new GraphNode<String>("i");
        gr.addNode(i);
        gr.addEdge(new GraphEdge<String>(a, b, false, 4));
        gr.addEdge(new GraphEdge<String>(a, h, false, 8.5));
        gr.addEdge(new GraphEdge<String>(b, h, false, 11));
        gr.addEdge(new GraphEdge<String>(b, c, false, 8));
        gr.addEdge(new GraphEdge<String>(c, i, false, 2));
        gr.addEdge(new GraphEdge<String>(c, d, false, 7));
        gr.addEdge(new GraphEdge<String>(c, f, false, 4));
        gr.addEdge(new GraphEdge<String>(d, f, false, 14));
        gr.addEdge(new GraphEdge<String>(d, e, false, 9));
        gr.addEdge(new GraphEdge<String>(e, f, false, 10));
        gr.addEdge(new GraphEdge<String>(f, g, false, 2));
        gr.addEdge(new GraphEdge<String>(g, i, false, 6));
        gr.addEdge(new GraphEdge<String>(g, h, false, 1));
        gr.addEdge(new GraphEdge<String>(h, i, false, 7));
        PrimMSP<String> alg = new PrimMSP<String>();
        alg.computeMSP(gr, a);
        assertTrue(a.getPrevious() == null);
        assertTrue(b.getPrevious() == a);
        assertTrue(c.getPrevious() == b);
        assertTrue(d.getPrevious() == c);
        assertTrue(e.getPrevious() == d);
        assertTrue(f.getPrevious() == c);
        assertTrue(g.getPrevious() == f);
        assertTrue(h.getPrevious() == g);
        assertTrue(i.getPrevious() == c);
    }

    @Test
    final void testFindMSP2() {
        Graph<String> gr = new AdjacencyMatrixUndirectedGraph<String>();
        GraphNode<String> a = new GraphNode<String>("a");
        gr.addNode(a);
        GraphNode<String> b = new GraphNode<String>("b");
        gr.addNode(b);
        GraphNode<String> c = new GraphNode<String>("c");
        gr.addNode(c);
        GraphNode<String> d = new GraphNode<String>("d");
        gr.addNode(d);
        gr.addEdge(new GraphEdge<String>(a, b, false, 1));
        gr.addEdge(new GraphEdge<String>(a, c, false, 5));
        gr.addEdge(new GraphEdge<String>(b, d, false, 2));
        gr.addEdge(new GraphEdge<String>(b, c, false, 3));
        gr.addEdge(new GraphEdge<String>(c, d, false, 4));
        PrimMSP<String> alg = new PrimMSP<String>();
        alg.computeMSP(gr, a);
        assertTrue(a.getPrevious() == null);
        assertTrue(b.getPrevious() == a);
        assertTrue(c.getPrevious() == b);
        assertTrue(d.getPrevious() == b);
    }

    @Test
    final void testFindMSP3() {
        Graph<String> gr = new AdjacencyMatrixUndirectedGraph<String>();
        GraphNode<String> a = new GraphNode<String>("a");
        gr.addNode(a);
        GraphNode<String> b = new GraphNode<String>("b");
        gr.addNode(b);
        GraphNode<String> c = new GraphNode<String>("c");
        gr.addNode(c);
        GraphNode<String> d = new GraphNode<String>("d");
        gr.addNode(d);
        gr.addEdge(new GraphEdge<String>(a, b, false, 1));
        gr.addEdge(new GraphEdge<String>(a, c, false, 5));
        gr.addEdge(new GraphEdge<String>(b, d, false, 2));
        gr.addEdge(new GraphEdge<String>(b, c, false, 3));
        gr.addEdge(new GraphEdge<String>(c, d, false, 4));
        PrimMSP<String> alg = new PrimMSP<String>();
        alg.computeMSP(gr, b);
        assertTrue(a.getPrevious() == b);
        assertTrue(b.getPrevious() == null);
        assertTrue(c.getPrevious() == b);
        assertTrue(d.getPrevious() == b);
    }

    @Test
    final void testFindMSP4() {
        Graph<String> gr = new AdjacencyMatrixUndirectedGraph<String>();
        GraphNode<String> a = new GraphNode<String>("a");
        gr.addNode(a);
        GraphNode<String> b = new GraphNode<String>("b");
        gr.addNode(b);
        GraphNode<String> c = new GraphNode<String>("c");
        gr.addNode(c);
        GraphNode<String> d = new GraphNode<String>("d");
        gr.addNode(d);
        gr.addEdge(new GraphEdge<String>(a, b, false, 1));
        gr.addEdge(new GraphEdge<String>(a, c, false, 5));
        gr.addEdge(new GraphEdge<String>(b, d, false, 2));
        gr.addEdge(new GraphEdge<String>(b, c, false, 3));
        gr.addEdge(new GraphEdge<String>(c, d, false, 4));
        PrimMSP<String> alg = new PrimMSP<String>();
        alg.computeMSP(gr, c);
        assertTrue(a.getPrevious() == b);
        assertTrue(b.getPrevious() == c);
        assertTrue(c.getPrevious() == null);
        assertTrue(d.getPrevious() == b);
    }

    @Test
    final void testFindMSP5() {
        Graph<String> gr = new AdjacencyMatrixUndirectedGraph<String>();
        GraphNode<String> a = new GraphNode<String>("a");
        gr.addNode(a);
        GraphNode<String> b = new GraphNode<String>("b");
        gr.addNode(b);
        GraphNode<String> c = new GraphNode<String>("c");
        gr.addNode(c);
        GraphNode<String> d = new GraphNode<String>("d");
        gr.addNode(d);
        gr.addEdge(new GraphEdge<String>(a, b, false, 1));
        gr.addEdge(new GraphEdge<String>(a, c, false, 5));
        gr.addEdge(new GraphEdge<String>(b, d, false, 2));
        gr.addEdge(new GraphEdge<String>(b, c, false, 3));
        gr.addEdge(new GraphEdge<String>(c, d, false, 4));
        PrimMSP<String> alg = new PrimMSP<String>();
        alg.computeMSP(gr, d);
        assertTrue(a.getPrevious() == b);
        assertTrue(b.getPrevious() == d);
        assertTrue(c.getPrevious() == b);
        assertTrue(d.getPrevious() == null);
    }
}