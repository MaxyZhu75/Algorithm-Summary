/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func preorderTraversal(root *TreeNode) []int { // Morris遍历在线性时间完成且空间复杂度为O(1)！！！
    result := []int{}
    if root == nil {
        return result // 前序遍历：根左右！！！
    }

    var subtreeRoot, predecessor *TreeNode = root, nil // 核心思想即将每个节点视作子树根考虑，将相应的前驱节点predecessor指向该subtreeRoot，过程上分为下潜和上浮两个过程（其中要分为总体和局部两个视角）！！！
    
    for subtreeRoot != nil {
        if subtreeRoot.Left != nil { // case1：左边不为空时说明还未办手续，需要先对当前节点的左边办手续，总体上下潜！！！

            predecessor = subtreeRoot.Left // 要点：使用while循环找predecessor；在中序遍历中，前驱结点为左子树的最右子节点！！！
            for predecessor.Right != nil && predecessor.Right != subtreeRoot {
                predecessor = predecessor.Right
            }

            if predecessor.Right == nil { // 未连接：注意前序遍历需要先将当前subtreeRoot加入result；再将predecessor指向当前subtreeRoot后，subtreeRoot才继续往左边下潜！！！
                result = append(result, subtreeRoot.Val)
                predecessor.Right = subtreeRoot
                subtreeRoot = subtreeRoot.Left
            } else if predecessor.Right == subtreeRoot { // 已连接：总体上已下潜结束，总体来看进入上浮过程，需要断开连接；但上浮前需要先处理当前subtreeRoot的右边（又需要局部的下潜上浮）！！！
                predecessor.Right = nil
                subtreeRoot = subtreeRoot.Right
            }

        } else { // case2：左边为空，则将当前subtreeRoot加入结果后，向右边下潜！！！
            result = append(result, subtreeRoot.Val)
            subtreeRoot = subtreeRoot.Right
        }
    }
    return result
}