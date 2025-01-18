package PrimePath;

public class PrimePathRunner {

    public static void main(String[] args)
    {
        PrimePath primePath = new PrimePath();
        int src = 1033;
        int dest = 8179;
        int dist = primePath.shortestPath(src, dest);
        System.out.println("Shortest path from " + src + " to " + dest + " is " + dist);

    }

}
