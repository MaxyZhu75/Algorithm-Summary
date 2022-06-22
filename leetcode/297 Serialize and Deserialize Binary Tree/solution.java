/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec { // 不能借助类变量来存储！！！

    public String serialize(TreeNode root) { // TreeNode转为String类型！！！
        return rserialize(root, "");
    }

    public TreeNode deserialize(String data) { // String转为TreeNode类型！！！
        String[] nodes = data.split(",");
        List<String> nodeList = new LinkedList<>(Arrays.asList(nodes)); // 需要利用列表删除指定位置元素时，后续元素能顺序移动的特殊性质！！！
        return rdeserialize(nodeList);
    }

    public String rserialize(TreeNode root, String s) { // 先序遍历递归：「根左右」！！！
        if (root == null) {
            s += "none,"; // 细节：加逗号！！！
        } else {
            s += s.valueOf(root.val) + ",";
            s = rserialize(root.left, s);
            s = rserialize(root.right, s);
        }
        return s;
    }
  
    public TreeNode rdeserialize(List<String> nodeList) { // 先序遍历递归：「根左右」！！！
        if (nodeList.get(0).equals("none")) {
            nodeList.remove(0);
            return null;
        }
  
        TreeNode root = new TreeNode(Integer.valueOf(nodeList.get(0)));
        nodeList.remove(0); // 列表删除第一个元素后，其余元素会前移！！！
        root.left = rdeserialize(nodeList);
        root.right = rdeserialize(nodeList);
    
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));