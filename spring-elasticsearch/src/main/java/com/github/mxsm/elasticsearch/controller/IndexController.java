package com.github.mxsm.elasticsearch.controller;

import com.github.mxsm.elasticsearch.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author mxsm
 * @Date 2020/2/16 16:39
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @PostMapping
    public boolean createIndex(@RequestParam("indexName") String indexName){
        return indexService.createIndex(indexName);
    }

    @DeleteMapping("/{indexName}")
    public boolean deleteIndex(@PathVariable("indexName") String indexName){
        return indexService.deleteIndex(indexName);
    }

    @GetMapping
    public boolean indexExists(@RequestParam("indexName") String indexName){
        return indexService.indexExists(indexName);
    }
}
