package LeetCode.dynamic.SerializeAndDeserializeBinaryTree_297;

public class Main {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(10);

        String encoded = codec.serialize(root);
        TreeNode res = codec.deserialize(encoded);
        String encoded1 = codec.serialize(res);
        System.out.println(encoded);
        System.out.println(encoded1);
    }
}
