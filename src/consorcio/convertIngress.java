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
public class convertIngress {
AuxiliaryFunctions af = new AuxiliaryFunctions();
Object [][] totalIngress;
String fecha, cod_cedulon, concepto, medio, detallePago, total, total2;

public convertIngress()
{
    totalIngress = af.getIngress("");
}

public void walkArray()
{
    for (Object[] ingress : totalIngress) 
    {
        fecha = (String) ingress[1];
        cod_cedulon = (String) ingress[3];
        concepto = (String) ingress[4];
        medio = (String) ingress[6];
        detallePago = (String) ingress[7];
        if (detallePago == null){detallePago="";}
        total = (String) ingress[8];
        if (total == null){total="";}
        total2 = (String) ingress[9];
        if (total2 == null){total2="";}
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
    if(concepto.equals("Canon por uso de agua"))
    {
        //agrego el ingreso.
        int id_ingress = af.temporalInsertIngress(fecha, concepto+".");
        //Registro la operacion
        int id_operation = af.inserPayment1(medio, detallePago , total);
        //asocio ambos el ingreso y la operacion.
        af.insertIngMod(String.valueOf(id_ingress), String.valueOf(id_operation));
        //tengo que setear el numero de ingreso en el cedulon.
        af.modifyCedulon(cod_cedulon, "cod_ingreso", String.valueOf(id_ingress));
    }
    else
    {
        //agrego el ingreso.
        int id_ingress = af.temporalInsertIngress(fecha, concepto);
        //Registro la operacion
        int id_operation = af.inserPayment1(medio, detallePago , total2);
        //asocio ambos el ingreso y la operacion.
        af.insertIngMod(String.valueOf(id_ingress), String.valueOf(id_operation));
    
    }
}

}
