class Solution {
    public int lengthOfLongestSubstring(String s) { // ע�⣺�ִ���Ҫ�����������в���Ҫ����������
        int n = s.length();
        int result = 0;
        Set<Character> hashRecord = new HashSet<>(); // ��¼��ǰ�������ѳ��ֵ���ĸ������

        int right = 0; // Ҫ�㣺�������ڵ��Ҷ��ǲ���Ҫ�����˵ģ�����
        for (int left=0; left<n; left++) {
            if (left > 0) hashRecord.remove(s.charAt(left-1)); // ÿ���ƶ���ˣ���Ҫ��ǰһ����ĸ��HashSet���õ�������
            while (right<n && !hashRecord.contains(s.charAt(right))) {
                hashRecord.add(s.charAt(right));
                right++;
            }
            result = Math.max(result, right-left);
        }
        return result;
    }
}