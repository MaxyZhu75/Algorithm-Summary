class Solution {
    public boolean xorGame(int[] nums) { // ��ѧ���������ۡ���֤�����ٷ���𣡣���
        if (nums.length % 2 == 0) {
            return true; // ����һ������A�Ļغ�ʱ�������鳤��Ϊż������A��ʤ���ڽ��۶�ǰ�����ܿ���ʹʣ�����������������Ϊ0��������
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0; // ���۶���������ȫ��Ԫ�������Ϊ0����Aֱ��ʤ������ʤ���������֣�������
    }
}