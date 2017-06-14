# 项目脚手架
> base(基础框架模块)：用于整合对外部依赖的适配及版本等信息的统一管理，相关子模块如下：
>>  <strong>gulj-base-adapter<strong>: 平台基础框架适配模块，主要用于统一对spring boot的依赖
>>>  <strong>gulj-base-dependency<strong>: 平台基础框架版本管理模块，用于统一管理项目依赖信息

> app(业务模块)：用于具体业务的实际承载，相关子模块如下：
>>  <strong>gulj-app-parent<strong>:  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;  app子模块的父模块，用于统一归集
>>>	<strong>gulj-app-admin</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 后台管理系统Web层
<br/>
 <strong>gulj-app-admin-biz</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 后台管理系统服务层
<br/>
 <strong>gulj-app-blog</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    博客系统web层（消费者）
<br/>
<strong>gulj-app-blog-api</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 博客系统Api接口
<br/>
<strong>gulj-app-blog-biz</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 博客系统服务层（提供者）
		 
> assembly(组件模块)：用于对外部工具的基本封装，除common指定模块外，与具体业务没有任务耦合，即放诸四海皆可用，相关子模块如下：
>>  <strong>gulj-assembly-parent<strong>:  &nbsp;&nbsp;子模块的父模块，用于统一归集
>>>
  <strong>gulj-assembly-email</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		email 组件(可以发送普通文本邮件,嵌入静态资源邮件,带有附件的邮件)
<br/>
 <strong>gulj-assembly-redis </strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   redis 组件（提供两种接口存储，hashkey键值，普通键值）

> common(公共模块)：用于为项目提供公共信息，如：工具类、统一业务bean、ORM相关实体定义以及ORM相关实现，此处定义的orm实体，用于上层领域建模引用；相关子模块如下
>>  <strong>gulj-common-parent<strong>:  &nbsp;&nbsp;子模块的父模块，用于统一归集
>>>
  <strong>gulj-common-util</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		公共工具类模块
<br/>
 <strong>gulj-entity-common</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   orm实体的公共模块
<br/>
 <strong>gulj-entity-common-bo</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   公共业务bean模块，提供公共分页、异常定义等信息



# 项目页面部分展示
![image](https://github.com/gulijian/joingu/blob/master/screenshots/1.jpeg)

