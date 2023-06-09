
// 트리와 그래프의 공통점은 비선형 데이터 구조로 서로 노드끼리 연결되어있다는 점이다.

// 차이점은 트리는 부모노드와 자식노드간의 관계로 계층구조 형태를 보이지만,
// 그래프는 단지 하나의 노드와 하나의 엣지로 구성되어있다. 그렇기떄문에 전체 노드를 한번에 순회(사이클) 할 수 있다.
//트리는 그래프의 한 종류이다.
// 그래프 자료구조를 사용해야할 경우는 주로 노드끼리의 연관성에서 최단거리를 찾을때 사용한다.
// 인접행렬과 인접리스트를 사용하여 그래프를 구현할 수 있다.
// 인접행렬은 이차원 배열을 사용하고 인접리스트는 노드형태로 구현한다.


import java.util.*;
public class Graph {


    public static class MatrixClass{

        int[][] matrix = null;
        int size = 0;

        MatrixClass(int size){

            this.size = size;
            matrix = new int[size][size];

        }


        void connectEdge(int start, int end){

            matrix[start][end] = 1;
            matrix[end][start] = 1;

        }

        void disconnectEdge(int start, int end){

            matrix[start][end] = 0;
            matrix[end][start] = 0;


        }

        void display(){

            for(int i=0; i<size; i++){

                    System.out.println("Element at index "+i+": "+Arrays.toString(matrix[i]));



            }

        }




    }



    public static class AdjacencyClass{
        int vertex = 0;
        LinkedList<Integer> adjacency[] = null;

        AdjacencyClass(int vertexSize){
            this.vertex = vertexSize;

            adjacency = new LinkedList[vertexSize];

            for(int i =0; i<vertexSize; i++){

                adjacency[i] = new LinkedList<>();
            }

        }

        void addEdge(int start, int end){

            adjacency[start].add(end);

        }

        void displayEl(){

            for(int i=0; i<vertex; i++){

                System.out.println("Element at index "+i+": "+adjacency[i]);

            }
        }
    }

    public static void main(String[] args) {

        AdjacencyClass graph = new AdjacencyClass(4);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);

//        graph.displayEl();


        MatrixClass matrix = new MatrixClass(4);

        matrix.connectEdge(0,1);
        matrix.connectEdge(0,2);
        matrix.connectEdge(1,2);
        matrix.connectEdge(2,0);
        matrix.connectEdge(2,3);
        matrix.connectEdge(3,3);

        matrix.display();


    }


}