class Solution {
    public int largestVariance(String s) { // LeetCode��53���������������⣻ʱ���Ż��ɿ���DP������
        int result = 0;
        for (char c1 = 'a'; c1 <= 'z'; c1++) // ������ִ��������ַ�Ϊc1�����ִ������ٵ��ַ�Ϊc2������
            for (char c2 = 'a'; c2 <= 'z'; c2++) {
                if (c1 == c2) continue;
                int count = 0; // ά��c1��c2�ĳ��ִ���֮�����
                int difference = Integer.MIN_VALUE; // c1��c2���붼�������Ӵ��У���c2δ���֣���difference��ʼ��Ϊ����С������
                for (int i=0; i<s.length(); i++) {
                    if (s.charAt(i) == c1) { // ���������Ҫ������ע��������ϸ�ڣ�����
                        count++;
                        difference++; // �˴�difference��c1��ͳ�ƽ�����ȷ��c2�������Ӵ���ʱ��difference��Ϊ����С������Ч������
                    } else if (s.charAt(i) == c2) {
                        count--;
						difference = count;
                        count = Math.max(count, 0); // c1���ִ���������c2ʱ�����֮ǰ��ͳ�ƣ�����countΪ0���Ҵ�ʱdifferenceҲ��ȻΪ0��-1������Ҫ����Ϊ����С����Ϊ�Ѿ���ʱ��ȷ��c2���������Ӵ����У����Ӵ�Ϊc1c2��c2��������
                    }

                    result = Math.max(result, difference);
                }
            }
        return result;
    }
}