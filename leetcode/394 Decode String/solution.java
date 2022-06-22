class Solution {
    String decodeString(String s) { // 「数字栈」+「字符栈」！！！
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (char letter : s.toCharArray()) {
            if (Character.isDigit(letter)) { // case1：统计数字大小！！！
                k = k * 10 + letter - '0';
            } else if (letter == '[') { // case2：遇见「左括号」则入栈；且需要重置sb与k的内容（sb入栈存的是其地址，内容仍会改变）！！！
                countStack.addFirst(k);
                stringStack.addFirst(sb);
                sb = new StringBuilder();
                k = 0;
            } else if (letter == ']') { // case3：遇见「右括号」则将栈顶sb的内容重复k次并赋给sb！！！
                StringBuilder current = stringStack.removeFirst();
                for (int i=countStack.removeFirst(); i>0; i--) {
                    current.append(sb);
                }
                sb = current;
            } else { // case4：普通字母直接追加到sb即可！！！
                sb.append(letter);
            }
        }
        return sb.toString();
    }
}