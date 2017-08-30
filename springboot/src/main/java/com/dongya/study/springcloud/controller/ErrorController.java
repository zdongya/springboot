package com.dongya.study.springcloud.controller;

import com.dongya.study.springcloud.domain.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Andy on 2017/8/30.
 */
@RestController
public class ErrorController {
    @RequestMapping("/error_token")
    public BaseResponse errorToken(){
        return new BaseResponse(-1, "token异常");
    }
}
