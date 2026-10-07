package Week4;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class H_index {
    public static int solve(int[] a, int n){
        int l = 1, r = n, ans = 1;
        while(l <= r){
            int m = (l + r) / 2;
            if(a[n - m] >= m){
                ans = m;
                l = m + 1;

            }
            else r = m - 1;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i ++) a[i] = sc.nextInt();
        Arrays.sort(a);
        System.out.print(solve(a, n));
    }
}