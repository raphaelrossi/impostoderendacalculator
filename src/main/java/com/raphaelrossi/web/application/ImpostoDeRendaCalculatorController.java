package com.raphaelrossi.web.application;

import com.raphaelrossi.business.service.ImpostoDeRendaCalculatorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * Created by e074467 on 1/29/2019.
 */
@Controller
@RequestMapping(value = "/imposto-de-renda-calculator")
public class ImpostoDeRendaCalculatorController {

    @Autowired
    private ImpostoDeRendaCalculatorServiceImp impostoDeRendaCalculatorImp;

    @RequestMapping(method = RequestMethod.GET)
    public String getImpostoDeRenda(@RequestParam(value = "salary", required=false) BigDecimal salary, Model model){
        if(null != salary)
            model.addAttribute("impostoDeRenda", impostoDeRendaCalculatorImp.getImpostoDeRenda(salary));

        return "imposto-de-renda-calculator";
    }


}
