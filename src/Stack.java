import jdk.dynalink.beans.StaticClass;

public class Stack {


    static public class StackClass {


        int[] arr = null;
        int top = 0;


        StackClass(int size) {

            this.arr = new int[size];


        }


        public void push(int data) {
            if (top == arr.length) {

                System.out.println("stack overflow");

            } else {

                arr[top + 1] = data;
                top++;

            }
        }

        public void pop() {

            if (top == -1) {
                System.out.println("it is empty");
            } else {

                arr[top - 1] = 0;

                top--;
            }

        }

        public void printNode() {


            for (int i = 0; i < top; i++) {
                System.out.println(arr[i]);
            }


        }

        public boolean isEmpty() {

            if (top == -1) {
                return true;
            } else {
                return false;
            }
        }

        public void findPeek() {

            if (!isEmpty()) {
                System.out.println(top);
            }

        }
    }


    public static void main(String[] args) {

        StackClass makeStack = new StackClass(100);

        makeStack.push(1);
        makeStack.push(2);
        makeStack.push(3);
        makeStack.push(4);
        makeStack.push(5);

        makeStack.printNode();

        makeStack.findPeek();


    }


}
