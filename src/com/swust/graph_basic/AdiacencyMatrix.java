package com.swust.graph_basic;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AdiacencyMatrix {
    private int V;
    private int E;
    private int[][] adj;

    public AdiacencyMatrix(String filename){

        File file = new File(filename);

        try(Scanner scanner = new Scanner(file)){
        	//V：顶点   E：边数
            V = scanner.nextInt();
            adj = new int[V][V];

            E = scanner.nextInt();
            for(int i = 0; i < E; i ++){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                adj[a][b] = 1;
                adj[b][a] = 1;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("V = %d, E = %d\n", V, E));
        for(int i = 0; i < V; i ++){
            for(int j = 0; j < V; j ++)
                sb.append(String.format("%d ", adj[i][j]));
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args){

    	AdiacencyMatrix adjMatrix = new AdiacencyMatrix("E:/workspace/myeclipse/tulun/src/com/swust/g.txt");
        System.out.print(adjMatrix);
    }
}
