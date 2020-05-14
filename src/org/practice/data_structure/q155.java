package org.practice.data_structure;

public class q155 {
    /*
    Time Complexity: All operations O(1)
    Space Complexity: O(N)
     */
    class MinStack {

        Deque<ArrayList<Integer>> dq;
        /** initialize your data structure here. */
        public MinStack() {
            dq = new ArrayDeque<>();
        }

        public void push(int x) {
            if(dq.isEmpty()) dq.offerLast(makeList(x, x));
            else {
                ArrayList<Integer> top = dq.peekLast();
                int min = top.get(1);
                dq.offerLast(makeList(x, Math.min(x, min)));
            }
        }

        public void pop() {
            dq.pollLast();
        }

        public int top() {
            ArrayList<Integer> top = dq.peekLast();
            return top.get(0);
        }

        public int getMin() {
            ArrayList<Integer> top = dq.peekLast();
            return top.get(1);
        }

        public ArrayList<Integer> makeList(int a, int b) {
            return new ArrayList<Integer>(Arrays.asList(a, b));
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
