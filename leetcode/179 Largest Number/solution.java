class Solution {
    public String largestNumber(int[] nums) { // ̰�� + ��������ȷ��֤�����ٷ���⣡����
        String[] strArray = new String[nums.length];
        for (int i=0; i<nums.length; i++) {
            strArray[i] = String.valueOf(nums[i]); // ȫ��תΪString���ͣ�����
        }

        Arrays.sort(strArray, new Comparator<String>() { // ÿ�����ַ������ֻ�������ƴ�ӽ����������Ҫ�ܵõ����������˳�򣡣���
			@Override
            public int compare(String o1, String o2) {
                String order1 = o1 + o2; // ֱ�ӡ�+�����ӣ�����
                String order2 = o2 + o1;
				return order2.compareTo(order1);
            }
		});

        if (strArray[0].equals("0")) { // �ж�����Ϊ0�����������
            return "0";
        }

        StringBuilder sb = new StringBuilder(); // ƴ�ӽ��������
        for (String num : strArray) {
            sb.append(num);
        }

        return sb.toString();
    }
}