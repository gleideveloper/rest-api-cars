package com.analytics.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "car_model_analytics")
@Entity
@NoArgsConstructor
public class CarModelAnalyticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String model;

    private Long posts;
}
