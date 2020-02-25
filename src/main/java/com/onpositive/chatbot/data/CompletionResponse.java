package com.onpositive.chatbot.data;

import java.util.List;

public class CompletionResponse {
	private List<String> suggestions;

	public List<String> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<String> suggestions) {
		this.suggestions = suggestions;
	}
}
