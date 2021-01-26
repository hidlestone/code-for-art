# security-authentication 自定义用户认证

### 自定义认证过程

自定义认证的过程需要实现Spring Security提供的UserDetailService接口，该接口只有一个抽象方法loadUserByUsername，源码如下：

```java
public interface UserDetailsService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
```
loadUserByUsername方法返回一个UserDetail对象，该对象也是一个接口，包含一些用于描述用户信息的方法，源码如下：
```java
public interface UserDetails extends Serializable {

    Collection<? extends GrantedAuthority> getAuthorities();

    String getPassword();

    String getUsername();

    boolean isAccountNonExpired();

    boolean isAccountNonLocked();

    boolean isCredentialsNonExpired();

    boolean isEnabled();
}
```

这些方法的含义如下：
- getAuthorities获取用户包含的权限，返回权限集合，权限是一个继承了GrantedAuthority的对象；
- getPassword和getUsername用于获取密码和用户名；
- isAccountNonExpired方法返回boolean类型，用于判断账户是否未过期，未过期返回true反之返回false；
- isAccountNonLocked方法用于判断账户是否未锁定；
- isCredentialsNonExpired用于判断用户凭证是否没过期，即密码是否未过期；
- isEnabled方法用于判断用户是否可用。

实际中我们可以自定义UserDetails接口的实现类，也可以直接使用Spring Security提供的UserDetails接口实现类org.springframework.security.core.userdetails.User。


























