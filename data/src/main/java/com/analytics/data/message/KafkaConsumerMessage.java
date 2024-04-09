package com.analytics.data.message;


import com.analytics.data.entity.dto.CarPostDTO;
import com.analytics.data.service.PostAnalyticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {
    private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private PostAnalyticsService postAnalyticsService;

    @KafkaListener(topics = "car-post-topic", groupId = "store-posts-group")
    public void listening(CarPostDTO carPost) {

        LOG.info("CAR STORE - Received Car Post information: {}", carPost);
        postAnalyticsService.saveDataAnalytics(carPost);

    }
}
