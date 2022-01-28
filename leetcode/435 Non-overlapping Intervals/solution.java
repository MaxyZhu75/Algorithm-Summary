class Solution {
    public int eraseOverlapIntervals(int[][] intervals) { // ����ѡ��̰�ģ����γ̽���ʱ������ÿ��ѡ����������ģ�����
        int allClass = intervals.length;
        int scheduledClass = 1;
        
        Arrays.sort(intervals, new Comparator<int[]>(){ // java.util.Comparator���ص��ס������ʽ������
            @Override
            public int compare(int[] o1, int[]o2) { // ��дcompare������ע�ⷵ�ص���int���ͣ�����
                return (o1[1] < o2[1]) ? -1 : (o1[1] == o2[1] ? 0 : 1); // д����Ԫ�����������o1[1]-o2[1]�ɷ�ֹ�������������
            }
        });

        int[] previous = intervals[0];
        for ( int[] interval : intervals ) {
            if (interval[0] >= previous[1]) {
                scheduledClass++;
                previous = interval;
            }
        }
        return allClass - scheduledClass;
    }
}