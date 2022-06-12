class Solution {
    public int maximizeSweetness(int[] sweetness, int k) { // �����ֲ��ҡ��ж����⣻��LeetCode��1011��875�����ƣ�����
        int min = Integer.MAX_VALUE, sum = 0;
		for (int sweet : sweetness) {
			sum += sweet;
			min = Math.min(min, sweet);
		}
		
		int low = min, high = sum/(k+1), result = 0; // �Լ����Ե������С��һ�ݣ�����Լ������ֵܷ������С��һ�飬�����ֵܷ�ƽ��ֵ������
        while (low <= high) {
            int mid = (high-low)/2 + low;
            int currentSweetness = 0;
            int people = 0; // ��midΪ������ޣ�people��ʾ����������currentSweetness��¼��ǰ���ѷֵ�����ȣ�����
            for (int sweet : sweetness) {
                currentSweetness += sweet;
                if (currentSweetness >= mid) {
                    people++;
                    currentSweetness = 0;
                }
            }
            if (people >= k+1) { // �������ҵ������������ޣ�����
                low = mid + 1;
                result = mid;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}