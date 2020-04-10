package com.inter.desafiointer.memorycache;

import com.inter.desafiointer.entities.UniqueDigit;
import java.util.Queue;
import java.util.LinkedList;

public class UniqueDigitMemoryCache {

    private Queue<UniqueDigit> cache;

    public UniqueDigitMemoryCache() {
        cache = new LinkedList<>();
    }

    public void put(UniqueDigit value) {
        if (cache.size() >= 10) {
            cache.poll();
        }
        cache.add(value);
    }

    public Queue<UniqueDigit> getCache() {
        return cache;
    }
}