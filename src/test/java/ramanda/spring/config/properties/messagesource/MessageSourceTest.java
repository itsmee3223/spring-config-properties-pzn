package ramanda.spring.config.properties.messagesource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class MessageSourceTest {
    private ConfigurableApplicationContext applicationContext;
    private MessageSource messageSource;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(TestApplication.class);
        messageSource = applicationContext.getBean(MessageSource.class);
    }

    @Test
    void testDefaultLocale(){
        String message = messageSource.getMessage("hello", new Object[]{"Ramanda"}, Locale.ENGLISH);
        Assertions.assertEquals("Hello Ramanda", message);
    }

    void testIndonesianLocale(){
        String message = messageSource.getMessage("hello", new Object[]{"Ramanda"}, new Locale("in_ID"));
        Assertions.assertEquals("Halo Ramanda", message);
    }

    @SpringBootApplication
    public static class TestApplication{
        @Bean
        public MessageSource messageSource(){
            ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
            messageSource.setBasename("my");
            return messageSource;
        }
    }
}
