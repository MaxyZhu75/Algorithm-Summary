class Solution {
    public List<Integer> findAnagrams(String s, String p) { // 滑动窗口！！！
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        int [] pCount = new int[26];
        int [] sCount = new int[26];
        for (char c : p.toCharArray()) { // 存储「p」各个字母的数量！！！
            pCount[(int)(c-'a')]++;
        }

        int k = p.length();
        for (int i=0; i<s.length(); i++) { // 统计大小为「k」的滑动窗口内，「s」各个字母的数量！！！
            sCount[(int)(s.charAt(i)-'a')]++;
            if (i >= k) {
                sCount[(int)(s.charAt(i-k)-'a')]--;
            }
            if (Arrays.equals(pCount, sCount)) { // 比较两数组内容是否相同即可！！！
                result.add(i-k+1);
            }
        }
        return result;
    }
}
