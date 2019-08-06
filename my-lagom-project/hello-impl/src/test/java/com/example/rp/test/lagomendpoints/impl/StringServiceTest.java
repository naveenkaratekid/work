package com.example.rp.test.lagomendpoints.impl;

import org.junit.Test;

import com.example.rp.test.lagomendpoints.api.StringService;

import static com.lightbend.lagom.javadsl.testkit.ServiceTest.defaultSetup;
import static com.lightbend.lagom.javadsl.testkit.ServiceTest.withServer;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;

public class StringServiceTest {
    @Test
    public void shouldGreet() {
        withServer(defaultSetup(), server -> {
            StringService service = server.client(StringService.class);

            String msg1 = service.action("reverse","Alice").invoke().toCompletableFuture().get(5, SECONDS);
            assertEquals("Alice in reverse is: ecilA", msg1);

            String msg2 = service.action("upper", "krishna").invoke().toCompletableFuture().get(5, SECONDS);
            assertEquals("krishna in upper case is: KRISHNA", msg2);

            String msg3 = service.action("lower", "MURTHY").invoke().toCompletableFuture().get(5, SECONDS);
            assertEquals("MURTHY in lower case is: murthy", msg3);

            String msg4 = service.action("add", "onions").invoke().toCompletableFuture().get(5, SECONDS);
            assertEquals("onions added to the list. Here is the current list: [onions]", msg4);

            String msg5 = service.action("clear", "list").invoke().toCompletableFuture().get(5, SECONDS);
            assertEquals("list has been cleared", msg5);

        });
    }
}
