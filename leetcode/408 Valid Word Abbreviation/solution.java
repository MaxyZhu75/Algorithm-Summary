class Solution {
    public boolean validWordAbbreviation(String word, String abbr) { // 要点：对数字的处理！！！
        int n = word.length(); 
        int m = abbr.length();
        int pointer = 0; // word中的指针！！！
        int digit = 0; // abbr中的数字！！！

        for (int i=0; i<m; i++) {
            char letter = abbr.charAt(i);
            if (digit == 0 && letter == '0') { // case1：存在前导0；digit等于0说明前一个字符不是数字是字母！！！
                return false;                
            }

            if (letter >= '0' && letter <= '9') { // case2：合理数字；按照如下写法则可以顺利统计多位合理数字！！！
                digit = 10 * digit  + (int)(letter-'0');
            } else { // case3：合理字母！！！
                pointer += digit; // 将word中指针移动，然后digit需要清零！！！
                digit = 0;
                if (pointer >= n || word.charAt(pointer) != letter) { // 指针越界或字母不匹配说明缩写不合理，直接返回！！！
                    return false;
                }
                pointer++;
            }
        }
        return digit == n - pointer; // 缩写末尾的数字并未验证，需要在循环外验证！！！
    }
}