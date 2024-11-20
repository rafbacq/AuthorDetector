package io.github.rafbacq.lava;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FrequencyMap<K> implements Map<K, Long> {
    private Map<K, Long> backing;

    public FrequencyMap(Map<K, Long> backing) {
        super();
        this.backing = backing;
    }

    public int size() {
        return backing.size();
    }

    public boolean isEmpty() {
        return backing.isEmpty();
    }

    public boolean containsKey(Object key) {
        return backing.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return backing.containsValue(value);
    }

    public Long get(Object key) {
        return nullIsZero(backing.get(key));
    }

    public Long put(K key, Long value) {
        return nullIsZero(backing.put(key, value));
    }

    public Long remove(Object key) {
        return nullIsZero(backing.remove(key));
    }

    public void putAll(Map<? extends K, ? extends Long> m) {
        backing.putAll(m);
    }

    public void clear() {
        backing.clear();
    }

    public Set<K> keySet() {
        return backing.keySet();
    }

    public Collection<Long> values() {
        return backing.values();
    }

    public Set<Entry<K, Long>> entrySet() {
        return backing.entrySet();
    }

    public boolean equals(Object o) {
        return backing.equals(o);
    }

    public int hashCode() {
        return backing.hashCode();
    }

    public Long getOrDefault(Object key, Long defaultValue) {
        return backing.getOrDefault(key, defaultValue);
    }

    public void forEach(BiConsumer<? super K, ? super Long> action) {
        backing.forEach(action);
    }

    public void replaceAll(BiFunction<? super K, ? super Long, ? extends Long> function) {
        backing.replaceAll(function);
    }

    public Long putIfAbsent(K key, Long value) {
        return nullIsZero(backing.putIfAbsent(key, value));
    }

    public boolean remove(Object key, Object value) {
        return backing.remove(key, value);
    }

    public boolean replace(K key, Long oldValue, Long newValue) {
        return backing.replace(key, oldValue, newValue);
    }

    public Long replace(K key, Long value) {
        return nullIsZero(backing.replace(key, value));
    }

    public Long computeIfAbsent(K key, Function<? super K, ? extends Long> mappingFunction) {
        return backing.computeIfAbsent(key, mappingFunction);
    }

    public Long computeIfPresent(K key, BiFunction<? super K, ? super Long, ? extends Long> remappingFunction) {
        return backing.computeIfPresent(key, remappingFunction);
    }

    public Long compute(K key, BiFunction<? super K, ? super Long, ? extends Long> remappingFunction) {
        return backing.compute(key, remappingFunction);
    }

    public Long merge(K key, Long value, BiFunction<? super Long, ? super Long, ? extends Long> remappingFunction) {
        return backing.merge(key, value, remappingFunction);
    }

    @Override
    public String toString() {
        return String.valueOf(backing);
    }

    private Long nullIsZero(Long l) {
        return l == null ? 0L : l;
    }    
}
