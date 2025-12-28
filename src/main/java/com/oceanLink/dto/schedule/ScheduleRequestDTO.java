package com.oceanLink.dto.schedule;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleRequestDTO {
    private Long shipId;
    private Long routeId;

    private String departure;

    private String arrival;

    private int price;

}
