package scut.deng.didservice.controller;

import cn.hutool.core.codec.Base32;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.text.StrSpliter;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import scut.deng.didservice.exception.MyException;
import scut.deng.didservice.pojo.BaseDidDoc;
import scut.deng.didservice.pojo.constant.Constant;
import scut.deng.didservice.pojo.constant.EncryptType;
import scut.deng.didservice.pojo.request.DIDRequest;
import scut.deng.didservice.pojo.response.BaseResponse;
import scut.deng.didservice.pojo.DidDoc;
import scut.deng.didservice.pojo.constant.ErrorCode;
import scut.deng.didservice.service.DidDocService;
import scut.deng.didservice.util.EncUtil;

import java.security.KeyPair;
import java.time.LocalDateTime;
import java.util.Map;
@Validated  // 启用参数校验
@RequestMapping("did")  // 映射请求路径为"/did"
@RestController  // 声明为RESTful控制器
public class DidController {

    @Autowired  // 自动注入DidDocService依赖
    public DidDocService docService;

    @Resource(name = "VCdict")  // 注入名为"VCdict"的字典对象
    public Dict VCdict;

    // 处理"/did/create" GET请求，用于创建DID
    @RequestMapping(value = "/create")
    public BaseResponse createDID(@RequestParam(value = "type", defaultValue = "user") String type, @RequestParam(value = "comment", defaultValue = "默认评论") String comment) throws MyException {
        if (type.equals("user") || type.equals("enterprise")) {
            return BaseResponse.failure(ErrorCode.REQ_ERROR);
        }
        return docService.createDID(type, comment);
    }

    // 处理"/did/getDoc" POST请求，用于获取DID文档
    @PostMapping(value = "/getDoc")
    public BaseResponse getDIDDoc(@RequestBody DIDRequest didRequest) {
        return docService.getDIDDoc(didRequest.getDid());
    }

    // 处理"/did/getMyVC" GET请求，用于获取用户的VC（可验证凭证）
    @GetMapping(value = "getMyVC")
    public BaseResponse getMyVC() {
        return docService.getMyVC();
    }

    // 处理"/did/getAllDoc" GET请求，用于获取所有DID文档
    @GetMapping("/getAllDoc")
    public BaseResponse getAllDoc() {
        return docService.getAllDoc();
    }

    // 处理"/did/applyVP" GET请求，用于申请VP（可验证表示）
    @GetMapping("applyVP")
    public BaseResponse applyVP(@RequestParam("uuid") String uuid, @RequestParam("index") String index) throws MyException {
        String[] indexVec = StrSpliter.splitToArray(index, ",", 0, true, true);
        return docService.applyForVP(uuid, indexVec);
    }
}
