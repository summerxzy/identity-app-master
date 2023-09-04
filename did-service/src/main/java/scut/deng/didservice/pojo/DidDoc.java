package scut.deng.didservice.pojo;

import cn.hutool.core.bean.BeanUtil;  // 导入Hutool的BeanUtil工具类
import cn.hutool.core.date.DateUtil;  // 导入Hutool的DateUtil工具类
import cn.hutool.json.JSONUtil;  // 导入Hutool的JSONUtil工具类
import jakarta.validation.constraints.NotNull;  // 导入用于验证非空的注解
import lombok.Data;  // 导入Lombok的@Data注解，用于自动生成getter和setter方法
import scut.deng.didservice.pojo.constant.Constant;  // 导入常量类Constant
import scut.deng.didservice.pojo.constant.EncryptType;  // 导入EncryptType枚举类
import scut.deng.didservice.util.EncUtil;  // 导入自定义的加密工具类

import java.util.List;  // 导入List集合类

@Data  // 自动生成getter和setter方法
public class DidDoc {

    @NotNull  // 使用@NotNull注解标记字段为非空
    private String didID;  // DID标识

    @NotNull  // 使用@NotNull注解标记字段为非空
    private Integer version;  // 版本号

    private String createTime;  // 创建时间

    private String updateTime;  // 更新时间

    private List<PublicKey> keyList;  // 公钥列表

    private String type;  // 类型

    private String comment;  // 注释

    @NotNull(message = "公钥对应的私钥的用户就是此 DID 的拥有者，不能为空")
    private String authentication;  // 认证信息

    @NotNull(message = "恢复公钥不能为空")
    private String recovery;  // 恢复信息

    private List<DidService> serviceList;  // DID服务列表

    private Proof proof;  // 证明信息

    // 静态方法，用于创建新的DID文档
    public static DidDoc createNewDID(String did, BaseDidDoc baseDidDoc, String sk) {
        DidDoc didDoc = new DidDoc();

        // 设置DID标识
        didDoc.setDidID(did);

        // 设置时间为当前时间
        String now = DateUtil.now();
        didDoc.setCreateTime(now);
        didDoc.setUpdateTime(now);

        // 设置版本号为1
        didDoc.setVersion(1);

        // 设置认证和恢复信息
        didDoc.setAuthentication(did + baseDidDoc.getAuthentication());
        didDoc.setRecovery(did + baseDidDoc.getRecovery());

        // 将公钥列表中的每个公钥的ID前缀添加DID标识
        baseDidDoc.getKeyList().forEach(x -> {
            x.setId(did + x.getId());
        });

        // 设置公钥列表
        didDoc.setKeyList(baseDidDoc.getKeyList());

        // 将DID文档对象转换为JSON字符串
        String docString = JSONUtil.toJsonStr(BeanUtil.beanToMap(didDoc));

        // 使用私钥将JSON字符串进行加密
        String encstring = EncUtil.digestMsgUseSK(docString, sk);

        // 创建证明信息对象
        Proof proof = new Proof();
        proof.setType(EncryptType.RSA.getType());
        proof.setCreator(did + "#key-1");
        proof.setSignatureValue(encstring);

        // 设置证明信息
        didDoc.setProof(proof);

        return didDoc;  // 返回创建好的DID文档对象
    }
}
