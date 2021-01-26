# security-smscode 短信验证码登录

在 03.security-validatecode 中，我们已经实现了基于Spring Boot + Spring Security的账号密码登录，并集成了图形验证码功能。时下另一种非常常见的网站登录方式为手机短信验证码登录，但Spring Security默认只提供了账号密码的登录认证逻辑，所以要实现手机短信验证码登录认证功能，我们需要模仿Spring Security账号密码登录逻辑代码来实现一套自己的认证逻辑。

### 短信验证码生成
和图形验证码类似，先定义一个短信验证码对象SmsCode：

SmsCode对象包含了两个属性：code验证码和expireTime过期时间。isExpire方法用于判断短信验证码是否已过期。

接着在ValidateCodeController中加入生成短信验证码相关请求对应的方法：

这里我们使用createSMSCode方法生成了一个6位的纯数字随机数，有效时间为60秒。然后通过SessionStrategy对象的setAttribute方法将短信验证码保存到了Session中，对应的key为SESSION_KEY_SMS_CODE。




















