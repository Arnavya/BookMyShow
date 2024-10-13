package com.sst.bookmyshowsst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowSstApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowSstApplication.class, args);
    }

}
/*
Steps to automatically add createAt & lastModifiedAt columns.(Auditing attributes).
i)Enable JPA Auditing at SpringBoot application.
ii)Add this annotation "@EntityListeners(AuditingEntityListener.class)" on BaseModelClass
iii) Use @createdDate, @LastModifiedDate annotations on the respective attributes.
 */
