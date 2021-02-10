package it.unicam.cs.asdl2021.mp2;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/*
    @author - Riccardo Pierini 105131
    @project - asdl2021-codice-mp2-traccia
 */
class StronglyConnectedComponentsFinderTest {
  /*  StronglyConnectedComponentsFinder<String> finder = new StronglyConnectedComponentsFinder<>();

    MapAdjacentListDirectedGraph<String> adjMatrix = new MapAdjacentListDirectedGraph<>();

    @Test
    void findStronglyConnectedComponentsTest1() {
        this.adjMatrix.clear();

        GraphNode<String> n1 = new GraphNode<>("a");
        GraphNode<String> n2 = new GraphNode<>("b");
        GraphNode<String> n3 = new GraphNode<>("c");
        GraphNode<String> n4 = new GraphNode<>("d");

        GraphEdge<String> a1 = new GraphEdge<>(n1, n2, true);
        GraphEdge<String> a2 = new GraphEdge<>(n2, n3, true);
        GraphEdge<String> a3 = new GraphEdge<>(n3, n1, true);

        this.adjMatrix.addNode(n1);
        this.adjMatrix.addNode(n2);
        this.adjMatrix.addNode(n3);
        this.adjMatrix.addNode(n4);

        this.adjMatrix.addEdge(a1);
        this.adjMatrix.addEdge(a2);
        this.adjMatrix.addEdge(a3);

        Set<GraphNode<String>> SCC1 = new HashSet<>();
        SCC1.add(n1);
        SCC1.add(n2);
        SCC1.add(n3);

        Set<GraphNode<String>> SCC2 = new HashSet<>();
        SCC2.add(n4);

        Set<Set<GraphNode<String>>> dsfForest = finder.findStronglyConnectedComponents(adjMatrix);

        assertEquals(dsfForest.size(), 2);

        assertTrue(dsfForest.contains(SCC1));
        assertTrue(dsfForest.contains(SCC2));
    }

    @Test
    void findStronglyConnectedComponentsTest2() {
        this.adjMatrix.clear();

        GraphNode<String> n1 = new GraphNode<>("a");
        GraphNode<String> n2 = new GraphNode<>("b");
        GraphNode<String> n3 = new GraphNode<>("c");
        GraphNode<String> n4 = new GraphNode<>("d");
        GraphNode<String> n5 = new GraphNode<>("e");

        GraphEdge<String> a1 = new GraphEdge<>(n1, n2, true);
        GraphEdge<String> a2 = new GraphEdge<>(n2, n3, true);
        GraphEdge<String> a3 = new GraphEdge<>(n3, n1, true);
        GraphEdge<String> a4 = new GraphEdge<>(n4, n5, true);

        this.adjMatrix.addNode(n1);
        this.adjMatrix.addNode(n2);
        this.adjMatrix.addNode(n3);
        this.adjMatrix.addNode(n4);
        this.adjMatrix.addNode(n5);

        this.adjMatrix.addEdge(a1);
        this.adjMatrix.addEdge(a2);
        this.adjMatrix.addEdge(a3);
        this.adjMatrix.addEdge(a4);

        Set<GraphNode<String>> SCC1 = new HashSet<>();
        SCC1.add(n1);
        SCC1.add(n2);
        SCC1.add(n3);

        Set<GraphNode<String>> SCC2 = new HashSet<>();
        SCC2.add(n4);

        Set<GraphNode<String>> SCC3 = new HashSet<>();
        SCC3.add(n5);

        Set<Set<GraphNode<String>>> dsfForest = finder.findStronglyConnectedComponents(adjMatrix);

        assertEquals(dsfForest.size(), 3);

        assertTrue(dsfForest.contains(SCC1));
        assertTrue(dsfForest.contains(SCC2));
        assertTrue(dsfForest.contains(SCC3));
    }

    @Test
    void findStronglyConnectedComponentsTest3() {
        this.adjMatrix.clear();

        GraphNode<String> n1 = new GraphNode<>("a");
        GraphNode<String> n2 = new GraphNode<>("b");
        GraphNode<String> n3 = new GraphNode<>("c");
        GraphNode<String> n4 = new GraphNode<>("d");
        GraphNode<String> n5 = new GraphNode<>("e");
        GraphNode<String> n6 = new GraphNode<>("f");
        GraphNode<String> n7 = new GraphNode<>("g");

        GraphEdge<String> a1 = new GraphEdge<>(n1, n2, true);
        GraphEdge<String> a2 = new GraphEdge<>(n2, n3, true);
        GraphEdge<String> a3 = new GraphEdge<>(n3, n4, true);
        GraphEdge<String> a4 = new GraphEdge<>(n4, n1, true);
        GraphEdge<String> a5 = new GraphEdge<>(n2, n5, true);
        GraphEdge<String> a6 = new GraphEdge<>(n5, n6, true);
        GraphEdge<String> a7 = new GraphEdge<>(n6, n7, true);
        GraphEdge<String> a8 = new GraphEdge<>(n7, n5, true);

        this.adjMatrix.addNode(n1);
        this.adjMatrix.addNode(n2);
        this.adjMatrix.addNode(n3);
        this.adjMatrix.addNode(n4);
        this.adjMatrix.addNode(n5);
        this.adjMatrix.addNode(n6);
        this.adjMatrix.addNode(n7);

        this.adjMatrix.addEdge(a1);
        this.adjMatrix.addEdge(a2);
        this.adjMatrix.addEdge(a3);
        this.adjMatrix.addEdge(a4);
        this.adjMatrix.addEdge(a5);
        this.adjMatrix.addEdge(a6);
        this.adjMatrix.addEdge(a7);
        this.adjMatrix.addEdge(a8);

        Set<GraphNode<String>> SCC1 = new HashSet<>();
        SCC1.add(n1);
        SCC1.add(n2);
        SCC1.add(n3);
        SCC1.add(n4);

        Set<GraphNode<String>> SCC2 = new HashSet<>();
        SCC2.add(n5);
        SCC2.add(n6);
        SCC2.add(n7);

        Set<Set<GraphNode<String>>> dsfForest = finder.findStronglyConnectedComponents(adjMatrix);

        assertEquals(dsfForest.size(), 2);
        assertTrue(dsfForest.contains(SCC1));
        assertTrue(dsfForest.contains(SCC2));
    }

    @Test
    void findStronglyConnectedComponentsTest4() {
        this.adjMatrix.clear();

        GraphNode<String> n1 = new GraphNode<>("a");
        GraphNode<String> n2 = new GraphNode<>("b");
        GraphNode<String> n3 = new GraphNode<>("c");
        GraphNode<String> n4 = new GraphNode<>("d");
        GraphNode<String> n5 = new GraphNode<>("e");
        GraphNode<String> n6 = new GraphNode<>("f");
        GraphNode<String> n7 = new GraphNode<>("g");
        GraphNode<String> n8 = new GraphNode<>("h");
        GraphNode<String> n9 = new GraphNode<>("i");

        GraphEdge<String> a1 = new GraphEdge<>(n1, n2, true);
        GraphEdge<String> a2 = new GraphEdge<>(n1, n8, true);
        GraphEdge<String> a3 = new GraphEdge<>(n2, n7, true);
        GraphEdge<String> a4 = new GraphEdge<>(n3, n2, true);
        GraphEdge<String> a5 = new GraphEdge<>(n3, n4, true);
        GraphEdge<String> a6 = new GraphEdge<>(n3, n6, true);
        GraphEdge<String> a7 = new GraphEdge<>(n4, n6, true);
        GraphEdge<String> a8 = new GraphEdge<>(n5, n4, true);
        GraphEdge<String> a9 = new GraphEdge<>(n6, n5, true);
        GraphEdge<String> a10 = new GraphEdge<>(n7, n3, true);
        GraphEdge<String> a11 = new GraphEdge<>(n7, n6, true);
        GraphEdge<String> a12 = new GraphEdge<>(n8, n1, true);
        GraphEdge<String> a13 = new GraphEdge<>(n8, n7, true);
        GraphEdge<String> a14 = new GraphEdge<>(n9, n1,true);

        this.adjMatrix.addNode(n1);
        this.adjMatrix.addNode(n2);
        this.adjMatrix.addNode(n3);
        this.adjMatrix.addNode(n4);
        this.adjMatrix.addNode(n5);
        this.adjMatrix.addNode(n6);
        this.adjMatrix.addNode(n7);
        this.adjMatrix.addNode(n8);
        this.adjMatrix.addNode(n9);

        this.adjMatrix.addEdge(a1);
        this.adjMatrix.addEdge(a2);
        this.adjMatrix.addEdge(a3);
        this.adjMatrix.addEdge(a4);
        this.adjMatrix.addEdge(a5);
        this.adjMatrix.addEdge(a6);
        this.adjMatrix.addEdge(a7);
        this.adjMatrix.addEdge(a8);
        this.adjMatrix.addEdge(a9);
        this.adjMatrix.addEdge(a10);
        this.adjMatrix.addEdge(a11);
        this.adjMatrix.addEdge(a12);
        this.adjMatrix.addEdge(a13);
        this.adjMatrix.addEdge(a14);

        Set<GraphNode<String>> SCC1 = new HashSet<>();
        SCC1.add(n1);
        SCC1.add(n8);

        Set<GraphNode<String>> SCC2 = new HashSet<>();
        SCC2.add(n2);
        SCC2.add(n3);
        SCC2.add(n7);

        Set<GraphNode<String>> SCC3 = new HashSet<>();
        SCC3.add(n4);
        SCC3.add(n5);
        SCC3.add(n6);

        Set<GraphNode<String>> SCC4 = new HashSet<>();
        SCC4.add(n9);

        Set<Set<GraphNode<String>>> dsfForest = finder.findStronglyConnectedComponents(adjMatrix);

        assertEquals(dsfForest.size(), 4);
        assertTrue(dsfForest.contains(SCC1));
        assertTrue(dsfForest.contains(SCC2));
        assertTrue(dsfForest.contains(SCC3));
        assertTrue(dsfForest.contains(SCC4));
    }*/
  @Test
  final void testExceptions() {
      StronglyConnectedComponentsFinder<String> alg = new StronglyConnectedComponentsFinder<String>();
      assertThrows(NullPointerException.class,
              () -> alg.findStronglyConnectedComponents(null));
      Graph<String> gr = new AdjacencyMatrixUndirectedGraph<String>();
      assertThrows(IllegalArgumentException.class,
              () -> alg.findStronglyConnectedComponents(gr));
  }

    @Test
    final void testFindStronglyConnectedComponents1() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        GraphNode<String> n1 = new GraphNode<String>("1");
        g.addNode(n1);
        GraphNode<String> n2 = new GraphNode<String>("2");
        g.addNode(n2);
        GraphNode<String> n3 = new GraphNode<String>("3");
        g.addNode(n3);
        GraphNode<String> n4 = new GraphNode<String>("4");
        g.addNode(n4);
        GraphNode<String> n5 = new GraphNode<String>("5");
        g.addNode(n5);
        GraphNode<String> n6 = new GraphNode<String>("6");
        g.addNode(n6);
        GraphEdge<String> e12 = new GraphEdge<String>(n1, n2, true);
        g.addEdge(e12);
        GraphEdge<String> e22 = new GraphEdge<String>(n2, n2, true);
        g.addEdge(e22);
        GraphEdge<String> e24 = new GraphEdge<String>(n2, n4, true);
        g.addEdge(e24);
        GraphEdge<String> e41 = new GraphEdge<String>(n4, n1, true);
        g.addEdge(e41);
        GraphEdge<String> e25 = new GraphEdge<String>(n2, n5, true);
        g.addEdge(e25);
        GraphEdge<String> e45 = new GraphEdge<String>(n4, n5, true);
        g.addEdge(e45);
        GraphEdge<String> e54 = new GraphEdge<String>(n5, n4, true);
        g.addEdge(e54);
        GraphEdge<String> e63 = new GraphEdge<String>(n6, n3, true);
        g.addEdge(e63);
        Set<GraphNode<String>> component1 = new HashSet<GraphNode<String>>();
        component1.add(n1);
        component1.add(n2);
        component1.add(n4);
        component1.add(n5);
        Set<GraphNode<String>> component2 = new HashSet<GraphNode<String>>();
        component2.add(n3);
        Set<GraphNode<String>> component3 = new HashSet<GraphNode<String>>();
        component3.add(n6);
        Set<Set<GraphNode<String>>> stronglyConnectedComponents = new HashSet<Set<GraphNode<String>>>();
        stronglyConnectedComponents.add(component1);
        stronglyConnectedComponents.add(component2);
        stronglyConnectedComponents.add(component3);
        StronglyConnectedComponentsFinder<String> f = new StronglyConnectedComponentsFinder<String>();
        assertTrue(f.findStronglyConnectedComponents(g)
                .equals(stronglyConnectedComponents));
    }

    @Test
    final void testFindStronglyConnectedComponents2() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        GraphNode<String> n1 = new GraphNode<String>("1");
        g.addNode(n1);
        GraphNode<String> n2 = new GraphNode<String>("2");
        g.addNode(n2);
        GraphNode<String> n3 = new GraphNode<String>("3");
        g.addNode(n3);
        GraphNode<String> n4 = new GraphNode<String>("4");
        g.addNode(n4);
        GraphNode<String> n5 = new GraphNode<String>("5");
        g.addNode(n5);
        GraphNode<String> n6 = new GraphNode<String>("6");
        g.addNode(n6);
        GraphEdge<String> e12 = new GraphEdge<String>(n1, n2, true);
        g.addEdge(e12);
        GraphEdge<String> e22 = new GraphEdge<String>(n2, n2, true);
        g.addEdge(e22);
        GraphEdge<String> e24 = new GraphEdge<String>(n2, n4, true);
        g.addEdge(e24);
        GraphEdge<String> e41 = new GraphEdge<String>(n4, n1, true);
        g.addEdge(e41);
        GraphEdge<String> e25 = new GraphEdge<String>(n2, n5, true);
        g.addEdge(e25);
        GraphEdge<String> e45 = new GraphEdge<String>(n4, n5, true);
        g.addEdge(e45);
        GraphEdge<String> e54 = new GraphEdge<String>(n5, n4, true);
        g.addEdge(e54);
        GraphEdge<String> e63 = new GraphEdge<String>(n6, n3, true);
        g.addEdge(e63);
        GraphEdge<String> e26 = new GraphEdge<String>(n2, n6, true);
        g.addEdge(e26);
        Set<GraphNode<String>> component1 = new HashSet<GraphNode<String>>();
        component1.add(n1);
        component1.add(n2);
        component1.add(n4);
        component1.add(n5);
        Set<GraphNode<String>> component2 = new HashSet<GraphNode<String>>();
        component2.add(n3);
        Set<GraphNode<String>> component3 = new HashSet<GraphNode<String>>();
        component3.add(n6);
        Set<Set<GraphNode<String>>> stronglyConnectedComponents = new HashSet<Set<GraphNode<String>>>();
        stronglyConnectedComponents.add(component1);
        stronglyConnectedComponents.add(component2);
        stronglyConnectedComponents.add(component3);
        StronglyConnectedComponentsFinder<String> f = new StronglyConnectedComponentsFinder<String>();
        assertTrue(f.findStronglyConnectedComponents(g)
                .equals(stronglyConnectedComponents));
    }

    @Test
    final void testFindStronglyConnectedComponents3() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        GraphNode<String> n1 = new GraphNode<String>("1");
        g.addNode(n1);
        GraphNode<String> n2 = new GraphNode<String>("2");
        g.addNode(n2);
        GraphNode<String> n3 = new GraphNode<String>("3");
        g.addNode(n3);
        GraphNode<String> n4 = new GraphNode<String>("4");
        g.addNode(n4);
        GraphNode<String> n5 = new GraphNode<String>("5");
        g.addNode(n5);
        GraphNode<String> n6 = new GraphNode<String>("6");
        g.addNode(n6);
        GraphEdge<String> e12 = new GraphEdge<String>(n1, n2, true);
        g.addEdge(e12);
        GraphEdge<String> e22 = new GraphEdge<String>(n2, n2, true);
        g.addEdge(e22);
        GraphEdge<String> e24 = new GraphEdge<String>(n2, n4, true);
        g.addEdge(e24);
        GraphEdge<String> e41 = new GraphEdge<String>(n4, n1, true);
        g.addEdge(e41);
        GraphEdge<String> e25 = new GraphEdge<String>(n2, n5, true);
        g.addEdge(e25);
        GraphEdge<String> e45 = new GraphEdge<String>(n4, n5, true);
        g.addEdge(e45);
        GraphEdge<String> e54 = new GraphEdge<String>(n5, n4, true);
        g.addEdge(e54);
        GraphEdge<String> e63 = new GraphEdge<String>(n6, n3, true);
        g.addEdge(e63);
        GraphEdge<String> e36 = new GraphEdge<String>(n3, n6, true);
        g.addEdge(e36);
        Set<GraphNode<String>> component1 = new HashSet<GraphNode<String>>();
        component1.add(n1);
        component1.add(n2);
        component1.add(n4);
        component1.add(n5);
        Set<GraphNode<String>> component2 = new HashSet<GraphNode<String>>();
        component2.add(n3);
        component2.add(n6);
        Set<Set<GraphNode<String>>> stronglyConnectedComponents = new HashSet<Set<GraphNode<String>>>();
        stronglyConnectedComponents.add(component1);
        stronglyConnectedComponents.add(component2);
        StronglyConnectedComponentsFinder<String> f = new StronglyConnectedComponentsFinder<String>();
        assertTrue(f.findStronglyConnectedComponents(g)
                .equals(stronglyConnectedComponents));
    }

    @Test
    final void testFindStronglyConnectedComponents4() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        GraphNode<String> n1 = new GraphNode<String>("1");
        g.addNode(n1);
        GraphNode<String> n2 = new GraphNode<String>("2");
        g.addNode(n2);
        GraphNode<String> n3 = new GraphNode<String>("3");
        g.addNode(n3);
        GraphNode<String> n4 = new GraphNode<String>("4");
        g.addNode(n4);
        GraphNode<String> n5 = new GraphNode<String>("5");
        g.addNode(n5);
        GraphNode<String> n6 = new GraphNode<String>("6");
        g.addNode(n6);
        GraphEdge<String> e12 = new GraphEdge<String>(n1, n2, true);
        g.addEdge(e12);
        GraphEdge<String> e22 = new GraphEdge<String>(n2, n2, true);
        g.addEdge(e22);
        GraphEdge<String> e24 = new GraphEdge<String>(n2, n4, true);
        g.addEdge(e24);
        GraphEdge<String> e41 = new GraphEdge<String>(n4, n1, true);
        g.addEdge(e41);
        GraphEdge<String> e25 = new GraphEdge<String>(n2, n5, true);
        g.addEdge(e25);
        GraphEdge<String> e45 = new GraphEdge<String>(n4, n5, true);
        g.addEdge(e45);
        GraphEdge<String> e54 = new GraphEdge<String>(n5, n4, true);
        g.addEdge(e54);
        GraphEdge<String> e63 = new GraphEdge<String>(n6, n3, true);
        g.addEdge(e63);
        GraphEdge<String> e36 = new GraphEdge<String>(n3, n6, true);
        g.addEdge(e36);
        GraphEdge<String> e26 = new GraphEdge<String>(n2, n6, true);
        g.addEdge(e26);
        Set<GraphNode<String>> component1 = new HashSet<GraphNode<String>>();
        component1.add(n1);
        component1.add(n2);
        component1.add(n4);
        component1.add(n5);
        Set<GraphNode<String>> component2 = new HashSet<GraphNode<String>>();
        component2.add(n3);
        component2.add(n6);
        Set<Set<GraphNode<String>>> stronglyConnectedComponents = new HashSet<Set<GraphNode<String>>>();
        stronglyConnectedComponents.add(component1);
        stronglyConnectedComponents.add(component2);
        StronglyConnectedComponentsFinder<String> f = new StronglyConnectedComponentsFinder<String>();
        assertTrue(f.findStronglyConnectedComponents(g)
                .equals(stronglyConnectedComponents));
    }

    @Test
    final void testFindStronglyConnectedComponents5() {
        Graph<String> g = new MapAdjacentListDirectedGraph<String>();
        GraphNode<String> na = new GraphNode<String>("a");
        g.addNode(na);
        GraphNode<String> nb = new GraphNode<String>("b");
        g.addNode(nb);
        GraphNode<String> nc = new GraphNode<String>("c");
        g.addNode(nc);
        GraphNode<String> nd = new GraphNode<String>("d");
        g.addNode(nd);
        GraphNode<String> ne = new GraphNode<String>("e");
        g.addNode(ne);
        GraphNode<String> nf = new GraphNode<String>("f");
        g.addNode(nf);
        GraphNode<String> ng = new GraphNode<String>("g");
        g.addNode(ng);
        GraphNode<String> nh = new GraphNode<String>("h");
        g.addNode(nh);
        GraphEdge<String> eab = new GraphEdge<String>(na, nb, true);
        g.addEdge(eab);
        GraphEdge<String> ebc = new GraphEdge<String>(nb, nc, true);
        g.addEdge(ebc);
        GraphEdge<String> ebe = new GraphEdge<String>(nb, ne, true);
        g.addEdge(ebe);
        GraphEdge<String> ebf = new GraphEdge<String>(nb, nf, true);
        g.addEdge(ebf);
        GraphEdge<String> ecd = new GraphEdge<String>(nc, nd, true);
        g.addEdge(ecd);
        GraphEdge<String> ecg = new GraphEdge<String>(nc, ng, true);
        g.addEdge(ecg);
        GraphEdge<String> edc = new GraphEdge<String>(nd, nc, true);
        g.addEdge(edc);
        GraphEdge<String> edh = new GraphEdge<String>(nd, nh, true);
        g.addEdge(edh);
        GraphEdge<String> eea = new GraphEdge<String>(ne, na, true);
        g.addEdge(eea);
        GraphEdge<String> eef = new GraphEdge<String>(ne, nf, true);
        g.addEdge(eef);
        GraphEdge<String> efg = new GraphEdge<String>(nf, ng, true);
        g.addEdge(efg);
        GraphEdge<String> egf = new GraphEdge<String>(ng, nf, true);
        g.addEdge(egf);
        GraphEdge<String> egh = new GraphEdge<String>(ng, nh, true);
        g.addEdge(egh);
        GraphEdge<String> ehh = new GraphEdge<String>(nh, nh, true);
        g.addEdge(ehh);
        Set<GraphNode<String>> component1 = new HashSet<GraphNode<String>>();
        component1.add(na);
        component1.add(nb);
        component1.add(ne);
        Set<GraphNode<String>> component2 = new HashSet<GraphNode<String>>();
        component2.add(nc);
        component2.add(nd);
        Set<GraphNode<String>> component3 = new HashSet<GraphNode<String>>();
        component3.add(nf);
        component3.add(ng);
        Set<GraphNode<String>> component4 = new HashSet<GraphNode<String>>();
        component4.add(nh);
        Set<Set<GraphNode<String>>> stronglyConnectedComponents = new HashSet<Set<GraphNode<String>>>();
        stronglyConnectedComponents.add(component1);
        stronglyConnectedComponents.add(component2);
        stronglyConnectedComponents.add(component3);
        stronglyConnectedComponents.add(component4);
        StronglyConnectedComponentsFinder<String> f = new StronglyConnectedComponentsFinder<String>();
        assertTrue(f.findStronglyConnectedComponents(g)
                .equals(stronglyConnectedComponents));
    }
}