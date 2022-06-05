class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) { // 0-1背包变形；见LeetCode第416题！！！
		int M = 20000; // 确定准确地M较为繁琐，但该题M最大为20000可以确定，因为target与base属于[1, 10000]，定价超过20000则必不是最优解！！！
		boolean[] d = new boolean[M+1];
        for (int base : baseCosts) { // 必须加base！！！
			if (base <= M) {
				d[base] = true;
			}
		}
        
        for(int topping : toppingCosts){ // 同一个topping只加一次得到的定价！！！
            for(int j=M; j>=1; j--){
                if (j > topping){
					d[j] = d[j] || d[j-topping];
				}
			}
		}

        for(int topping : toppingCosts){ // 同一个topping加两次能得到的定价！！！
            for(int j=M; j>=1; j--){
                if (j > topping){
					d[j] = d[j] || d[j-topping];
				}
			}
		}

        int result = 0;
        int difference = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int i=1; i<=M; i++) { // 答案可能超过target，所以要用abs判断！！！
            difference = Math.abs(i-target);
            if (d[i] == true && difference < minDiff){   
                result = i;
                minDiff = difference;
            }        
        }
        return result;
    }
}