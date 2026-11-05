package week7;
import java.io.*;
import java.util.*;
public class JavaStringReverse {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int l = 0, r = A.length() - 1;
        Boolean flag = true;
        while(l <= r){
            if(A.charAt(l) != A.charAt(r)) {
                flag = false;
                break;
            }
            l ++;
            r --;
        }
        if(flag == true) System.out.print("Yes");
        else System.out.print("No");
    }
}
