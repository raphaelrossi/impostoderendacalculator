package com.raphaelrossi.web.service;

import com.raphaelrossi.business.service.ImpostoDeRendaCalculatorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by e074467 on 1/29/2019.
 */

@RestController
@RequestMapping(value = "/api")
public class ImpostoDeRendaCalculatorServiceController {

    @Autowired
    private ImpostoDeRendaCalculatorServiceImp impostoDeRendaCalculatorImp;

    @RequestMapping(method = RequestMethod.GET, value = "/imposto-de-renda-calculator/{salary}")
    public BigDecimal getImpostoDeRenda(@PathVariable(value = "salary") BigDecimal salary){
        return impostoDeRendaCalculatorImp.getImpostoDeRenda(salary);
    }

}
