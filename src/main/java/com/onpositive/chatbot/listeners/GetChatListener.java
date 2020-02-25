package com.onpositive.chatbot.listeners;

import com.onpositive.chatbot.data.ChatMessages;
import com.onpositive.chatbot.data.None;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;

public class GetChatListener extends AbstractListener<None, ChatMessages> {
	public GetChatListener() {
		super(None.class);
	}
	
	protected void handleRequest(String sessionId, None data, Consumer<ChatMessages> callback) {
		callback.accept(this.getServer().getChat(sessionId));
	}
	
	protected String eventName() {
		return "get_chat";
	}
}
