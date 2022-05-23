class Solution {
    public String reverseWords(String s) { // 对于字符串不可变的语言，需要把字符串转化成其他可变的数据结构，如StringBuilder！！！
        StringBuilder sb = trimSpaces(s);  // 步骤一：实现trim()将首尾空格去除，并且将单词间多余空格擦除！！！
        reverse(sb, 0, sb.length() - 1);   // 步骤二：反转整个字符串！！！
        reverseEachWord(sb);               // 步骤三：将空格隔开的各个单词内部自己反转！！！
        return sb.toString();
    }

    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1; // 定义左右指针指针！！！

        while (left <= right && s.charAt(left) == ' ') { // 去掉字符串开头的空白字符！！！
            left++;
        }

        while (left <= right && s.charAt(right) == ' ') { // 去掉字符串末尾的空白字符！！！
            right--;
        }

        StringBuilder sb = new StringBuilder(); // 注意返回的是StringBuilder；将字符串间多余的空白字符去除！！！
        while (left <= right) {
            char letter = s.charAt(left);
            if (letter != ' ') {
                sb.append(letter);
            } else if (sb.charAt(sb.length() - 1) != ' ') { // 检查是否是连续空格！！！
                sb.append(letter);
            }
            left++;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right)); // StringBuilder.setCharAt()！！！
            sb.setCharAt(right--, temp);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverse(sb, start, end-1); // 传入单词的开头与末尾下标！！！
            end++;
			start = end;
        }
    }
}