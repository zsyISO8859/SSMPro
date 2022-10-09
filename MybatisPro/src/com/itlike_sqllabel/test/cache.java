package com.itlike_sqllabel.test;

// 一级缓存：sqlsession级别
// 默认开启 在sapsession没有关闭时候再去查询相同的内容会从缓存中取数据 不会重新发送sql
// 如果查询之前执行了增删改就会导致缓存失效

// 二级缓存: mapper级别
// 以前需要手动开启 现在默认开启了（增加set配置、pojo序列化、mapper中写<cache>）
// 一个namespace对应一个缓存 会话关闭才会将缓存保存到二级缓存中

//缓存使用顺序:
//	先到二级缓存当中查找
//	如果二级缓存中没有,就去找一级缓存
//	如果一级缓存中也没有就去到数据库当中查询
public class cache {

}
