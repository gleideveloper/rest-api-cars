package com.analytics.data.service;

import com.analytics.data.entity.dto.CarPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface PostAnalyticsService {
    void saveDataAnalytics(CarPostDTO carPostDTO);
}
