package Week3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String ans = "";
        Map<Character, Integer> priority = new HashMap<>();
        Stack<Character>st = new Stack<>();

        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('(', 0);

        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') ans += s.charAt(i);
            else{
                if(s.charAt(i) == '(')  st.push(s.charAt(i));
                else if(s.charAt(i) == ')'){
                    while(!st.isEmpty() && st.peek() != '('){
                        ans += st.pop();
                    }
                    if(!st.isEmpty() && st.peek() == '(') st.pop();
                }
                else if(priority.containsKey(s.charAt(i))){
                    while(!st.isEmpty() && priority.get(s.charAt(i)) <= priority.get(st.peek())){
                        ans += st.pop();
                    }
                    st.push(s.charAt(i));
                }

            }
        }
    while(!st.isEmpty()) ans += st.pop();
    System.out.print(ans);



    }
}
