/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tonelitosnuevo;

/**
 *
 * @author rick
 */
public class Arista {
    
    private long distancia;
    private Node nodoInicial;
    private Node nodoFinal;
    private int inicial;
    private int finall;

    public Arista(long distancia, Node nodoInicial, Node nodoFinal) {
        this.distancia = distancia;
        this.nodoInicial = nodoInicial;
        this.nodoFinal = nodoFinal;
    }

    public Arista(long distancia, int inicial, int finall) {
        this.distancia = distancia;
        this.inicial = inicial;
        this.finall = finall;
    }

    public int getInicial() {
        return inicial;
    }

    public void setInicial(int inicial) {
        this.inicial = inicial;
    }

    public int getFinall() {
        return finall;
    }

    public void setFinall(int finall) {
        this.finall = finall;
    }
    
    public long getDistancia() {
        return distancia;
    }

    public void setDistancia(long distancia) {
        this.distancia = distancia;
    }

    public Node getNodoInicial() {
        return nodoInicial;
    }

    public void setNodoInicial(Node nodoInicial) {
        this.nodoInicial = nodoInicial;
    }

    public Node getNodoFinal() {
        return nodoFinal;
    }

    public void setNodoFinal(Node nodoFinal) {
        this.nodoFinal = nodoFinal;
    }
    
    
    
    
}
