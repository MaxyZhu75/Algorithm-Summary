class Solution {
    public int[][] merge(int[][] intervals) { 
        Arrays.sort(intervals, new Comparator<int[]>(){ // 先按左端点从小到大排序！！！
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
            preRight = result.get(result.size()-1)[1]; // 获取result列表末尾元素的右端点！！！
            if (left > preRight) {
                result.add(new int[]{left, right}); // case1：若当前区间左端点与前一区间右端点不相交，则将当前区间添加入result列表！！！
            } else {
                result.get(result.size()-1)[1] = Math.max(preRight, right); // case2：若当前区间左端点与前一区间右端点相交，则需要检查更新result列表末尾元素的右端点！！！
            }
        }

        return result.toArray(new int[result.size()][2]); // List转换为数组！！！
    }
}