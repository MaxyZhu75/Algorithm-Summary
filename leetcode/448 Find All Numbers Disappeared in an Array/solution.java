class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) { // 将答案与索引关联进行原地修改！！！
        int n = nums.length;
        for (int num : nums) {
            int i = (num - 1) % n; // 细节：由于当前num可能已添加了k次n，因此需要「%n」操作确定index！！！
            nums[i] += n; // 对num的值对应的索引处进行「+n」操作！！！
        }
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if (nums[i] <= n) {
                result.add(i+1); // 未出现过的数对应的索引处必然没被「+n」！！！
            }
        }
        return result;
    }
}