package com.abetterplanner.controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class ControllerTest {

    @Test
    public void testFunction(){
        // given
        Controller controller = new Controller();

        // when

        // then
        assertThat(controller).isNotNull();
        assertThat(15).isEqualTo(controller.add(5, 10));
    }
}
