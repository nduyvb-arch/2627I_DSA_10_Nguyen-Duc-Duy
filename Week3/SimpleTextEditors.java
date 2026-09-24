package Week3;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditors {
    private StringBuilder CurrentText;
    private Stack<String> history;

    public SimpleTextEditors() {
       this.CurrentText = new StringBuilder();
       this.history = new Stack<>();
    }

    public void append(String s){
        history.push(CurrentText.toString());
        CurrentText.append(s);
    }
    public void delete (int k ){
        int n = CurrentText.length();
        history.push(CurrentText.toString());
        CurrentText.delete(n - k, n);
    }

    public char print(int k ){
        return CurrentText.charAt(k - 1);
    }

    public void undo(){
        if(!history.isEmpty()){
            CurrentText = new StringBuilder(history.pop());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleTextEditors editor = new SimpleTextEditors();

        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int type = sc.nextInt();

            switch (type) {
                case 1 -> {
                    String s = sc.next();
                    editor.append(s);
                }
                case 2 -> {
                    int k = sc.nextInt();
                    editor.delete(k);
                }
                case 3 -> {
                    int k = sc.nextInt();
                    System.out.println(editor.print(k));
                }
                case 4 -> editor.undo();
            }
        }
        sc.close();
    }
}
