
## 项目作用: 展示`application.yml`的简单配置以及为`Person`类注入一些值

#### 主要后台代码：

```java

/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties：告诉SpringBoot将本类中的所有属性和配置文件中相关 的配置进行绑定；
 *      prefix = "person"：配置文件中哪个下面的所有属性进行一一映射
 * 只有这个组件是容器中的组件，才能使用容器提供的@ConfigurationProperties功能；
 * 所以需要使用@Component注解;
 *  @ConfigurationProperties(prefix = "person")默认从全局配置文件中获取值(也可以指定文件)；
 */
@Component("myPerson")
@ConfigurationProperties(prefix = "person")
public class Person {


    private String lastName;
    private Integer age;
    private Boolean boss;

    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
}
```

#### 主要配置文件代码

```yaml
server:
  port: 8081

person:
  lastName: zhangsan
  age: 18
  boss: false
  birth: 2018/01/02
  maps: {k1 : v1, k2 : 100}
  lists:
    - lisi
    - wangwu
  dog:
    name: 小狗
    age: 5
```

#### 测试的简单说明

```java
/**
 * SpringBoot单元测试
 * 可以在测试期间很方便的类似编码一样的进行自动注入等容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {

	@Autowired
	@Qualifier("myPerson")
	private Person person;

	@Test
	public void contextLoads() {
		System.out.println(person); //可以得到容器中的值
	}

}
```