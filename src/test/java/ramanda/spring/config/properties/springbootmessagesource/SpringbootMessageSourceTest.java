package ramanda.spring.config.properties.springbootmessagesource;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootTest(classes = SpringbootMessageSourceTest.TestApplication.class)
public class SpringbootMessageSourceTest {
    @Autowired
    TestApplication.SampleSource sampleSource;

    @Test
    void testSayHello(){
        Assertions.assertEquals("Hello Ramanda", sampleSource.sayHello(Locale.ENGLISH));
        Assertions.assertEquals("Halo Ramanda", sampleSource.sayHello(new Locale("in_ID")));
    }

    @SpringBootApplication
    public static class TestApplication {

        @Setter
        @Component
        public static class SampleSource implements MessageSourceAware{
             private MessageSource messageSource;

             public String sayHello(Locale locale){
                return messageSource.getMessage("hello", new Object[]{"Ramanda"}, locale);
             }
        }
    }
}
