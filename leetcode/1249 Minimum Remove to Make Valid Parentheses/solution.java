class Solution {
    public String minRemoveToMakeValid(String s) { // 方法一：Stack + List ！！！
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        Stack<Integer> myStack = new Stack<>();
        List<Integer> toBeRemove = new ArrayList<>();
        
        for (int i=0; i<n; i++) {
            char letter = s.charAt(i);
            if (letter == '(') { // 左括号入栈！！！
                myStack.push(i);
            } else if (letter == ')') { // 右括号分情况处理！！！
                if (!myStack.isEmpty()) 
                    myStack.pop(); // case1：栈不为空时，弹出栈内一个左括号，匹配成功！！！
                } else {
                    toBeRemove.add(i); // case2: 栈为空时，无法匹配左括号，该右括号加入待删List！！！
                }
            }
        }

        while (!myStack.isEmpty()) {
            toBeRemove.add(myStack.pop()); // 若循环结束栈不为空，则栈内左括号未匹配，需加入待删List！！！
        }

        for (int i=0; i<n; i++) {
            if (!toBeRemove.contains(i)) { // StringBuilder不添加待删List中的元素！！！
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}