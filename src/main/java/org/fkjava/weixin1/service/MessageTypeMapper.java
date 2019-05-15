package org.fkjava.weixin1.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.fkjava.weixin1.domain.Object;
import org.fkjava.weixin1.domain.event.EventInMessage;
import org.fkjava.weixin1.domain.image.ImageInMessage;
import org.fkjava.weixin1.domain.link.LinkInMessage;
import org.fkjava.weixin1.domain.location.LocationInMessage;
import org.fkjava.weixin1.domain.shortvideo.ShortvideoInMessage;
import org.fkjava.weixin1.domain.text.TextInMessage;
import org.fkjava.weixin1.domain.video.VideoInMessage;
import org.fkjava.weixin1.domain.voice.VoiceInMessage;

public class MessageTypeMapper {
   
	private static Map<String,Class<? extends Object>> typeMap =new ConcurrentHashMap<>();
	static {
		typeMap.put("text",TextInMessage.class);
		typeMap.put("image",ImageInMessage.class);
		typeMap.put("link",LinkInMessage.class);
		typeMap.put("location",LocationInMessage.class);
		typeMap.put("shortvideo",ShortvideoInMessage.class);
		typeMap.put("video",VideoInMessage.class);
		typeMap.put("voice",VoiceInMessage.class);
		
		typeMap.put("event",EventInMessage.class);
	}
	@SuppressWarnings("unchecked")
	public static <T extends Object>Class<T> getClass(String type){
		return (Class<T>) typeMap.get(type);
	}
}
