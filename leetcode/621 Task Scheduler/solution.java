class Solution {
    public int leastInterval(char[] tasks, int n) { // ̰�ģ�Ԥ����϶��գ�����
        int[] frequencies = new int[26];
        for (int task : tasks) {
            frequencies[task-'A']++; // ͳ��ÿ����ĸ����Ƶ�ʣ�����
        }

        Arrays.sort(frequencies);
        int slot = frequencies[25]-1;
        int idle = slot * n; // �Ƚ����ִ���������ĸ���п�����ÿ��slot�ɡ�n����϶����ɣ�����

        for (int i = 24; i >= 0 && idle > 0; i--) { // ����������ĸ���ռ�ÿ�϶��ÿ��slotͬһ����ĸ�������һ�Σ�����϶����������ѭ��������
            idle -= Math.min(slot, frequencies[i]); // �������ĸƵ�������Ƶ����ͬ������ĸռ�ÿ�϶ʱֻռ��slot����϶����ʣ��һ������β����ӡ�������
        }

        return (idle <= 0) ? tasks.length : idle+tasks.length; // ȫ����϶��������ʣ����ĸ��β����ӣ������ڵ�����������������
    }
}