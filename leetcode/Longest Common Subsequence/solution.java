import java.util.*;

public class Solution {
    public String LCS (String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] d = new int[m+1][n+1]; // ��ʾs1����i���ַ���s2����j���ַ�Ϊֹ�Ĺ����Ӵ����ȣ�����
        int longest = 0, end = 0;
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    d[i][j] = d[i-1][j-1] + 1; // case1����λ�������ַ�����ĸƥ�䣡����
                } else {
                    d[i][j] = 0; // case2����λ�������ַ�����ƥ�䣡����
                }
                if (longest < d[i][j]) { // ��¼������Ӵ��Ľ���λ�úͳ��ȣ����ڷ����Ӵ����������
                    longest = d[i][j];
                    end = i-1;
                }
            }
        }
        return str1.substring(end-longest+1, end+1);
    }
}