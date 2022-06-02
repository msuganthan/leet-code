package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null)
            sb.append("#").append(",");
        else {
            sb.append(root.val).append(",");
            serialize(root.left);
            serialize(root.right);
        }
    }

    public TreeNode deserialize(String data) {
        Queue queueData = new LinkedList(Arrays.asList(data.split(",")));
        return deserialize(queueData);
    }

    TreeNode deserialize(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {this.val = val;}
    }
}
