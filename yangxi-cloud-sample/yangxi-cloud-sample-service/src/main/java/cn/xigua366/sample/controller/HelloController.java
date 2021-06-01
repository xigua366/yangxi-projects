package cn.xigua366.sample.controller;

import com.yangxi.cloud.framework.core.JsonData;
import com.yangxi.cloud.framework.core.JsonMap;
import cn.xigua366.sample.domain.entity.UserDO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <P>
 * hello world示例
 * </P>
 *
 * @author yangxi
 * @version 1.0
 */
@Api(tags = "Hello world示例模块")
@RestController
@RequestMapping("/api/v1/pub/test")
public class HelloController {

    @ApiOperation("hello world测试接口")
    @GetMapping("hello")
    public JsonData<String> hello(String name) {
        String result = "hello," + name;
        return JsonData.buildSuccess(result);
    }

    @ApiOperation("测试直接返回一个字符串")
    @GetMapping("str")
    public String str(String name) {
        return "hello, " + name;
    }

    @ApiOperation("测试直接返回一个JsonMap对象")
    @GetMapping("map")
    public JsonMap<String, String> map(HttpServletRequest request, @RequestParam String name) {
        String page = request.getParameter("page");
        String size = request.getParameter("size");

        JsonMap<String, String> map = new JsonMap<>();

        map.put("a", "1");
        map.put("b", "2");
        map.put("page", page);
        map.put("size", size);

        return map;
    }

    @ApiOperation("测试返回一个普通的POJO对象")
    @GetMapping("user")
    public UserDO user(String name) {
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setName("zhangsan");
        return userDO;
    }
}