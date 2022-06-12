class Solution {
    public int[] asteroidCollision(int[] asteroids) { // 判断爆炸发生条件及栈的使用！！！
        int n = asteroids.length;
        Deque<Integer> myStack = new ArrayDeque<>(); // 若在一排处于稳定的小行星右边增加一个新的，若再次稳定前发生碰撞，这些碰撞会自右向左依次发生！！！
		myStack.addFirst(asteroids[0]);

		int i = 1;
        while (i < n) {
            if (!myStack.isEmpty() && myStack.peekFirst() > 0 && asteroids[i] < 0) { // 爆炸条件：当前仅当原先存在小行星且向右移动，新来的向左移动！！！ 
                if (myStack.peekFirst() < (-1*asteroids[i])) { // case1：原先的爆炸；注意新来的可能引起多个原先的爆炸，故在确定稳定前，不能入栈和移动i！！！
                    myStack.removeFirst();
                } else if (myStack.peekFirst() > (-1*asteroids[i])) { // case2：新来的爆炸！！！
                    i++;
                } else { // case3：双方爆炸！！！
                    myStack.removeFirst();
                    i++;
                }
            } else { // 不符合爆炸条件，稳定！！！
                myStack.addFirst(asteroids[i]);
                i++;
            }
        }
		
        int[] result = new int[myStack.size()];
        i = 0;
        while(!myStack.isEmpty()){
            result[i++] = myStack.removeLast(); // 双端队列逆序添加！！！
        }
        return result;
    }
}