package Ch22_Graph;

import java.util.ArrayList;

public class Vertex {
    public String s;
    public Color color;
    public int d;
    public int f;
    public Vertex pi;
    public ArrayList<Vertex> adj;

    public Vertex(String s) {
        this.s = s;
        this.adj = new ArrayList<>();
    }

    public void addAdj(Vertex v) {
        adj.add(v);
    }
}
