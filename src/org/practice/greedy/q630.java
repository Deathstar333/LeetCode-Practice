package org.practice.greedy;

public class q630 {
    /*
    Time Complexity: O(N logN)
    Space Complexity: O(N)
     */

    class Solution {
        public int scheduleCourse(int[][] courses) {
            // for(int[] c: courses) System.out.println(Arrays.toString(c));
            // System.out.println("----------");
            Arrays.sort(courses, new myComp());
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new pqComp());
            // for(int[] c: courses) System.out.println(Arrays.toString(c));
            int currDay = 0;
            int count = 0;
            int len = courses.length;
            for(int i=0; i<len; i++) {
                int t = courses[i][0];
                int d = courses[i][1];
                if(currDay + t <= d) {
                    currDay += t;
                    count++;
                    pq.add(courses[i]);
                }
                else if(pq.peek() != null && t < pq.peek()[0]) {
                    int[] r = pq.poll();
                    pq.add(courses[i]);
                    currDay += t-r[0];
                }
            }
            return count;
        }

        class myComp implements Comparator<int[]> {
            public int compare(int[] a, int[] b) {
                int x = (a[1] - b[1]);
                if(x == 0)
                    return a[0] - b[0];
                return x;
            }
        }

        class pqComp implements Comparator<int[]> {
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        }
    }

}
