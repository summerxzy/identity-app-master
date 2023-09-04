package scut.deng.didservice.pojo.issue;

import lombok.Data;  // 导入Lombok的@Data注解，用于自动生成getter和setter方法
import java.time.LocalDateTime;  // 导入Java 8中的LocalDateTime类

@Data  // 自动生成getter和setter方法
public class Issuer {
    private int id;  // 发行者的唯一标识符

    private String uuid;  // 发行者的UUID
    private String did;  // DID（分布式身份标识）信息
    private String website;  // 网站信息
    private String endpoint;  // 终端信息

    private String shortDescription;  // 简短描述信息

    private String longDescription;  // 长描述信息

    /*issuer提供的认证类型*/
    private String serviceType;  // 发行者提供的认证类型信息

    /*需要向 issuer 提供的信息*/
//    private RequestData requestData;  // 需要向发行者提供的信息（此行代码被注释掉了）

    private boolean deleted;  // 标识是否已删除

    private LocalDateTime createtime;  // 创建时间，使用Java 8的LocalDateTime类表示

    private LocalDateTime updatetime;  // 更新时间，使用Java 8的LocalDateTime类表示
}
