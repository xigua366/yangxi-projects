# yangxi-cloud
基于spring cloud alibaba技术栈的基础开发框架


# yangxi-cloud-archetype
一个maven的archetype插件服务，该插件帮助生成基于spring boot框架的骨架工程，快速开始项目搭建

# yangxi-cloud-denpendencies
基础依赖定义，对标spring-boot-denpendencies

# yangxi-cloud-parent
基础父工程，对标spring-boot-parent

# yangxi-cloud-framework
yang-boot框架自定义扩展的核心类

# yangxi-cloud-starters
yang-boot框架自定义扩展的starter工程

# yangxi-cloud-sample
yang-boot框架使用示例工程

## 从archetype中生成项目
clone代码之后，在本地对yangxi-boot进行构建：mvn clean install

[使用示例]

使用默认值模式，或者按提示在命令行输入自定义的值
```
mvn archetype:generate                                    \
	-DarchetypeGroupId=com.yangxi.cloud                    \
	-DarchetypeArtifactId=yangxi-cloud-archetype           \
	-DarchetypeVersion=1.0.0-SNAPSHOT
```

你也可以输入groupId，artifactId，version，package来指定生成项目。
使用指定值模式
```
mvn archetype:generate                                    \
  -DarchetypeGroupId=com.yangxi.cloud                      \
  -DarchetypeArtifactId=yangxi-cloud-archetype             \
  -DarchetypeVersion=1.0.0-SNAPSHOT                       \
  -DgroupId=com.yangxi                                    \
  -DartifactId=yangxi-cloud-sample                         \
  -Dpackage=com.yangxi.cloud.sample                        \
  -Dversion=1.0.0-SNAPSHOT                                \
  -DarchetypeCatalog=local
```


这个过程可能会很慢，但是如果你之前已经成功执行过一次后，速度会快一点。增加这个参数：-DarchetypeCatalag=local


## 相关文档

* [Archetypes简介](https://maven.apache.org/guides/introduction/introduction-to-archetypes.html)
* [创建Archetypes的手册](https://maven.apache.org/guides/mini/guide-creating-archetypes.html)