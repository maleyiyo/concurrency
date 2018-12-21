package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
@Slf4j
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    private volatile int count = 100;

    private static AtomicExample5 atomicExample5 = new AtomicExample5();

    public static void main(String[] args) {

        if (updater.compareAndSet(atomicExample5, 100, 120)) {
            log.info("update succeed1, {}", atomicExample5.getCount());
        }

        if (updater.compareAndSet(atomicExample5, 100, 120)) {
            log.info("update succeed2, {}", atomicExample5.getCount());
        } else {
            log.info("update fail, {}", atomicExample5.getCount());
        }
    }
}
