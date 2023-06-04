

//힙은 최솟값과 최대값을 효율적이게 추출하기 위해 만들어진 자료구조이다.
// 완전 이진트리의 형태를 갖고있으며 최대값과 최소값을 찾는 시간은 O(1) 이며 재 정렬 시간복잡도는 Ologn 을 갖는다.
// 힙은 순회할때 층단위로 왼쪽에서부터 오른쪽으로 순회되는데 일차 배열로 구현된다.

// 힙 구현

// 힙 삭제 / 추가

// 1. 삽입 은 트리의 마지막 , 완전이진트리이므로 가장 오른쪽 노드에 추가된다.
// 이후 각 부모노드와 계속해서 비교해 가며 위치가 변경된다.
// 2. 삭제 는 루트 노드에서 삭제가 되고 마지막 노드로 교환이된다. 그후 루트노드에서 자식들을 비교해서 교체한다.


// (i-1)/2	부모노드
// (2*i)+1	왼쪽자식
// (2*i)+2	오른쪽 자식

//ㄴ


public class Heap {

    static public class MaxHeap{

        int[] maxHeap = null;
        int heapSize = 0;


        MaxHeap (int size){

            heapSize = 0;
            maxHeap = new int[size];

        }


        //노드는 항상 마지막 노드에 추가되고 추가 된 후에 재정렬한다.
        public void insertValue(int data){

            if(maxHeap.length -1  < heapSize) {
                System.out.println("over size");
                return;
            }

            maxHeap[++heapSize] = data;


            heapIfy();

        }


        //추가된 데이터 정렬 함수
        //데이터가 추가되면 해당 부모노드부터 루트노트까지 비교해야한다.
        public void heapIfy(){
            int pointLastEl = heapSize;


            while(pointLastEl > 1 && maxHeap[pointLastEl] > maxHeap[(pointLastEl-1)/2]){


                int tempLastEl = maxHeap[heapSize];
                int tempParentEl = maxHeap[(heapSize-1)/2];

                maxHeap[(heapSize-1)/2] = tempLastEl;
                maxHeap[heapSize] = tempParentEl;

                pointLastEl =  pointLastEl/2;
            }



        }


        public void findMaxValue(){

            System.out.println(maxHeap[0]);

//            heapIfy();


        }

        public void displayHeap(){
            for(int i=0; i<heapSize; i++){

                System.out.println(maxHeap[i]);

            }
        }

    }







    public static void main(String[] args) {



        MaxHeap startHeap = new MaxHeap(10);

        startHeap.insertValue(1);

        startHeap.insertValue(2);

        startHeap.insertValue(3);

        startHeap.insertValue(4);

        startHeap.insertValue(5);

        startHeap.displayHeap();











    }
}
