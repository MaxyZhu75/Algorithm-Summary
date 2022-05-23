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
                result -= currentVal; // case1: С�������ڴ�����ֵ���ߣ��ɹ����֪����6��������ڴ��м�ȥ��С�����ּ��ɣ�����
            } else {
                result += currentVal; // case2: С�������ڴ�����ֵ��ұߣ���ô���Խ�ÿ���ַ�����һ��������ֵ���ۼ�ÿ���ַ���Ӧ����ֵ���ɣ�����
            }
        }
        result += hashRecord.get(s.charAt(n-1)); // ĩβ���ֵ�ֵ��Ȼ��Ҫ����𰸣�����
        return result;
    }
}