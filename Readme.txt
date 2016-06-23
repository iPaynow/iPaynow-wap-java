现在支付-中小开发者手机网页类应用支付业务接入指南

2014-08-21

==== 基本要求 ====

    JDK 1.5及以上版本


==== 文件结构 ====

<cpgatetest>
  │
  ├src┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈类文件夹
  │  │
  │  ├com.ipaynow.filter
  │  │  │
  │  │  └CharacterEncodingFilter.java┈┈┈┈┈┈Web字符过滤器
  │  │
  │  ├com.ipaynow.utils
  │  │  │
  │  │  ├FormDateReportConvertor.java┈┈┈ 表单数据型报文数据转换器
  │  │  │
  │  │  ├HttpClientUtil.java┈┈┈┈┈Http协议客户端工具类
  │  │  │
  │  │  ├MD5.java┈┈┈┈ MD5加密基本工具类
  │  │  │
  │  │  └MD5Facade.java┈┈┈┈┈ MD5门面接口工具
  │  │
  │  ├com.ipaynow.pay
  │  │  │
   |   |   |---OrderServlet.java----------------模拟商户订单信息填写页面
   |   |   | 
   |   |   |---ToPayServlet.java---------------- 商户订单确认与支付数据签名Servlet
   |   |   
   |   |---com.ipaynow.notify
   |   |    |
   |   |    |---MchFrontNotifyServlet.java--------------- 商户接收现在支付订单浏览器前端支付结果通知的Servlet
   |   |    |
   |   |    |---MchBackNotifyServlet.java----------------商户接收现在支付服务器端异步通讯通知的Servlet 
   |   | 
   |   |---com.ipaynow.query
   |   |    |
   |   |    |---MchQuery.java-------商户向现在支付发起订单信息和状态查询的Demo
  │      
  │
  ├WebRoot┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈WEB根， 可以直接放在Tomcat上进行运行查看效果
      │  
      │
      └WEB-INF
      |   |
      |   |-lib（如果JAVA项目中包含这些jar包，则不需要导入）
      |   |  │
      |   |  ├commons-logging-1.1.1.jar
      |   |  │
      |   |  ├httpclient-4.1.2.jar
      |   |  │
      |   |  └httpcore-4.1.2.jar| 
      |   |
      |   |-web.xml ------配置了字符过滤器和  商户接收现在支付通知的Servlet
      |     
      |------ order.jsp -------此是模拟商户订单页面
      |
      |------ topay.jsp -------此接口最为关键，是聚合支付接口的参数Form表单
      | 
      |------ frontNotify.jsp ----前端通知接收后的显示页面 
  


==== 注意事项 ====

    此Demo中关键的Java类有两个：1.ToPay.java  ----此类中有参数中数据签名字段的签名方法  为支付参数数据拼凑类
                                2.MchFrontNotifyServlet.java ---此类为前台通知的接收类 此Servlet的url一定是topay.jsp中前台通知url
                                3.MchBackNotifyServlet.java ---此类为后台通知的接受类

    此Demo中关键的页面有一个：  topay.jsp  ---form的url是现在支付的线上接口url。  表单数据即是必要参数 

    本代码示例中获取远程HTTP信息使用的是httpclient-4.1.2 版本的第三方jar包。
    如果您不想使用该方式实现获取远程HTTP功能，可用其他方式替代，此时需您自行编写代码。

