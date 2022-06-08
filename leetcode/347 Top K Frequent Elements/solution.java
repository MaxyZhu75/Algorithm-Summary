class Solution {
    public int[] topKFrequent(int[] nums, int k) { // ǰk��Ԫ�����⣻���ȶ���ʵ�ֶѣ�����
        Map<Integer, Integer> hashRecord = new HashMap<>(); // ͳ��ÿ�����ֵ�Ƶ�ʣ�����
        for (int num : nums) {
            hashRecord.put(num, hashRecord.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // С���ѣ����������б��ֶѵĴ�СΪk��Ԫ�ؼ��ɣ�����
        
		for (Map.Entry<Integer, Integer> entry : hashRecord.entrySet()) {
            int num = entry.getKey(), frequency = entry.getValue();
            if (heap.size() == k) { // case1���ѵ�Ԫ�ظ�������k������root���½ڵ��frequency������
                if (heap.peek()[1] < frequency) { // ����½ڵ�Ƶ�ʸ��ߣ��򵯳�root�����½ڵ������У�����
                    heap.poll();
                    heap.add(new int[]{num, frequency});
                }
            } else { // case2������ѵ�Ԫ�ظ���С��k�����½ڵ�ֱ�Ӽ�����У�����
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