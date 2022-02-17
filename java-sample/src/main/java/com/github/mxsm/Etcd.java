package com.github.mxsm;

import io.etcd.jetcd.ByteSequence;
import io.etcd.jetcd.Client;
import io.etcd.jetcd.KV;
import io.etcd.jetcd.kv.DeleteResponse;
import io.etcd.jetcd.kv.PutResponse;
import io.etcd.jetcd.options.DeleteOption;
import java.util.concurrent.TimeUnit;

/**
 * @author mxsm
 * @date 2022/2/17 23:09
 * @Since 1.0.0
 */
public class Etcd {
    public static void main(String[] args) throws Exception {
        // create client using endpoints
        Client client = Client.builder().endpoints("http://172.26.124.74:2379").build();

        KV kvClient = client.getKVClient();
        ByteSequence key = ByteSequence.from("/mxsm/local/etcd-mxsm/".getBytes());
        ByteSequence value = ByteSequence.from("{\"host\":\"172.22.50.98\",\"ttl\":60}".getBytes());
        PutResponse putResponse = kvClient.put(key, value).get();
        System.out.println(putResponse.toString());

        TimeUnit.SECONDS.sleep(20);
        DeleteResponse deleteResponse = kvClient.delete(key, DeleteOption.newBuilder().isPrefix(true).build()).get();
        System.out.println(deleteResponse);
    }
}
