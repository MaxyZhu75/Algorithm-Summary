class Solution {
    public long minimumHealth(int[] damage, int armor) { // ̰�ĵ���max��armor���˺�������
        long max = 0, sum = 0;
        for (int current : damage) {
            sum += current;
            max = Math.max(max, current);
        }
        return (long) sum - Math.min(max, armor) + 1; // �����Ҫʣһ��Ѫ������
    }
}