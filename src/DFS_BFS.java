

// DFS 와 BFS 는 "그래프 , 트리" (트리 그래프의 일종) 에서 노드를 탐색하기위한 탐색 알고리즘이다.
// DFS 는 Depth First Search 로 그래프의 깊이를 우선적으로 탐색한다.
// BFS 는 Breadth First Search 로 그래프의 넓이 를 우선적으로 탐색한다.

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class DFS_BFS {

    // DFS 는 시작 기준으로 깊게 탐색한다.
    // 인접리스트를 기준으로 DFS 한다고 가정
    // 재귀함수를 사용해서 해당 노드가 연결되어있는 끝 노드까지 탐색한다.


    static void DFS(int startNode, Graph.AdjacencyClass adj){

        Stack<Integer> stack = new Stack<>();

        boolean[] isVisited = new boolean[4];


        // 처음 DFS 순회할때 스타트 노드 체크하고 값 넣어준다.
        isVisited[startNode] = true;
        stack.push(startNode);

        // 콜바이 레퍼런스로 값 넘겨준다.
        DFSRecursion(startNode, adj, stack, isVisited);

        diaplayBFSDFS(stack);

    }

    static void DFSRecursion(int currNode, Graph.AdjacencyClass adj, Stack<Integer> stack, boolean[] isVisited){

        Iterator<Integer> list = adj.adjacency[currNode].listIterator();

        // hasNext 는 다음 값이 있는지 확인하고,next method 하나씩 값 가져온다.
        while(list.hasNext()){

            int currEl = list.next();
            System.out.println("curr element : " + currEl);
            if(!isVisited[currEl]){
                isVisited[currEl] = true;
                stack.push(currEl);

                // 계속해서 다음값으로 재귀함수 돌려준다.
                DFSRecursion( currEl, adj, stack, isVisited);
            }

        }

    }

    //BFS 는 시작점을 기준으로 넓게 탐색한다.

    // linked List 메소드 정리
    // get(int index) - Returns the element at the specified position in this list.
    //

    static void BFS(int startNode, Graph.AdjacencyClass adj){

        //자바에서 불린값은 기본적으로 false 값으로 초기화된다.

        boolean[] isVisited = new boolean[4];
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        queue.add(startNode);
        isVisited[startNode] = true;

        stack.push(startNode);

//
//        Iterator<Integer> list = adj.adjacency[0].listIterator();
//
//        while(list.hasNext()){
//
//            System.out.println(list.next());
//        }

        while(queue.size() != 0){

            int currQueue = queue.poll();

            Iterator<Integer> list = adj.adjacency[currQueue].listIterator();

            while(list.hasNext()){

                int currNum = list.next();

                if(!isVisited[currNum]){
                    stack.push(currNum);
                    isVisited[currNum] = true;
                    queue.add(currNum);
                }

            }

        }
        diaplayBFSDFS(stack);
    }

    //static 함수의 차이점
    static void diaplayBFSDFS(Stack<Integer> stack){

        String values = Arrays.toString(stack.toArray());
        System.out.println(values);

    }


    public static void main(String[] args) {

        // 앞에서 했던 graph 를 기준으로 DFS /BFS 탐색을 해봄
        Graph.AdjacencyClass graph = new Graph.AdjacencyClass(4);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);


        // 클레스에대한 질문 - 다른 파일에서 사용하는 클레스를 가져와서 타입 그대로 사용할 수 있는지?
//        BFS(2, graph);

        DFS(2, graph);

    }

}

// 0 - 1 -2
// 1 - 2
// 2 - 0 -3
// 3 - 3


