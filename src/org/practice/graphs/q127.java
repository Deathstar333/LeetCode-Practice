package org.practice.graphs;

public class q127 {
    /*
    Time Complexity: O(M^2 * N)
    Space Complexity: O(M^2 * N)
    where M is length of each word and N is length of wordList
     */

    class Solution {
        Map<String, List<String>> wordBuckets;
        Map<String, Boolean> visited;
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            wordBuckets = new HashMap<>();
            visited = new HashMap<>();
            int len = wordList.size();
            if(len == 0) return 0;
            int wordLen = wordList.get(0).length();
            createBuckets(wordList, len, wordLen);
            // System.out.println(wordBuckets.toString());
            int ans = bfs(beginWord, endWord, wordLen);
            return ans;
        }

        public int bfs(String beginWord, String endWord, int wordLen) {
            Deque<Pair<String, Integer>> dq = new ArrayDeque<>();
            dq.add(new Pair(beginWord, 1));
            while(!dq.isEmpty()) {
                Pair<String, Integer> p = dq.poll();
                String word = p.first;
                int level = p.second;
                visited.put(word, true);
                for(int i=0; i<wordLen; i++) {
                    String newWord = word.substring(0,i)+"*"+word.substring(i+1,wordLen);

                    for(String adjacentWord: wordBuckets.getOrDefault(newWord, new ArrayList<String>())) {
                        if(adjacentWord.equals(endWord)) {
                            return level+1;
                        }
                        if(!visited.containsKey(adjacentWord)) {
                            dq.add(new Pair(adjacentWord, level+1));
                        }
                    }
                }
            }
            return 0;
        }


        public void createBuckets(List<String> wordList, int len, int wordLen) {

            for(int i=0; i<len; i++) {
                String str = wordList.get(i);
                for(int j=0; j<wordLen; j++) {
                    String adjacentWord = str.substring(0,j)+"*"+str.substring(j+1, wordLen);
                    List<String> temp = wordBuckets.getOrDefault(adjacentWord, new ArrayList<String>());
                    temp.add(str);
                    wordBuckets.put(adjacentWord, temp);
                }
            }
        }

    }

    class Pair <T1, T2> {
        T1 first;
        T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }
}
