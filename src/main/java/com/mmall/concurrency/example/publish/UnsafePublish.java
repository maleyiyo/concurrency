package com.mmall.concurrency.example.publish;

import com.mmall.concurrency.annotations.ThreadNotSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@ThreadNotSafe
public class UnsafePublish {

    private String[] states = {"a","b","c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {

        UnsafePublish unsafePublish = new UnsafePublish();
        log.info(Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";
        log.info(Arrays.toString(unsafePublish.getStates()));
    }
}
