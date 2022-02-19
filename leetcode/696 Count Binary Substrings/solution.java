class Solution { // 空间优化版本请见Go语言答案！！！
    public int countBinarySubstrings(String s) { // 要点一：将字符分组统计！！！
        int n = s.length();
        List<Integer> record = new ArrayList<>();
        char group = s.charAt(0); // 当前分组字符！！！
        int count = 1;
        for (int i=1; i<n; i++) {
            if (s.charAt(i) == group) {
                count++;
            } else {
                record.add(count);
                group = s.charAt(i);
                count = 1;
            }
        }

        record.add(count); // 要点二：循环未将最后一组记录，需在此处补上！！！

        int result = 0;
        for (int i=0; i<record.size()-1; i++) { // 要点三：record中相邻的组代表不同字符，加入result时，符合题目要求的子串数量应该等于相邻组中较短的的那一组的长度（结合题意理解）！！！
            result += Math.min(record.get(i), record.get(i+1));
        }

        return result;
    }
}