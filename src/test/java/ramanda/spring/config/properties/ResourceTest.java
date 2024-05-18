package ramanda.spring.config.properties;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class ResourceTest {
    @Test
    void testResource() throws IOException {
//        jiak tidak di dalam folder dan berada dalam base folder langsung akses saja
        ClassPathResource resource1 = new ClassPathResource("application.properties");
//        jika di dalam sebuah folder tambahkan foldernya diawal
        ClassPathResource resource = new ClassPathResource("/text/text.txt");

        Assertions.assertNotNull(resource1);
        Assertions.assertTrue(resource1.exists());
        Assertions.assertNotNull(resource1.getFile());

        Assertions.assertNotNull(resource);
        Assertions.assertTrue(resource.exists());
        Assertions.assertNotNull(resource.getFile());
    }
}
