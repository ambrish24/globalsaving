package com.globalsaving.netprice.repository;

import java.util.HashMap;
import java.util.Map;

public class TaxRateProvider {

    public static Map<String, Double> taxRateProvider;

    static {
        taxRateProvider = new HashMap<>(0);
        taxRateProvider.put("DE", 0.19);
        taxRateProvider.put("FR", 0.20);
        taxRateProvider.put("IN", 0.15);
        taxRateProvider.put("GB", 0.21);
        taxRateProvider.put("US", 0.18);
    }

    public static Double getTaxRate(String countryIso) {
        return taxRateProvider.get(countryIso);
    }
}
