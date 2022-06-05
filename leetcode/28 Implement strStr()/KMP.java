class Solution {
    public int strStr(String haystack, String needle) { // KMP�㷨������ǰ׺��������ַ���ƥ�����⣡����
        int n = haystack.length();
		int m = needle.length();
        if (m == 0) return 0;
		
        int[] pi = new int[m];
        for (int i=1, j=0; i<m; i++) { // ��needle��ǰ׺����������
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) { // ͨ������j=��(��(��(��)?1)?1)�ҵ�����j����s[0:j?1]=s[i?j:i?1]������
                j = pi[j-1];
            }
            if (needle.charAt(i) == needle.charAt(j)) { // case1����s[i]=s[j]����ô��(i)=j+1������
                j++;
            }
            pi[i] = j; // case2�����Ҳ���s[i]=s[j]����j=0����ô��(i)=0������
        }
        
		for (int i=0, j=0; i<n; i++) { // ͬ����haystack��ǰ׺������i��ʼֵΪ0�����ڱ� # ռ�ã�����
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) { // ���ҽ���ǰ׺����ֵ����mʱ��˵���ҵ���һ���ַ���needle��haystack�еĳ��֣�����
                return i - m + 1; // �� str = needle + # + haystack �� s[0:j?1]=s[i?j:i?1]��֪�����׺��ʼ����Ϊi-m+1��#ռ��1λҪ���ϣ�������
            }
        }
        
		return -1;
    }
}