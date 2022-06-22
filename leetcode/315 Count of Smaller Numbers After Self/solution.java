class Solution {
    private int[] index;
    private int[] mergeIndex;
    private int[] merge;
    private int[] result;

    public List<Integer> countSmaller(int[] nums) { // 统计符合要求的对数调用「归并排序」；本题进一步要求「对应元素返回结果」！！！
        int n = nums.length;
		this.index = new int[n]; // 增加数组index与mergeIndex使原始索引随着nums元素排序后的位置变化而变化！！！
        this.mergeIndex = new int[n];
        this.merge = new int[n]; // merge变为全局；每次分治将分段使用！！！
		this.result = new int[n];
        for (int i=0; i<n; i++) {
            index[i] = i;
        }
        mergeCount(nums, 0, n-1);
		List<Integer> resultList = new ArrayList<Integer>();
        for (int num : result) {
            resultList.add(num);
        }
        return resultList;
    }

    public void mergeCount(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
		int mid = (right-left)/2 + left;
		mergeCount(nums, left, mid);
        mergeCount(nums, mid+1, right);

		int p1 = left, p2 = mid+1;
        int i = left;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                merge[i] = nums[p1];
				mergeIndex[i] = index[p1];
				result[index[p1]] += (p2-mid-1); // 找到不符合条件的边界；此时[mid+1,p2)中所有index满足「nums[i]>nums[index]」！！！
				i++;
				p1++;
            } else {
                merge[i] = nums[p2];
				mergeIndex[i] = index[p2];
				i++;
				p2++;
            }
        }
        while (p1 <= mid) { // 其中一个指针走完时，用循环将另一个也走完！！！
            merge[i] = nums[p1];
			mergeIndex[i] = index[p1];
			result[index[p1]] += (p2-mid-1);
			i++;
			p1++;
        }
        while (p2 <= right) {
			merge[i] = nums[p2];
			mergeIndex[i] = index[p2];
			i++;
			p2++;
        }

        for (int k=left; k <= right; k++) { // 将合并且排序后的内容及索引[left,right]填回原数组！！！
            index[k] = mergeIndex[k];
			nums[k] = merge[k];
        }
    }
}