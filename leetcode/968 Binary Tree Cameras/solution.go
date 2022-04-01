/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func minCameraCover(root *TreeNode) int { // 要点：dfs递归 + 维护三个状态！！！
    array := dfs(root) 					  // 状态0：当root必须放置摄像头时，覆盖整棵树需要的摄像头数目！！！
    return array[1]      			      // 状态1：无论root是否放置摄像头，覆盖整棵树需要的摄像头数目！！！
}    			  	    	 	          // 状态2：无论root是否被监控到，覆盖左右子树需要的摄像头数目！！！

func dfs(root *TreeNode) []int {
    if root == nil {
        return []int{math.MaxInt32, 0, 0} // 除2是因为防止两个无穷大相加溢出！！！
    }
    leftArray := dfs(root.Left)
    rightArray := dfs(root.Right)
    array := []int{0, 0, 0}
    array[0] = leftArray[2] + rightArray[2] + 1 // 若root安放摄像头，则left和right一定也会被监控到；此时只需要保证left和right各自的左右子树也都被覆盖即可！！！
    array[1] = min(array[0], min(leftArray[0] + rightArray[1], leftArray[1] + rightArray[0])) // root安放摄像头，即状态0的结果；若root不安放摄像头，此时除了需要保证覆盖root的左右子树，为了使root会被监控到，left与right其中一个必须要安装摄像头！！！
    array[2] = min(array[0], leftArray[1] + rightArray[1]) // 若仅保证左右子树被覆盖：要么root安放摄像头，即状态0的结果；要么root不安放摄像头，此时左右子树分别保证自己被覆盖即可，即左右子节点状态1的结果相加！！！
    return array
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}