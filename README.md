## SpringBoot

### 注意springboot_01_hello不是使用springInitializr创建的


* springboot_01_hello是依赖整个SpringBoot的pom.xml文件的一下内容;


* 但是以后的springboot_02...我都是使用springInitializr创建的，所以不依赖SpringBoot;(整个大项目)
```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.5.9.RELEASE</version>
</parent>
```