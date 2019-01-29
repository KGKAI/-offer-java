package two_stacks_queue;

import java.util.Iterator;
import java.util.Stack;

public class TwoStacksQueue<T> {
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void appendTail(T node) {
        stack1.push(node);
    }

    public T deleteHead() {
        T node;
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty())
            System.out.println("没有元素");
        node = stack2.pop();
        return node;
    }

    public static void main(String[] args) {
        TwoStacksQueue<Integer> queue = new TwoStacksQueue<>();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
