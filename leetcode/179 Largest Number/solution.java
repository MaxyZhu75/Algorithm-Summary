class Solution {
    public String largestNumber(int[] nums) { // 贪心 + 重排序；正确性证明见官方题解！！！
        String[] strArray = new String[nums.length];
        for (int i=0; i<nums.length; i++) {
            strArray[i] = String.valueOf(nums[i]); // 全部转为String类型！！！
        }

        Arrays.sort(strArray, new Comparator<String>() { // 每两个字符串数字会有两种拼接结果，我们需要能得到更大的数的顺序！！！
			@Override
            public int compare(String o1, String o2) {
                String order1 = o1 + o2; // 直接「+」连接！！！
                String order2 = o2 + o1;
				return order2.compareTo(order1);
            }
		});

        if (strArray[0].equals("0")) { // 判断数字为0的情况！！！
            return "0";
        }

        StringBuilder sb = new StringBuilder(); // 拼接结果！！！
        for (String num : strArray) {
            sb.append(num);
        }

        return sb.toString();
    }
}