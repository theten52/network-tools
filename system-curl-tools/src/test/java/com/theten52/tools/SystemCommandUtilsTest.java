package com.theten52.tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SystemCommandUtilsTest {

    @Test
    void execCmd() {
        String[] command = {"pwd"};
        String result = SystemCommandUtils.execCmd(command);
        Assertions.assertNotNull(result);
    }
}