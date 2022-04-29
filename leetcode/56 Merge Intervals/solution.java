class Solution {
    public int[][] merge(int[][] intervals) { 
        Arrays.sort(intervals, new Comparator<int[]>(){ // �Ȱ���˵��С�������򣡣���
            @Override
            public int compare(int[]o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] > o2[1] ? -1 : (o1[1] == o2[1] ? 0 : 1);
                } else {
                    return o1[0] < o2[0] ? -1 : 1;
                }
            }
        });

        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int left = intervals[0][0], right = intervals[0][1], preRight = 0;
        result.add(new int[]{left, right});
        for (int i=1; i<n; i++) {
            left = intervals[i][0];
            right = intervals[i][1];
            preRight = result.get(result.size()-1)[1]; // ��ȡresult�б�ĩβԪ�ص��Ҷ˵㣡����
            if (left > preRight) {
                result.add(new int[]{left, right}); // case1������ǰ������˵���ǰһ�����Ҷ˵㲻�ཻ���򽫵�ǰ���������result�б�����
            } else {
                result.get(result.size()-1)[1] = Math.max(preRight, right); // case2������ǰ������˵���ǰһ�����Ҷ˵��ཻ������Ҫ������result�б�ĩβԪ�ص��Ҷ˵㣡����
            }
        }

        return result.toArray(new int[result.size()][2]); // Listת��Ϊ���飡����
    }
}