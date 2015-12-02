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
            
            for (int i = 0; i < nodos.size(); i++) {
                nodos.get(i).setID(i);
            }
            
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
     
    public ArrayList<Arista> summonDijkstra(int ORIGIN,  int DESTINY){
        ArrayList<Boolean> permanents= new ArrayList();
        ArrayList<Integer> dijkstraNumber = new ArrayList();
        ArrayList<ArrayList<Arista>> dijkstraPath = new ArrayList();
        ArrayList<Node> otherPermanents = new ArrayList();
        Node origin = nodos.get(ORIGIN);
        Node destiny = nodos.get(DESTINY);
        
        for (int i = 0; i < nodos.size(); i++) {
            permanents.add(false);
            dijkstraNumber.add(Integer.MAX_VALUE);
            dijkstraPath.add(new ArrayList());
        }
        
        permanents.set(ORIGIN, true);
        dijkstraNumber.set(ORIGIN, 0);
        otherPermanents.add(origin);
        
        
        while(nodos.size() > otherPermanents.size()){
            int num_temp = nodos.indexOf(otherPermanents.get(otherPermanents.size()-1));
            Node temp = nodos.get(num_temp);
            for (int i = 0; i < temp.getAristas().size(); i++) {
                for (int j = 0; j < permanents.size(); j++) {
                    int num_nodofinal = nodos.indexOf(temp.getAristas().get(i).getNodoFinal());
                    if ((!permanents.get(j)) && nodos.get(num_nodofinal) != nodos.get(j)) {
                        if(temp.getAristas().get(i).getDistancia() + dijkstraNumber.get(num_temp) < dijkstraNumber.get(num_nodofinal)){
                            dijkstraNumber.set(num_nodofinal, (int)(temp.getAristas().get(i).getDistancia() + dijkstraNumber.get(num_temp)));
                            dijkstraPath.set(num_nodofinal, dijkstraPath.get(num_temp));
                            dijkstraPath.get(num_nodofinal).add(temp.getAristas().get(i));
                        }
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < permanents.size(); i++) {
                if (!permanents.get(i)) {
                    if (dijkstraNumber.get(i) < min) {
                        min = dijkstraNumber.get(i);
                        num_temp = i;
                    }
                }
            }
            permanents.set(num_temp, true);
            otherPermanents.add(nodos.get(num_temp));
        }
        
        return dijkstraPath.get(DESTINY);
    }

    public ArrayList<Node> getNodos() {
        return nodos;
    }

    public void setNodos(ArrayList<Node> nodos) {
        this.nodos = nodos;
    }
     
     
}
