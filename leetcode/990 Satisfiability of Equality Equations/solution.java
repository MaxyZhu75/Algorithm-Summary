class Solution {
    int[] parent = new int[26]; // �洢ÿ����������ͨ������Ϣ��ÿ��Ԫ�ر�ʾ��ǰ�������ڵ���ͨ�����ĸ��ڵ���Ϣ������

	public boolean equationsPossible(String[] equations) { //�����鼯��������
        for (int i=0; i<26; i++) {
            this.parent[i] = i; // ��ʼ����ͨ����Ϊ��������
        }
        for (String equation : equations) { // �Ⱥϲ�������
            if (equation.charAt(1) == '=') {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                union(index1, index2);
            }
        }
        for (String equation : equations) { // �ٴ����Ⱥţ������Ƿ�����ͬһ��ͨ����������
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

    public void union(int index1, int index2) { //���ϲ���������һ�������ġ����ڵ�ĸ��ڵ㡹ָ��ڶ��������ġ����ڵ㡹������
        parent[find(index1)] = find(index2);
    }

    public int find(int index) {
        while (parent[index] != index) { // �����ҡ������ŵ�ǰ�����ĸ��ڵ�һ·���ϲ��ң�ֱ���ҵ������ڵ㡹������
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}