package com.globalsaving.netprice.controller;

import com.globalsaving.netprice.service.NetPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NetPriceController {

    @Autowired
    private NetPriceService netPriceService;

    @GetMapping(value = "/netprice")
    public String calculateNetPrice(@RequestParam Double grossPrice, @RequestParam String countryIso){
        return netPriceService.calculateNetPrice(grossPrice, countryIso);
    }
}

