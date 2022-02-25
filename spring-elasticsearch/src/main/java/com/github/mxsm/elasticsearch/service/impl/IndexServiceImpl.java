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


    @Override
    public boolean createIndex(String indexName) {
        return false;
    }

    @Override
    public boolean deleteIndex(String indexName) {
        return false;
    }

    @Override
    public boolean indexExists(String indexName) {
        return false;
    }
}
