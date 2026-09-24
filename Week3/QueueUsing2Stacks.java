package Week3;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsing2Stacks {
    private static Stack<Integer>st1 ;
    private static Stack<Integer>st2;

    public QueueUsing2Stacks(){
        this.st1 = new Stack<>();
        this.st2 = new Stack<>();
    }

    public void Enqueue(int x){
        st1.push(x);
    }

    public void Dequeue(){
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        st2.pop();
    }

    public void print(){
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        if(!st2.empty()) System.out.println(st2.peek());
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        QueueUsing2Stacks qs = new QueueUsing2Stacks();
        int q = sc.nextInt();

        while(q-- > 0){
            int type = sc.nextInt();
            switch (type){
                case 1 ->{
                    int x = sc.nextInt();
                    qs.Enqueue(x);
                }
                case 2 ->{
                    qs.Dequeue();
                }
                case 3 -> {
                    qs.print();
                }
            }
        }
        sc.close();
    }
}
