package com.github.mxsm.springboot.protobuf;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.springframework.stereotype.Service;

/**
 * @author mxsm
 * @date 2022/1/29 10:33
 * @Since 1.0.0
 */
@Service
public class ThreadPoolService {

    public boolean createThread(){


        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {

            /**
             * Constructs a new {@code Thread}.  Implementations may also initialize priority, name, daemon
             * status, {@code ThreadGroup}, etc.
             *
             * @param r a runnable to be executed by new thread instance
             * @return constructed thread, or {@code null} if the request to create a thread is rejected
             */
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "mxsm");
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("王尼玛");
            }
        });

        return true;
    }

    public boolean addUser(StudentJson json){
        if(json.getFirstName() == null || "".equals(json.getFirstName().trim())){
            throw new IllegalArgumentException("名称不能为空");
        }
        //其他的校验逻辑
        return true;
    }

}
