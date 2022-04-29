class Solution {
    public int minMeetingRooms(int[][] intervals) { // 经典机器数量贪心算法，按开始时间从小到大排序！！！
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[]o1, int[]o2) {
                return o1[0] < o2[0] ? -1 : (o1[0] == o2[0] ? 0 : 1); // 重写数组排序，按开始时间从小到大！！！
            }
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() { // 优先队列实现最小堆，存放不同机器当前结束时间！！！
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : (o1 == o2 ? 0 : 1); // 重写优先队列排序，按元素从小到大！！！
            }
        });

        minHeap.add(intervals[0][1]);
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek()) minHeap.poll(); // 不需要增加机器数量时，将堆顶元素弹出！！！
            minHeap.add(intervals[i][1]);
        }

        return minHeap.size();
    }
}