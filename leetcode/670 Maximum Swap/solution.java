class Solution {
    public int maximumSwap(int num) { // 贪心地将尽可能将最大的数字排到靠前的位置！！！
        String s = String.valueOf(num);
        char[] letters = s.toCharArray(); // 将int先转成string，再最终转成char[]处理！！！
        int n = letters.length;

        int[] previous = new int[10]; // 记录每个数字最后一次出现的下标！！！
        for (int i=0; i<n; i++) {
            previous[letters[i] - '0'] = i;
        }

        for (int i=0; i<n-1; i++) { // 从高位到低位（从左到右）进行处理，贪心地找到低位（当前位置右边）最大的数字去交换！！！
            for (int digit=9; digit > letters[i]-'0'; digit--) { // 期望交换的数字由大到小扫描！！！
                if (previous[digit] > i) {
                    swap(letters, i, previous[digit]);
                    return Integer.parseInt(new String(letters)); // 只允许交换一次，因此直接返回！！！
                }
            }
        }
        return num;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}