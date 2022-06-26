/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public Node expTree(String s) {
        s = '(' + s + ')';
        Deque<Node> stack = new ArrayDeque<>(); // 不清楚计算顺序的全部压入栈！！！
        
		for (char letter : s.toCharArray()) {
            if (!Character.isDigit(letter) && letter != '(') { // case1:「数字」和「左括号」先跳过，稍后按序入栈即可！！！
                Node previous = stack.removeFirst(); // 由于压入栈内是按中序「左根右」；弹出时栈顶为前一个操作符的「右数字」！！！
                if (letter == '*' || letter == '/') {
                    if (stack.peekFirst().val == '*' || stack.peekFirst().val == '/') { // case2:「*」和「/」需要检查栈内前一个运算，当且仅当是乘除则需要立即构造之！！！
                        Node preOps = stack.removeFirst(); //「标准构造步骤」！！！
                        Node left = stack.removeFirst();
                        preOps.left = left;
                        preOps.right = previous;
                        previous = preOps;
                    }
                } else { // case3:「+」和「-」和「右括号」需要进行构造直至「前一个左括号」！！！
                    while (stack.peekFirst().val != '(') {
                        Node preOps = stack.removeFirst();
                        Node left = stack.removeFirst();
                        preOps.left = left;
                        preOps.right = previous;
                        previous = preOps;
                    }
                    if (letter == ')') { //「右括号」需要多一步弹出「前一个左括号」的操作！！！
                        stack.removeFirst();
                    }
                }

                stack.addFirst(previous); // 将构造后的部分视作整体重新「入栈」（操作符为子树根）！！！
            }

            if (letter != ')') { // 前面的部分构造结束入栈后「当前左括号或操作符或数字」再入栈！！！
                stack.addFirst(new Node(letter));
            }
        }

        return stack.removeFirst(); // 最后剩下根节点返回！！！
    }
}