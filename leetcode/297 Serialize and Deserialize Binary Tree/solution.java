/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec { // ���ܽ�����������洢������

    public String serialize(TreeNode root) { // TreeNodeתΪString���ͣ�����
        return rserialize(root, "");
    }

    public TreeNode deserialize(String data) { // StringתΪTreeNode���ͣ�����
        String[] nodes = data.split(",");
        List<String> nodeList = new LinkedList<>(Arrays.asList(nodes)); // ��Ҫ�����б�ɾ��ָ��λ��Ԫ��ʱ������Ԫ����˳���ƶ����������ʣ�����
        return rdeserialize(nodeList);
    }

    public String rserialize(TreeNode root, String s) { // ��������ݹ飺�������ҡ�������
        if (root == null) {
            s += "none,"; // ϸ�ڣ��Ӷ��ţ�����
        } else {
            s += s.valueOf(root.val) + ",";
            s = rserialize(root.left, s);
            s = rserialize(root.right, s);
        }
        return s;
    }
  
    public TreeNode rdeserialize(List<String> nodeList) { // ��������ݹ飺�������ҡ�������
        if (nodeList.get(0).equals("none")) {
            nodeList.remove(0);
            return null;
        }
  
        TreeNode root = new TreeNode(Integer.valueOf(nodeList.get(0)));
        nodeList.remove(0); // �б�ɾ����һ��Ԫ�غ�����Ԫ�ػ�ǰ�ƣ�����
        root.left = rdeserialize(nodeList);
        root.right = rdeserialize(nodeList);
    
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));