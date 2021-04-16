/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consorcio;

/**
 *
 * @author leoas
 */
public class convertEgress {
AuxiliaryFunctions af = new AuxiliaryFunctions();
Object [][] totalEgress;
String fecha, concepto, medio, detallePago, total;

public convertEgress()
{
    totalEgress = af.getEgress("");
}

public void walkArray()
{
    for (Object[] egress : totalEgress) 
    {
        fecha = (String) egress[1];
        concepto = (String) egress[2];
        medio = (String) egress[3];
        detallePago = (String) egress[4];
        if (detallePago == null){detallePago="";}
        total = (String) egress[5];
        setModality();
        verify();
    }
}

private void setModality()
{
    if(medio.equals("EFECTIVO"))
    {
        medio="1";
    }
    else
    {
        medio = "3";
        detallePago = "Banco: nombreBanco ~ N°cheque: 000000 ~ Acreditación: 2020-02-14 ~ Detalle: " + detallePago;
    }
}

private void verify()
{
        //agrego el egreso.
        int id_egress = af.temporalInsertEgress(fecha, concepto);
        //Registro la operacion
        int id_operation = af.inserPayment1(medio, detallePago , total);
        //asocio ambos el ingreso y la operacion.
        af.insertEgrMod(String.valueOf(id_egress), String.valueOf(id_operation));
}

}
