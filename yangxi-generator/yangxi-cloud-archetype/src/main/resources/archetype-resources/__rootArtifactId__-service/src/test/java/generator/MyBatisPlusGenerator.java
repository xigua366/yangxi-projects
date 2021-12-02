package ${package}.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * @author yangxi
 */
public class MyBatisPlusGenerator {

    public static void main(String[] args) {
        //1. 全局配置
        GlobalConfig config = new GlobalConfig();
        // 作者
        config.setAuthor("xi.yang")
                // 生成路径，最好使用绝对路径，window路径是不一样的
                .setOutputDir("~/temp/yangxi-cloud-sample-generator/demo/src/main/java")
                // 文件覆盖
                .setFileOverride(true)
                // 主键策略
                .setIdType(IdType.AUTO)
                .setDateType(DateType.ONLY_DATE)
                // 设置生成的service接口的名字的首字母是否为I，默认Service是以I开头的
                .setServiceName("%sDAO")
                .setServiceImplName("%sDAOImpl")
                //实体类结尾名称
                .setEntityName("%sDO")
                //生成基本的resultMap
                .setBaseResultMap(true)
                //不使用AR模式
                .setActiveRecord(false)
                //生成基本的SQL片段
                .setBaseColumnList(true);
        //2. 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        // 设置数据库类型
        dsConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://127.0.0.1:3306/yangxi_boot_sample_admin?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai")
                .setUsername("root")
                .setPassword("root");
        //3. 策略配置globalConfiguration中
        StrategyConfig stConfig = new StrategyConfig();
        //全局大写命名
        stConfig.setCapitalMode(true)
                // 数据库表映射到实体的命名策略
                .setNaming(NamingStrategy.underline_to_camel)
//                .setNaming(NamingStrategy.no_change)
                //使用lombok
                .setEntityLombokModel(true)
                //使用restcontroller注解
                .setRestControllerStyle(false)
                // 生成的表, 支持多表一起生成，以数组形式填写
                // 两个方式，直接写，或者使用命令行输入
                .setInclude("sys_acl", "sys_acl_module", "sys_org", "sys_org_role_ref", "sys_org_user_ref",
                        "sys_role", "sys_role_acl_ref", "sys_user", "sys_user_acl_ref", "sys_user_role_ref"); // 可以写多个，用逗号隔开
        //.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.yangxi.boot.sample")
                .setMapper("mapper")
                .setService("dao")
                .setServiceImpl("dap.impl")
                .setController("controller")
                .setEntity("domain.entity")
                .setXml("mapper");
        //5. 整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);
        //6. 执行操作
        ag.execute();
        System.out.println("======= Done 相关代码生成完毕  ========");
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}