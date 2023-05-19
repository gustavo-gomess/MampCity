package model;

import java.math.BigDecimal;

public class Financeiro {

    private BigDecimal totalEmCaixa;


    public void calculaArrecadacaoMes (){

    }


    public void setTotalEmCaixa(BigDecimal totalEmCaixa) {
        this.totalEmCaixa = totalEmCaixa;
    }

    public BigDecimal getTotalEmCaixa() {
        return totalEmCaixa;
    }

    @Override
    public String toString() {
        return "Financeiro{" +
                "totalEmCaixa=" + totalEmCaixa +
                '}';
    }
}
