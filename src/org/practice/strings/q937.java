package org.practice.strings;

public class q937 {
    /*
    Time Complexity: O(NlogN * avg_len_of_string)
    Space Complexity: O(1);
     */

    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            Arrays.sort(logs, new MyComp());
            return logs;
        }

        public class MyComp implements Comparator<String> {

            public int compare(String str1, String str2) {
                String[] l1 = str1.split(" ");
                String[] l2 = str2.split(" ");
                String iden1 = l1[0];
                String iden2 = l2[0];
                String word1 = l1[1];
                String word2 = l2[1];
                if(Character.isDigit(word1.charAt(0)) && Character.isDigit(word2.charAt(0))) {
                    return 0;
                }
                else if(Character.isDigit(word1.charAt(0))) {
                    return 1;
                }
                else if(Character.isDigit(word2.charAt(0))) {
                    return -1;
                }
                else {

                    int len1 = l1.length;
                    int len2 = l2.length;
                    int flag = 0;
                    if(len1 != len2)
                        flag = 1;
                    int len = Math.min(len1, len2);
                    for(int i=1; i<len; i++) {
                        word1 = l1[i];
                        word2 = l2[i];
                        if(word1.compareTo(word2) != 0)
                            return word1.compareTo(word2);
                    }
                    if(flag == 1)
                        return len1 - len2;
                    return iden1.compareTo(iden2);
                }
            }
        }
    }
}
