##### swagger访问:http://host:port/contextPath/swagger-ui.html
> 实例
http://localhost:8080/auth/swagger-ui.html

##### springBoot模块contextPath设置:
主函数实现EmbeddedServletContainerCustomizer接口并实现customize方法
```java
@SpringBootApplication
public class Main implements EmbeddedServletContainerCustomizer {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    // 设置contextPath contextPath中的"/"不能省略
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setContextPath("/main");
    }
}
```



