package com.raphaelrossi.impostoderendacalculator.web.application;

import com.raphaelrossi.business.service.ImpostoDeRendaCalculatorService;
import com.raphaelrossi.business.service.ImpostoDeRendaCalculatorServiceImp;
import com.raphaelrossi.web.application.ImpostoDeRendaCalculatorController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by e074467 on 1/29/2019.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ImpostoDeRendaCalculatorController.class)
public class ImpostoDeRendaCalculatorControllerTest {

    @MockBean
    private ImpostoDeRendaCalculatorServiceImp impostoDeRendaCalculatorServiceImp;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnFreeRangeTax() throws Exception{
        given(impostoDeRendaCalculatorServiceImp.getImpostoDeRenda(new BigDecimal("1903.98")))
                .willReturn(new BigDecimal("0.00"));
        this.mockMvc.perform(get("/imposto-de-renda-calculator?salary=1903.98"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("0.00")));
    }

    @Test
    public void shouldReturnFirstRangeTax() throws Exception{
        given(impostoDeRendaCalculatorServiceImp.getImpostoDeRenda(new BigDecimal("1903.99")))
                .willReturn(new BigDecimal("142.80"));
        this.mockMvc.perform(get("/imposto-de-renda-calculator?salary=1903.99"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("142.80")));
    }
    @Test
    public void shouldReturnSecondRangeTax() throws Exception{
        given(impostoDeRendaCalculatorServiceImp.getImpostoDeRenda(new BigDecimal("2826.66")))
                .willReturn(new BigDecimal("424.00"));
        this.mockMvc.perform(get("/imposto-de-renda-calculator?salary=2826.66"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("424.00")));
    }
    @Test
    public void shouldReturnThirdRangeTax() throws Exception{
        given(impostoDeRendaCalculatorServiceImp.getImpostoDeRenda(new BigDecimal("3751.06")))
                .willReturn(new BigDecimal("843.99"));
        this.mockMvc.perform(get("/imposto-de-renda-calculator?salary=3751.06"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("843.99")));
    }
    @Test
    public void shouldReturnForthRangeTax() throws Exception{
        given(impostoDeRendaCalculatorServiceImp.getImpostoDeRenda(new BigDecimal("4664.69")))
                .willReturn(new BigDecimal("1282.79"));
        this.mockMvc.perform(get("/imposto-de-renda-calculator?salary=4664.69"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("1282.79")));
    }

}
