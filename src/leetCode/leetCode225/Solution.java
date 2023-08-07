class MyStack {
    private static Queue<Integer> in;
    private static Queue<Integer> temp;
    public MyStack() {
        in = new LinkedList<>();
        temp = new LinkedList<>();
    }
    
    public void push(int x) {
        in.add(x);
    }
    
    public int pop() {
        while(in.size() > 1){
            temp.add(in.poll());
        }

        int ans = in.poll();

        while(!temp.isEmpty()){
            in.add(temp.poll());
        }

        return ans;
    }
    
    public int top() {
        while(in.size() > 1){
            temp.add(in.poll());
        }

        int ans = in.poll();

        while(!temp.isEmpty()){
            in.add(temp.poll());
        }

        in.add(ans);

        return ans;
    }
    
    public boolean empty() {
        return in.isEmpty();   
    }
}
