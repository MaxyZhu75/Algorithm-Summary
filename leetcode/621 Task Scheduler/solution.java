class Solution {
    public int leastInterval(char[] tasks, int n) { // 贪心；预留空隙插空！！！
        int[] frequencies = new int[26];
        for (int task : tasks) {
            frequencies[task-'A']++; // 统计每个字母出现频率！！！
        }

        Arrays.sort(frequencies);
        int slot = frequencies[25]-1;
        int idle = slot * n; // 先将出现次数最多的字母排列开来，每个slot由「n个空隙」组成！！！

        for (int i = 24; i >= 0 && idle > 0; i--) { // 遍历其他字母插空占用空隙，每个slot同一种字母至多出现一次；若空隙填满则跳出循环！！！
            idle -= Math.min(slot, frequencies[i]); // 若多个字母频率与最大频率相同，该字母占用空隙时只占「slot个空隙」，剩余一个「往尾部添加」！！！
        }

        return (idle <= 0) ? tasks.length : idle+tasks.length; // 全部空隙被填满后，剩余字母往尾部添加，则周期等于总任务数！！！
    }
}