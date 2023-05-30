

// 큐

public class Queue {

    static public class QueueClass{
        int[] arr = null;
        int top = 0;
        int size =0;


        QueueClass(int size){
            this.arr = new int[size];

        }


        public void enqueue(int data){


            if(size > arr.length-1) {
                System.out.println("Queue overflow");
            }else{

            this.arr[size++] = data;
            }

        }


        public void dequeue(){

            System.out.println("dequque data" + this.arr[top]);

            this.arr[top] = 0;

            top+=1;

        }

        public void display(){

            for(int curr : arr){
                System.out.println("curr items : " + curr);
            }
        }

    }





    public static void main(String[] args) {

        QueueClass queue = new QueueClass(10);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);



        queue.dequeue();
        queue.dequeue();
        queue.display();




    }


}
