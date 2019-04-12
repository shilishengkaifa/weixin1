package org.fkjava.weixin1.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.fkjava.weixin1.domain.InMessage;
import org.fkjava.weixin1.domain.image.ImageInMessage;
import org.fkjava.weixin1.domain.link.LinkInMessage;
import org.fkjava.weixin1.domain.location.LocationInMessage;
import org.fkjava.weixin1.domain.shortvideo.ShortvideoInMessage;
import org.fkjava.weixin1.domain.text.TextInMessage;
import org.fkjava.weixin1.domain.video.VideoInMessage;
import org.fkjava.weixin1.domain.voice.VoiceInMessage;

public class MessageTypeMapper {
   
	private static Map<String,Class<? extends InMessage>> typeMap =new ConcurrentHashMap<>();
	//通过Map记录了消息类型和类的关系
	static {
		typeMap.put("text",TextInMessage.class);
		typeMap.put("image",ImageInMessage.class);
		typeMap.put("link",LinkInMessage.class);
		typeMap.put("location",LocationInMessage.class);
		typeMap.put("shortvideo",ShortvideoInMessage.class);
		typeMap.put("video",VideoInMessage.class);
		typeMap.put("voice",VoiceInMessage.class);	
	}
	//通过消息类型获取对应的消息
	@SuppressWarnings("unchecked")
	public static <T extends InMessage>Class<T> getClass(String type){
		return (Class<T>) typeMap.get(type);
	}
}
