package com.globalsaving.netprice.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.globalsaving.netprice.service.NetPriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {NetPriceController.class})
@ExtendWith(SpringExtension.class)
public class NetPriceControllerTest {
    @Autowired
    private NetPriceController netPriceController;

    @MockBean
    private NetPriceService netPriceService;

    @Test
    void testCalculateNetPrice() throws Exception {
        when(netPriceService.calculateNetPrice((Double) any(), (String) any())).thenReturn("Calculate Net Price");
        MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/netprice").param("countryIso", "foo");
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("grossPrice", String.valueOf(10.0d));
        MockMvcBuilders.standaloneSetup(netPriceController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Calculate Net Price"));
    }
}

