class Solution {
    public int eraseOverlapIntervals(int[][] intervals) { // 经典选课贪心：按课程结束时间排序，每次选择最早结束的！！！
        int allClass = intervals.length;
        int scheduledClass = 1;
        
        Arrays.sort(intervals, new Comparator<int[]>(){ // java.util.Comparator；重点记住该排序方式！！！
            @Override
            public int compare(int[] o1, int[]o2) { // 重写compare方法；注意返回的是int类型！！！
                return (o1[1] < o2[1]) ? -1 : (o1[1] == o2[1] ? 0 : 1); // 写成三元运算符而不是o1[1]-o2[1]可防止减法溢出！！！
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