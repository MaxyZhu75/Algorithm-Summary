class Solution {
    public String longestDiverseString(int a, int b, int c) { // 贪心 + 数组动态排序（实现堆PriorityQueue的功能）！！！
        int[][] letters = {{'a', a}, {'b', b}, {'c', c}}; // int类型数组存储字符和字符剩余数量！！！
        StringBuilder sb = new StringBuilder();
        while (true) { // 贪心地优先添加剩余数量最多的字符！！！
            Arrays.sort(letters, (o1, o2) -> o2[1]-o1[1]); // 每次循环都要先按剩余数量由大到小排序！！！
            if (letters[0][1] == 0) {
                break; // 出口一：所有字符使都用完了，返回最长快乐字符串！！！
            }
			int k = sb.length();
            if (k >= 2 && sb.charAt(k-1) == letters[0][0] && sb.charAt(k-2) == letters[0][0]) { // case1：结尾即将连续出现三个相同字符！！！
                if (letters[1][1] == 0) {
                    break; // 出口二：仅剩最多的字符，跳出循环返回（此时已是尽可能长的快乐字符串）！！！
                } 
                sb.append((char)letters[1][0]); // 拼接次多的字符！！！
                letters[1][1]--;
            } else { // case2：其余情况均贪心地拼接最多的字符即可！！！
                sb.append((char)letters[0][0]);
                letters[0][1]--;
            }
        }
        return sb.toString();
    }
}