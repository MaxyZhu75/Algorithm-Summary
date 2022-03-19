class SparseVector {
    
    Map<Integer, Integer> hashRecord; // ������ĳ�Ա������֮��ͬ������Ե��ã�����
    
    SparseVector(int[] nums) {
        hashRecord = new HashMap<>(); // �����ͨ���飬�˴���HashMap���Ը���Ӧ��ϡ�������������к����0��������
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) hashRecord.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        for (int index : this.hashRecord.keySet()) { // ����·�����ʾ����⣬this��ָv1��vec��ָv2������
            if (vec.hashRecord.containsKey(index)) {
                result += this.hashRecord.get(index) * vec.hashRecord.get(index);
            }
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);