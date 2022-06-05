class Solution {
    public boolean possiblyEquals(String s1, String s2) { // ��̬�滮�������������⣡����
        int m = s1.length(), n = s2.length();
        char[] letters1 = s1.toCharArray(), letters2 = s2.toCharArray();
		
		Set<Integer>[][] d = new Set[m+1][n+1]; // dp��ʹ�ö�άSet���ϣ�����
        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                d[i][j] = new HashSet<>(); // ����HashSet��d[i][j]��ʾs1ǰi����ĸ��s2ǰj����ĸƥ���Ҳ�������ͻʱ�����ܵĳ��Ȳ�ֵ������
            }
        }
        d[0][0].add(0);

        int num = 0;
		for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                for (int difference : d[i][j]) {
                    num = 0;
                    if (difference <= 0) { // �Ż����Ҫ��differenceС�ڵ���0������
						for (int k=i; k < Math.min(i+3, m) && isDigit(letters1[k]); k++) { // s1[i][j]��s1[k][j]Ϊ���֣�����
							num = num * 10 + letters1[k] - '0';
							d[k+1][j].add(difference + num);
						}	
					}

                    num = 0;
                    if (difference >= 0) { // �Ż����Ҫ��difference���ڵ���0������
						for (int k=j; k < Math.min(j+3, n) && isDigit(letters2[k]); k++) { // s2[i][j]��s1[i][k]Ϊ���֣�����
							num = num * 10 + letters2[k] - '0';
							d[i][k+1].add(difference - num);
						}
                    }

                    if (i < m && !isDigit(letters1[i]) && difference < 0) { // ��s1[i]����ĸ���Ҹ���ĸ���Ա�s2����ƥ�䣨Ҫ��differenceС��0��������
                        d[i+1][j].add(difference + 1);
                    }

                    if (j < n && !isDigit(letters2[j]) && difference > 0) { // ��s2[j]����ĸ���Ҹ���ĸ���Ա�s1����ƥ�䣨Ҫ��difference����0��������
                        d[i][j+1].add(difference - 1);
                    }

                    if (i < m && j < n && !isDigit(letters1[i]) && letters1[i] == letters2[j] && difference == 0) { // s1[i]��s2[j]������ĸƥ�䣨Ҫ��difference����0��������
                        d[i+1][j+1].add(difference);
                    }
                }
            }
        }

        return d[m][n].contains(0); // ���d[m][n]�Ƿ����0������
    }

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}