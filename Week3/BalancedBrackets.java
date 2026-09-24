package Week3;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public boolean check(String s){
        Map<Character, Character>mp= new HashMap<Character, Character>();
        Stack<Character>st = new Stack<>();
        mp.put('(', ')');
        mp.put('[', ']');
        mp.put('{', '}');

        for(int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') st.push(s.charAt(i));
            else {
                if (st.isEmpty() || mp.get(st.pop()) != s.charAt(i)) return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        BalancedBrackets bb = new BalancedBrackets();
        if(bb.check(s)) System.out.print("Chuoi ngoac hop le");
        else System.out.print("Chuoi ngoac khong hop le");
    }
}

