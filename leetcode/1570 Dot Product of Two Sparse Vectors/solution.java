class SparseVector {
    
    Map<Integer, Integer> hashRecord; // 定义类的成员变量，之后不同对象可以调用！！！
    
    SparseVector(int[] nums) {
        hashRecord = new HashMap<>(); // 相比普通数组，此处用HashMap可以更好应对稀疏向量（向量中含多个0）！！！
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) hashRecord.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        for (int index : this.hashRecord.keySet()) { // 结合下方调用示例理解，this即指v1，vec即指v2！！！
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