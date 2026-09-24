
package Week3;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;

public class EqualStacks {

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();

        for(int i = h1.size() - 1; i >= 0; i --){
            if(!st1.isEmpty()) st1.push(st1.peek() + h1.get(i));
            else st1.push(h1.get(i));
        }
        for(int i = h2.size() - 1; i >= 0; i --){
            if(!st2.isEmpty()) st2.push(st2.peek() + h2.get(i));
            else st2.push(h2.get(i));
        }
        for(int i = h3.size() - 1; i >= 0; i --){
            if(!st3.isEmpty()) st3.push(st3.peek() + h3.get(i));
            else st3.push(h3.get(i));
        }

        while(!st1.empty() && !st2.empty() && !st3.empty()){
            int t1 = st1.peek(), t2 = st2.peek(), t3 = st3.peek();
            if (t1 == t2 && t2 == t3)  return st1.peek();

            if(t1 >= t2 && t1 >= t3) st1.pop();
            else if(t2 >= t1 && t2 >= t3) st2.pop();
            else st3.pop();
        }
        return 0;
    }
}

