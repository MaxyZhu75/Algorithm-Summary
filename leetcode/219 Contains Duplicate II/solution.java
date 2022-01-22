class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) { // ��������HashSetʵ�ֵĻ������ڣ�����
        int n = nums.length;
        Set<Integer> hashWindow = new HashSet<>();
        for (int i=0; i<n; i++) {
            if (i > k) {
                hashWindow.remove(nums[i-(k+1)]); // ά�ִ��ڴ�СΪk+1������
            }
            if (hashWindow.contains(nums[i])) { // HashSet.contains()��ע�⼯�ϵ����ʣ�����
                return true;
            }
            hashWindow.add(nums[i]); // ÿ��ѭ������󶼱���ѵ�ǰ��ָԪ�ؼ��뵽�����У�����
        }
        return false;
    }
}