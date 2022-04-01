class Solution {
    private String original;
    private String regular;
    
    public boolean isMatch(String s, String p) { // ���ӵĶ�̬�滮ת�Ʒ��̣��࿴���ٷ�����Լ���ˮ��Ҷ��֤��������
        this.original = s;
        this.regular = p;
        int m = s.length();
        int n = p.length();

        boolean[][] d = new boolean[m+1][n+1]; // original��i���ַ���regular��j���ַ�ƥ�����������
        d[0][0] = true;

        for (int i=0; i<=m; i++) { 						  // Ҫ��һ����dp��ʱi��0��ʼ��j��1��ʼ������
            for (int j=1; j<=n; j++) {
                if (regular.charAt(j-1) == '*') {         // case1��regular��j���ַ�Ϊ * ������
                    if (matches(i, j-1)) { 				  // ע�⣺��ʹ�ܹ�ƥ�� * Ҳ����ѡ���滻���滻0���ַ���������
                        d[i][j] = d[i-1][j] || d[i][j-2]; // �ܹ�ƥ�䣬ȡd[i-1][j]��������滻originalĩβ���ַ����˴�����ö����ǰ�滻���ٸ��ַ���ȡdp�� * ��������µ�ǰһ��״̬���ɣ���ȡd[i][j-2]���� * �滻original���0���ַ�������
                    } else {
                        d[i][j] = d[i][j-2];              // ���ܹ�ƥ�䣬ȡd[i][j-2]���� * �滻original���0���ַ�������
                    }
                } else {                                  // case2��regular��j���ַ�Ϊ��ĸ�� "." ������
                    if (matches(i, j)) {
                        d[i][j] = d[i-1][j-1];		      // ȡd[i-1][j-1]��������ͨ�ַ�����*��ƥ��ɹ�������
                    } else {
                        d[i][j] = false;                  // ������ͨ�ַ�����*��ƥ�䲻�ɹ�������
                    }
                }
            }
        }
        return d[m][n];
    }

    public boolean matches(int i, int j) {
        if (i == 0) { // case1��original��Ϊ�����Ȼ�޷�ƥ�䣡����
            return false;
        }
        if (regular.charAt(j-1) == '.') { // case2: "." ����ƥ��������ĸ������
            return true;
        }
        return original.charAt(i-1) == regular.charAt(j-1); // case3��������ĸ������ȣ�����
    }
}