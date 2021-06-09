package Ch22_Graph;

import java.util.ArrayList;

public class DFS {
    public static int time;

    public static void main(String[] args) {
        Vertex s = new Vertex("s");
        Vertex r = new Vertex("r");
        Vertex v = new Vertex("v");
        Vertex w = new Vertex("w");
        Vertex t = new Vertex("t");
        Vertex x = new Vertex("x");
        Vertex y = new Vertex("y");
        Vertex u = new Vertex("u");

        s.addAdj(r);
        r.addAdj(s);

        r.addAdj(v);
        v.addAdj(r);

        s.addAdj(w);
        w.addAdj(s);

        t.addAdj(w);
        w.addAdj(t);

        x.addAdj(w);
        w.addAdj(x);

        t.addAdj(x);
        x.addAdj(t);

        t.addAdj(u);
        u.addAdj(t);

        x.addAdj(u);
        u.addAdj(x);

        x.addAdj(y);
        y.addAdj(x);

        u.addAdj(y);
        y.addAdj(u);

        ArrayList<Vertex> V = new ArrayList<>();
        V.add(s);
        V.add(r);
        V.add(v);
        V.add(w);
        V.add(x);
        V.add(y);
        V.add(t);
        V.add(u);

        Graph G = new Graph(V);

        dfs(G);
    }

    public static void dfs(Graph G) {
        for (Vertex u : G.V) {
            u.color = Color.White;
            u.pi = null;
        }
        time = 0;
        for (Vertex u : G.V) {
            if (u.color == Color.White) {
                dfsVisit(G, u);
            }
        }
    }

    public static void dfsVisit(Graph G, Vertex u) {
        time++;
        u.d = time;
        u.color = Color.Grey;
        for (Vertex v : u.adj) {
            if (v.color == Color.White) {
                v.pi = u;
                dfsVisit(G, v);
            }
        }
        u.color = Color.Black;
        time++;
        u.f = time;
    }
}
