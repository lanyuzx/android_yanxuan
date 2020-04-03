package com.lingyun.yanxuan.base;

import lombok.Data;

@Data
public class BaseBean<T> {

    private int code;

    private T data;
}
