package Ch22_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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

        bfs(G, s);

        PrintPath(G, s, u);
    }

    public static void bfs(Graph G, Vertex s) {
        for (Vertex u : G.V) {
            if (!u.s.equals(s.s)) {
                u.color = Color.White;
                u.d = Integer.MAX_VALUE;
                u.pi = null;
            }
        }
        s.color = Color.Grey;
        s.d = 0;
        s.pi = null;
        Queue<Vertex> q = new LinkedList<>();
        q.add(s);
        while ( !q.isEmpty() ) {
            Vertex u = q.poll();
            for (Vertex v : u.adj) {
                if (v.color == Color.White) {
                    v.color = Color.Grey;
                    v.d = u.d + 1;
                    v.pi = u;
                    q.add(v);
                }
            }
            u.color = Color.Black;
        }

    }

    public static void PrintPath(Graph G, Vertex s, Vertex v) {
        if (v.s.equals(s.s)) {
            System.out.println(s.s);
        } else if (v.pi == null) {
            System.out.println("no path from s to v exists");
        } else {
            PrintPath(G, s, v.pi);
            System.out.println(v.s);
        }
    }
}
