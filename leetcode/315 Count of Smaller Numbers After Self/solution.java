class Solution {
    private int[] index;
    private int[] mergeIndex;
    private int[] merge;
    private int[] result;

    public List<Integer> countSmaller(int[] nums) { // ͳ�Ʒ���Ҫ��Ķ������á��鲢���򡹣������һ��Ҫ�󡸶�ӦԪ�ط��ؽ����������
        int n = nums.length;
		this.index = new int[n]; // ��������index��mergeIndexʹԭʼ��������numsԪ��������λ�ñ仯���仯������
        this.mergeIndex = new int[n];
        this.merge = new int[n]; // merge��Ϊȫ�֣�ÿ�η��ν��ֶ�ʹ�ã�����
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
				result[index[p1]] += (p2-mid-1); // �ҵ������������ı߽磻��ʱ[mid+1,p2)������index���㡸nums[i]>nums[index]��������
				i++;
				p1++;
            } else {
                merge[i] = nums[p2];
				mergeIndex[i] = index[p2];
				i++;
				p2++;
            }
        }
        while (p1 <= mid) { // ����һ��ָ������ʱ����ѭ������һ��Ҳ���꣡����
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

        for (int k=left; k <= right; k++) { // ���ϲ������������ݼ�����[left,right]���ԭ���飡����
            index[k] = mergeIndex[k];
			nums[k] = merge[k];
        }
    }
}