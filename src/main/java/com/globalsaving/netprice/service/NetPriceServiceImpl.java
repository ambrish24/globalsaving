package com.globalsaving.netprice.service;

import com.globalsaving.netprice.repository.TaxRateProvider;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Service
public class NetPriceServiceImpl implements NetPriceService{

    @Override
    public String calculateNetPrice(Double grossPrice, String countryIso) {
        Double taxRate = TaxRateProvider.getTaxRate(countryIso);
        Double netPrice = grossPrice - (grossPrice * taxRate);
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.CEILING);
        String result = df.format(netPrice);
        System.out.println(result);
        return result;
    }
}
