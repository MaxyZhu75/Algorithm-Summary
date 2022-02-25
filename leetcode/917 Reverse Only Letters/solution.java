class Solution {
    public String reverseOnlyLetters(String s) { // 双指针即可；注意if-else结构，不是字母时当前循环只动一个指针！！！
        int n = s.length();
        char[] chars = s.toCharArray(); // String不可变，先转为字符数组！！！
        int p1 = 0, p2 = n-1;
        while (p1 < p2) {
            if (!Character.isLetter(chars[p1])) { // java.lang.Character.isLetter()！！！
                p1++;
            } else if (!Character.isLetter(chars[p2])) {
                p2--;
            } else if (Character.isLetter(chars[p1]) && Character.isLetter(chars[p2])) {
                swap(chars, p1, p2);
                p1++;
                p2--;
            }
        }

        return String.valueOf(chars);
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}