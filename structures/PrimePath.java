package PrimePath;

import java.util.*;

public class PrimePath {

    private static final int MAX = 10000;
    private List<Integer>[] adjList;

    public PrimePath() {
        adjList = new ArrayList[MAX];
        for (int i = 0; i < MAX; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private void buildGraph() {
        for (int i = 1000; i < MAX; i++) {
            if (isPrime(i)) {
                String str1 = String.valueOf(i);
                for (int j = i + 1; j < MAX; j++) {
                    if (isPrime(j)) {
                        String str2 = String.valueOf(j);
                        int count = 0;
                        for (int k = 0; k < 4; k++) {
                            if (str1.charAt(k) != str2.charAt(k)) {
                                count++;
                            }
                        }
                        if (count == 1) {
                            adjList[i].add(j);
                            adjList[j].add(i);
                        }
                    }
                }
            }
        }
    }

    private int bfs(int src, int dest) {
        int[] dist = new int[MAX];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        dist[src] = 0;
        queue.offer(src);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adjList[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    queue.offer(v);
                    if (v == dest) {
                        return dist[v];
                    }
                }
            }
        }
        return -1;
    }

    public int shortestPath(int src, int dest) {
        buildGraph();
        return bfs(src, dest);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int src = scanner.nextInt();
        int dest = scanner.nextInt();
        PrimePath primePath = new PrimePath();
        int dist = primePath.shortestPath(src, dest);
        System.out.println(dist);
    }
}

