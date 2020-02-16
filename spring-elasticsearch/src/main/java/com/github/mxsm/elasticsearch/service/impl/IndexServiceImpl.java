package com.github.mxsm.elasticsearch.service.impl;

import com.github.mxsm.elasticsearch.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author mxsm
 * @Date 2020/2/16 16:33
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private ElasticsearchRestTemplate template;


    @Override
    public boolean createIndex(String indexName) {

        boolean indexExists = indexExists(indexName);
        if (indexExists) {
            return false;
        }
        return template.createIndex(indexName);
    }

    @Override
    public boolean deleteIndex(String indexName) {

        boolean indexExists = indexExists(indexName);
        if (indexExists) {
            return false;
        }
        return template.deleteIndex(indexName);
    }

    @Override
    public boolean indexExists(String indexName) {
        return template.indexExists(indexName);
    }
}
