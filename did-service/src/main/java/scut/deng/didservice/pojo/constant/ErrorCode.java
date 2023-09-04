package scut.deng.didservice.pojo.constant;

public enum ErrorCode {
    SUCCESS(0, "操作成功"),  // 操作成功的错误码和描述
    REQ_ERROR(101, "请求参数校验失败"),  // 请求参数校验失败的错误码和描述
    NULL_ERROR(102, "空指针异常"),  // 空指针异常的错误码和描述

    REQUEST_ERROR(103, "请求远程端口出错"),  // 请求远程端口出错的错误码和描述
    NO_DIDDOC(104, "不存在该did标识对应的文档"),  // 不存在该did标识对应的文档的错误码和描述

    ENC_ERROR(105, "加解密出现异常，请检查密钥对或者考虑是否遭遇篡改文档"),  // 加解密出现异常的错误码和描述

    SYSTEM_ERROR(999, "未知异常");  // 未知异常的错误码和描述

    /**
     * 错误码
     */
    private int code;

    /**
     * 错误描述
     */
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {  // 获取错误码的方法
        return this.code;
    }

    public void setCode(int code) {  // 设置错误码的方法
        this.code = code;
    }

    public String getMsg() {  // 获取错误描述的方法
        return this.msg;
    }

    public void setMsg(String msg) {  // 设置错误描述的方法
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
