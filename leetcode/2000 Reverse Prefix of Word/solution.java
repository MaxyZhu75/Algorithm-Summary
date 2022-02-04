class Solution {
    public String reversePrefix(String word, char ch) {
        int stopIndex = word.indexOf(ch); // String.indexOf()直接能返回查找字符第一次出现的索引；不存在则返回-1！！！
        char[] letters = word.toCharArray(); // 转为char[]方便反转操作！！！

        if (stopIndex == -1 || stopIndex == 0) {
            return word;
        }

        reverse(letters, stopIndex);
        String result = String.valueOf(letters); // String.valueOf()支持各种类型转String！！！

        return result;
    }


    public void reverse(char[] letters, int stopIndex) {
        int p1 = 0;
        int p2 = stopIndex;
        while (p1 <= p2) {
            char temp = letters[p1];
            letters[p1] = letters[p2];
            letters[p2] = temp;
            p1++;
            p2--;
        }
    }
}