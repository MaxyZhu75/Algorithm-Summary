public class Solution {
    public String fractionAddition(String expression) {
        List<Character> sign = new ArrayList<>();
        if (expression.charAt(0) != '-') {
            sign.add('+');
		}
        for (int i=0; i<expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign.add(expression.charAt(i));
		    }
		}

        int prevNum = 0, prevDen = 1, i = 0;
        for (String current: expression.split("(\\+)|(-)")) { //「. $ | *」等转义字符必须得加「\\」，多个分隔符可以用「|」作为连字符！！！
            if (current.length() > 0) {
                String[] fraction = current.split("/");
                int numerator = (Integer.parseInt(fraction[0]));
                int denominator = (Integer.parseInt(fraction[1]));
                int gcd = Math.abs(gcd(denominator, prevDen));
                if (sign.get(i++) == '+') { //「分子数值计算」！！！
                    prevNum = prevNum*denominator/gcd + numerator*prevDen/gcd;
                } else {
                    prevNum = prevNum*denominator/gcd - numerator*prevDen/gcd;
                }
				prevDen = denominator*prevDen / gcd; //「分母通分」！！！
                
				gcd = Math.abs(gcd(prevDen, prevNum)); //「分数约分」！！！
                prevNum /= gcd;
                prevDen /= gcd;
            }
        }

        return prevNum + "/" + prevDen;
    }
    public int gcd(int a, int b) { //「最大公因数」！！！
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}