package com.adidas.challenge.common.stream;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cities {

    private String origin;
    private Date departure;
    private String destiny;
    private Date arrival;
    private Date publishedAt;

}
