
## 项目作用: 	使用`application.properties`配置文件来替代上一个项目中的`application.yml`文件


#### 配置文件的代码

```properties
server.port=8081

# 乱码问题
spring.http.encoding.force=true
spring.http.encoding.charset=UTF-8
spring.http.encoding.enabled=true
server.tomcat.uri-encoding=UTF-8

# 配置person的值
person.last-name=zhangsan
person.age=18
person.birth=2018/01/02
person.boss=false
person.maps.k1=v1
person.maps.k2=100
person.lists=lisi,wangwu
person.dog.name=小狗
person.dog.age=5
```