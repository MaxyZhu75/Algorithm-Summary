class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        Map<Character, Integer> hashRecord = new HashMap<>(); // 用桶数组计数速度会更快！！！
        
        for (int i=0; i<n; i++) {
            char letter = s.charAt(i);
            hashRecord.put(letter, hashRecord.getOrDefault(letter, 0) + 1);
        }

        int pairs = 0;
        int single = 0;
        for (char key : hashRecord.keySet()) { // 计算成对的对数！！！
            int currentpair = hashRecord.get(key) / 2;
            pairs += currentpair;
        }
        
        if (2*pairs < n) { // 如果成对数量乘2小于原本长度，则说明有落单的字符！！！
            single = 1;
        }

        int result = 2*pairs + single;
        return result;
    }
}