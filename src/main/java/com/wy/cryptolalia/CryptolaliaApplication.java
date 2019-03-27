package com.wy.cryptolalia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.wy.cryptolalia.mapper")
@EnableSwagger2
@EnableTransactionManagement
@EnableCaching
public class CryptolaliaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptolaliaApplication.class, args);
    }

}
