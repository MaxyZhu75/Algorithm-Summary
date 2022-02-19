class Solution {
    public int maxNumberOfBalloons(String text) { // 即简单统计次数，并取所需字母里数量最少的！！！
        Map<Character, Integer> hashRecord = new HashMap<>();
        for (char letter : text.toCharArray()) {
            if (letter == 'b' || letter == 'a' || letter == 'l' || letter == 'o' || letter == 'n') {
                hashRecord.put(letter, hashRecord.getOrDefault(letter, 0) + 1);
            }
        }

        int bNum = hashRecord.getOrDefault('b', 0);
        int aNum = hashRecord.getOrDefault('a', 0);
        int lNum = hashRecord.getOrDefault('l', 0)/2;
        int oNum = hashRecord.getOrDefault('o', 0)/2;
        int nNum = hashRecord.getOrDefault('n', 0);

        return min(bNum, aNum, lNum, oNum, nNum);
    }

    public int min(int a, int b, int c, int d, int e) {
        if (a <= b && a <= c && a <= d && a <= e) {
            return a;
        } else if (b <= a && b <= c && b <= d && b <= e) {
            return b;
        } else if (c <= a && c <= b && c <= d && c <= e) {
            return c;
        } else if (d <= a && d <= b && d <= c && d <= e) {
            return d;
        } else {
            return e;
        }
    }
}