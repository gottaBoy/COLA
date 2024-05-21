# sophon发布操作说明

sophon发布到`Maven`中央库操作过程/CheckList。

## 0. 前置准备与配置

在Maven的`settting.xml`中配置`oss.sonatype.org`账号：

```xml

<servers>
    <server>
        <id>ossrh</id>
        <username>__YOUR_USERNAME__</username>
        <password>__YOUR_PASSWORD__</password>
    </server>
</servers>
```

更多发布操作说明（如用于`GPG`签名的`GPG`安装与配置），参见：

- OSSRH Guide  
  https://central.sonatype.org/pages/ossrh-guide.html
- Deploying to OSSRH with Apache Maven - Introduction  
  https://central.sonatype.org/pages/apache-maven.html

发布过程与发布文件的查看地址：

- sonatype的发布控制台  
  https://oss.sonatype.org/index.html
- Maven中央库的文件查看  
  https://repo1.maven.org/maven2/com/zeron/sophon/

发布使用`JDK 17`，为了生成`Javadoc`更现代。  
TODO：这个约束应该要去掉。使用`JDK 8`能发布挺好 :")

## 1. 发布 sophon Components

先确认版本号，去掉`SNAPSHOT`，如`4.x.y`。  
更新版本操作可以通过脚本[`bump_sophon_version`](bump_sophon_version)来统一完成。

在[sophon Components的根目录](../sophon-components)，执行发布

```bash
./mvnw clean && ./mvnw deploy -DperformRelease
```

## 2. 发布 sophon Archetype

先确认版本号，去掉`SNAPSHOT`，如`3.x.y`：

- 更新 Archetype工程的POM文件的工程版本号：
    - [`sophon-archetypes/pom.xml`](../sophon-archetypes/pom.xml)
    - [`sophon-archetype-service/pom.xml`](../sophon-archetypes/sophon-archetype-service/pom.xml)
    - [`sophon-archetype-web/pom.xml`](../sophon-archetypes/sophon-archetype-web/pom.xml)
- 更新 Archetype模板中的POM文件的`sophon.components.version`：
    - [`sophon-archetypes/sophon-archetype-service/src/main/resources/archetype-resources/pom.xml`](../sophon-archetypes/sophon-archetype-service/src/main/resources/archetype-resources/pom.xml)
    - [`sophon-archetypes/sophon-archetype-web/src/main/resources/archetype-resources/pom.xml`](../sophon-archetypes/sophon-archetype-web/src/main/resources/archetype-resources/pom.xml)

更新版本操作可以通过脚本[`bump_sophon_version`](bump_sophon_version)来统一完成。

在[sophon Archetype的根目录](../sophon-archetypes)，执行发布

```bash
./mvnw clean && ./mvnw deploy -DperformRelease
```

## 3. 使用发布版本的sophon Archetype重新生成Sample

在[Samples目录](../samples)执行：

```bash
rm -rf craftsman

./mvnw archetype:generate \
    -DgroupId=com.zeron.sophon.craftsman \
    -DartifactId=craftsman \
    -Dversion=1.0.0-SNAPSHOT \
    -Dpackage=com.zeron.sophon.craftsman \
    -DarchetypeGroupId=com.zeron.sophon \
    -DarchetypeArtifactId=sophon-framework-archetype-web \
    -DarchetypeVersion=3.x.y \
    -DinteractiveMode=false
```

然后`git`提交Sample。
