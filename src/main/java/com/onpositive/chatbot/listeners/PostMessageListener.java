package com.onpositive.chatbot.listeners;

import com.onpositive.chatbot.data.ChatMessage;
import com.onpositive.chatbot.data.None;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;

public class PostMessageListener extends AbstractListener<ChatMessage, None> {	
	public PostMessageListener() {
		super(ChatMessage.class);
	}
	
	protected void handleRequest(String sessionId, ChatMessage data, Consumer<None> callback) {
		this.getServer().addMessage(sessionId, data);
	}
	
	protected String eventName() {
		return "post_message";
	}
}
