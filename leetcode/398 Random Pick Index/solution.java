class Solution { // LeetCode第382题改版；存储各元素的所有索引；空间为O(n)！！！
    Map<Integer, List<Integer>> hashRecord = new HashMap<>();
    Random random;

    public Solution(int[] nums) { // 构造方法！！！
        this.random = new Random();
        for (int i=0; i<nums.length; i++) { // 哈希下拉链表存储各元素的所有索引！！！
            hashRecord.putIfAbsent(nums[i], new ArrayList<Integer>());
            hashRecord.get(nums[i]).add(i);
        }
    }

    public int pick(int target) { // 取指定元素的随机索引方法！！！
        List<Integer> indices = hashRecord.get(target);
        return indices.get(random.nextInt(indices.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */