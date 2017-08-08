package nowCoder;
import java.util.Stack;

public class MinStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(int node) {
        if(stack2.empty()) {
            stack2.push(node);
        }else {
            if(node<=stack2.peek()) {
                stack2.push(node);
            }else {
                stack2.push(stack2.peek());//保留每一次入栈时那个状态下栈的最小值.
            }
        }
        stack1.push(node);
    }
    
    public void pop() {
        stack1.pop();
        stack2.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int min() {
        return stack2.peek();
    }
}
