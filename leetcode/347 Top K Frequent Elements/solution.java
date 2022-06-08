class Solution {
    public int[] topKFrequent(int[] nums, int k) { // 前k个元素问题；优先队列实现堆！！！
        Map<Integer, Integer> hashRecord = new HashMap<>(); // 统计每个数字的频率！！！
        for (int num : nums) {
            hashRecord.put(num, hashRecord.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // 小根堆；遍历过程中保持堆的大小为k个元素即可！！！
        
	for (Map.Entry<Integer, Integer> entry : hashRecord.entrySet()) {
            int num = entry.getKey(), frequency = entry.getValue();
            if (heap.size() == k) { // case1：堆的元素个数等于k，则检查root与新节点的frequency！！！
                if (heap.peek()[1] < frequency) { // 如果新节点频率更高，则弹出root，将新节点加入堆中！！！
                    heap.poll();
                    heap.add(new int[]{num, frequency});
                }
            } else { // case2：如果堆的元素个数小于k，则将新节点直接加入堆中！！！
                heap.add(new int[]{num, frequency});
            }
        }
        int[] result = new int[k];
        for (int i=0; i<k; i++) {
            result[i] = heap.poll()[0];
        }
        return result;
    }
}
