package gradle_spring_mybatis_java_study.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ContextDataSource.class, ContextSqlSession.class})
@ComponentScan(basePackages = {"gradle_spring_mybatis_java_study.mapper",
                               "gradle_spring_mybatis_java_study.service",
                               ""
})
public class ContextRoot {

}
