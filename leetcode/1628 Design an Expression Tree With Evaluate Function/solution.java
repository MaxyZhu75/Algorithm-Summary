/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node { // 题目所给抽象类！！！
    public abstract int evaluate();
    // define your fields here
};

class myNode extends Node { // 抽象类Node的实现类！！！
    String val;
    myNode left;
    myNode right;

    myNode(String val){ // 叶子节点构造函数！！！
        this.val = val;
    }

    myNode(String val, myNode left, myNode right){ // 非叶子节点构造函数！！！
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int evaluate(){ // 表达树根节点通过调用此函数得到计算结果！！！
        myNode root = this;
        return inorder(this);
    }
      
    public int inorder(myNode root){  // 中序遍历计算表达式结果！！！
        if(isDigit(root.val)){
            return Integer.parseInt(root.val);
        }
        int left = inorder(root.left);
        String operator = root.val;
        int right = inorder(root.right);
        int result = calculate(left, right, operator);
        return result;
    }

    public int calculate(int left, int right, String operator){ // 运算！！！
        if(operator.equals("+")){
            return left + right;
        } else if(operator.equals("-")){
            return left - right;
        } else if(operator.equals("*")){
            return left * right;
        } else {
			return left / right;
		}
    }

    public boolean isDigit(String str){ // String类型isDigit()！！！
        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
            return false;
        }
        return true;
    }
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    
    int index; // 用于每次找到数组postfix的最后一个索引！！！

    Node buildTree(String[] postfix) { // 递归实现构造树！！！
        this.index = postfix.length-1;
        return recursion(postfix);
    }

    public Node recursion(String[] postfix) {
        if (index < 0) { // 递归出口！！！
            return null;
        }
        
        String nodeVal = postfix[index]; // 获取节点值！！！
        if (isDigit(nodeVal)){
            return new myNode(nodeVal); // case1：节点值是数字，调用叶子节点构造函数后直接返回！！！
        }
        
        myNode newNode = new myNode(nodeVal); // case2：节点值是运算符，调用非叶子节点构造函数，移动index指针并「先右后左」继续递归！！！
        index--;
        newNode.right = (myNode) recursion(postfix);
        index--;
        newNode.left = (myNode) recursion(postfix);
        return newNode;
    }

    public boolean isDigit(String str){ // String类型isDigit()！！！
        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
            return false;
        }
        return true;
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */