class Solution {
    public int strongPasswordChecker(String password) { // 根据情况选择最优操作；复杂模拟分析见官方解答！！！
        int n = password.length();
        int hasLower = 0, hasUpper = 0, hasDigit = 0;
        for (int i=0; i<n; i++) { // 统计三种字符种类包含几种！！！
            char letter = password.charAt(i);
            if (Character.isLowerCase(letter)) {
                hasLower = 1;
            } else if (Character.isUpperCase(letter)) {
                hasUpper = 1;
            } else if (Character.isDigit(letter)) {
                hasDigit = 1;
            }
        }
        
		int categories = hasLower + hasUpper + hasDigit;
		int operationC = 3-categories; // 保证最终字符串包含全部的3类字符时可能需要的操作数量！！！
		int insert = 0, delete = 0, replace = 0; // 三种操作数量！！！
		
        if (n < 6) { // 可证明只有「添加一个字符」操作有意义（最优）；返回时保证字符串长度和字符种类均满足要求即可！！！
            insert = 6-n;
			return Math.max(insert, operationC);
        
		} else if (n <= 20) { // 可证明只有「替换一个字符」操作有意义（最优）；返回时保证连续字符和字符种类均满足要求即可！！！
			int repeat = 0;
            char preLetter = '#';
            for (int i=0; i<n; i++) { // 统计连续字符个数k，每组对应floor(k/3)次替换操作！！！
                char letter = password.charAt(i);
                if (letter == preLetter) {
                    repeat++;
                } else {
                    replace += repeat/3;
                    preLetter = letter;
					repeat = 1;
                }
            }
            replace += repeat/3;
            return Math.max(replace, operationC);
        
		} else { // 可证明只有「替换一个字符」和「删除一个字符」操作有意义（最优）；返回时保证连续字符和字符种类均满足要求即可！！！
            delete = n - 20;
            int case1 = 0; // 临时保存case1对应的操作次数！！！
            int repeat = 0;
            char preLetter = '#';
            for (int i=0; i<n; i++) { // 统计连续字符个数k，根据情况对变量进行更新！！！
                char letter = password.charAt(i);
                if (letter == preLetter) {
                    repeat++;
                } else {
                    if (delete > 0 && repeat >= 3) {
                        if (repeat % 3 == 0) { // case0：若「k%3=0」，则优先删除1个字符，减少1次替换操作！！！
                            delete--;
                            replace--;
                        } else if (repeat % 3 == 1) { // case1：若「k%3=1」，则可以考虑删除2个字符，减少1次替换操作（不是立即执行）！！！
                            case1++;
                        }  // case2：若「k%3=2」，则可以考虑删除3个字符，减少1次替换操作（无需显示考虑）！！！
                    }
                    replace += repeat/3;
                    preLetter = letter;
                    repeat = 1;
                }
            }
            if (delete > 0 && repeat >= 3) { // 补上面循环最后一次的操作！！！
                if (repeat % 3 == 0) {
                    delete--;
                    replace--;
                } else if (repeat % 3 == 1) {
                    case1++;
                }
            }
            replace += repeat/3;

            case1 = Math.min(Math.min(case1, replace), delete/2); // 实际使用case1对应的操作：取「Min{case1, replace, delete/2}」！！！
            replace -= case1;
            delete -= case1 * 2;
      
            int case2 = Math.min(replace, delete/3); // 实际使用case2对应的操作：取「Min{replace, delete/3}」！！！
            replace -= case2;
            delete -= case2 * 3;
            return (n-20) + Math.max(replace, operationC);
        }
    }
}