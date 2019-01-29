package two_queues_stack;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueuesStack<T> {
    private Queue<T> queue1 = new LinkedList<>();
    private Queue<T> queue2 = new LinkedList<>();

    public void push(T node) {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            queue1.offer(node);
        }
        if (!queue1.isEmpty()) {
            queue1.offer(node);
        } else if (!queue2.isEmpty()) {
            queue2.offer(node);
        }
    }

    public T pop() {
        if (!queue1.isEmpty() && queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }

            return queue1.poll();
        } else if (!queue2.isEmpty() && queue1.isEmpty()){
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        } else {
            try {
                throw new Exception("empty stack!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TwoQueuesStack<Integer> stack = new TwoQueuesStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
