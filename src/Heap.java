

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


        //노드는 항상 마지막 노드에 추가되고 추가 된 후에 재정렬한다.3
        public void insertValue(int data){

            if(maxHeap.length -1  < heapSize) {
                System.out.println("over size");
                return;
            }

            maxHeap[heapSize] = data;

            int pointTreeHeight = heapSize;

            while(maxHeap[pointTreeHeight] > maxHeap[(pointTreeHeight-1)/2]){

                int tempLastEl = maxHeap[pointTreeHeight];
                int tempParentEl = maxHeap[(pointTreeHeight-1)/2];

                maxHeap[(pointTreeHeight-1)/2] = tempLastEl;
                maxHeap[pointTreeHeight] = tempParentEl;

                pointTreeHeight =  (pointTreeHeight-1)/2;

            }

            heapSize++;
        }


        public void extractMaxEl(){

            int maxEl = maxHeap[0];

            maxHeap[0] = maxHeap[heapSize-1];

            heapSize--;

            System.out.println("Max Num" + maxEl);

            heapIfyDown(maxHeap,0);

        }


        // 추가된 데이터 힙으로 재정렬

        public void heapIfyDown( int[] maxHeap, int parentIdx){

            int parentNode = parentIdx;
            int leftNode = leftNode(parentIdx);
            int rightNode = rightNode(parentIdx);



            // 만약 부모노드의 차일드보다 큰경우
            if(maxHeap[parentNode] < maxHeap[leftNode]){

                parentNode = leftNode;

            } else if(maxHeap[parentNode] < maxHeap[rightNode]){

                parentNode = rightNode;

            }

            //자식 노드가 부모노드보다 커서 스왑이 필요한상태.

            if(parentNode != parentIdx){

                System.out.println("Swap" +  maxHeap[parentNode] + " " + maxHeap[leftNode] );

                int tempNode = maxHeap[parentIdx];

                maxHeap[parentIdx] = maxHeap[leftNode];
                maxHeap[leftNode] = tempNode;


                heapIfyDown(maxHeap, parentNode);

            }


        }


        void max_heapIfy(int[] a,int i)
        {

            // left index not a left value;
            int l=2*i+1;

            // right index
            int r=2*i+2;

            // largest index
            int largest=i;
            if(l<heapSize &&a[l]>a[largest])
                largest=l;
            if(r<heapSize &&a[r]>a[largest])
                largest=r;

            // largest index is left node or right node
            if(largest!=i)
            {
                int t=a[i];
                a[i]=a[largest];
                a[largest]=t;
                max_heapIfy(a,largest);
            }

        }


        public int parentsNode(int data){

            return (data-1)/2;

        }

        public int leftNode(int data){

            return (2 * data) + 1;
        }


        public int rightNode(int data){

            return (2 * data) + 2;
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

        startHeap.extractMaxEl();

//        startHeap.displayHeap();

        startHeap.extractMaxEl();
        startHeap.displayHeap();









    }
}
