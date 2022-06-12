class Solution {
    public String reorganizeString(String s) { // ̰�Ľ��������������ȷ��֤�����ٷ���𣡣���
        int n = s.length();
		if (n <= 1) return s;
        
		int[] record = new int[26]; // ͳ�Ƹ����ַ����ִ������������ַ������ִ���������
        int maxCount = 0;
        for (int i=0; i<n; i++) {
            record[s.charAt(i) - 'a']++;
            maxCount = Math.max(maxCount, record[s.charAt(i) - 'a']);
        }

        if (maxCount > (n+1)/2) { // ��n��ż����������ĸ�ĳ��ִ��������ܳ���n/2�Σ���n��������������ĸ�ĳ��ִ��������ܳ���(n+1)/2�Σ�����
            return ""; // ����ż����n/2��(n+1)/2��ȣ��ʼ��ж�����������
        }
        char[] reorganized = new char[n]; // ��ż�±꽻����������ʹ���ַ����飡����
        int even = 0, odd = 1;
        for (int i=0; i<26; i++) {
            char letter = (char) ('a' + i);
            while (record[i] > 0 && record[i] <= n/2 && odd < n) { // Ҫ�㣺��n��������maxCount=(n+1)/2ʱ������������ĸ����ȫ��������ż���±ꣻ����������⣡����
                reorganized[odd] = letter;
                record[i]--;
                odd += 2;
            }
            while (record[i] > 0) { // ��recordʣ���ַ��ó����꼴�ɣ�����
                reorganized[even] = letter;
                record[i]--;
                even += 2;
            }
        }
        return new String(reorganized);
    }
}