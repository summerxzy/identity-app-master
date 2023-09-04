package scut.deng.didservice.pojo.request;

import jakarta.validation.constraints.NotNull;  // 导入用于验证非空的注解
import lombok.Data;  // 导入Lombok的@Data注解，用于自动生成getter和setter方法

@Data  // 自动生成getter和setter方法
public class VerifyVCRequest {
    @NotNull  // 使用@NotNull注解标记字段为非空
    public String did;  // DID（分布式身份标识）字段

    @NotNull  // 使用@NotNull注解标记字段为非空
    public String uuid;  // UUID字段

    @NotNull  // 使用@NotNull注解标记字段为非空
    public String encodeMsg;  // 编码消息字段
}
