package com.manish.spring.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class SecondServiceTest {
    private SecondService secondService;

    @BeforeEach
    public void init(){
        secondService = new SecondService();
    }
    @AfterEach
    public void cleanup(){
        secondService = null;
    }
    @Test
    public void testWithNull(){
        String result = secondService.prepareMessage(null);
        assertNull(result);
    }
    @Test
    public void testWithEmpty(){
        String result = secondService.prepareMessage("");
        assertNull(result);
    }
    @Test
    public void testWithSpace(){
        String result = secondService.prepareMessage("  ");
        assertNull(result);
    }

    @Test
    public void testWithName(){
        String result = secondService.prepareMessage("Manish");
        assertEquals("Hello Manish", result);
    }

    @Test
    public void testWithNameAndSpace(){
        String result = secondService.prepareMessage("    Manish      ");
        assertEquals("Hello Manish", result);
    }

    @Test
    public void testWithTime(){
        assertTimeout(Duration.ofMillis(100), () -> secondService.prepareMessage("Manish"));
    }

    @Test
    public void testWithTimeError(){
        assertTimeout(Duration.ofMillis(20), () -> secondService.prepareMessage("Manish"));
    }

}