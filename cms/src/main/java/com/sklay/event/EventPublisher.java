package com.sklay.event;

public interface EventPublisher {

	void asyncPublish(String topicId, String json);

	void publish(String topicId, String json);

}
