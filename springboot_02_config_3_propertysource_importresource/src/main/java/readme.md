## `@PropertySource`和`@ImportResource`的使用


#### 使用一个单独的`person.properties`来配置`Person`的属性值: 需要在`Person`类上加入注解

```java
@PropertySource(value = {"classpath:person.properties"}) //需要加入这个注解
@Component("myPerson")
@ConfigurationProperties(prefix = "person")
public class Person {

}
```

#### 以前的Spring配置文件默认不能直接生效，需要在配置类(主配置类上加上`@ImportResource`注解)

看主配置类的注解:
```java
//@ImportResource(locations = {"classpath:beans.xml"}) // 但是Spring不推荐使用配置，而是使用全注解
@SpringBootApplication
public class SpringBoot02Config3PropertySourceImportResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot02Config3PropertySourceImportResourceApplication.class, args);
	}
}
```
这里我注释了这个注解，　因为SpringBoot不推荐我们使用配置beans.xml这种配置的方式，而是推荐全注解式的开发。

所以我写了`MyAppConfig`这个配置类（需要加上`@Configuration`注解）

```java
/**
 * @Configuration：指明当前类是一个配置类；就是来替代之前的Spring配置文件
 * 类似 : 在配置文件中用<bean><bean/>标签添加组件
 */
@Configuration
public class MyAppConfig {

    //将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloService01(){
        System.out.println("配置类@Bean给容器中添加组件了...");
        return new HelloService();
    }
}
```