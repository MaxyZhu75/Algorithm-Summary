class Solution {
    public List<List<Integer>> generate(int numRows) { // 根据定义模拟即可！！！
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
            List<Integer> current = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                if (j == 0 || j == i) {
                    current.add(1);
                } else {
                    int num = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                    current.add(num);
                }
            }
            result.add(current);
        }
        return result;
    }
}