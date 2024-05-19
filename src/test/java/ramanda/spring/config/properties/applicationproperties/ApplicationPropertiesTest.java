package ramanda.spring.config.properties.applicationproperties;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import ramanda.spring.config.properties.ApplicationProperties;

import java.util.Arrays;

@SpringBootTest(classes = ApplicationPropertiesTest.TestApplication.class)
public class ApplicationPropertiesTest {
    @Autowired
    private ApplicationProperties properties;

    @Test
    void testApplicationProperties(){
        Assertions.assertEquals("Belajar Spring Boot", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
        Assertions.assertFalse(properties.isProductionMode());
    }

    @Test
    void testDatabaseProperties(){
        Assertions.assertEquals("contoh", properties.getDatabase().getDatabase());
        Assertions.assertEquals("ramanda", properties.getDatabase().getUsername());
        Assertions.assertEquals("rahasia", properties.getDatabase().getPassword());
        Assertions.assertEquals("jdbc:contoh", properties.getDatabase().getUrl());
    }

    @Test
    void testCollectionProperties(){
        Assertions.assertEquals(Arrays.asList("customers", "categories", "products"), properties.getDatabase().getWhitelistTables());
        Assertions.assertEquals(100, properties.getDatabase().getMaxTablesSize().get("products"));
        Assertions.assertEquals(100, properties.getDatabase().getMaxTablesSize().get("categories"));
        Assertions.assertEquals(100, properties.getDatabase().getMaxTablesSize().get("customers"));
    }

    @Test
    void testEmbeddedCollection(){
        Assertions.assertEquals("default", properties.getDefaultRole().getFirst().getId());
        Assertions.assertEquals("Default Role", properties.getDefaultRole().getFirst().getName());
        Assertions.assertEquals("guest", properties.getDefaultRole().get(1).getId());
        Assertions.assertEquals("Guest Role", properties.getDefaultRole().get(1).getName());

        Assertions.assertEquals("admin", properties.getRoles().get("admin").getId());
        Assertions.assertEquals("Admin Role", properties.getRoles().get("admin").getName());
        Assertions.assertEquals("finance", properties.getRoles().get("finance").getId());
        Assertions.assertEquals("Finance Role", properties.getRoles().get("finance").getName());
    }

    @SpringBootApplication
    @EnableConfigurationProperties({
            ApplicationProperties.class
    })
    public static class TestApplication{

    }
}
