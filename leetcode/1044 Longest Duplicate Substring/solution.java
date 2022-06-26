class Solution { //���ַ�����ϣ��+�����֡�������
    long[] h;
	long[] p;

    public String longestDupSubstring(String s) {
        int P = 1313131; // ��Ҫ�ϴ������������
		int n = s.length();
        this.h = new long[n+10]; // ��ϣ����h[]������
		this.p = new long[n+10]; // �η�����p[]������
        p[0] = 1;
        for (int i=0; i<n; i++) { // ����ʽ������飡����
            p[i+1] = p[i] * P;
            h[i+1] = h[i] * P + s.charAt(i);
        }

        String result = "";
        int low = 0, high = n; // �ԡ���󳤶ȡ�Ϊ�ָ���������С������ԡ�������
        while (low < high) {
            int mid = high + low + 1 >> 1; // �˴�д�ɳ���ʱ��ᳬ�����ƣ�����
            String current = check(s, mid);
            if (current.length() != 0) {
			    low = mid;
			} else {
			    high = mid - 1;	
			}
            result = (current.length() > result.length()) ? current : result;
        }
        return result;
    }
	
    public String check(String s, int len) { // O(n)ʱ����ĳ�����ȡ�len����Ϊ��󳤶ȣ��Ƿ���ںϷ�����������
        int n = s.length();
        Set<Long> hashRecord = new HashSet<>();
        for (int i = 1; i+len-1 <= n; i++) {
            int j = i+len-1;
            long hash = h[j] - h[i-1] * p[j-i+1]; // ����ǰ׺��˼�룬ʹ���ܹ�O(1)ʱ���ȡ���Ӵ�s[i...j]�Ĺ�ϣֵ��������
            if (hashRecord.contains(hash)) {
			    return s.substring(i-1, j);
			} else {
			    hashRecord.add(hash);	
			}
        }
        return "";
    }
}