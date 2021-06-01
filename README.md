# yangxi-cloud
基于spring boot + mybatis plus + spring cloud alibaba技术栈的微服务快速开发框架


# yangxi-cloud-archetype
一个maven的archetype插件服务，该插件帮助生成基于spring boot框架的骨架工程，快速开始项目搭建

# yangxi-cloud-denpendencies
基础依赖定义，对标spring-boot-denpendencies

# yangxi-cloud-parent
基础父工程，对标spring-boot-parent

# yangxi-cloud-framework
yang-cloud框架自定义扩展的核心类

# yangxi-cloud-starters
yang-cloud框架自定义扩展的starter工程

# yangxi-cloud-sample
yang-cloud框架使用示例工程

## 从archetype中生成项目
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

