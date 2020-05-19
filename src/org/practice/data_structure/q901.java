package org.practice.data_structure;

public class q901 {

    /*
    Time Complexity: O(Q)
    Space Complexity: O(Q)
    Q is number of calls to StockSpanner.next
     */

    class StockSpanner {
        Stack<Integer> prices, weights;

        public StockSpanner() {
            prices = new Stack();
            weights = new Stack();
        }

        public int next(int price) {
            int w = 1;
            while (!prices.isEmpty() && prices.peek() <= price) {
                prices.pop();
                w += weights.pop();
            }

            prices.push(price);
            weights.push(w);
            return w;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

// 100 80 60 70 60 75 85
//  0  1  2  3  4  5  6
// -1  0  1  1  3  1  0

// 31 41 48 59 79
//  0  1  2  3  4
// -1 -1 -1 -1 -1
}
