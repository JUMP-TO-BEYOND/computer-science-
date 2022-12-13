package algorithm.sort;

import java.io.*;
import java.util.*;

/*
* 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
* 둘째 줄부터 N개의 줄에는 수가 주어진다.
* 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다.
* 수는 중복되지 않는다.
* -> N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
*/

class QuickSort{
    public void ascendingOrder(int[] array){
        if(array == null)
            return;

        quickSort(0, array.length-1, array);
    }

    private void quickSort(int start, int end, int[] currentArray){
        if(start >= end) return;

        int pivot = patitioning(start, end, currentArray);
        int val = currentArray[pivot];

        int i = start;
        int j = end;
        while(i < j){
            while(currentArray[i] < val) i++;
            while(currentArray[j] > val && j > pivot) j--;
            swap(i, j, currentArray);
        }

        quickSort(start, pivot, currentArray);
        quickSort(pivot, end, currentArray);
    }

    private int patitioning(int start, int end, int[] curentArray){
        Random random = new Random();
        return random.nextInt(end-start)+start;
    }

    private void swap(int index1, int index2, int[] array){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public void printAll(int[] array) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i : array){
            bw.write(i+"/n");
        }
        bw.flush();
        bw.close();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numArray = new int[N];

        for(int i=0; i< N; i++){
            numArray[i] = Integer.parseInt(br.readLine());
        }

        QuickSort qs = new QuickSort();
        qs.ascendingOrder(numArray);
        qs.printAll(numArray);
    }
}
