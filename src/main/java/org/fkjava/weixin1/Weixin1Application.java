package org.fkjava.weixin1;

import org.fkjava.weixin1.domain.InMessage;
import org.fkjava.weixin1.service.JsonRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class Weixin1Application {
	//相当于spring的XML配置方式中的<bean>元素
	@Bean
    public RedisTemplate<String,InMessage> inMessageTemplate(@Autowired RedisConnectionFactory redisConnectionFactory){
		RedisTemplate<String,InMessage> template =new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		//设置一个序列化程序，就可以非常方便！
		//由于不确定是那个类型，InMessage只是一个父类，他又许多不同的子类
		//因此扩展jackson2jsonRedisSerializer变得极其重要：重写方法 不要构造参数
		template.setValueSerializer(new JsonRedisSerializer());
		
		return template;
    }
	public static void main(String[] args) {
		SpringApplication.run(Weixin1Application.class, args);
	}

}
