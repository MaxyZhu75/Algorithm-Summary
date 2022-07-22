class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return recursion(num);
    }

    String recursion(int num) {
    String result = "";
    if (num < 20) {
	result = LESS_THAN_20[num];
    } else if (num < 100) {
	result = TENS[num/10] + " " + recursion(num%10);
    } else if (num < 1000) {
	result = recursion(num/100) + " Hundred " + recursion(num%100);
    } else if (num < 1000000) {
	result = recursion(num/1000) + " Thousand " + recursion(num%1000);
    } else if (num < 1000000000) {
	result = recursion(num/1000000) + " Million " + recursion(num%1000000);
    } else {
	result = recursion(num/1000000000) + " Billion " + recursion(num%1000000000);
    }

    return result.trim(); // trim()能去除首位空格！！
    }
}
