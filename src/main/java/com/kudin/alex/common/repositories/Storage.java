package com.kudin.alex.common.repositories;

/**
 * Created by KUDIN ALEKSANDR on 24.01.2018.
 */
public interface Storage<T> {

    int saveEntity(T t);
}
