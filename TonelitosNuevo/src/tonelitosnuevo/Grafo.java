/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tonelitosnuevo;

import java.util.ArrayList;

/**
 *
 * @author rick
 */
public class Grafo {
    
    private ArrayList<Node> nodos = new ArrayList();
    
    public Node First(Node vertex){
        if (nodos.get(vertex.getID()).getAristas().get(0).getNodoFinal() == null
                || nodos.get(vertex.getID()).getAristas().get(0).getNodoFinal()== vertex){
            System.err.println("No hay nodos adyacentes/ el nodo adyacente es el mismo");
            return null;
        }
        return nodos.get(vertex.getID()).getAristas().get(0).getNodoFinal();    
    }
    
    public Node getVertex(Node vertex, int posicion){
         int nodeIndex = -1;

        for (int i = 0; i < nodos.size(); i++) {
            if (vertex.getID() == nodos.get(i).getID()) {
                nodeIndex = nodos.get(i).getAristas().get(posicion).getNodoFinal().getID();
                break;
            }
        }
        if (nodeIndex == -1) {
            System.err.println("Index out of bounds");
            return null;
        }
        // el -1 se aplica si se empieza con ID 1 y no con ID 0
        return nodos.get(nodeIndex - 1);
    }
    
    public void addVertex(Node vertex) {
        nodos.get(nodos.size() - 1).setNext(vertex);
    }
    
     public void addEdge(Node vertex, Arista edge) {

        for (int i = 0; i < nodos.size(); i++) {
            if (vertex.getID() == nodos.get(i).getID()) {
                nodos.get(i).getAristas().add(edge);
                break;
            }
        }
    }
     
     
    public void removeVertex(int posicion) {
        int nodeIndex = -1;

        for (int i = 0; i < nodos.size(); i++) {
            if (nodos.get(posicion).getID() == nodos.get(i).getID()) {
                nodeIndex = i;
                break;
            }
        }

        if (nodeIndex != -1) {
            for (int i = 0; i < nodos.size(); i++) {
                for (int j = 0; j < nodos.get(i).getAristas().size(); j++) {
                    if ( nodos.get(i).getAristas().get(j).getNodoFinal().getID()
                            == nodos.get(nodeIndex).getID()
                            || nodos.get(i).getAristas().get(j).getNodoInicial().getID()
                            == nodos.get(nodeIndex).getID()) {
                        removeEdge(nodos.get(nodeIndex),  nodos.get(i).getAristas().get(j));
                    }
                }
            }
            nodos.remove(nodeIndex);
            /*
            for (int i = 0; i < nodos.size(); i++) {
                nodos.get(i).setID(i);
            }
            */
        } else {
            System.err.println("Index out of bounds");
        }
    }
     
     
     
     
     
     public void removeEdge(Node vertex, Arista edge) {

        for (int i = 0; i < nodos.size(); i++) {
            if (vertex.getID() == nodos.get(i).getID()) {
                for (int j = 0; j < nodos.get(i).getAristas().size(); j++) {
                    if ( nodos.get(i).getAristas().get(j).getNodoInicial().getID()
                            == edge.getNodoInicial().getID()
                            &&  nodos.get(i).getAristas().get(j).getNodoFinal().getID()
                            == edge.getNodoFinal().getID()) {

                        nodos.get(i).getAristas().remove(j);
                        break;

                    }
                }
                        
            }
        }
    }

    public ArrayList<Node> getNodos() {
        return nodos;
    }

    public void setNodos(ArrayList<Node> nodos) {
        this.nodos = nodos;
    }
     
     
}
