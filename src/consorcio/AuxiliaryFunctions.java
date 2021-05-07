package consorcio;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leoasson
 */
public class AuxiliaryFunctions
{
    sentencesSql senSql = new sentencesSql();
    public AuxiliaryFunctions (){}
    
    public void disconect()
    {
     senSql.disconect();
    }
    
    public boolean isValidNumber(String field)
    {
        double value;
        try
        {
            value = Double.valueOf(field);
        }
        catch(NumberFormatException e)
        {
        return false;
        }
        
        return (value >= 0);  
    }
    
public Double CutDecimales_Double(Double number)
{
    return Math.round(number * Math.pow(10,2)) / Math.pow(10, 2);
}

public String CutDecimal_String(String number)
{
        Double total_=CutDecimales_Double(Double.valueOf(number));
        return String.valueOf(total_);
}

public String getActualDateInString ()
{ 
   java.sql.Date Date = new java.sql.Date(System.currentTimeMillis());
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   return String.valueOf(sdf.format(Date));
}
    
    public Date getActualDate()
    {
       java.sql.Date Date = new java.sql.Date(System.currentTimeMillis());
       return Date;
    }
    
    public Date getDate(String date)
    {
        try 
        {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } 
        catch (ParseException ex)
        {
            Logger.getLogger(AuxiliaryFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String getDateToString (Date date)
    {
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             try
             {
                return String.valueOf(sdf.format(date));
             }
             catch(Exception e)
             {return "empty";}            
    }
    
    public Object[][] getPadron()
    {
        String[] columnas={"id_padron", "usuario","canal","cuantia", "propietario", "cod_inquilino"};
        Object[][] datos = senSql.GetTable(columnas, " from padron ","");
        return datos;
    }
    
    public String[] getPayments(String id)
    {
        String []values;     
        values = new String[3];
        values[0] = senSql.datos_string("cod_modalidad","select cod_modalidad from operacion where id_operacion='"+id+"';");
        values[1] = senSql.datos_string("detalle","select detalle from operacion where id_operacion='"+id+"';");
        values[2] = senSql.datos_string("importe","select importe from operacion where id_operacion='"+id+"';");
        return values;
    }
    
    public String getConceptForIngressOrEgress(String id, String nameOfTable, String column)
    {
        return senSql.datos_string("concepto", "select concepto from "+nameOfTable+" where "+column+" ='"+id+"';");
    }
    
    public String getRubroForIngressOrEgress(String id, String nameOfTable, String column)
    {
        return senSql.datos_string("rubro", "select rubro from "+nameOfTable+" LEFT JOIN rubro ON cod_rubro = id_rubro where "+column+" ='"+id+"';");
    }
    
    public Date getDateFromIngressOrEgress(String id_ingressOrEgress, String nameOfTable, String column)
    {
        return getDate(senSql.datos_string("fecha","select fecha from "+nameOfTable+" where "+column+" ='"+id_ingressOrEgress+"';"));
    }
    
        
    public Object [][] getPadronFilter(String joinWhere)
    {
        String[] columnas={"id_padron", "usuario","canal","cuantia", "propietario", "nombreApellido"};
        Object[][] datos = senSql.GetTable(columnas, " from padron ", joinWhere);
        return datos;
    }
    public Object [][] getLessee(String joinWhere)
    {
        String[] columnas={"id_inquilino", "nombreApellido", "direccion", "telefono", "nombreCiudad"};
        Object[][] datos = senSql.GetTable(columnas, " from inquilino ", joinWhere);
        return datos;
    }
    
   /*
    * @param where Se debe ingresar el filtro para la tabla de la siguiente forma: "where cod_xxx = id_xxx and cod_yyy = id_yyy;"
    * en el caso de tener un join la consulta debe ser ingresado en este parametro.
    */
    public Object[][] getCedulon( String joinWhere)
    {
        String[] columnas={"id_cedulon", "canal", "cuantia", "propietario", "nombreApellido","periodo", "fechaVencimiento", "recargo", "total", "estado","cod_ingreso"};
        Object[][] datos = senSql.GetTable(columnas, " from cedulon ", joinWhere);
        return datos;
    }
    
    public Object[][] getIdCedulonThroughCodIngress(String cod_ingress)
    {
        String[] columnas={"id_cedulon"};
        Object[][] datos = senSql.GetTable(columnas, " from cedulon ", "where `cod_ingreso`= "+cod_ingress);
        return datos;
    }
  
    public Object[][] getCedulonForModifyIngress(String joinWhere)
    {
        String[] columnas={"id_cedulon", "periodo", "propietario", "nombreApellido", "total"};
        Object[][] datos = senSql.GetTable(columnas, " from cedulon ", joinWhere);
        return datos;   
    }
    
    public Object[][] getPaymentForModifyIngressOrEgress(String joinWhere)
    {
        String[] columnas={"id_operacion", "modalidad", "detalle", "importe"};
        Object[][] datos = senSql.GetTable(columnas, " from operacion ", joinWhere);
        return datos;  
    }
    
    
    public Object[][] getCedulonForPrint(String value)
    {
        String[] columnas={"id_cedulon","usuario", "canal","cuantia", "propietario", "total", "fechaVencimiento", "periodo", "recargo","montoPorCuantia"};
        Object[][] datos = senSql.GetTable(columnas, " from cedulon, padron ", " where cod_padron = id_padron and "+ value);
        return datos;
    }

    public int getTotalPadron()
    {
        return senSql.coutTable("*", "from padron");
    }
    
    public String [] getPeriod()
    {
        String period [] = {"Ingresar periodo","01/2018","02/2018", "01/2019", "02/2019", "01/2020","02/2020", "01/2021", "02/2021","01/2022", "02/2022" };
        return period;
    }   
    
    public String [] getState()
    {
        String period [] = {"PENDIENTE","PAGADO"};
        return period;
    }   
    
    public Object[][] getIngress(String where)
    {
        String[] columnas={"id_ingreso","fecha", "periodo","id_cedulon", "concepto", "propietario", "medio", "detallePago", "total", "total2"};
        Object[][] datos = senSql.GetTable(columnas, " from ingreso " ,"LEFT JOIN cedulon ON cod_cedulon = id_cedulon LEFT JOIN padron on cod_padron = id_padron LEFT JOIN inquilino on cod_inquilino = id_inquilino " + where);
        return datos;
    }
    
    public Object[][] temporalGetEgress(String where)
    {
        String tableAux = "(SELECT id_egreso,fecha, concepto, rubro, SUM(importe) as importe FROM `pruebaegreso` LEFT JOIN `rubro` ON pruebaegreso.cod_rubro = rubro.id_rubro LEFT JOIN `egrmod` ON pruebaegreso.id_egreso = egrmod.cod_egreso LEFT JOIN `operacion` ON operacion.id_operacion = egrmod.cod_operacion GROUP BY id_egreso) as egress";
        String consult = " FROM " + tableAux;
        String[] columnas={"id_egreso", "fecha", "concepto", "rubro", "importe"};
        Object[][] datos = senSql.GetTable(columnas,consult, where);
        return datos;
    }
    
    public Object[][] temporalGetIngress(String where)
    {
        String tableAux = "(SELECT id_ingreso,fecha, concepto, SUM(importe) as importe FROM `pruebaingreso` LEFT JOIN `ingmod` ON pruebaingreso.id_ingreso = ingmod.cod_ingreso LEFT JOIN `operacion` ON operacion.id_operacion = ingmod.cod_operacion GROUP BY id_ingreso) as ingress";
        String consult = " FROM " + tableAux;
        String[] columnas={"id_ingreso", "fecha", "concepto", "importe"};
        Object[][] datos = senSql.GetTable(columnas,consult, where);
        return datos;
    }
    
    public Object[][] getOtherIngress(String where)
    {
        String tableAux = "(SELECT id_ingreso,fecha, concepto, rubro, SUM(importe) as importe FROM `otrosingresos` LEFT JOIN `rubro` ON otrosingresos.cod_rubro = rubro.id_rubro LEFT JOIN `ingmodblack` ON otrosingresos.id_ingreso = ingmodblack.cod_ingreso LEFT JOIN `operacion` ON operacion.id_operacion = ingmodblack.cod_operacion GROUP BY id_ingreso) as ingress";
        String consult = " FROM " + tableAux;
        String[] columnas={"id_ingreso", "fecha", "concepto", "rubro", "importe"};
        Object[][] datos = senSql.GetTable(columnas,consult, where);
        return datos;
    }
    
    public Object[][] getOtherEgress(String where)
    {
        String tableAux = "(SELECT id_egreso,fecha, concepto, rubro, SUM(importe) as importe FROM `otrosegresos` LEFT JOIN `rubro` ON otrosegresos.cod_rubro = rubro.id_rubro LEFT JOIN `egrmodblack` ON otrosegresos.id_egreso = egrmodblack.cod_egreso LEFT JOIN `operacion` ON operacion.id_operacion = egrmodblack.cod_operacion GROUP BY id_egreso) as egress";
        String consult = " FROM " + tableAux;
        String[] columnas={"id_egreso", "fecha", "concepto", "rubro", "importe"};
        Object[][] datos = senSql.GetTable(columnas,consult, where);
        return datos;
    }
    
    public Object[][] getTemporalDetailedEgress(String where)
    {
        String consult = " from (SELECT * FROM `pruebaegreso` LEFT JOIN `rubro` ON pruebaegreso.cod_rubro = rubro.id_rubro LEFT JOIN `egrmod` ON pruebaegreso.id_egreso = egrmod.cod_egreso LEFT JOIN `operacion` ON operacion.id_operacion = egrmod.cod_operacion LEFT JOIN `modalidad` ON modalidad.id_modalidad = operacion.cod_modalidad) as egress " ;
        String[] columnas={"egress.id_egreso", "egress.fecha", "egress.concepto", "egress.rubro", "egress.modalidad","egress.detalle", "egress.importe"};
        Object[][] datos = senSql.GetTable(columnas,consult, where);
        return datos;
    }
    
    public Object[][] getTemporalDetailedIngress(String where)
    {
        String consult = " from (SELECT * FROM `pruebaingreso` LEFT JOIN `ingmod` ON pruebaingreso.id_ingreso = ingmod.cod_ingreso LEFT JOIN `operacion` ON operacion.id_operacion = ingmod.cod_operacion LEFT JOIN `modalidad` ON modalidad.id_modalidad = operacion.cod_modalidad) as ingress " ;
        String[] columnas={"ingress.id_ingreso", "ingress.fecha", "ingress.concepto", "ingress.modalidad","ingress.detalle", "ingress.importe"};
        Object[][] datos = senSql.GetTable(columnas,consult, where);
        return datos;
    }
    
    public Object[][] getDetailedOtherIngress(String where)
    {
        String consult = " from (SELECT * FROM `otrosingresos` LEFT JOIN `rubro` ON otrosingresos.cod_rubro = rubro.id_rubro LEFT JOIN `ingmodblack` ON otrosingresos.id_ingreso = ingmodblack.cod_ingreso LEFT JOIN `operacion` ON operacion.id_operacion = ingmodblack.cod_operacion LEFT JOIN `modalidad` ON modalidad.id_modalidad = operacion.cod_modalidad) as ingress " ;
        String[] columnas={"ingress.id_ingreso", "ingress.fecha", "ingress.concepto", "ingress.rubro", "ingress.modalidad","ingress.detalle", "ingress.importe"};
        Object[][] datos = senSql.GetTable(columnas,consult, where);
        return datos;
    }
    
    public Object[][] getDetailedOtherEgress(String where)
    {
        String consult = " from (SELECT * FROM `otrosegresos` LEFT JOIN `rubro` ON otrosegresos.cod_rubro = rubro.id_rubro LEFT JOIN `egrmodblack` ON otrosegresos.id_egreso = egrmodblack.cod_egreso LEFT JOIN `operacion` ON operacion.id_operacion = egrmodblack.cod_operacion LEFT JOIN `modalidad` ON modalidad.id_modalidad = operacion.cod_modalidad) as egress " ;
        String[] columnas={"egress.id_egreso", "egress.fecha", "egress.concepto", "egress.rubro", "egress.modalidad","egress.detalle", "egress.importe"};
        Object[][] datos = senSql.GetTable(columnas,consult, where);
        return datos;
    }
    
    public Object[][] getEgress(String where)
    {
        String[] columnas={"id_egreso", "fecha", "concepto", "rubro", "medio", "detallePago", "total"};
        Object[][] datos = senSql.GetTable(columnas, " from egreso "  , where);
        return datos;
    }
        
    public boolean modifyLesseeCensus (String DNI, String id_padron){
    return senSql.modifiedRow("padron", "cod_inquilino" , DNI, "id_padron = "+id_padron);
    }
    
    public boolean modifyCedulon(String id_cedulon, String column, String value)
    {
        return senSql.modifiedRow("cedulon", column , value, "id_cedulon = "+id_cedulon);
    }
    
    public boolean modifyPayment(int id_operacion, String column, String value)
    {
        return senSql.modifiedRow("operacion", column , value, "id_operacion = "+id_operacion);
    }
    
    public boolean modifyCensus(String id_padron, String column, String value)
    {
        return senSql.modifiedRow("padron", column , value, "id_padron = "+id_padron);
    }
    
    public boolean modifyStatePay (String id_cedulon)
    {
        return senSql.modifiedRow("cedulon", "estado" , "PAGADO", "id_cedulon = "+id_cedulon);
    }
    
    public boolean modifyState (String id_cedulon, String state)
    {
        return senSql.modifiedRow("cedulon", "estado" , state, "id_cedulon = "+id_cedulon);
    }
    
    public boolean modifyEgress(String id_egress, String date, String concept, String mode, String detailPayment, String total)
    {
        boolean v1, v2, v3, v4, v5;
        v1 = senSql.modifiedRow("egreso", "fecha", date, "id_egreso =  "+id_egress);
        v2 = senSql.modifiedRow("egreso", "concepto", concept, "id_egreso = "+id_egress);
        v3 = senSql.modifiedRow("egreso", "medio", mode, "id_egreso = "+id_egress);
        v4 = senSql.modifiedRow("egreso", "detallePago", detailPayment, "id_egreso = "+id_egress);
        v5 = senSql.modifiedRow("egreso", "total", total, "id_egreso = "+id_egress);   
        return v1 && v2 && v3 && v4 && v5;
    }
    
    public boolean modifyIngress(String id_cedulon, String mode, String detailPayment)
    {
        boolean v1, v2;
        v1 = senSql.modifiedRow("ingreso", "medio", mode, "cod_cedulon = '"+id_cedulon+"'");
        v2 = senSql.modifiedRow("ingreso", "detallePago", detailPayment, "cod_cedulon = '"+id_cedulon+"'");
        return v1 && v2;
    }
    
    public boolean modifySimpleIngress(String id_ingress, String date, String concept, String paymentMethod, String detailPayment, String total)
    {
        boolean v1, v2, v3, v4, v5;
        v1 = senSql.modifiedRow("ingreso", "medio", paymentMethod, "id_ingreso = '"+id_ingress+"'");
        v2 = senSql.modifiedRow("ingreso", "detallePago", detailPayment, "id_ingreso = '"+id_ingress+"'");
        v3 = senSql.modifiedRow("ingreso", "fecha", date, "id_ingreso = '"+id_ingress+"'");
        v4 = senSql.modifiedRow("ingreso", "concepto", concept, "id_ingreso = '"+id_ingress+"'");
        v5 = senSql.modifiedRow("ingreso", "total2", total, "id_ingreso = '"+id_ingress+"'");
        return v1 && v2 && v3 &&  v4 && v5;
    }
    
    public boolean modifyLessee(String id_lessee, String column, String value)
    {
        return senSql.modifiedRow("inquilino", column , value, "id_inquilino = "+id_lessee);
    }
    
    public Object [][] filterPadron(String channel, String name, String lessee, boolean [] filter)
    {
            Object [][] padron = getPadronFilter(" LEFT JOIN inquilino ON cod_inquilino = id_inquilino order by id_padron");
            switch(Arrays.toString(filter))
            {
                case "[false, false, false]":
                padron = getPadronFilter(" LEFT JOIN inquilino ON cod_inquilino = id_inquilino order by id_padron");
                return padron;
                case "[false, false, true]":
                padron = getPadronFilter(" LEFT JOIN inquilino ON cod_inquilino = id_inquilino where `nombreApellido` LIKE '%"+ lessee +"%' order by id_padron");
                return padron;
                
                case "[false, true, false]":
                padron = getPadronFilter(" LEFT JOIN inquilino ON cod_inquilino = id_inquilino where `propietario` LIKE '%"+name+"%' ORDER by id_padron;");        
                return padron;
                
                case "[false, true, true]":
                padron = getPadronFilter(" LEFT JOIN inquilino ON cod_inquilino = id_inquilino where `propietario` LIKE '%"+name+"%' and `nombreApellido` LIKE '%"+ lessee +"%' ORDER by id_padron;");     
                return padron;
                
                case "[true, false, false]":
                padron = getPadronFilter(" LEFT JOIN inquilino ON cod_inquilino = id_inquilino where canal = '"+ channel +"' ORDER by id_padron;");    
                return padron;
                
                case "[true, false, true]":
                padron = getPadronFilter(" LEFT JOIN inquilino ON cod_inquilino = id_inquilino where canal = '"+ channel +"' and `nombreApellido` LIKE '%"+ lessee +"%' ORDER by id_padron;");
                return padron;
                
                case "[true, true, false]":
                padron = getPadronFilter(" LEFT JOIN inquilino ON cod_inquilino = id_inquilino where `propietario` LIKE '%"+name+"%' and canal = '"+ channel +"' ORDER by id_padron;");    
                return padron;
                
                case "[true, true, true]":
                padron = getPadronFilter(" LEFT JOIN inquilino ON cod_inquilino = id_inquilino where `propietario` LIKE '%"+name+"%' and canal = '"+ channel +"' and `nombreApellido` LIKE '%"+ lessee +"%' ORDER by id_padron;");    
                return padron;
                default:
                return padron;
            }

    }
    
    public Object [][] filterLessee(String DNI, String name, boolean[] filter)
    {
    Object [][] lessee = getLessee(" LEFT join ciudad on cod_ciudad = id_ciudad order by nombreApellido");
        switch(Arrays.toString(filter))
        {
            case "[false, false]":
                lessee = getLessee(" LEFT join ciudad on cod_ciudad = id_ciudad order by nombreApellido");
                return lessee;
            case "[false, true]":
                lessee = getLessee(" LEFT join ciudad on cod_ciudad = id_ciudad where `nombreApellido` LIKE '%"+ name +"%' order by nombreApellido");
                return lessee;
            case "[true, false]":
                lessee = getLessee(" LEFT join ciudad on cod_ciudad = id_ciudad where `id_inquilino` LIKE '%"+ DNI +"%' order by nombreApellido");
                return lessee;
            case "[true, true]":
                lessee = getLessee(" LEFT join ciudad on cod_ciudad = id_ciudad where `nombreApellido` LIKE '%"+ name +"%' and `id_inquilino` LIKE '%"+ DNI +"%' order by nombreApellido");
                return lessee;
            default:
                return lessee;
            }
    }
    
        public Object [][] TemporalFilterEgress(String month, String year, boolean [] filter)
    {
            Object [][] egress;
            switch(Arrays.toString(filter))
            {
                case "[false, false]":
                egress = temporalGetEgress(" ORDER BY fecha DESC");   
                return egress;
                case "[false, true]":
                egress = temporalGetEgress(" where YEAR(fecha) = '"+ year +"' ORDER BY fecha DESC");
                return egress;
                case "[true, true]":
                egress = temporalGetEgress(" where YEAR(fecha) = '"+ year +"' and MONTH(fecha) = '"+month+"'");
                return egress;
                default:
                egress = temporalGetEgress("");
                return egress;
            }
    }
    
    public Object [][] filterIngress(String period, String month, String year, boolean [] filter)
    {
            Object [][] pay = getIngress("ORDER by fecha DESC;");
            switch(Arrays.toString(filter))
            {
                case "[false, false, false]":
                pay = getIngress("ORDER by fecha DESC;");   
                return pay;
                
                case "[false, false, true]":
                pay = getIngress("where YEAR(fecha) = '"+ year +"' ORDER by fecha DESC;");
                return pay;
                
                case "[false, true, true]":
                pay = getIngress(" where YEAR(fecha) = '"+ year +"' and MONTH(fecha) = '"+month+"' ORDER by fecha DESC;");
                return pay;
                
                case "[true, false, false]":
                pay = getIngress(" where periodo = '"+ period +"' ORDER by fecha DESC;");
                return pay;

                default:
                return pay;
            }

    }
    
    public Object [][] TemporalFilterIngress(String month, String year, String cedulon, String id_ingress, boolean [] filter)
    {
            Object [][] ingress;
            switch(Arrays.toString(filter))
            {
                case "[false, false, false, false]":
                ingress = temporalGetIngress(" ORDER BY fecha DESC");   
                return ingress;
                case "[false, true, false, false]":
                ingress = temporalGetIngress(" where YEAR(fecha) = '"+ year +"' ORDER BY fecha DESC");
                return ingress;
                case "[true, true, false, false]":
                ingress = temporalGetIngress(" where YEAR(fecha) = '"+ year +"' and MONTH(fecha) = '"+month+"' ORDER BY fecha DESC");
                return ingress;
                case "[false, false, true, false]":
                ingress = temporalGetIngress(" LEFT JOIN cedulon ON ingress.id_ingreso = cedulon.cod_ingreso where id_cedulon = '"+cedulon+"' ");
                return ingress;
                case "[false, false, false, true]":
                ingress = temporalGetIngress(" where id_ingreso = '"+ id_ingress +"'");
                return ingress;
                default:
                ingress = temporalGetIngress(" ");
                return ingress;
            }
    }
    
    public Object [][] FilterOtherIngress(String month, String year, boolean [] filter)
    {
            Object [][] ingress;
            switch(Arrays.toString(filter))
            {
                case "[false, false]":
                ingress = getOtherIngress(" ORDER BY fecha DESC");   
                return ingress;
                case "[false, true]":
                ingress = getOtherIngress(" where YEAR(fecha) = '"+ year +"' ORDER BY fecha DESC");
                return ingress;
                case "[true, true]":
                ingress = getOtherIngress(" where YEAR(fecha) = '"+ year +"' and MONTH(fecha) = '"+month+"' ORDER BY fecha DESC");
                return ingress;
                default:
                ingress = getOtherIngress("");
                return ingress;
            }
    }
    
    public Object [][] FilterOtherEgress(String month, String year, boolean [] filter)
    {
            Object [][] ingress;
            switch(Arrays.toString(filter))
            {
                case "[false, false]":
                ingress = getOtherEgress(" ORDER BY fecha DESC");   
                return ingress;
                case "[false, true]":
                ingress = getOtherEgress(" where YEAR(fecha) = '"+ year +"' ORDER BY fecha DESC");
                return ingress;
                case "[true, true]":
                ingress = getOtherEgress(" where YEAR(fecha) = '"+ year +"' and MONTH(fecha) = '"+month+"' ORDER BY fecha DESC");
                return ingress;
                default:
                ingress = getOtherEgress("");
                return ingress;
            }
    }
    
    public Object [][] filterEgress(String month, String year, boolean [] filter)
    {
            Object [][] egress = getEgress(" ORDER by fecha DESC");
            switch(Arrays.toString(filter))
            {
                case "[false, false]":
                egress = getEgress(" ORDER by fecha DESC");   
                return egress;
                case "[false, true]":
                egress = getEgress("where YEAR(fecha) = '"+ year +"' ORDER by fecha DESC");
                return egress;
                case "[true, true]":
                egress = getEgress(" where YEAR(fecha) = '"+ year +"' and MONTH(fecha) = '"+month+"' ORDER by fecha DESC");
                return egress;
                default:
                return egress;
            }
    }
    
    public Object [][] filterCedulones(String period, String lessee, String name, boolean [] filter)
    {
            Object [][] cedulon = getCedulon(" LEFT join padron on cod_padron = id_padron LEFT JOIN inquilino ON cod_inquilino = id_inquilino order by id_cedulon");
            switch(Arrays.toString(filter))
            {
                case "[false, false, false]":
                cedulon = getCedulon(" LEFT join padron on cod_padron = id_padron LEFT JOIN inquilino ON cod_inquilino = id_inquilino order by id_cedulon");   
                return cedulon;
                case "[false, false, true]":
                cedulon = getCedulon(" LEFT join padron on cod_padron = id_padron LEFT JOIN inquilino ON cod_inquilino = id_inquilino where `propietario` LIKE '%"+name+"%' ORDER by id_cedulon;");
                return cedulon;
                case "[false, true, false]":
                cedulon = getCedulon(" LEFT join padron on cod_padron = id_padron LEFT JOIN inquilino ON cod_inquilino = id_inquilino where `nombreApellido` LIKE '%"+lessee+"%' ORDER by id_cedulon;");    
                return cedulon;
                case "[false, true, true]":
                cedulon = getCedulon(" LEFT join padron on cod_padron = id_padron LEFT JOIN inquilino ON cod_inquilino = id_inquilino where `propietario` LIKE '%"+name+"%' and `nombreApellido` LIKE '%"+lessee+"%' ORDER by id_cedulon;");
                return cedulon;
                case "[true, false, false]":
                cedulon = getCedulon(" LEFT join padron on cod_padron = id_padron LEFT JOIN inquilino ON cod_inquilino = id_inquilino where periodo = '"+ period +"' ORDER by id_cedulon;");
                return cedulon;
                case "[true, false, true]":
                cedulon = getCedulon(" LEFT join padron on cod_padron = id_padron LEFT JOIN inquilino ON cod_inquilino = id_inquilino where `propietario` LIKE '%"+name+"%' and periodo = '"+ period +"' ORDER by id_cedulon;");
                return cedulon;
                case "[true, true, false]":
                cedulon = getCedulon(" LEFT join padron on cod_padron = id_padron LEFT JOIN inquilino ON cod_inquilino = id_inquilino where periodo = '"+ period +"' and `nombreApellido` LIKE '%"+lessee+"%' ORDER by id_cedulon;");
                return cedulon;
                case "[true, true, true]":
                cedulon = getCedulon(" LEFT join padron on cod_padron = id_padron LEFT JOIN inquilino ON cod_inquilino = id_inquilino where periodo = '"+ period +"' and `propietario` LIKE '%"+name+"%' and `nombreApellido` LIKE '%"+lessee+"%' ORDER by id_cedulon;");
                return cedulon;
                default:
                return cedulon;
            }
    }
    
    public Object [][] filterDue(String properties, String lessee, boolean[] filter)
    {
            String select = " LEFT join padron on cod_padron = id_padron LEFT JOIN inquilino ON cod_inquilino = id_inquilino ";
            Object [][] cedulon = getCedulon(select + "order by id_cedulon;");
            switch(Arrays.toString(filter))
            {
                case "[false, false]":
                cedulon = getCedulon(select + " where `estado` = 'PENDIENTE' order by id_cedulon;");
                return cedulon;
                case "[false, true]":
                cedulon = getCedulon(select +"where `nombreApellido` = '"+lessee+"' and `estado` = 'PENDIENTE' ORDER by id_cedulon;");
                return cedulon;
                case "[true, false]":
                 cedulon = getCedulon(select +"where `propietario` = '"+properties+"' and `estado` = 'PENDIENTE' ORDER by id_cedulon;");    
                return cedulon;
                case "[true, true]":
                cedulon = getCedulon(select +"where `propietario` = '"+properties+"' and `nombreApellido` = '"+lessee+"' and `estado` = 'PENDIENTE' ORDER by id_cedulon;");
                return cedulon;
                default:
                return cedulon;
            }
    }
    
    public boolean inserPayment(String date, String cod_cedulon, String concept, String cod_payment, String detailPaymnet)
    {
            String datos[] = {date, cod_cedulon, concept, cod_payment, detailPaymnet};
            return senSql.insert(datos, "insert into `ingreso`(`fecha`, `cod_cedulon`, `concepto`, `medio`, `detallePago`) values(?,?,?,?,?)");
    }
    
    public int inserPayment1(String modality, String detail, String import_)
    {
            String datos[] = {modality, detail, import_};
            if(senSql.insert(datos, "insert into `operacion`(`cod_modalidad`, `detalle`, `importe`) values(?,?,?);"))
                return senSql.ReturnId("operacion","id_operacion");
            else
                return -1;
    }
    
    public boolean insertRubro(String rubro)
    {
        String datos[] = {rubro};
        return senSql.insert(datos, "insert into `rubro`(`rubro`) values(?)");    
    }
    
    public boolean inserSimpleIngress(String date, String cod_cedulon, String concept, String paymentMethod, String DetailPayment, String total)
    {
        String datos[] = {date, cod_cedulon, concept, paymentMethod, DetailPayment, total};
        return senSql.insert(datos, "insert into `ingreso`(`fecha`, `cod_cedulon`, `concepto`, `medio`, `detallePago`, `total2`) values(?,?,?,?,?,?)");
    }
   
    public int temporalInsertEgress(String date, String concept, String cod_rubro)
    {
        String datos[] = {date, concept, cod_rubro};
        if(senSql.insert(datos, "insert into `pruebaegreso`(`fecha`, `concepto`, `cod_rubro`) values(?,?,?)"))
            return senSql.ReturnId("pruebaegreso","id_egreso");
        else
            return -1;
    }
    
    public boolean temporalInsertEgress(String id, String date, String concept, String cod_rubro)
    {
        String datos[] = {id, date, concept, cod_rubro};
        return senSql.insert(datos, "insert into `pruebaegreso`(`id_egreso`, `fecha`, `concepto`, `cod_rubro`) values(?,?,?,?)");
    }
    
    public int temporalInsertIngress(String date, String concept)
    {
        String datos[] = {date, concept};
        if(senSql.insert(datos, "insert into `pruebaingreso`(`fecha`, `concepto`) values(?,?)"))
            return senSql.ReturnId("pruebaingreso","id_ingreso");
        else
            return -1;
    }
    
    public boolean temporalInsertIngress(String id, String date, String concept)
    {
        String datos[] = {id, date, concept};
        return senSql.insert(datos, "insert into `pruebaingreso`(`id_ingreso`, `fecha`, `concepto`) values(?,?,?)");
    }
    
    public int InsertOtherIngress(String date, String concept, String cod_rubro)
    {
        String datos[] = {date, concept, cod_rubro};
        if(senSql.insert(datos, "insert into `otrosingresos`(`fecha`, `concepto`, `cod_rubro`) values(?,?,?)"))
            return senSql.ReturnId("otrosingresos","id_ingreso");
        else
            return -1;
    }
    
    public boolean InsertOtherIngress(String id, String date, String concept, String cod_rubro)
    {
        String datos[] = {id, date, concept, cod_rubro};
        return senSql.insert(datos, "insert into `otrosingresos`(`id_ingreso`, `fecha`, `concepto`, `cod_rubro`) values(?,?,?,?)");
    }
    
    public int InsertOtherEgress(String date, String concept, String cod_rubro)
    {
        String datos[] = {date, concept, cod_rubro};
        if(senSql.insert(datos, "insert into `otrosegresos`(`fecha`, `concepto`, `cod_rubro`) values(?,?,?)"))
            return senSql.ReturnId("otrosegresos","id_egreso");
        else
            return -1;
    }
    
    public boolean InsertOtherEgress(String id, String date, String concept, String cod_rubro)
    {
        String datos[] = {id, date, concept, cod_rubro};
        return senSql.insert(datos, "insert into `otrosegresos`(`id_egreso`, `fecha`, `concepto`, `cod_rubro`) values(?,?,?,?)");
    }
    
    
    public boolean insertEgrMod(String codEgress, String codOperation)
    {
        String datos[] = {codEgress, codOperation};
        return senSql.insert(datos, "insert into `egrmod`(`cod_egreso`, `cod_operacion`) values(?,?)");
    }
    
    public boolean insertIngMod(String codIngress, String codOperation)
    {
        String datos[] = {codIngress, codOperation};
        return senSql.insert(datos, "insert into `ingmod`(`cod_ingreso`, `cod_operacion`) values(?,?)");
    }
    
    public boolean insertIngModBlack(String codIngress, String codOperation)
    {
        String datos[] = {codIngress, codOperation};
        return senSql.insert(datos, "insert into `ingmodblack`(`cod_ingreso`, `cod_operacion`) values(?,?)");
    }
    
    public boolean insertEgrModBlack(String codEgress, String codOperation)
    {
        String datos[] = {codEgress, codOperation};
        return senSql.insert(datos, "insert into `egrmodblack`(`cod_egreso`, `cod_operacion`) values(?,?)");
    }
    
    public boolean insertEgress(String date, String concept, String mode, String detailPayment, String total)
    {
        String datos[] = {date, concept, mode, detailPayment, total};
        return senSql.insert(datos, "insert into `egreso`(`fecha`, `concepto`, `medio`, `detallePago` ,`total`) values(?,?,?,?,?)");
    }
   
    public boolean insertCensus(String user, String channel, String value, String owner, String cod_inquilino )
    {
        String datos[] = {user, channel, value, owner, cod_inquilino};
        return senSql.insert(datos, "insert into `padron`(`usuario`, `canal`, `cuantia`, `propietario`, `cod_inquilino`) values(?,?,?,?,?)");
    }
   
    public boolean insertCedulon(String cod_Padron, String valueCuantia,String total, String dateOfExpired, String period, String recargo, String state )
    {
        String datos[] = {cod_Padron, valueCuantia, total, dateOfExpired, period, recargo, state};
        return senSql.insert(datos, "insert into `cedulon`(`cod_padron`, `montoPorCuantia`, `total`, `fechaVencimiento`, `periodo`, `recargo`, `estado`) values(?,?,?,?,?,?,?)");
    }
    public boolean insertCedulonWithId(String id_cedulon, String cod_Padron, String valueCuantia,String total, String dateOfExpired, String period, String recargo, String state )
    {
        String datos[] = {id_cedulon, cod_Padron, valueCuantia, total, dateOfExpired, period, recargo, state};
        return senSql.insert(datos, "insert into `cedulon`(`id_cedulon`, `cod_padron`, `montoPorCuantia`, `total`, `fechaVencimiento`, `periodo`, `recargo`, `estado`) values(?,?,?,?,?,?,?,?)");
    }
    
    public boolean insertLesse(String id_inquilino, String nombreApellido, String domicilio, String telefono, String cod_ciudad)
    {               
        String datos[] = {id_inquilino, nombreApellido, domicilio, telefono ,cod_ciudad};           
        return senSql.insert(datos, "insert into inquilino(id_inquilino, nombreApellido, direccion, telefono, cod_ciudad) values(?,?,?,?,?)");
    }
    
    public Object[] combox(String tabla, String campo)
    {
        return senSql.SetComboBox(tabla, campo, "select DISTINCT "+campo+" from "+tabla+" ORDER by "+ campo + ";");
    }
    
    public boolean deleteCedulon( String id)
    {
        return senSql.deleteRow("cedulon", "`id_cedulon` = "+id+"");
    }
    
    public boolean deleteIngress( String id)
    {
        return senSql.deleteRow("ingreso", "`cod_cedulon` = "+id+"");
    }
    
    public boolean deletePayment(String id)
    {
        return senSql.deleteRow("operacion", "`id_operacion` = "+id+"");
    }
    
    public boolean deleteSimpleIngress( String id)
    {
        return senSql.deleteRow("ingreso", "`id_ingreso` = "+id+"");
    }
    
    public boolean deleteEgress(String id)
    {
        return senSql.deleteRow("egreso", "`id_egreso` = "+id+"");
    }
    
    public boolean deleteTemporalOperation(String id)
    {
        return senSql.deleteRow("operacion", "`id_operacion` = "+id+"");
    }
    
    public boolean deleteIngModTrhowsCodOperation(String cod_operation)
    {
        return senSql.deleteRow("ingmod", "`cod_operacion` = "+cod_operation+"");
    }
    
    public boolean deleteEgrModTrhowsCodOperation(String cod_operation)
    {
        return senSql.deleteRow("egrmod", "`cod_operacion` = "+cod_operation+"");
    }
    
    public boolean deleteIngModBlackTrhowsCodOperation(String cod_operation)
    {
        return senSql.deleteRow("ingmodblack", "`cod_operacion` = "+cod_operation+"");
    }
    
    public boolean deleteEgrModBlackTrhowsCodOperation(String cod_operation)
    {
        return senSql.deleteRow("egrmodblack", "`cod_operacion` = "+cod_operation+"");
    }
    
    public boolean deleteTemporalIngress(String id)
    {
        return senSql.deleteRow("pruebaingreso", "`id_ingreso` = "+id+"");
    }
    
    public boolean deleteTemporalEgress(String id)
    {
        return senSql.deleteRow("pruebaegreso", "`id_egreso` = "+id+"");
    }
    
    public boolean deleteOtherIngress(String id)
    {
        return senSql.deleteRow("otrosingresos", "`id_ingreso` = "+id+"");
    }
    
    public boolean deleteOtherEgress(String id)
    {
        return senSql.deleteRow("otrosegresos", "`id_egreso` = "+id+"");
    }
    
    public boolean existPeriod(String period)
    {
        return senSql.existence(period, " from cedulon where periodo='"+period+"';");
    }
    public boolean existCedulon(String number)
    {
        return senSql.existence("id_cedulon", " from cedulon where id_cedulon='"+number+"';");
    }
    
    public boolean existPayment(int number)
    {
        return senSql.existence("id_operacion", " from operacion where id_operacion='"+number+"';");
    }
    
    public boolean existPadron(String number)
    {
        return senSql.existence("id_padron", " from padron where id_padron= '"+number+"';");
    }
    
    public boolean existLessee(String id_lessee)
    {
        return senSql.existence("id_inquilino", " from inquilino where id_inquilino = '"+id_lessee+"';");
    }
    
    public boolean existLesseeForName(String name)
    {
        return senSql.existence("nombreApellido", " from inquilino where nombreApellido = '"+name+"';");
    }
    
    public boolean existLesseInPadron(String id_lessee)
    {
        return senSql.existence("id_inquilino", " from padron,inquilino where cod_inquilino = id_inquilino and id_inquilino = '"+id_lessee+"';");
    }
    
    public boolean isPaidOut (String value)
    {
        return senSql.existence("id_cedulon", " from cedulon where id_cedulon = '"+value+"' and estado = 'PAGADO';");
    }
    
    public boolean dropCensus(String id_padron)
    {
        return senSql.deleteRow("padron", "id_padron = '" +id_padron+ "';");
    }
    
    public boolean dropLessee(String id_lessee)
    {
        return senSql.deleteRow("inquilino", "id_inquilino = '" +id_lessee+ "';");
    }
    
    public String parseCity(String city)
    {
    return senSql.datos_string("id_ciudad", "select id_ciudad from ciudad where nombreCiudad='"+city+"';");
    }
    
    public String parseRubro(String rubro)
    {
    return senSql.datos_string("id_rubro", "select id_rubro from rubro where rubro='"+rubro+"';");
    }
    
    public String parseLessee(String lessee)
    {
        return senSql.datos_string("id_inquilino", "select id_inquilino from inquilino where nombreApellido='"+lessee+"';");
    }
    public String parcePayment(String pay)
    {
        return senSql.datos_string("id_modalidad", "select id_modalidad from modalidad where modalidad='"+pay+"';");
    }
    public String parcePayment1(String id_modalidad)
    {
        return senSql.datos_string("modalidad", "select modalidad from modalidad where id_modalidad='"+id_modalidad+"';");
    }
}
