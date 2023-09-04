package scut.deng.didservice.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import scut.deng.didservice.exception.MyException;
import scut.deng.didservice.pojo.issue.DIDInfo;
import scut.deng.didservice.pojo.response.BaseResponse;
import scut.deng.didservice.service.RegisterCenterService;

import java.util.Map;

@RestController  // 声明为RESTful控制器
@Slf4j  // 使用Lombok提供的@Slf4j注解，生成日志记录器
@RequestMapping("/registerCenter")  // 映射请求路径为"/registerCenter"
@Validated  // 启用参数校验
public class RegisterCenterController {

    @Autowired  // 自动注入RegisterCenterService依赖
    public RegisterCenterService registerCenterService;

    // 处理"/registerCenter/register" POST请求，用于注册发行者
    @PostMapping("/register")
    public BaseResponse registerIssuer(@RequestBody @Validated DIDInfo data) throws MyException {
        return registerCenterService.registerIssuer(data);
    }

    // 处理"/registerCenter/getIssuerInfo" GET请求，用于获取发行者信息
    @GetMapping("/getIssuerInfo")
    public BaseResponse getIssuerInfo(@NotNull @RequestParam("website") String website) {
        return registerCenterService.getIssuerInfo(website);
    }
}
