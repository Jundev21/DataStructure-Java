

//배열은 선형형태의 자료구조로 모든언어에서 그렇듯 가장 기본적인 데이터 구조이다
//배열 선언 초기화방법
//배열은 선언할때 타입 [] 이름 으로 선언하고
//초기화할때 {} 안에 넣어 초기화를 하거나
//new 타입[사이즈] 로 작성하여 초기화한다.


import java.util.Scanner;


public class Array {

    public static void main(String[] args) {

        int size = 5;
        int [] arr = new int[size];
        Scanner input = new Scanner(System.in);

        for(int i=0; i<size; i++){
            arr[i] = input.nextInt();
        }

        for(int curr : arr){
            System.out.println(curr);
        }

    }
}
