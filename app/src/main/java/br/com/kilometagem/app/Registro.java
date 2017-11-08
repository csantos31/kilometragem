package br.com.kilometagem.app;

import com.orm.SugarRecord;

/**
 * Created by 16254842 on 31/10/2017.
 */

public class Registro extends SugarRecord {

    private String mes;
    private Float kilometros;

    //CONSTRUTORES

    public Registro (){};

    public Registro (String mes, Float kilometros){
        this.mes = mes;
        this.kilometros = kilometros;
    }

    //GETERS AND SETERS

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Float getKilometros() {
        return kilometros;
    }

    public void setKilometros(Float kilometros) {
        this.kilometros = kilometros;
    }


}
