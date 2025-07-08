package com.shine.automation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AppTest {

    @Test
    void testAppRunsWithoutCrashing() {
        assertDoesNotThrow(() -> App.main(new String[]{}), "App crashed during execution");
    }
}
