package com.chi.demo03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

public class DemoMockitoAssertTests {
    
    @Test
    void simpleTest() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(3);
        assertEquals(3, listMock.size());
    }

    @Test
    void multipleReturns() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(3).thenReturn(30);
        assertEquals(3, listMock.size()); // 第一次呼叫，預期回傳 3
        assertEquals(30, listMock.size()); // 第二次呼叫，預期回傳 30
        assertEquals(30, listMock.size()); // 之後每次呼叫，預期回傳 30
    }

    @Test
    void genericParams() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("ja");
        assertEquals("ja", listMock.get(0));
        assertNull(listMock.get(1));

        List listMock2 = mock(List.class);
        when(listMock2.get(anyInt())).thenReturn("jaja");
        assertEquals("jaja", listMock2.get(0));
        assertNotNull(listMock2.get(1));
    }
}
