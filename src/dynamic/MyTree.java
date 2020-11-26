package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 根据前序和中序遍历结果
 * @author 郑凯努
 * @version 1.0
 * @date 2020/7/22
 */
public class MyTree {

    private TreeNode root;

    public static class TreeNode {
        private int value;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public List<Integer> preOrder() {
        List<Integer> res = new LinkedList<>();
        preOrder(root, res);
        return res;
    }

    public void preOrder(TreeNode node, List<Integer> res) {
        if (node != null) {
            res.add(node.value);
            preOrder(node.left, res);
            preOrder(node.right, res);
        }
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        // 在中序中找到前序的根
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                // 左子树，注意 copyOfRange 函数，左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                // 右子树，注意 copyOfRange 函数，左闭右开
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};

        TreeNode node = MyTree.reConstructBinaryTree(pre, in);

        List<Integer> preOrder = new ArrayList<>();
        new MyTree().preOrder(node, preOrder);
        preOrder.forEach(System.out::println);
    }
}
