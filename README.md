# Blog
一个SSM+shiro博客系统，适合对SSM的初学、熟悉、巩固。<br/>
本项目是在GitHub中找到的开源项目<https://github.com/saysky/ForestBlog>,非常感谢项目作者。<br/>
取出项目中前端静态文件，自己重新写业务逻辑，以达到学习目的，目前已经将项目部署到云服务器上，网站链接<http://kurtblog.cn//><br/>
目前域名正在购买审核，等域名到手后会挂上域名。<br/>
未来如果学的可以的话可能会加上solr搜索，如果更好一点的话还会加上shiro。可能那时候已经就业找工作了吧，先到时候再说。
# 项目介绍
项目基本的逻辑没有什么变化，基本也是按照原项目来，持久层用的是mybatis使用mybatis generator逆向工程生成实体类以及mapper。<br/>
原项目是SSM，我在学习了shiro之后加入了权限控制，当然必须要有其他用户，所以在首页添加了注册功能，权限控制中一共分为两个角色<br/>
1.admin  拥有所有权限
2.passenger 普通游客注册后即为passenger，仅提供添加文章、后台展示、编辑个人文章等操作。
由于不是什么分布式项目，有些上传的静态资源是通过tomcat的静态资源映射到文件夹去了。
配置如下，Linux 服务器上部署<br/>
用nginx+vsftpd弄个图片服务器也可以，如果服务器资源充足的话。

# 待完成
首页如果用户已登陆加一个登出<br/>
可能的话加一个搜索框架<br/>

# 几个注意点
1）本项目使用IDE。<br/>
2）确保 tomcat 配置中 application context 是 /，而不是 /Blog。因为引用css路径都是 /xxx/xxx.css，否则会导致页面没有样式。<br/>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200426104436606.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDAwMTY4MQ==,size_16,color_FFFFFF,t_70)
3）uploadfile<br/>
3.1）对于在IDEA下的tomcat部署需要添加一下文件关联，选择你要关联的文件夹<br/>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200426111717280.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDAwMTY4MQ==,size_16,color_FFFFFF,t_70)
3.2）如果在linux下部署，修改tomcat配置文件设置静态资源映射<br/>
在 tomcat/conf/server.xml  Host 标签内添加如下代码<br/>
```
<Context path="/uploads" docBase="/usr/local/blogfile/uploads" debug="0" reloadable="true" />
```

4)配置的mysql数据库5.X版本，修改路径在\Blog\src\main\resources\db.properties里，
# sql文件之后会上传
# 业务介绍
## 资源加载（拦截器）
设置了一个mvc拦截器HomeResourceInterceptor，拦截路径为“ /** ”，用于加载菜单，以及网站概况，最新文章等等，加入request中，用于显示。
```
<mvc:interceptors>
        <mvc:interceptor>
            <mvc:mapping path="/**"/>
            <bean class="com.xcy.blog.interceptor.HomeResourceInterceptor"/>
        </mvc:interceptor>
</mvc:interceptors>
```
## 后台登陆（拦截器）
设置了一个mvc拦截器SecurityInterceptor，拦截路径为“ /admin/** ”，查找请求中是否包含user,没有的话重定向到"/login"，有的话放行。
```
<mvc:interceptors>
        <mvc:interceptor>
            <mvc:mapping path="/admin/**"/>
            <bean class="com.xcy.blog.interceptor.SecurityInterceptor"/>
        </mvc:interceptor>
</mvc:interceptors>
```
