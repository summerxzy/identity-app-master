package scut.deng.didservice.pojo;

import lombok.Data;

@Data  // 使用Lombok的@Data注解，自动生成Getter和Setter方法等
public class PublicKey {
    private String id;  // 公钥的唯一标识符

    private String type;  // 公钥的类型

    private String keyString;  // 公钥的字符串表示，通常是Base64格式
}
