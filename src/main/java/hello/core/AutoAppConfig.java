package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        basePackages = "hello.core", // 특정 패키지만 스캔하도록 설정 가능, 미지정 시 해당 클래스의 패키지가 시작 위치로 됨.
        // AppConfig.class 통해 생긴 Configuration.class 제외하기 위함
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
