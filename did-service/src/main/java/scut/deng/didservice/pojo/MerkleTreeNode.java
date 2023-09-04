package scut.deng.didservice.pojo;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.digest.DigestUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data  // 使用Lombok的@Data注解，自动生成Getter和Setter方法等
public class MerkleTreeNode {
    private String data = null;  // 节点存储的数据
    private String hash = null;  // 节点的哈希值

    private MerkleTreeNode left = null;  // 左子节点
    private MerkleTreeNode right = null;  // 右子节点

    // 构造函数，接受数据、左子节点和右子节点作为参数
    public MerkleTreeNode(String data, MerkleTreeNode left, MerkleTreeNode right) {
        this.left = left;
        this.right = right;
        String hash = SmUtil.sm3(data);  // 使用SmUtil计算数据的哈希值
        this.hash = hash;
        this.data = data;
    }
}
