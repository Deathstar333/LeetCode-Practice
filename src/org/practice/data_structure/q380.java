package org.practice.data_structure;

public class q380 {

    /*
    Time Complexity: All functions avg O(1)
    Space Complexity: O(N)
     */
    class RandomizedSet {

        List<Integer> arr;
        Map<Integer, Integer> map;
        int len;
        Random rand;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            arr = new ArrayList<>();
            map = new HashMap<>();
            len = 0;
            rand = new Random();

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)) return false;

            arr.add(val);
            map.put(val, len);
            len++;
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;

            int index = map.get(val);
            int lastElem = arr.get(len-1);

            int temp = arr.get(index);
            arr.set(index, lastElem);
            arr.set(len-1, temp);
            len--;
            arr.remove(len);

            map.put(lastElem, index);
            map.remove(val);

            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int randIndex = rand.nextInt(len);
            return arr.get(randIndex);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
