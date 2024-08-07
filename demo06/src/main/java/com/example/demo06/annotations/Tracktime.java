package com.example.demo06.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// Tracktime 可用在 controler 方法上，追蹤執行時間
@Target(ElementType.METHOD) // 指定 @Tracktime 註解只能用在方法上
@Retention(RetentionPolicy.RUNTIME) // 註解在運行時保留
public @interface Tracktime {
        
}