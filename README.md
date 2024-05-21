# 🥤 sophon v4
## 生成web项目
```bash
mvn archetype:generate \
    -DgroupId=com.zeron.sophon \
    -DartifactId=pdmweb \
    -Dversion=1.0.0-SNAPSHOT \
    -Dpackage=com.zeron.pdm \
    -DarchetypeArtifactId=sophon-framework-archetype-web \
    -DarchetypeGroupId=com.zeron.sophon \
    -DarchetypeVersion=3.0.0-SNAPSHOT \
    -DarchetypeCatalog=internal
```

## 生成接口服务 pdm
```bash
mvn archetype:generate \
    -DgroupId=com.zeron.sophon \
    -DartifactId=pdmapi \
    -Dversion=1.0.0-SNAPSHOT \
    -Dpackage=com.zeron.sophon.pdm \
    -DarchetypeArtifactId=sophon-framework-archetype-service \
    -DarchetypeGroupId=com.zeron.sophon \
    -DarchetypeVersion=3.0.0-SNAPSHOT \
    -DarchetypeCatalog=internal
```

<strong>sophon 是 Clean Object-Oriented and Layered Architecture的缩写，代表“整洁面向对象分层架构”。
目前sophon已经发展到[sophon v4](https://blog.csdn.net/significantfrank/article/details/110934799)。</strong>

> - 想了解更多sophon信息，请关注微信公众号：  
> ![qrcode_60.jpg](https://img-blog.csdnimg.cn/2020110314110321.png#pic_center)
> - 想了解更多sophon背后的故事，请支持我的新书[《程序员的底层思维》](https://item.jd.com/13652002.html)

sophon分为两个部分，sophon架构和sophon组件。

# 一、sophon架构

## sophon 概述

**架构**的**意义** 就是 要素结构：

- 要素 是 组成架构的重要元素；
- 结构 是 要素之间的关系。

而 **应用架构**的**意义** 就在于

- 定义一套良好的结构；
- 治理应用复杂度，降低系统熵值；
- 从随心所欲的混乱状态，走向井井有条的有序状态。

![archWhy](https://img-blog.csdnimg.cn/e27c22d706084ead900c8838326135f3.png)

sophon架构就是为此而生，其核心职责就是定义良好的应用结构，提供最佳应用架构的最佳实践。通过不断探索，我们发现良好的分层结构，良好的包结构定义，可以帮助我们治理混乱不堪的业务应用系统。

![cure](https://img-blog.csdnimg.cn/2020120918285068.png)

经过多次迭代，我们定义出了相对稳定、可靠的应用架构：sophon v4

![sophon](https://img-blog.csdnimg.cn/6549230c6723448fb3ab51ca74829e80.png)

## sophon Archetypes

好的应用架构，都遵循一些共同模式，不管是六边形架构、洋葱圈架构、整洁架构、还是sophon架构，**都提倡以业务为核心，解耦外部依赖，分离业务复杂度和技术复杂度等**。

sophon架构区别于这些架构的地方，在于除了思想之外，我们还提供了可落地的工具和实践指导。

为了能够快速创建满足sophon架构的应用，我们提供了两个`archetype`，位于[`sophon-archetypes`目录](sophon-archetypes)下：

1. `sophon-archetype-service`：用来创建纯后端服务的`archetype`。
2. `sophon-archetype-web`：用来创建`adapter`和后端服务一体的`web`应用`archetype`。

# 二、sophon组件

此外，我们还提供了一些非常有用的通用组件，这些组件可以帮助我们提升研发效率。

这些功能组件被收拢在[`sophon-components`目录](sophon-components)下面。到目前为止，我们已经沉淀了以下组件：

组件名称 | 功能 | 依赖
------ | ---- | ----
`sophon-component-dto` | 定义了`DTO`格式，包括分页 |无
`sophon-component-exception` | 定义了异常格式，<br>主要有`BizException`和`SysException` |无
`sophon-component-statemachine` | 状态机组件 | 无
`sophon-component-domain-starter` | `Spring`托管的领域实体组件 | 无
`sophon-component-catchlog-starter` | 异常处理和日志组件 | `exception`、`dto`组件
`sophon-component-extension-starter` | 扩展点组件 | 无
`sophon-component-test-container` | 测试容器组件 | 无

# 三、如何使用sophon

## 1. 创建应用

执行以下命令：

```bash
mvn archetype:generate \
    -DgroupId=com.zeron.sophon.demo.web \
    -DartifactId=demo-web \
    -Dversion=1.0.0-SNAPSHOT \
    -Dpackage=com.alibaba.demo \
    -DarchetypeArtifactId=sophon-framework-archetype-web \
    -DarchetypeGroupId=com.zeron.sophon \
    -DarchetypeVersion=4.3.1
```

命令执行成功的话，会看到如下的应用代码结构：

![demo](https://img-blog.csdnimg.cn/20201209192258840.png)

注：也可以使用阿里云的应用生成器：https://start.aliyun.com/bootstrap.html 生成sophon应用。

## 2. 运行应用

- 在`项目`目录下运行`mvn install`（如果不想运行测试，可以加上`-DskipTests`参数）。
- 进入`start`目录，执行`mvn spring-boot:run`。  
  运行成功的话，可以看到`SpringBoot`启动成功的界面。
- 生成的应用中，已经实现了一个简单的`Rest`请求，可以在浏览器中输入 http://localhost:8080/helloworld 进行测试。

如果要生成不是`web`工程而是`service`工程也类似，执行的是下面的命令：

```bash
mvn archetype:generate \
    -DgroupId=com.zeron.sophon.demo.service \
    -DartifactId=demo-service \
    -Dversion=1.0.0-SNAPSHOT \
    -Dpackage=com.alibaba.demo \
    -DarchetypeArtifactId=sophon-framework-archetype-service \
    -DarchetypeGroupId=com.zeron.sophon \
    -DarchetypeVersion=4.3.1
```

# 版本迭代

## 4.0.0 版本

https://blog.csdn.net/significantfrank/article/details/110934799

## 3.1.0 版本

https://blog.csdn.net/significantfrank/article/details/109529311

1. 进一步简化了`sophon-core`，只保留了扩展能力。
2. 将`exception`从`sophon-core`移入到`sophon-common`。
3. 对`archetype`中的分包逻辑进行重构，改成按照`domain`做划分。
4. 将`sophon-archetype-web`中的`controller`改名为`adapter`，为了呼应六边形架构的命名。

## 3.0.0 版本

https://blog.csdn.net/significantfrank/article/details/106976804

## 2.0.0 版本

https://blog.csdn.net/significantfrank/article/details/100074716

## 1.0.0 版本

https://blog.csdn.net/significantfrank/article/details/85785565


