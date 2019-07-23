package cn.jsoso.constant;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Getter
@Setter
public class ResultMsg<T> {
    private Integer code;
    private String msg;
    private String url;
    private Integer count;
    private T data;
    private T extData;
}
