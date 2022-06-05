/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node { // ��Ŀ���������࣡����
    public abstract int evaluate();
    // define your fields here
};

class myNode extends Node { // ������Node��ʵ���࣡����
    String val;
    myNode left;
    myNode right;

    myNode(String val){ // Ҷ�ӽڵ㹹�캯��������
        this.val = val;
    }

    myNode(String val, myNode left, myNode right){ // ��Ҷ�ӽڵ㹹�캯��������
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int evaluate(){ // ��������ڵ�ͨ�����ô˺����õ�������������
        myNode root = this;
        return inorder(this);
    }
      
    public int inorder(myNode root){  // �������������ʽ���������
        if(isDigit(root.val)){
            return Integer.parseInt(root.val);
        }
        int left = inorder(root.left);
        String operator = root.val;
        int right = inorder(root.right);
        int result = calculate(left, right, operator);
        return result;
    }

    public int calculate(int left, int right, String operator){ // ���㣡����
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

    public boolean isDigit(String str){ // String����isDigit()������
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
    
    int index; // ����ÿ���ҵ�����postfix�����һ������������

    Node buildTree(String[] postfix) { // �ݹ�ʵ�ֹ�����������
        this.index = postfix.length-1;
        return recursion(postfix);
    }

    public Node recursion(String[] postfix) {
        if (index < 0) { // �ݹ���ڣ�����
            return null;
        }
        
        String nodeVal = postfix[index]; // ��ȡ�ڵ�ֵ������
        if (isDigit(nodeVal)){
            return new myNode(nodeVal); // case1���ڵ�ֵ�����֣�����Ҷ�ӽڵ㹹�캯����ֱ�ӷ��أ�����
        }
        
        myNode newNode = new myNode(nodeVal); // case2���ڵ�ֵ������������÷�Ҷ�ӽڵ㹹�캯�����ƶ�indexָ�벢�����Һ��󡹼����ݹ飡����
        index--;
        newNode.right = (myNode) recursion(postfix);
        index--;
        newNode.left = (myNode) recursion(postfix);
        return newNode;
    }

    public boolean isDigit(String str){ // String����isDigit()������
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