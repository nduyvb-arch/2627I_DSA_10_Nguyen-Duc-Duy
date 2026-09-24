import java.util.Scanner;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
public class w3_tailop_25021693 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine();
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('(', 0);
        String ans= "";
        Stack<Character> dau = new Stack<>();
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9' ) ans += s.charAt(i);
            else{
               if(s.charAt(i) == '(')  dau.push(s.charAt(i));
               else if(s.charAt(i) == ')') {
                   while (!dau.isEmpty() && dau.peek() != '(') {
                       ans += dau.pop();
                   }
                   if (!dau.isEmpty() && dau.peek() == '(') dau.pop();
               }
               else if (priority.containsKey(s.charAt(i))){
                       while (!dau.isEmpty() && priority.get(dau.peek()) >= priority.get(s.charAt(i))) {
                           ans += dau.pop();
                       }
                       dau.push(s.charAt(i));
                   }
               }
            }
        while(!dau.isEmpty()){
            ans += dau.pop();
            }
        System.out.print(ans);

        }
}