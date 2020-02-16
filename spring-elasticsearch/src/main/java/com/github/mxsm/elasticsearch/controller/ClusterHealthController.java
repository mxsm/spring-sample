package com.github.mxsm.elasticsearch.controller;

import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequest;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.TimeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author mxsm
 * @Date 2020/2/16 15:21
 */
@RestController
@RequestMapping("/cluster")
public class ClusterHealthController {

    @Autowired
    private ElasticsearchRestTemplate template;

    @GetMapping("/health")
    public ClusterHealthResponse clusterHealth() throws Exception{
        ClusterHealthRequest request = new ClusterHealthRequest();
        request.indices("twitter");
        request.timeout(TimeValue.timeValueSeconds(10));
        ClusterHealthResponse response = template.getClient().cluster().health(request, RequestOptions.DEFAULT);
        return response;
    }

}
