class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int p1 = 0, p2 = 0, result = 0; // ����˼·�������ʹ��̰��˼�룻ʵ��ʱ����˫ָ�룡����
        Arrays.sort(g); // java.util.Arrays������
        Arrays.sort(s);
        while (p2 < s.length) { // ̰������:������С�ı�������θ����С�ĺ��ӣ��Ӷ�ʹ������ĺ���������࣬��ȷ�Կ��ɷ�֤����֤��������
            if (p1 > g.length-1) {
                return g.length;
            }
            if (s[p2] >= g[p1]) {
                p1++;
                p2++;
                result++;
            } else {
                p2++;
            }
        }
        return result;
    }
}