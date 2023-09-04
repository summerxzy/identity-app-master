package scut.deng.didservice.pojo.response;

import lombok.Data;
import scut.deng.didservice.pojo.constant.ErrorCode;

@Data  // 使用Lombok的@Data注解，自动生成Getter和Setter方法等
public class BaseResponse<T> {

    private int code;  // 响应状态码

    private String msg;  // 响应消息

    private T data;  // 响应数据

    // 无参构造函数
    public BaseResponse() {
    }

    // 带参构造函数，接受状态码和消息作为参数
    public BaseResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    // 带参构造函数，接受错误码和数据作为参数
    public BaseResponse(ErrorCode errorCode, T data) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.data = data;
    }

    // 创建成功响应的静态工厂方法，可传递数据和消息
    public static <T> BaseResponse<T> success(T data, String msg) {
        BaseResponse<T> response = new BaseResponse<>(ErrorCode.SUCCESS, data);
        response.setMsg(msg);
        return response;
    }

    // 创建成功响应的静态工厂方法，可传递数据
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<T>(ErrorCode.SUCCESS, data);
    }

    // 创建成功响应的静态工厂方法，不传递数据和消息
    public static <T> BaseResponse<T> success() {
        return new BaseResponse<T>(ErrorCode.SUCCESS, (T) "");
    }

    // 创建失败响应的静态工厂方法，可传递错误码和占位符参数
    public static <T> BaseResponse<T> failure(ErrorCode errorCode, Object... args) {
        String msg = "";
        if (args != null && args.length > 0) {
            msg = String.format(errorCode.getMsg(), args);
        } else {
            msg = errorCode.getMsg();
        }
        return new BaseResponse<>(errorCode.getCode(), msg);
    }
}

