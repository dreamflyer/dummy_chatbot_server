package com.onpositive.chatbot.listeners;

import java.util.ArrayList;

import com.onpositive.chatbot.data.CompletionRequest;
import com.onpositive.chatbot.data.CompletionResponse;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;

public class CompletionListener extends AbstractListener<CompletionRequest, CompletionResponse> {
	public CompletionListener() {
		super(CompletionRequest.class);
	}
	
	protected void handleRequest(String sessionId, CompletionRequest data, Consumer<CompletionResponse> callback) {
		ArrayList<String> suggestions = new ArrayList<String>();
		
		suggestions.add("oneword1");
		suggestions.add("oneword2");
		suggestions.add("twoword");
		suggestions.add("threeword");
		
		CompletionResponse response = new CompletionResponse();
		
		response.setSuggestions(suggestions);
		
		callback.accept(response);
	}
	
	protected String eventName() {
		return "get_completions";
	}
}
