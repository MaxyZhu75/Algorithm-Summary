class Solution {
    public int minEatingSpeed(int[] piles, int h) { // �����ֲ��ҡ��ж����⣻��LeetCode��1011��1231�����ƣ�����
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int low = 1, high = max;
        while (low < high) {
            int mid = (high-low)/2 + low; // ��midΪÿСʱθ�����ޣ�period��ʾ���ٳ���ȫ���㽶��ʱ�䣡����
            int period = 0;
            for (int pile : piles) { // ע��ÿСʱֻ��һ�ѣ�ĳһ�ѳ���θ��ʱ��Ҫ�Զ��Сʱ������
                if (pile > mid) {
                    period += (pile+mid-1)/mid; // �Ż�ʱ��д�����˴��ȼ��ڵ��� Math.ceil(pile*1.0 / mid)������
                } else {
                    period++;
                }
            }
            if (period <= h) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}