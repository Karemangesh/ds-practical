TokenRing.java 

import java.util.Scanner;

public class TokenRing {
    private static int[] nodes;
    private static boolean[] hasToken;
    private static int numNodes;
    private static int tokenPos;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get number of nodes
        System.out.print("Enter the number of nodes: ");
        numNodes = scanner.nextInt();
        
        // Initialize nodes array
        nodes = new int[numNodes];
        hasToken = new boolean[numNodes];
        
        // Get initial values for nodes
        for (int i = 0; i < numNodes; i++) {
            System.out.print("Enter the initial value for node " + i + ": ");
            nodes[i] = scanner.nextInt();
        }
        
        // Set initial token position
        tokenPos = 0;
        
        // Enter critical region for each node in turn
        for (int i = 0; i < numNodes; i++) {
            enterCriticalRegion(i);
            exitCriticalRegion(i);
        }
        
        // Print final node values
        System.out.println("All nodes have exited the critical region");
        System.out.println("Final node values:");
        for (int i = 0; i < numNodes; i++) {
            System.out.println("Node " + i + ": " + nodes[i]);
        }
    }
    
    private static void enterCriticalRegion(int node) {
        hasToken[node] = true;
        while (true) {
            if (tokenPos == node) {
                System.out.println("Node " + node + " entered critical region");
                break;
            }
            if (hasToken[tokenPos]) {
                hasToken[node] = false;
                tokenPos = (tokenPos + 1) % numNodes;
                hasToken[tokenPos] = true;
            }
        }
    }
    
    private static void exitCriticalRegion(int node) {
        tokenPos = (tokenPos + 1) % numNodes;
        hasToken[node] = false;
        System.out.println("Node " + node + " exited critical region");
    }
}
