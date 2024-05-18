package ramanda.spring.config.properties.environment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = EnvironmentTest.TestApplication.class)
public class EnvironmentTest {
    @Autowired
    Environment environment;

    @Test
    void testEnvironment(){
        String gopath = environment.getProperty("GOPATH");
        Assertions.assertEquals("C:\\Users\\tamva\\go", gopath);
    }

    @SpringBootApplication
    public static class TestApplication{

    }
}
