class Solution {
    public boolean isPalindrome(String s) { // ˫ָ�룻�������ռ䣡����
        int n = s.length();
        int left = 0, right = n-1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) { // ÿ��ѭ���Ƚ�����ָ��������ĸ������ͣ�£�����
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) { // ������ָ��δ�ص����棬����бȽϣ�����
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}