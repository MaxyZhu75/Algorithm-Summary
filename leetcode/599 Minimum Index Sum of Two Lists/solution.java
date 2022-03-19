class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int n = list1.length;
        int m = list2.length;

        Map<String, Integer> hashRecord = new HashMap<>(); // HashMap��<restaurant��indexSum>��������List������һ�μ�����ɣ�����
        
        for (int i=0; i<n; i++) {
            hashRecord.put(list1[i], i); // �Ȱ�List1��restaurant������ȫ��д�룡����
        }

        List<String> result = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;
        for (int j=0; j<m; j++) {
            if (hashRecord.containsKey(list2[j])) { // ����List2ʱ��HashMap�д���key����ͬ�������Ž��к�������������
                int indexSum = hashRecord.get(list2[j]) + j;
                if (indexSum < minIndexSum) {
                    result.clear(); // ArrayList.clear()��List��գ�����
                    result.add(list2[j]);
                    minIndexSum = indexSum;
                } else if (indexSum == minIndexSum) {
                    result.add(list2[j]);
                }
            }
        }
        return result.toArray(new String[result.size()]); // ����ArrayListתΪString����ȽϿӣ���ס��д��������
    }
}