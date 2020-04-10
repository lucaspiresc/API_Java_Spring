package com.inter.desafiointer.memorycache;

import java.util.Queue;
import java.util.LinkedList;
import com.inter.desafiointer.entities.UniqueDigit;

public class UniqueDigitMemoryCache {

    private Queue<UniqueDigit> cache;

    public UniqueDigitMemoryCache() {
        cache = new LinkedList<>();
    }

    public void put(UniqueDigit value) {
        if (cache.size() >= 10 && !cache.contains(value)) {
            cache.poll();
        }
        cache.add(value);
    }
}