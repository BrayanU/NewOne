/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication32;

/**
 *
 * @author buseche
 */
public class vertice {

    private int num;
    private vertice apuntador = null;

    public vertice(int n) {
        this.num = n;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public vertice getApuntador() {
        return apuntador;
    }

    public void setApuntador(vertice apuntador) {
        this.apuntador = apuntador;
    }

}
