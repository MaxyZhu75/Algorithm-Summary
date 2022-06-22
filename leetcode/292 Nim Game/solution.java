class Solution {
    public boolean canWinNim(int n) { // 数学推理「博弈论」；证明见官方解答！！！
        return n % 4 != 0; // 结论：每一步都是最优解时，若A的回合石头剩余数目为4的倍数，B一定可以使之后A的每个回合都面对4的倍数，从而使A输掉游戏！！！
    }
}