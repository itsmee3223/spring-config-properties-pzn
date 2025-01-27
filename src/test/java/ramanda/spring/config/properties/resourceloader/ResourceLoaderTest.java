package ramanda.spring.config.properties.resourceloader;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@SpringBootTest(classes = ResourceLoaderTest.TestApplication.class)
public class ResourceLoaderTest {
    @Autowired
    private TestApplication.SampleResource sampleResource;

    @Test
    void testResourceLoader() throws Exception{
        String text = sampleResource.getText();
        Assertions.assertEquals("Ramanda Ajisaka Asyraf", text.trim());
    }

    @SpringBootApplication
    public static class TestApplication {
        @Setter
        @Component
        public static class SampleResource implements ResourceLoaderAware {
            private ResourceLoader resourceLoader;

            public String getText() throws Exception{
//                prefix diawal menentukan resource apa yang ingin diload
//                Resource resource = resourceLoader.getResource("file:///Users/Ramanda/file.properties");
//                Resource resource = resourceLoader.getResource("https://www.sample.com/file.properties");
                Resource resource = resourceLoader.getResource("classpath:/text/resource.txt");

                try(var inputStream = resource.getInputStream()){
                    return new String(inputStream.readAllBytes());
                }
            }
        }
    }
}
