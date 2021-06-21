package cn.xigua366.sample.controller;

import cn.xigua366.sample.domain.vo.StudentVO;
import cn.xigua366.sample.domain.vo.UserVO;
import com.yangxi.cloud.framework.core.JsonData;
import com.yangxi.cloud.framework.core.JsonMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;

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
    @GetMapping("student")
    public StudentVO user(String name) {
        StudentVO studentVO = new StudentVO();
        studentVO.setId(1L);
        studentVO.setSchoolName("广州一中");
        studentVO.setName("zhangsan");
        return studentVO;
    }

    @ApiOperation("测试获取日期类型字段值")
    @GetMapping("getDate")
    public UserVO getDate(String name) {
        UserVO userVO = new UserVO();
        userVO.setId(1L);
        userVO.setName("zhangsan");
        userVO.setPhone("13826434456");
        userVO.setMail("xigua366@qq.com");
        userVO.setBirthday(new Date());
        userVO.setCreatedTime(new Date());
        userVO.setUpdatedTime(LocalDateTime.now());
        return userVO;
    }

    @ApiOperation("测试提交日期类型字段值")
    @PutMapping("putDate")
    public UserVO putDate(HttpServletRequest request, @RequestBody UserVO userVO) {
        return userVO;
    }

    @ApiOperation("测试提交日期类型字段值")
    @PostMapping("postDate")
    public UserVO postDate(UserVO userVO) {
        System.out.println(userVO);
        return userVO;
    }
}