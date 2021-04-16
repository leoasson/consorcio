package consorcio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Leandro Asson
 */
public class sentencesSql {
    
    private final Conection con;
    PreparedStatement ps;
    ResultSet res;

    public sentencesSql() {
        con = new Conection();
    }
    
    public boolean insert(String datos[], String insert)
    {
      boolean state = false;
       try {
            ps = con.connected().prepareStatement(insert);
            for(int i=0; i<=datos.length-1;i++){
                ps.setString(i+1, datos[i]);
            }
            ps.execute();
            ps.close();
            state = true;
         }catch(SQLException e){
         System.out.println(e);
      }
       return state;
   }
    
    public void disconect()
    {
        con.disconnect();
    }
    
    public int ReturnId(String table, String nameOfThePrimaryColumn)
    {
        int id =0;
        try{
            ps = con.connected().prepareStatement("SELECT MAX("+nameOfThePrimaryColumn+") AS id FROM "+table+";");
            res = ps.executeQuery();
            res.next();
            id = res.getInt("id");
            res.close();
         }catch(SQLException e){
            System.out.println(e);
         }
        return id;
   
    }
    
    public Object [][] GetTable(String colName[], String from, String where)
    {
        int register = 0;
        String select = arrayStringToString(colName);
        String consult = "SELECT " + select + from + where ; 
        System.out.println(consult);
        try
        {
           ps = con.connected().prepareStatement("select count(*) as total " + from + where);
           //System.out.println("select count(*) as total " + from + where);
           res = ps.executeQuery();
           res.next();
           register = res.getInt("total");
           res.close();
        }
        catch(SQLException e)
        {
           System.out.println(e);
        }

      Object[][] data = new String[register][colName.length];
      String col[] = new String[colName.length];

        try{
           ps = con.connected().prepareStatement(consult);
           res = ps.executeQuery();
           int i = 0;
           while(res.next()){
              for(int j=0; j<=colName.length-1;j++){
                  col[j] = res.getString(colName[j]);
                  data[i][j] = col[j];
              }
              i++;
           }
           res.close();
            }catch(SQLException e){
           System.out.println(e);
        }
        return data;
        
    }
    
    /* Funcion que modifica un elemento de la tabla.
     *
     *@param table nombre de la tabla que se desea modificar.
     *@param column nombre de la columna que se desea modificar.
     *@param value valor que se agregara en una posicion de la columna seleccionada.
     *@param where condicion, lo que determina la fila seleccionada. "nombreColumna = xxxx".
     *@return true si la modificacion se realizo exitosamente.
     *@return false si en la modificacion hubo errores.
     */
    public boolean modifiedRow(String table, String column ,String value, String where)
    {
        try
        {
            //System.out.println("UPDATE `"+ table +"` SET `"+column+"` = '"+value+"' WHERE "+ where +";");
            ps = con.connected().prepareStatement("UPDATE `"+ table +"` SET `"+column+"` = '"+value+"' WHERE "+ where +";");
            System.out.println("UPDATE `"+ table +"` SET `"+column+"` = '"+value+"' WHERE "+ where +";");
            ps.executeUpdate();
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
     
    public boolean deleteRow(String table, String where)
        {
            try
            {
              //System.out.println("DELETE FROM `"+ table +"` WHERE "+where+";");
              ps = con.connected().prepareStatement("DELETE FROM `"+ table +"` WHERE "+where+";");
              ps.executeUpdate();
              return true;
            }
          catch(SQLException e)
          {
              System.out.println(e);
              return false;
          }  
            
        }
    
     /* Funcion que modifica un elemento de la tabla.
     *
     *@param campo nombre de la columna
     *@param from_where nombre de la tabla y condiciones (from 'name_table' where xxx=yyy;).
     *@return register la cantidad de filas de la tabla
     */
     public int coutTable(String field, String from_where)
     {
        int register = 0;
        try{
            ps = con.connected().prepareStatement("SELECT count("+field+") as total  " + from_where);
            res = ps.executeQuery();
            res.next();
            register = res.getInt("total");
            res.close();
         }catch(SQLException e){
            System.out.println(e);
         }
        return register;
    }       
    
     
    /* Funcion que comprueba si existe un ciero elemento en la tabla
     *
     *@param campo nombre de la columna
     *@param from_where nombre de la tabla y condiciones (from 'name_table' where xxx=yyy;).
     *@return true o false;
     */ 
    public boolean existence(String field, String from_where)
    {
        int registros = 0;
        try{
            ps = con.connected().prepareStatement("SELECT count("+field+") as total  " + from_where);
            res = ps.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
         }catch(SQLException e){
            System.out.println(e);
         }
        return registros > 0;
    }
     /*
     * Retorna la suma de las cantidades de una tabla dado un articulo en particular.
     */
    public int getQuantity (String from_where)
    {
        int registros = 0;
        try{
            ps = con.connected().prepareStatement("SELECT sum(cantidad) as total "  + from_where);
            res = ps.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
         }
        catch(SQLException e)
         {
            System.out.println(e);
         }
        return registros;
        
    }
     
    public String datos_string(String nombre_columna, String sentenciasql){
        
    String datos ="";
      try{
         ps = con.connected().prepareStatement(sentenciasql);
         res = ps.executeQuery();
         while(res.next()){
            datos = res.getString(nombre_columna);
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return datos;
    }
     
    public Object[] SetComboBox(String tabla, String nombrecol, String sql)
    {
        int register = 0;      
        try{
           ps = con.connected().prepareStatement("SELECT count(DISTINCT " +nombrecol+ ") as total FROM " + tabla);
           res = ps.executeQuery();
           res.next();
           register = res.getInt("total");
           res.close();
        }catch(SQLException e){
           System.out.println(e);
        }

        Object[] datos = new Object[register];
        try
        {
           ps = con.connected().prepareStatement(sql);
           res = ps.executeQuery();
           int i = 0;
           while(res.next()){
              datos[i] = res.getObject(nombrecol);
              i++;
           }
           res.close();
        }
        catch(SQLException e)
        {
           System.out.println(e);
        }
        return datos;
    }
        
     public String arrayStringToString (String [] table)
     {
           String select = "";
              for (String table1 : table)
        {
            if (select.equals("")) {
                select = table1;
            } else {
                select = select + ", " + table1;
            }
        }
              return select;
     }
     
     
     }
    

