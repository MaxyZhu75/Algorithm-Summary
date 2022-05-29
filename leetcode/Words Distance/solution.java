class Solution { // 进阶：如果寻找过程会重复多次，且每次寻找的单词不同，则可以维护一个哈希表记录每个单词的下标列表，然后双指针遍历所查两个单词的下标链表！！！
    public int findClosest(String[] words, String word1, String word2) { // 常数空间一次遍历！！！
        int n = words.length;
        int result = n;
        int previous1 = -1, previous2 = -1; // 记录已经遍历的单词中，最后一次出现的word1与word2的下标！！！
        for (int i=0; i<n; i++) {
            if (words[i].equals(word1)) { // case1：遇到word1，更新previous1的值！！！
                previous1 = i;
            } else if (words[i].equals(word2)) { // case2：遇到word2，更新previous2的值！！！
                previous2 = i;
            }
            if (previous1 >= 0 && previous2 >= 0) { // 每次循环都需要更新result！！！
                result = Math.min(result, Math.abs(previous1 - previous2));
            }
        }
        return result;
    }
}