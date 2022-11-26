package com.manish.spring.service;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MyServiceTest {

    private MyService myService;

    @BeforeEach
    public void init(){
        myService = new MyService();
        System.out.println("\nBeforeEach");
    }

    @BeforeAll
    public static void initOnce(){
        System.out.println("BeforeAll");
    }

    @AfterEach
    public void cleanup(){
        myService = null;
        System.out.println("AfterEach");
    }

    @AfterAll
    public static void cleanupOnce(){
        System.out.println("AfterAll");
    }


    @Test
    @DisplayName("Dividing 15 by 4")
    public void testDivideWith15And4(){
        System.out.println("testDivideWith15And4");
        int result = myService.divide("15", "4");
        assertEquals(3, result);
    }

    @Test
    public void testDivideWithNull(){
        System.out.println("testDivideWithNull");
        Throwable exception = assertThrows(NumberFormatException.class,  () -> myService.divide(null, null));
        assertEquals("Cannot parse null string", exception.getMessage());
    }

    @Test
    public void testDivideWithFirstAsNullSecondAlpha(){
        System.out.println("testDivideWithFirstAsNullSecondAlpha");
        Throwable exception = assertThrows(NumberFormatException.class,  () -> myService.divide(null, "abc"));
        assertEquals("Cannot parse null string", exception.getMessage());
    }

    @Test
    public void testDivideWithFirstAlphaSecondAsNull(){
        System.out.println("testDivideWithFirstAlphaSecondAsNull");
        Throwable exception = assertThrows(NumberFormatException.class,  () -> myService.divide("abc", null));
        assertEquals("For input string: \"abc\"", exception.getMessage());
    }

    @Test
    public void testDivideWithFirstAlphaSecondInt(){
        System.out.println("testDivideWithFirstAlphaSecondAsNull");
        Throwable exception = assertThrows(NumberFormatException.class,  () -> myService.divide("abc", "4"));
        assertEquals("For input string: \"abc\"", exception.getMessage());
    }
    @Test
    public void testDivideWithFirstIntSecondAlpha(){
        System.out.println("testDivideWithFirstAlphaSecondAsNull");
        Throwable exception = assertThrows(NumberFormatException.class,  () -> myService.divide("4", "abc"));
        assertEquals("For input string: \"abc\"", exception.getMessage());
    }
    @Test
    public void testDivideWithFirstDoubleSecondInt(){
        System.out.println("testDivideWithFirstAlphaSecondAsNull");
        Throwable exception = assertThrows(NumberFormatException.class,  () -> myService.divide("15.0", "4"));
        assertEquals("For input string: \"15.0\"", exception.getMessage());
    }
    @Test
    public void testDivideWithFirstDoubleSecondAlpha(){
        System.out.println("testDivideWithFirstAlphaSecondAsNull");
        Throwable exception = assertThrows(NumberFormatException.class,  () -> myService.divide("15.0", "abc"));
        assertEquals("For input string: \"15.0\"", exception.getMessage());
    }

    @Test
    public void testDivideWithFirstAlphaSecondDouble(){
        System.out.println("testDivideWithFirstAlphaSecondAsNull");
        Throwable exception = assertThrows(NumberFormatException.class,  () -> myService.divide("abc", "4.0"));
        assertEquals("For input string: \"abc\"", exception.getMessage());
    }

    @Test
    public void testDivideWithBothDouble(){
        System.out.println("testDivideWithFirstAlphaSecondAsNull");
        Throwable exception = assertThrows(NumberFormatException.class,  () -> myService.divide("15.0", "4.0"));
        assertEquals("For input string: \"15.0\"", exception.getMessage());
    }

}