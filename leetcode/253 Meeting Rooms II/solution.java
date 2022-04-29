class Solution {
    public int minMeetingRooms(int[][] intervals) { // �����������̰���㷨������ʼʱ���С�������򣡣���
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[]o1, int[]o2) {
                return o1[0] < o2[0] ? -1 : (o1[0] == o2[0] ? 0 : 1); // ��д�������򣬰���ʼʱ���С���󣡣���
            }
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() { // ���ȶ���ʵ����С�ѣ���Ų�ͬ������ǰ����ʱ�䣡����
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : (o1 == o2 ? 0 : 1); // ��д���ȶ������򣬰�Ԫ�ش�С���󣡣���
            }
        });

        minHeap.add(intervals[0][1]);
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek()) minHeap.poll(); // ����Ҫ���ӻ�������ʱ�����Ѷ�Ԫ�ص���������
            minHeap.add(intervals[i][1]);
        }

        return minHeap.size();
    }
}