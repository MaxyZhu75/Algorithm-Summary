class Solution {
    public char nextGreatestLetter(char[] letters, char target) { // �����Ѿ��ź�������飬Ӧ�����뵽���ֲ��ҵ�˼�룡����
        int low = 0;
        int high = letters.length-1; // ������ֲ��ҵĿ����69���󿪷����ƣ�����ϸ��Ӧ��������������������
        int resultIndex = 0;
        if (letters[high] - target <= 0) { // ��������������ĸ������target������Ŀ������ѭ����֪��ֱ�ӷ���ͷ��Ԫ�أ�����
            return letters[0];
        }
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (letters[mid] - target > 0) {
                resultIndex = mid; // �˴�����ĸ����target������½���Ҫ����resultIndex��ֱ��low����highʱ��result���Ϸ���ƽ�Ŀ�꣬��һ�����ϴ�������Ŀ����ĸ�����С��ĸ������
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return letters[resultIndex];
    }
}