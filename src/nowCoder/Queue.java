package nowCoder;
import java.util.EmptyStackException;
import java.util.Stack;
public class Queue {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	public void push(int node) {
		stack1.push(node);//假设原本就在栈二不用管啊，我空了再让你给我push我不空我就自己pop了
	}
	public int pop() {
		if(stack2.empty()&&stack1.empty()) {
			throw new EmptyStackException();
		}
		if (!stack2.empty()) {
			return stack2.pop();
		} else {
			while (!stack1.empty()) {
				stack2.push(stack1.pop());
			}
			return stack2.pop();
		}
	}
}