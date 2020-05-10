package org.practice.trees;

public class q208 {
    /*
        Time Complexity:
        insert => O(L) L is length of word
        search => O(L)
        startsWith => O(L) L is length of prefix
     */
    public static class Trie {
        TrieNode root;
        private class TrieNode {
            HashMap<Character, TrieNode> map;
            boolean isWordEnd;

            public TrieNode() {
                this.map = new HashMap<>();
                this.isWordEnd = false;
            }
        }

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            int len = word.length();
            TrieNode curr = root;
            for(int i=0; i<len; i++) {
                char c = word.charAt(i);
                TrieNode next = curr.map.get(c);
                if(next == null) {
                    TrieNode node = new TrieNode();
                    curr.map.put(c, node);
                    curr = node;
                }
                else {
                    curr = next;
                }
            }
            curr.isWordEnd = true;

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            int len = word.length();
            TrieNode curr = root;
            for(int i=0; i<len; i++) {
                char c = word.charAt(i);
                TrieNode next = curr.map.get(c);
                if(next == null) {
                    return false;
                }
                curr = next;
            }
            return curr.isWordEnd;

        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            int len = prefix.length();
            TrieNode curr = root;
            for(int i=0; i<len; i++) {
                char c = prefix.charAt(i);
                TrieNode next = curr.map.get(c);
                if(next == null) {
                    return false;
                }
                curr = next;
            }
            return true;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
}
