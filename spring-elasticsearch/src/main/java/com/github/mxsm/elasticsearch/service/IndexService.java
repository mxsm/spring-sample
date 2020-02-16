package com.github.mxsm.elasticsearch.service;

/**
 * description:索引服务
 *
 * @author mxsm
 * @Date 2020/2/16 16:32
 */
public interface IndexService {

    boolean createIndex(String indexName);

    boolean deleteIndex(String indexName);

    boolean indexExists(String indexName);
}
