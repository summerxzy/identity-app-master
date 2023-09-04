package scut.deng.didservice.pojo.issue;

import jakarta.validation.constraints.NotNull;  // 导入用于验证非空的注解
import lombok.Data;  // 导入Lombok的@Data注解，用于自动生成getter和setter方法
import lombok.NonNull;  // 导入Lombok的@NonNull注解，用于标记非空字段
import org.springframework.stereotype.Component;  // 导入Spring框架的@Component注解，用于标记为Spring组件

import java.util.List;  // 导入List集合类

@Data  // 自动生成getter和setter方法
public class DIDInfo {

    @NotNull(message = "did不能为空")  // 使用@NotNull注解标记字段为非空，同时指定错误消息
    public String did;  // DID字段

    @NotNull(message = "website不能为空")  // 使用@NotNull注解标记字段为非空，同时指定错误消息
    public String website;  // 网站字段

    @NotNull(message = "description不能为空")  // 使用@NotNull注解标记字段为非空，同时指定错误消息
    public String description;  // 描述字段

    @NotNull(message = "endpoint不能为空")  // 使用@NotNull注解标记字段为非空，同时指定错误消息
    public String endpoint;  // 终端字段

    @NotNull(message = "serviceType不能为空")  // 使用@NotNull注解标记字段为非空，同时指定错误消息
    public String serviceType;  // 服务类型字段

    @NotNull(message = "requestData不能为空")  // 使用@NotNull注解标记字段为非空，同时指定错误消息
    public List<String> requestData;  // 请求数据字段，使用List来存储多个请求数据
}
