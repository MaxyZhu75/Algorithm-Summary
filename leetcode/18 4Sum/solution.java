class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) { // ������ĿΪ����֮�ͣ��������һ��ָ�룡����
        List<List<Integer>> result = new ArrayList<>(); // p1��p2��left��rightָ���ֵ������ͬ���������ظ���result����Ѵ��ڵĴ���ϣ�����
        int n = nums.length;
        if (n < 4) return result;

        Arrays.sort(nums); // �����򣡣���

        for (int p1=0; p1<n-3; p1++) {
            if (p1 > 0 && nums[p1] == nums[p1-1]) continue; // ��ס������֦��������ǿ����Ч�ʣ�����
			if ((long) nums[p1] + nums[p1+1] + nums[p1+2] + nums[p1+3] > target) break;
            if ((long) nums[p1] + nums[n-1] + nums[n-2] + nums[n-3] < target) continue; // long�ɷ�ֹ�ӷ�������⣻�˴����ֱ�ӻ��ɼ����������������

			for (int p2=p1+1; p2<n-2; p2++) {
                if (p2 > p1+1 && nums[p2] == nums[p2-1]) continue; // ��ס������֦��������ǿ����Ч�ʣ�����
                if ((long) nums[p1] + nums[p2] + nums[p2+1] + nums[p2+2] > target) break;
                if ((long) nums[p1] + nums[p2] + nums[n-1] + nums[n-2] < target) continue;

                int left = p2 + 1; // ��ǰp1��p2�̶�����left��rightдwhileѭ����˫ָ�룡��
                int right = n-1;
                while (left < right) {
                    int sum = nums[p1] + nums[p2] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[p1], nums[p2], nums[left], nums[right])); // Arrays.asList(a, b, c��d)������
                        while (left < right && nums[left] == nums[++left]);
                        while (left < right && nums[right] == nums[--right]); // �˴�ѭ��ּ����ǰ�ƶ�ָ��ʹ��һ���𰸲��ظ�������
                    } else if (sum < target) {
                        while (left < right && nums[left] == nums[++left]);
                    } else {
                        while (left < right && nums[right] == nums[--right]);
                    }
                }
            }
        }
        return result;
    }
}