package scut.deng.didservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import scut.deng.didservice.exception.MyException;
import scut.deng.didservice.pojo.request.VerifyVCRequest;
import scut.deng.didservice.pojo.response.BaseResponse;
import scut.deng.didservice.service.AppService;

@RestController  // 声明为RESTful控制器
@RequestMapping("/app")  // 映射请求路径为"/app"
@Validated  // 启用参数校验
public class AppController {

    @Autowired  // 自动注入AppService依赖
    public AppService appService;

    // 处理"/app/login" GET请求，用于应用登录
    @RequestMapping("/login")
    public BaseResponse loginApp(@RequestParam(name = "did") String did) throws MyException {
        return appService.loginApp(did);
    }

    // 处理"/app/verifyVC" POST请求，用于验证VC（可验证凭证）
    @PostMapping("/verifyVC")
    public BaseResponse verifyVC(@RequestBody VerifyVCRequest encodeMsg) throws MyException {
        return appService.verifyVC(encodeMsg);
    }

    // 处理"/app/verifyVP" POST请求，用于验证VP（可验证表示）
    @PostMapping("/verifyVP")
    public BaseResponse verifyVP(@RequestBody VerifyVCRequest encodeMsg) throws MyException {
        return appService.verifyVP(encodeMsg);
    }
}
