package Week3;

import java.util.Scanner;
import java.util.Stack;

public class EvaluatePostfix {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Integer> so = new Stack<>();

        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') so.push(s.charAt(i) - '0');
            else{
                if(so.size() >= 2){
                    char dau = s.charAt(i);
                    int x = so.pop();
                    int y = so.pop();

                    switch (dau){
                        case '+' :
                            so.push(y + x);
                            break;
                        case '-':
                            so.push(y - x);
                            break;
                        case '*':
                            so.push(x * y);
                            break;
                        case '/':
                            so.push(y / x);
                            break;
                }

                }
            }
        }
    System.out.print(so.peek());
    }
}
