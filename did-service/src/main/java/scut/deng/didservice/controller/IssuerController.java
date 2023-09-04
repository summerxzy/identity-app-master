package scut.deng.didservice.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import scut.deng.didservice.exception.MyException;
import scut.deng.didservice.pojo.response.BaseResponse;
import scut.deng.didservice.service.IssuerService;

import java.util.Map;
@RestController  // 声明为RESTful控制器
@Slf4j  // 使用Lombok提供的@Slf4j注解，生成日志记录器
@AllArgsConstructor  // 使用Lombok提供的@AllArgsConstructor注解，生成构造函数
@RequestMapping("/scutIssuer")  // 映射请求路径为"/scutIssuer"
public class IssuerController {

    @Autowired  // 自动注入IssuerService依赖
    public IssuerService issuerService;

    // 处理"/scutIssuer/getAll" GET请求，用于获取所有发行者列表
    @GetMapping("/getAll")
    public BaseResponse getAllIssuers() {
        return issuerService.getIssuerLists();
    }

    // 处理"/scutIssuer/applyVC" POST请求，用于申请VC（可验证凭证）
    @PostMapping("/applyVC")
    public BaseResponse applyVC(@RequestBody Map<String, Object> map) throws MyException {
        JSONObject didInfo = JSONUtil.parseObj(map.get("didInfo"));
        JSONObject provideData = JSONUtil.parseObj(map.get("provideData"));
        return issuerService.applyForVC(didInfo, provideData);
    }
}

