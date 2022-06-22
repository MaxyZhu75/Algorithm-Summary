class Solution {
    public int longestConsecutive(int[] nums) { // ����ʱ����ɣ���ϣ������
        Set<Integer> hashRecord = new HashSet<>();
        for (int num : nums) {
            hashRecord.add(num); // �洢����Ԫ����ȥ�أ�����
        }

        int result = 0;
        for (int num : hashRecord) {
            if (!hashRecord.contains(num-1)) { // ���ۣ�������ԭ�������num-1��������ö����numΪ��ͷ���������н������ʱnum��Ȼ�Ѿ������ʹ���������
                int current = num;
                int count = 1;
                while (hashRecord.contains(current+1)) { // ͳ�Ƶ�ǰ����г��ȣ�����
                    current++;
                    count++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}