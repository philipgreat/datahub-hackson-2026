package com.example.enterpriseerpsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import jakarta.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;

public class KycAuthInterceptorTest {

    private KycAuthInterceptor interceptor;

    @BeforeEach
    public void setup() {
        interceptor = new KycAuthInterceptor();
    }

    @Test
    public void testPreHandle_MissingUserId() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/api/v1/payment");
        MockHttpServletResponse response = new MockHttpServletResponse();

        boolean result = interceptor.preHandle(request, response, null);

        assertFalse(result, "Should block request missing user ID");
        assertEquals(HttpServletResponse.SC_UNAUTHORIZED, response.getStatus());
    }

    @Test
    public void testPreHandle_KycFailed() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/api/v1/payment");
        request.addHeader("X-User-Id", "unverified_user");
        MockHttpServletResponse response = new MockHttpServletResponse();

        boolean result = interceptor.preHandle(request, response, null);

        assertFalse(result, "Should block unverified user");
        assertEquals(HttpServletResponse.SC_FORBIDDEN, response.getStatus());
    }

    @Test
    public void testPreHandle_KycPassed() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/api/v1/payment");
        request.addHeader("X-User-Id", "user_verified_001");
        MockHttpServletResponse response = new MockHttpServletResponse();

        boolean result = interceptor.preHandle(request, response, null);

        assertTrue(result, "Should allow verified user");
    }

    @Test
    public void testPreHandle_OtherEndpoints() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/api/v1/other_endpoint");
        MockHttpServletResponse response = new MockHttpServletResponse();

        boolean result = interceptor.preHandle(request, response, null);

        assertTrue(result, "Should not intercept other endpoints");
    }
}
