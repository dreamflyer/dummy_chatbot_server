package com.onpositive.chatbot;

import com.onpositive.chatbot.listeners.CompletionListener;
import com.onpositive.chatbot.listeners.GetChatListener;
import com.onpositive.chatbot.listeners.PostMessageListener;

public class Main {
	public static void main(String[] args) {
        Server server = new Server();
        
        server.addListener(new PostMessageListener());
        server.addListener(new GetChatListener());
        server.addListener(new CompletionListener());
        
        server.run();
	}
}
