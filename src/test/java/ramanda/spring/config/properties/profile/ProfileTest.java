package ramanda.spring.config.properties.profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@SpringBootTest(classes = ProfileTest.TestApplication.class)
public class ProfileTest {
    @Autowired
    private TestApplication.SayHello sayHello;

    @Test
    void testProfile(){
        Assertions.assertEquals("Hello Ramanda from Local", sayHello.say("Ramanda"));
    }


    @SpringBootApplication
    public static class TestApplication{

        public interface SayHello{
            String say(String name);
        }

        @Component
        @Profile({"local"})
        public static class SayHelloLocal implements SayHello{

            @Override
            public String say(String name) {
                return "Hello " + name + " from Local";
            }
        }

        @Component
        @Profile({"production"})
        public static class SayHelloProduction implements SayHello{

            @Override
            public String say(String name) {
                return "Hello " + name + " from Production";
            }
        }


    }
}