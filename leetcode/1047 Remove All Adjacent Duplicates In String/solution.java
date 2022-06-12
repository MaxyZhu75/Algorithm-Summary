class Solution {
    public String removeDuplicates(String s) { // 同LeetCode735题星球爆炸；需要使用栈！！！
        int n = s.length();
        Deque<Character> myStack = new ArrayDeque<>();
        myStack.addFirst(s.charAt(0));

        int i = 1;
        while (i < n) {
            if (!myStack.isEmpty() && myStack.peekFirst() == s.charAt(i)) {
                myStack.removeFirst();
                i++;
            } else {
                myStack.addFirst(s.charAt(i));
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!myStack.isEmpty()) {
            sb.append(myStack.removeLast());
        }
        return sb.toString();
    }
}