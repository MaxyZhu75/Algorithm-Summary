class Solution {
    int[] parent = new int[26]; // 存储每个变量的连通分量信息，每个元素表示当前变量所在的连通分量的父节点信息！！！

	public boolean equationsPossible(String[] equations) { //「并查集」！！！
        for (int i=0; i<26; i++) {
            this.parent[i] = i; // 初始化连通分量为自身！！！
        }
        for (String equation : equations) { // 先合并！！！
            if (equation.charAt(1) == '=') {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                union(index1, index2);
            }
        }
        for (String equation : equations) { // 再处理不等号，查找是否属于同一连通分量！！！
            if (equation.charAt(1) == '!') {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                if (find(index1) == find(index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int index1, int index2) { //「合并」：将第一个变量的「根节点的父节点」指向第二个变量的「根节点」！！！
        parent[find(index1)] = find(index2);
    }

    public int find(int index) {
        while (parent[index] != index) { // 「查找」：沿着当前变量的父节点一路向上查找，直到找到「根节点」！！！
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}