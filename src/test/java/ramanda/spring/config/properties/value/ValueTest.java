package ramanda.spring.config.properties.value;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@SpringBootTest(classes = ValueTest.TestApplication.class)
public class ValueTest {
    @Autowired
    private TestApplication.ApplicationProperties applicationProperties;

    @Autowired
    private TestApplication.SystemProperties systemProperties;

    @Test
    void testValue(){
        String applicationName = applicationProperties.getApplicationName();
        Boolean applicationProductionMode = applicationProperties.applicationProductionMode;
        Integer applicationVersion = applicationProperties.getApplicationVersion();
        String gopath = systemProperties.getGopath();

        Assertions.assertEquals("Belajar Spring Boot", applicationName);
        Assertions.assertEquals(false, applicationProductionMode);
        Assertions.assertEquals(1, applicationVersion);
        Assertions.assertEquals("C:\\Users\\tamva\\go", gopath);

    }

    @SpringBootApplication
    public static class TestApplication{

        @Component
        @Getter
        public static class SystemProperties{
            @Value("${GOPATH}")
            private String gopath;
        }

        @Component
        @Getter
        public static class ApplicationProperties{
            @Value("${application.version}")
            private Integer applicationVersion;

            @Value("${application.name}")
            private String applicationName;

            @Value("${application.production-mode}")
            private Boolean applicationProductionMode;
        }

    }
}
