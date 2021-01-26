# security-rememberme 添加记住我功能

在网站的登录页面中，记住我选项是一个很常见的功能，勾选记住我后在一段时间内，用户无需进行登录操作就可以访问系统资源。在Spring Security中添加记住我功能很简单，大致过程是：当用户勾选了记住我选项并登录成功后，Spring Security会生成一个token标识，然后将该token标识持久化到数据库，并且生成一个与该token相对应的cookie返回给浏览器。当用户过段时间再次访问系统时，如果该cookie没有过期，Spring Security便会根据cookie包含的信息从数据库中获取相应的token信息，然后帮用户自动完成登录操作。


#### oken持久化

Spring Security的记住我功能的实现需要使用数据库来持久化token。

然后在BrowserSecurityConfig中配置个token持久化对象：
```java
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        jdbcTokenRepository.setCreateTableOnStartup(false);
        return jdbcTokenRepository;
    }
    ...
}
```

PersistentTokenRepository为一个接口类，这里我们用的是数据库持久化，所以实例用的是PersistentTokenRepository的实现类JdbcTokenRepositoryImpl。

JdbcTokenRepositoryImpl需要指定数据源，所以我们将配置好的数据源对象DataSource注入进来并配置到JdbcTokenRepositoryImpl的dataSource属性中。createTableOnStartup属性用于是否启动项目时创建保存token信息的数据表，这里设置为false，自己手动创建。

查看JdbcTokenRepositoryImpl的源码，可以看到其包含了一个CREATE_TABLE_SQL属性：
```sql
CREATE TABLE persistent_logins (
    username VARCHAR (64) NOT NULL,
    series VARCHAR (64) PRIMARY KEY,
    token VARCHAR (64) NOT NULL,
    last_used TIMESTAMP NOT NULL
)
```

rememberMe()用于开启记住我功能；tokenRepository(persistentTokenRepository())用于指定token持久化方法；tokenValiditySeconds配置了token的有效时长，单为为秒；userDetailsService(userDetailService)用于处理通过token对象自动登录，这里为我们自定义的UserDetailsService接口实现。





















