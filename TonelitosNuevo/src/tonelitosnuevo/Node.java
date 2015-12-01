package tonelitosnuevo;

import java.util.ArrayList;

public class Node {
    
    private Object value;
    private Node next;
    private int ID;
    private Coordenada coordenada;
    private ArrayList<Arista> aristas = new ArrayList();
    private long DijkstraNum = Integer.MAX_VALUE;
    //private List DijkstraPath = new List();


    public Node(Object value) {
        this.value = value;
    }
    
    public Node(Object value, Node next, int ID, Coordenada coordenada) {
        this.value = value;
        this.next = next;
        this.ID = ID;
        this.coordenada = coordenada;
    }

    public Node() {
        value = null;
    }
    
    
    
    public Node(int x, int y){
        value = null;
        this.coordenada = new Coordenada(x,y);
    }

    public Object getValue() {
        return value;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return ""+value;
    }
    public boolean hasNext(){
        if(next != null)
            return true;
        return false;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public long getDijkstraNum() {
        return DijkstraNum;
    }

    public void setDijkstraNum(long DijkstraNum) {
        this.DijkstraNum = DijkstraNum;
    }

    public ArrayList<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(ArrayList<Arista> aristas) {
        this.aristas = aristas;
    }
    
    
    
   

    
    
    
    
    
    
}
