package $package;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApplicationBootstrap{

    public static void main( String[] args ){
        SpringApplication.run(SpringApplicationBootstrap.class, args)
    }
}