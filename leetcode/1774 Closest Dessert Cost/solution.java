class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) { // 0-1�������Σ���LeetCode��416�⣡����
		int M = 20000; // ȷ��׼ȷ��M��Ϊ������������M���Ϊ20000����ȷ������Ϊtarget��base����[1, 10000]�����۳���20000��ز������Ž⣡����
		boolean[] d = new boolean[M+1];
        for (int base : baseCosts) { // �����base������
			if (base <= M) {
				d[base] = true;
			}
		}
        
        for(int topping : toppingCosts){ // ͬһ��toppingֻ��һ�εõ��Ķ��ۣ�����
            for(int j=M; j>=1; j--){
                if (j > topping){
					d[j] = d[j] || d[j-topping];
				}
			}
		}

        for(int topping : toppingCosts){ // ͬһ��topping�������ܵõ��Ķ��ۣ�����
            for(int j=M; j>=1; j--){
                if (j > topping){
					d[j] = d[j] || d[j-topping];
				}
			}
		}

        int result = 0;
        int difference = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int i=1; i<=M; i++) { // �𰸿��ܳ���target������Ҫ��abs�жϣ�����
            difference = Math.abs(i-target);
            if (d[i] == true && difference < minDiff){   
                result = i;
                minDiff = difference;
            }        
        }
        return result;
    }
}