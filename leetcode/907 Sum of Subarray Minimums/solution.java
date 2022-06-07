class Solution { // 单调栈；另一种逆向思维的方法见LeetCode第2104题！！！
    
	private static final int MOD = 1000000007;
    
	public int sumSubarrayMins(int[] arr) { // arr[i]的辐射范围是一个连续数组，辐射范围内产生的所有子数组最小值都为arr[i]！！！
        int n = arr.length;
        int[] left = new int[n]; // 存储arr[i]辐射范围的左边界！！！
        int[] right = new int[n]; // 存储arr[i]辐射范围的右边界！！！
        Deque<Integer> myStack = new ArrayDeque<>(); // 单调栈！！！

        for (int i=0; i<n; i++) { // 步骤一：从0到n-1遍历，利用单调栈向左找到第一个小于等于arr[i]数，即辐射范围的左边界！！！
            while (!myStack.isEmpty() && arr[myStack.peekFirst()] > arr[i]) {
                myStack.removeFirst(); // 出栈条件：栈顶元素大于当前元素（维护单调栈）！！！
            }
            if (myStack.isEmpty()) { // 向左未找到左边界则定为-1！！！
                left[i] = -1;
            } else {
                left[i] = myStack.peekFirst(); // 存储左边界的值，不弹出！！！
            }
            myStack.addFirst(i); // 每次循环将下标入栈，方便同时得到i和arr[i]！！！
        }

        myStack.clear(); // 清空栈内元素！！！
		
        for (int i=n-1; i>=0; i--) { // 步骤二：从n-1到0遍历，利用单调栈向右找到第一个严格小于arr[i]的数，即辐射范围的右边界！！！
            while (!myStack.isEmpty() && arr[myStack.peekFirst()] >= arr[i]) { // 出栈条件：栈顶元素大于等于当前元素（维护单调栈）！！！
                myStack.removeFirst(); // 仅将右边界判断条件设置为严格小于，是因为当一个子数组中有两个最小值元素时，需要不重复且不遗漏地统计每一个子数组！！！
            }
            if (myStack.isEmpty()) { // 向右未找到右边界则定为n！！！
                right[i] = n;
            } else {
                right[i] = myStack.peekFirst(); // 存储右边界的值，不弹出！！
            }
            myStack.addFirst(i); // 每次循环将下标入栈，方便同时得到i和arr[i]！！！
        }

        long result = 0; // 子数组以元素arr[i]作为最小值时，子数组的左边界应在[left[i],i]中选取，子数组的右边界应在[i,right[i]]中选取！！！
        for (int i=0; i<n; i++) { // 因此由下标定义可知，以元素arr[i]作为最小值的子数组个数可表示为(i-left)*(right-i)！！！
            result = (result + (long)(i - left[i]) * (right[i] - i) * arr[i]) % MOD;
        }
        return (int)result;
    }
}
