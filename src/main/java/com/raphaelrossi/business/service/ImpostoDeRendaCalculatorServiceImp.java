package com.raphaelrossi.business.service;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

/**
 * Created by e074467 on 1/29/2019.
 */
@Service
public class ImpostoDeRendaCalculatorServiceImp implements ImpostoDeRendaCalculatorService {
    private static final BigDecimal HUNDRED = new BigDecimal("100");

    //free
    BigDecimal freeRangePercent = new BigDecimal("0.0");

    //7.5% first range: 1903.99 ~ 2826.65
    BigDecimal firstRangeSalary = new BigDecimal("1903.99");
    BigDecimal firstRangePercent = new BigDecimal("7.5");

    //15% second range: 2826.66 ~ 3751.05
    BigDecimal secondRangeSalary = new BigDecimal("2826.66");
    BigDecimal secondRangePercent = new BigDecimal("15.00");

    //22.5% third range 3751.06 ~ 4664.68
    BigDecimal thirdRangeSalary = new BigDecimal("3751.06");
    BigDecimal thirdRangePercent = new BigDecimal("22.5");

    //27.5% forth range > 4664.68
    BigDecimal forthRangeSalary = new BigDecimal("4664.68");
    BigDecimal forthRangePercent = new BigDecimal("27.5");

    public BigDecimal getImpostoDeRenda(BigDecimal salary){
        BigDecimal tax;
        if (salary.compareTo(firstRangeSalary) < 0) {
            tax = salary.multiply(freeRangePercent);
        } else if (salary.compareTo(secondRangeSalary) < 0) {
            tax = salary.multiply(firstRangePercent.divide(HUNDRED));
        } else if (salary.compareTo(thirdRangeSalary) < 0) {
            tax = salary.multiply(secondRangePercent.divide(HUNDRED));
        } else if (salary.compareTo(forthRangeSalary) <= 0) {
            tax = salary.multiply(thirdRangePercent.divide(HUNDRED));
        } else {
            tax = salary.multiply(forthRangePercent.divide(HUNDRED));
        }
        return tax.setScale(2, BigDecimal.ROUND_HALF_DOWN);
    }

}
