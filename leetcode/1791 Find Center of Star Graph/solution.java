class Solution {
    public int findCenter(int[][] edges) { // 中心结点必在任意一条边中出现！！！
        return (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) ? edges[0][0] : edges[0][1];
    }
}