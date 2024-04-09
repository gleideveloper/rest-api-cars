package com.analytics.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "brand_analytics")
@Entity
@NoArgsConstructor
public class BrandAnalyticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand;

    private Long posts;

}
