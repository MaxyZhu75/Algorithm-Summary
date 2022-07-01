class Solution {
    private String original;
    private String regular;
    
    public boolean isMatch(String s, String p) { // ���ӵĶ�̬�滮ת�Ʒ��̣��࿴�ٷ�����Լ���ˮ��Ҷ��֤��������
        this.original = s;
        this.regular = p;
        int m = s.length(), n = p.length();

        boolean[][] d = new boolean[m+1][n+1];
        d[0][0] = true;
        for (int i=0; i<=m; i++) { // ϸ��һ����dp��ʱi��0��ʼ��j��1��ʼ������
            for (int j=1; j<=n; j++) {
                char current = regular.charAt(j-1);
				if (current == '*') { // case1������*�����÷��Ž���ƥ������ǰһ��Ԫ�أ���ƥ��ʱ��עǰһ��Ԫ�أ�����
                    if (matches(i, j-1)) {
                        d[i][j] = d[i-1][j] || d[i][j-2]; // ƥ��ɹ���ȡd[i-1][j]��������滻originalĩβ���ַ���ȡd[i][j-2]�����滻������
                    } else {
                        d[i][j] = d[i][j-2]; // ƥ��ʧ�ܣ�ȡd[i][j-2]�����滻������
                    }
                } else { // case2���ǡ�*����ƥ��ʱ��ע��ǰԪ���Ƿ�ƥ�䣡����
                    if (matches(i, j)) {
                        d[i][j] = d[i-1][j-1];
                    } else {
                        d[i][j] = false;
                    }
                }
            }
        }
        return d[m][n];
    }

    public boolean matches(int i, int j) { // original����i���ַ�����regular����j���ַ���ƥ�����������
        if (i == 0) {
            return false; // case1��original��Ϊ�����Ȼ�޷�ƥ�䣡����
        }
        if (regular.charAt(j-1) == '.') {
            return true; // case2: "." ����ƥ��������ĸ������
        }
        return original.charAt(i-1) == regular.charAt(j-1); // case3��������ĸ������ȣ�����
    }
}