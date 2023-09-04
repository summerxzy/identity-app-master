package scut.deng.didservice.pojo.constant;

public enum EncryptType {
    RSA("rsa"),           // 枚举常量RSA，表示一种加密类型，其类型字符串为 "rsa"
    SECP256K1("Secp256k1");  // 枚举常量SECP256K1，表示另一种加密类型，其类型字符串为 "Secp256k1"

    private String type;  // 枚举常量的类型字符串

    EncryptType(String type) {  // 枚举类型的构造函数，用于初始化类型字符串
        this.type = type;
    }

    public void setType(String type) {  // 设置类型字符串的方法
        this.type = type;
    }

    public String getType() {  // 获取类型字符串的方法
        return this.type;
    }
}
