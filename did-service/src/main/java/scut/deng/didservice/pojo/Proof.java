package scut.deng.didservice.pojo;

import lombok.Data;

@Data
public class Proof {
  private String type;  // 证明的类型
  private String creator;  // 证明的创建者
  private String signatureValue;  // 证明的签名值
}
