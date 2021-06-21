# yangxi-framework
基于spring boot + mybatis plus + spring cloud alibaba技术栈的微服务快速开发框架


## 工程结构介绍
```
yangxi
  yangxi-boot                          // 用于单体项目
    yangxi-boot-denpendencies            // 基础依赖定义，对标spring-boot-denpendencies
    yangxi-boot-parent                   // 基础父工程，对标spring-boot-parent
    yangxi-boot-starters                 // 单体项目开发，自定义扩展的starter
  yangxi-cloud                         // 用于微服务项目
    yangxi-cloud-denpendencies           // 对yangxi-boot-denpendencies的扩展，用于微服务项目
    yangxi-cloud-parent                  // 对yangxi-boot-parent的扩展，用于微服务项目
    yangxi-cloud-starters                // 微服务项目开发，自定义扩展的starter
  yangxi-framework                     // 框架核心模块
    yangxi-framework-core                // 框架核心包代码
    yangxi-framework-web                 // 框架对于web工程的一些扩展代码
  yangxi-generator                     // 代码生成器
  yangxi-samples                       // 示例代码工程
    yangxi-boot-sample                   // 单体项目示例工程
      yangxi-boot-sample-admin              // 单体项目-后台运营管理服务
      yangxi-boot-sample-service            // 单体项目-前台业务服务
    yangxi-cloud-sample                  // 微服务项目示例工程
      yangxi-cloud-sample-member            // 微服务项目-会员服务
      yangxi-cloud-sample-order             // 微服务项目-订单服务
      yangxi-cloud-sample-commodity         // 微服务-商品服务
      yangxi-cloud-sample-pay               // 微服务-支付服务
```


## 入门使用介绍
### 第一步、先本地对yang-cloud进行构建部署（有nexus服务器的话，构建之后可以deploy到nexus私服）
clone代码之后，在本地对yangxi-cloud进行构建：mvn clean install -Dmaven.test.skip=true

### 第二步、基于archetype，本地快速生成项目源码工程
[使用示例]

使用默认值（主要是生成的目标工程的groupId、artifactId、version、package等值）模式。

在命令行的提示下输入各项自定义的值
```
mvn archetype:generate                                    \
	-DarchetypeGroupId=com.yangxi.cloud                    \
	-DarchetypeArtifactId=yangxi-cloud-archetype           \
	-DarchetypeVersion=1.0.0-SNAPSHOT
```

使用指定值模式

也可以直接事先自定义指定groupId，artifactId，version，package来指定生成项目源码工程。
```
mvn archetype:generate                                    \
  -DarchetypeGroupId=com.yangxi.cloud                      \
  -DarchetypeArtifactId=yangxi-cloud-archetype             \
  -DarchetypeVersion=1.0.0-SNAPSHOT                       \
  -DgroupId=com.yangxi                                    \
  -DartifactId=yangxi-cloud-sample                         \
  -Dpackage=cn.xigua366.sample                        \
  -Dversion=1.0.0-SNAPSHOT                                \
  -DarchetypeCatalog=local
```


这个过程可能会很慢，但是如果你之前已经成功执行过一次后，速度会快一点。增加这个参数：-DarchetypeCatalag=local


### 参考相关文档

* [Archetypes简介](https://maven.apache.org/guides/introduction/introduction-to-archetypes.html)
* [创建Archetypes的手册](https://maven.apache.org/guides/mini/guide-creating-archetypes.html)

