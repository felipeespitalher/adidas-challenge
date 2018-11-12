package com.adidas.challenge.common.data.output;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "ErrorOutput", description = "ErrorOutput - payload for errors ")
public class ErrorOutput {

    @ApiModelProperty(example = "500", notes = "Http status code")
    private Integer status;
    @ApiModelProperty(example = "2018-04-10T04:00:00.000Z", notes = "Datetime that occurred")
    private Date timestamp;
    @ApiModelProperty(example = "Internal Server Error", notes = "Message")
    private String message;

}
