/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication32;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author buseche
 */
public class JavaApplication32 {

    /**
     * @param args the command line arguments
     */
    //DFS 01234
    //BFS 01324
    static int mat[][] = {{0, 1, 0, 1, 0},
    {1, 0, 1, 0, 0},
    {0, 1, 0, 1, 1},
    {1, 0, 1, 0, 0},
    {0, 0, 1, 0, 0}};
    public static boolean[] visitado = new boolean[mat.length];
    public static LinkedList<vertice> r = new LinkedList<vertice>();

    public static void DFS(int u) {
        System.out.print(u + " ");
        visitado[u] = true;
        for (int v = 0; v < mat.length; v++) {
            if (mat[u][v] == 1) {
                if (!(visitado[v])) {
                    DFS(v);
                }
            }
        }
    }

    public static void DFSU(int u) {
        System.out.print(u + " ");
        visitado[u] = true;
        vertice num = r.get(4 - u);
        vertice tmp = num.getApuntador();
        while (tmp != null) {
            if (!(visitado[tmp.getNum()])) {
                DFSU(tmp.getNum());
            }
            tmp = tmp.getApuntador();
        }
    }

    public static void BFSU(int i) {
        Queue<Integer> cola = new LinkedList<Integer>();
        visitado[i] = true;
        cola.add(i);
        int u;
        vertice num, tmp;
        while (!cola.isEmpty()) {
            u = cola.remove();
            num = r.get(4 - u);
            tmp=num.getApuntador();
            System.out.print(num.getNum() + " ");
            while(tmp!=null){
                if(!visitado[tmp.getNum()]){
                    visitado[tmp.getNum()]=true;
                    cola.add(tmp.getNum());
                }
                tmp=tmp.getApuntador();
            }
        }
    }

    public static void BFS(int i) {
        Queue<Integer> cola = new LinkedList<Integer>();
        visitado[i] = true;
        cola.add(i);
        int u;
        while (!cola.isEmpty()) {
            u = cola.remove();
            System.out.print(u + " ");
            for (int v = 0; v < mat.length; v++) {
                if (mat[u][v] == 1) {
                    if (!visitado[v]) {
                        visitado[v] = true;
                        cola.add(v);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("DFS:");
        DFS(0);
        for (int i = 0; i < mat.length; i++) {
            visitado[i] = false;
        }
        System.out.println("\n\rBFS:");
        BFS(0);
        for (int i = 0; i < mat.length; i++) {
            visitado[i] = false;
        }
        vertice antp = null;
        for (int j = 0; j < mat.length; j++) {
            vertice p = new vertice(j);
            r.addFirst(p);
            for (int i = 0; i < mat.length; i++) {
                if (mat[j][i] == 1) {
                    vertice z = new vertice(i);
                    if (p.getApuntador() == null) {
                        p.setApuntador(z);
                    } else {
                        antp.setApuntador(z);
                    }
                    antp = z;
                }
            }
        }
        for (int i = 4; i >= 0; i--) {
            System.out.println("soy " + r.get(i).getNum());
            vertice tmp = r.get(i);
            while (tmp != null) {
                tmp = tmp.getApuntador();
                if (tmp != null) {
                    System.out.print("hijo: " + tmp.getNum());
                    System.out.println(" ");
                }
            }
        }
        System.out.println("DFS ");
        DFSU(0);
        for (int i = 0; i < mat.length; i++) {
            visitado[i] = false;
        }
        System.out.println("BFS ");
        BFSU(0);

    }

}
