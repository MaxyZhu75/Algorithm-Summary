class Solution {
    public String simplifyPath(String path) {
        String[] names = path.split("/"); // String.split(分隔符)！！！
        Deque<String> myDeque = new ArrayDeque<>(); // java.util.ArrayDeque！！！
        for (String name : names) {
            if (name.equals("..")) { // case1：“..” 不加入deque，且如果deque不为空则弹出栈顶！！！
                if (!myDeque.isEmpty()) myDeque.removeFirst();
            } else if (!name.equals(".") && name.length() != 0) { // case2：“.”与空字符（连续的“/”分割后即为空字符）不加入deque；其余元素压入栈顶！！！
                myDeque.addFirst(name);
            }
        }
        StringBuffer sb = new StringBuffer();
        if (myDeque.isEmpty()) { // case1：deque为空是时仅有根目录“/”！！！
            return "/";
        } else {
            while (!myDeque.isEmpty()) { // case2：deque不为空时，从栈底取元素依次拼接（此处不符合常规栈操作，而是双向链表）！！！
                sb.append('/');
                sb.append(myDeque.pollLast());
            }
        }
        return sb.toString();
    }
}