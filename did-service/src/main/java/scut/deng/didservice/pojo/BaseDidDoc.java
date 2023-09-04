package scut.deng.didservice.pojo;

import cn.hutool.core.bean.BeanUtil;  // 导入BeanUtil工具类
import lombok.Data;  // 导入Lombok的@Data注解，用于自动生成getter和setter方法
import scut.deng.didservice.pojo.constant.EncryptType;  // 导入EncryptType枚举类

import java.time.LocalDateTime;  // 导入Java 8中的LocalDateTime类
import java.time.format.DateTimeFormatter;  // 导入日期时间格式化工具类
import java.util.ArrayList;  // 导入ArrayList集合类
import java.util.List;  // 导入List集合类
import java.util.Map;  // 导入Map集合类

@Data  // 自动生成getter和setter方法
public class BaseDidDoc {
    private List<PublicKey> keyList;  // 公钥列表
    private String authentication;  // 认证信息
    private String recovery;  // 恢复信息

    // 静态方法，用于设置DID文档
    public static BaseDidDoc setUpDoc(String keyMain, String keyRecover, EncryptType type) {
        BaseDidDoc doc = new BaseDidDoc();

        // 创建主公钥
        PublicKey key_1 = new PublicKey();
        key_1.setType(type.getType());  // 设置公钥类型
        key_1.setKeyString(keyMain);  // 设置主公钥的字符串值
        key_1.setId("#key-1");  // 设置主公钥的ID

        // 创建恢复公钥
        PublicKey key_2 = new PublicKey();
        key_2.setType(type.getType());  // 设置公钥类型
        key_2.setKeyString(keyRecover);  // 设置恢复公钥的字符串值
        key_2.setId("#key-2");  // 设置恢复公钥的ID

        // 初始化公钥列表，并将主公钥和恢复公钥添加到列表中
        List<PublicKey> keyList = new ArrayList<>();
        keyList.add(key_1);
        keyList.add(key_2);
        doc.setKeyList(keyList);  // 设置DID文档的公钥列表

        doc.setAuthentication("#key-1");  // 设置DID文档的认证信息为主公钥的ID
        doc.setRecovery("#key-2");  // 设置DID文档的恢复信息为恢复公钥的ID

        return doc;  // 返回设置好的DID文档对象
    }
}
