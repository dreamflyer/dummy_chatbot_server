package com.onpositive.chatbot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.onpositive.chatbot.data.ChatMessage;
import com.onpositive.chatbot.data.ChatMessages;
import com.onpositive.chatbot.listeners.AbstractListener;

public class Server {
	private SocketIOServer connection;
	
	private HashMap<String, ChatMessages> chat = new HashMap<String, ChatMessages>();
	
	public Server() {
		Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(9595);
		
		this.connection = new SocketIOServer(config);
	}
	
	public void addListener(AbstractListener<?, ?> listener) {
		listener.register(this, connection);
	}
	
	public ChatMessages getChat(String sessionId) {
		if(!chat.containsKey(sessionId)) {
			chat.put(sessionId, new ChatMessages());
		}
		
		return chat.get(sessionId);
	}
	
	public Set<String> getSids() {
		return chat.keySet();
	}
	
	public void addMessage(String sessionId, ChatMessage message) {
		message.setId(UUID.randomUUID().toString());
		message.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd.mm.yy")));
		
		getChat(sessionId).add(message);
	}
	
	public void run() {
		connection.start();
		
		new ChatBot(this);
        
        try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        connection.stop();
	}
}
