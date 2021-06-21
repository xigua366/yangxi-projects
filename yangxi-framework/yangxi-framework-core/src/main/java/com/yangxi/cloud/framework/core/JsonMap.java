package com.yangxi.cloud.framework.core;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 自定义Map实现，完全兼容java.util.HashMap
 * </p>
 *
 * @author yangxi
 * @version 1.0
 */
public class JsonMap<K, V> extends HashMap<K, V> {

    public JsonMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public JsonMap(int initialCapacity) {
        super(initialCapacity);
    }

    public JsonMap() {
    }

    public JsonMap(Map<? extends K, ? extends V> m) {
        super(m);
    }
}