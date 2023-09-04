package scut.deng.didservice.exception;

import scut.deng.didservice.pojo.constant.ErrorCode;

public class MyException extends Exception {
    private final ErrorCode errorCode;
    private String message;

    // 构造函数，接受错误码作为参数
    public MyException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    // 构造函数，接受错误消息作为参数，默认错误码为系统错误
    public MyException(String message) {
        this.errorCode = ErrorCode.SYSTEM_ERROR;
        this.message = message;
    }

    // 构造函数，接受错误码和错误消息作为参数
    public MyException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    // 获取错误码
    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    // 获取异常消息，格式为 "MyException: [ErrorCode], Message: [ErrorMessage]"
    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder("MyException: [")
                .append(this.errorCode).append("], Message: [")
                .append(this.message).append("]");

        return sb.toString();
    }
}
