package com.manyit.account.controller;

import com.manyit.account.common.result.Result;
import com.manyit.account.common.util.DateTimeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Copyright ® 上海旻瑞信息技术有限公司版权所有。</p>
 * 类名:IndexController
 * 创建人:童海龙    创建时间:2018/5/17
 */
@Api(tags = "统一账户管理系统")
@Controller
@RequestMapping("/system")
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(getClass());



    @ResponseBody
    @RequestMapping(value = "system1", method = RequestMethod.GET,produces ="application/json;charset=utf-8")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "获取系统信息", httpMethod = "GET", notes = "### 返回数据说明：\n```\n{\n" +
            "    \"errcode\": 0, // 接口调用状态 0，正常；-1，错误\n" +
            "    \"errmsg\": \"\" // 接口调用失败时返回的提示信息\n" +
            "}```")
    public Result listSystem1() throws Exception {
        Result result = new Result<>();
        result.setSuccess(true);
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("createtime", DateTimeUtil.getToday());
        map.put("author", "tonghl");
        list.add(map);
        result.setData(list);
        return  result;
    }
}
