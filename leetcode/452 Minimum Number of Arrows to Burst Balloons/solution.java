class Solution {
    public int findMinArrowShots(int[][] points) { // �൱�����ʲ��ص��������������ע���ص��Ķ��������𣬶˵���ͬҲ���ص�����[1, 2]��[2, 3]������

        Arrays.sort(points, new Comparator<int[]>() { // ��̰��˼����LeetCode��435����ͬ������
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] < o2[1]) ? -1 : (o1[1] == o2[1] ? 0 : 1);
            }
        });

        int[] previous = points[0];
        int shots = 1;
        for (int[] point : points) {
            if (point[0] > previous[1]) {
                shots++;
                previous = point;
            }
        }
        return shots;
    }
}