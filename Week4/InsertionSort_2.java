package Week4;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solve {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */
    public static void printList(int n, List<Integer> arr){
        for(int i = 0; i < n; i ++){
            System.out.print(arr.get(i)+ " ");
        }
        System.out.println();
    }
    public static void insertionSort2(int n, List<Integer> arr) {

        for(int i = 1; i < n ; i ++){
            int j = i - 1;
            int x = arr.get(i);
            while(j >= 0 && arr.get(j) > x){

                arr.set(j + 1, arr.get(j));
                j --;
            }
            arr.set(j + 1, x);
            printList(n, arr);
        }
    }
}

public class InsertionSort_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Solve.insertionSort2(n, arr);

        bufferedReader.close();
    }
}

