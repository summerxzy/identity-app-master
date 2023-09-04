package scut.deng.didservice.pojo;

import lombok.Data;

@Data  // 使用Lombok的@Data注解，自动生成Getter和Setter方法等
public class DidService {
    private String id;  // 服务的唯一标识符

    private String type;  // 服务类型

    private String serviceEndpoint;  // 服务的终端地址
}
