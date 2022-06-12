class Solution {
    public String longestDiverseString(int a, int b, int c) { // 贪心 + 堆！！！
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]); // 大顶堆，根节点为剩余数量最多的字符！！！
        if (a > 0) {
            heap.add(new int[]{'a', a});
        }
        if (b > 0) {
            heap.add(new int[]{'b', b});
        }
        if (c > 0) {
            heap.add(new int[]{'c', c});
        }

        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            int[] root = heap.poll(); // 每次先弹出最多的字符root待处理；若处理后还有剩余再添加回堆中！！！
            int k = sb.length();
            if (k >= 2 && sb.charAt(k-1) == root[0] && sb.charAt(k-2) == root[0]) { // case1：结尾即将连续出现三个相同字符！！！
                if (!heap.isEmpty()) { // 若堆中仍有节点，则可以拼接次多的字符！！！
                    int[] second = heap.poll();
                    sb.append((char)second[0]);
                    second[1]--;
					if (second[1] > 0) { // 次多节点若处理后还有剩余则添加回堆中！！！
                        heap.add(second);
                    }
                    heap.add(root); // 将弹出的最多节点添加回堆中！！！
                }
            } else { // case2：其余情况均贪心地拼接最多的字符即可！！！
                sb.append((char) root[0]);
				root[1]--;
                if (root[1] > 0) {
                    heap.add(root); // 最多节点若处理后还有剩余则添加回堆中！！！
                }
            }
        }
        return sb.toString();
    }
}