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
    private Long duration;
    private String destiny;
    private Date publishedAt;

}
