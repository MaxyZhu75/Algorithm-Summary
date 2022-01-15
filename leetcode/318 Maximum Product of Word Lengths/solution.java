class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] wordBits = new int[n]; // 注意此处需用数组存储！！！
        for (int i=0; i<n; i++){
            for(char letter : words[i].toCharArray()){ // 每个单词为String字符串，要遍历各个单词中的字母需要使用toCharArray()！！！
                wordBits[i] |= 1<<(letter-'a'); // 技巧：小写字母-‘a’后变为数字，不同字母对1的左移各不相同；可用“|”或运算记录每个字母的出现！！！
            }
        }

        int maxLen = 0;
        for (int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if ((wordBits[i]&wordBits[j]) == 0){ // 注意若不加括号则优先算后面wordBits[j]==0，整个条件则报错！！！
                  maxLen = Math.max(maxLen, words[i].length()*words[j].length());  
                }
            }
        }
        return maxLen;
    }
}