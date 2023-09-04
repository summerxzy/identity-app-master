package scut.deng.didservice.pojo.constant;

public class Constant {
    public static final String SCHEME = "did";  // 定义了一个DID（分布式身份标识）的方案为 "did"

    public static final String DID_METHOD = "OPPO";  // 定义了一个DID方法为 "OPPO"

    public static final String REAL_NAME_AUTHENTICATION = "RealNameAuthentication"; // 实名认证
    public static final String FINGER_PRINT_AUTHENTICATION = "FingerprintAuthentication"; // 指纹认证
    public static final String ENTER_PRISE_AUTHENTICATION = "EnterpriseAuthentication"; // 企业认证
    public static final String BUSINESS_AUTHENTICATION = "BusinessAuthentication"; // 商户认证

    public static final String KEY_1 = "#key-1";  // 定义一个键为 "#key-1"
    public static final String KEY_2 = "#key-2";  // 定义一个键为 "#key-2"
    public static final String DID = "#did";  // 定义一个键为 "#did"

    public static final String ENTERPRISE = "enterprise";  // 定义一个字符串 "enterprise"

    public static final String USER = "user";  // 定义一个字符串 "user"

    /*VP相关*/
    public static final String MERKLE = "#Merkle";  // 定义一个键为 "#Merkle"
    public static final String ATTRIBUTE = "#Attribute";  // 定义一个键为 "#Attribute"
    public static final String VP = "#VP";  // 定义一个键为 "#VP"

    // 定义了两个常量，表示区块链客户端的地址
    public static final String FABRIC_CLIENT = "http://localhost:8080/fabric/";
    public static final String ISSUER_CLIENT = "http://localhost:8080/issuer/";
}
