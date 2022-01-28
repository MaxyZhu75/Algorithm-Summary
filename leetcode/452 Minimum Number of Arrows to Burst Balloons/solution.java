class Solution {
    public int findMinArrowShots(int[][] points) { // 相当于在问不重叠的区间个数，但注意重叠的定义有区别，端点相同也算重叠，如[1, 2]与[2, 3]！！！

        Arrays.sort(points, new Comparator<int[]>() { // 该贪心思想与LeetCode的435题相同！！！
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