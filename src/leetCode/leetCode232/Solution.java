package leetCode.leetCode232;

class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> temp;
    public MyQueue() {
        stack = new Stack<>();
        temp = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        while(stack.size() > 1){
            temp.push(stack.pop());
        }
        int ans = stack.pop();
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
        return ans;
    }
    
    public int peek() {
        while(stack.size() > 1){
            temp.push(stack.pop());
        }
        int ans = stack.peek();
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
        return ans;
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}
