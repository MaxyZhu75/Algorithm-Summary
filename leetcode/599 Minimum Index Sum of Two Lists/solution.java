class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int n = list1.length;
        int m = list2.length;

        Map<String, Integer> hashRecord = new HashMap<>(); // HashMap存<restaurant，indexSum>，则两个List各遍历一次即可完成！！！
        
        for (int i=0; i<n; i++) {
            hashRecord.put(list1[i], i); // 先把List1中restaurant的索引全部写入！！！
        }

        List<String> result = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;
        for (int j=0; j<m; j++) {
            if (hashRecord.containsKey(list2[j])) { // 遍历List2时，HashMap中存在key（相同餐厅）才进行后续操作！！！
                int indexSum = hashRecord.get(list2[j]) + j;
                if (indexSum < minIndexSum) {
                    result.clear(); // ArrayList.clear()将List清空！！！
                    result.add(list2[j]);
                    minIndexSum = indexSum;
                } else if (indexSum == minIndexSum) {
                    result.add(list2[j]);
                }
            }
        }
        return result.toArray(new String[result.size()]); // 该题ArrayList转为String数组比较坑，记住该写法！！！
    }
}