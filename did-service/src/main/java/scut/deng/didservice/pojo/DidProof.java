package scut.deng.didservice.pojo;

import lombok.Data;  // 导入Lombok的@Data注解，用于自动生成getter和setter方法

@Data  // 自动生成getter和setter方法
public class DidProof {
    private String type;  // 证明类型
    private String creator;  // 创建者
    private String signatureValue;  // 签名值
}
