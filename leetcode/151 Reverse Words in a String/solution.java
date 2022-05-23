class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();                           // 步骤一：trim()将字符串首尾空格去除！！！
        String[] words = s.split("\\s+");       // 步骤二：分割字符串并且将单词间多余空格擦除！！！
        for(int i=words.length-1; i>=0; i--) {  // 步骤三：从后向前添加单词到sb中！！！
            sb.append(words[i]);
            if (i != 0) sb.append(' ');
        }
        return sb.toString();
    }
}