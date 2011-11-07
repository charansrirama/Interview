package th.graph;

public class Dijkstra {
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');//0
        theGraph.addVertex('B');//1
        theGraph.addVertex('C');//2
        theGraph.addVertex('D');//3
        theGraph.addVertex('E');//4

        theGraph.addOneEdge(0, 1, 50);//AB 50
        theGraph.addOneEdge(0, 3, 80);//AD 80
        theGraph.addOneEdge(1, 2, 60);//BC 60
        theGraph.addOneEdge(1, 3, 90);//BD 90
        theGraph.addOneEdge(2, 4, 40);//CE 40
        theGraph.addOneEdge(3, 2, 20);//DC 20
        theGraph.addOneEdge(3, 4, 70);//DE 70
        theGraph.addOneEdge(4, 1, 50);//EF 50
       
        System.out.println("Dijkstra: ");
        theGraph.dijkstra();
    }

}
