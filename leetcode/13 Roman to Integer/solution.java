class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> hashRecord = new HashMap<>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        
        int n = s.length();
        int result = 0;
        int currentVal = 0;
        int nextVal = 0;
        for (int i=0; i<n-1; i++) {
            currentVal = hashRecord.get(s.charAt(i));
            nextVal = hashRecord.get(s.charAt(i+1));
            if (currentVal < nextVal) {
                result -= currentVal; // case1: 小的数字在大的数字的左边，由规则可知仅有6种情况，在答案中减去该小的数字即可！！！
            } else {
                result += currentVal; // case2: 小的数字在大的数字的右边，那么可以将每个字符视作一个单独的值，累加每个字符对应的数值即可！！！
            }
        }
        result += hashRecord.get(s.charAt(n-1)); // 末尾数字的值必然需要加入答案！！！
        return result;
    }
}