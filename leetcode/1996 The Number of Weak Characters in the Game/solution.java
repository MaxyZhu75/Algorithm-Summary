class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int maxDefense = 0;
        int weak = 0;

        Arrays.sort(properties, new Comparator<int[]>() { // 关键点：此处排序要遵循两个规则！！！
            @Override // 规则一：整个数组攻击降序排列！！！
            public int compare(int[] o1, int[] o2) { // 规则二：攻击相同的子集按防守升序排列！！！
                return (o1[0] == o2[0]) ? (o1[1] - o2[1]) : (o2[0] - o1[0]); // 此种写法方便同时写两种排序规则，只是未考虑减法溢出，不使用减法请见LeetCode435题！！！
            }
        });

        for (int[] property : properties) {
            if (property[1] < maxDefense) { // 由于相同攻击的子集中，最大防御已被放在该子集的最后面，则保证了遍历该子集内部时不可能产生weak++！！！
                weak++;
            } else {
                maxDefense = property[1]; // 更新最大防御！！！
            }
        }

        return weak;
    }
}