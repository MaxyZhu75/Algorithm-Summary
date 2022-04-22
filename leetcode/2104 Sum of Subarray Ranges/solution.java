class Solution { // 该题与LeetCode第907题使用单调栈的方式有区别，对于弹出元素的处理思维相反！！！
	private int[] nums;
	private int n;
	
	public long subArrayRanges(int[] nums) {
        this.nums = nums;
	this.n = nums.length;
        long result = 0;

        Deque<Integer> myStack = new ArrayDeque<>(); // 单调栈！！！

        for (int i=-1; i<= n; i++) { // 步骤一：从-1到n遍历，以元素nums[cur]作为最大值的子数组个数可表示为(cur - myStack.peek())*(i - cur)！！！
            while (!myStack.isEmpty() && get1(myStack.peek()) < get1(i)) {
                int cur = myStack.pop();
                result = result + (long)(cur - myStack.peek()) * (i - cur) * nums[cur]; 
            }                // 左边界：对于每个出栈的元素nums[cur]，出栈前栈内相邻的下一个元素是向左比它更大的第一个元素！！！
            myStack.push(i); // 右边界：对于每个出栈的元素nums[cur]，当前元素nums[i]是向右比它更大的第一个元素！！！
        }

        myStack.clear();  // 清空栈内元素！！！

        for (int i=-1; i<=n; i++) {  // 步骤二：从-1到n遍历，以元素nums[cur]作为最小值的子数组个数可表示为(cur - myStack.peek())*(i - cur)！！！
            while (!myStack.isEmpty() && get2(myStack.peek()) > get2(i)) {
                int cur = myStack.pop();
                result = result - (long)(cur - myStack.peek()) * (i - cur) * nums[cur]; 
            }                // 左边界：对于每个出栈的元素nums[cur]，出栈前栈内相邻的下一个元素是向左比它更小的第一个元素！！！
            myStack.push(i); // 右边界：对于每个出栈的元素nums[cur]，当前元素nums[i]是向右比它更小的第一个元素！！！
        }
        return result;
    }
	
    private int get1(int i) { // 重写get方法，设立哨兵-1和n，用于求取子数组最大值之和的过程！！！
        if (i == -1 || i == n) {
            return Integer.MAX_VALUE;
        }
        return nums[i];
    }

    private int get2(int i) { // 重写get方法，设立哨兵-1和n，用于求取子数组最小值之和的过程！！！
        if (i == -1 || i == n) {
            return Integer.MIN_VALUE;
        }
        return nums[i];
    }
}
