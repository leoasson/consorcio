package consorcio;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 *
 * @author decodigo
 */
public class GenerateXls 
{
    Object [][] dataTable;
    String[] column;
    String title;
    int tipe = 0;
    Workbook workbook = new HSSFWorkbook();
    Sheet sheet = workbook.createSheet("Hoja de datos");
    CellStyle style = workbook.createCellStyle();
    CellStyle style2 = workbook.createCellStyle();
    CellStyle style3 = workbook.createCellStyle();
    CellStyle style4 = workbook.createCellStyle();
    Map<Integer, Object[]> datos;
    
    public GenerateXls(Object[][] dataTable, String[] column, String title, int tipe)
    {
        this.tipe = tipe;
        this.dataTable = dataTable;
        this.column = column;
        this.title = title;
        //Por cada línea se crea un arreglo de objetos (Object[])
        datos = new TreeMap<>();
        for(int i=0; i<dataTable.length; i++)
        {    
            datos.put(i, dataTable[i]);
        }
        setStylus1();
        setBorderStylus();
        setTotalStylus();
        setTitleStylus();
    }
    
    public void generate(String route) 
    {
        generateHeader();
        insertDataInTable();
        generateDocument(route);

    }
    
    
    private void setStylus1()
    {
        // Indicamos que tendra un fondo azul aqua con patron solido del color indicado
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
    }
    private void setBorderStylus()
    {
        style2.setBorderBottom(CellStyle.BORDER_THIN);
        style2.setBorderTop(CellStyle.BORDER_THIN);
        style2.setBorderRight(CellStyle.BORDER_THIN);
        style2.setBorderLeft(CellStyle.BORDER_THIN);
    }
    
    private void setTotalStylus()
    {
        style3.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
        style3.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style3.setBorderBottom(CellStyle.BORDER_THIN);
        style3.setBorderTop(CellStyle.BORDER_THIN);
        style3.setBorderRight(CellStyle.BORDER_THIN);
        style3.setBorderLeft(CellStyle.BORDER_THIN);
        style3.setAlignment(CellStyle.ALIGN_CENTER);
    }
    
        private void setTitleStylus()
    {
        style4.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
        style4.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style4.setBorderBottom(CellStyle.BORDER_THIN);
        style4.setBorderTop(CellStyle.BORDER_THIN);
        style4.setBorderRight(CellStyle.BORDER_THIN);
        style4.setBorderLeft(CellStyle.BORDER_THIN);
        style4.setAlignment(CellStyle.ALIGN_CENTER);
    }
    
    
    
    private void generateHeader()
    {    
        //cramos el titulo del archivo
        Row fila = sheet.createRow(0);
        for(int i = 0; i < column.length;i++)
        {
            Cell celd = fila.createCell(i);
            celd.setCellStyle(style4);
            if(i == 0)
            {
                celd.setCellValue(title);
            }
        }
        CellRangeAddress cellRangeAddress = new CellRangeAddress(0,0,0,column.length - 1);
        sheet.addMergedRegion(cellRangeAddress);
        
        //Creamos los nombre de las columnas
        Row fila2 = sheet.createRow(1); 
        for(int i = 0; i < column.length; i++) 
        {
            Cell cell2 = fila2.createCell(i);
            cell2.setCellStyle(style); 
            cell2.setCellValue(column[i]);
            sheet.autoSizeColumn(i);
        }
    }
    private void insertDataInTable()
    {
        Set keyset = datos.keySet();
        int numeroRenglon = 2;
        for (Object key : keyset)
        {
            Row row = sheet.createRow(numeroRenglon++);
            Object[] arregloObjetos = datos.get(key);
            int numeroCelda = 0;
            for (Object obj : arregloObjetos) {
                Cell cell = row.createCell(numeroCelda++);      
                
                if((String) obj != null)
                {
                    if (!VerifyIsIntegger((String) obj)) 
                    {
                        cell.setCellValue((String) obj);
                        cell.setCellStyle(style2);
                        sheet.autoSizeColumn(numeroCelda);
                    } 
                    else if (VerifyIsIntegger((String) obj)) 
                    {
                        cell.setCellValue(Double.valueOf((String) obj));
                        cell.setCellStyle(style2);
                        sheet.autoSizeColumn(numeroCelda);
                    }
                }
                else
                {
                    cell.setCellValue("");
                    cell.setCellStyle(style2);
                    sheet.autoSizeColumn(numeroCelda);
                }
            }
        }
        
        if(tipe == 1)
        {
            insertTotalForPayments(numeroRenglon);
        }
        else if (tipe == 2)
        {
            insertTotalForEgress(numeroRenglon);
        }
        
    }
    
    private void insertTotalForEgress(int celda)
    {
        Row fila = sheet.createRow(celda);
        for(int i = 0; i < column.length; i++)
        {
            Cell celd = fila.createCell(i);
            celd.setCellStyle(style3);
            if(i == 0)
            {
                celd.setCellValue("Total");
            }
            else if (i == column.length-1)
            {
                celd.setCellType(Cell.CELL_TYPE_FORMULA);
                String strFormula = "SUM(F3:F"+celda+")";
                celd.setCellFormula(strFormula);
            }
        }
        CellRangeAddress cellRangeAddress = new CellRangeAddress(celda,celda,0,column.length-2);
        sheet.addMergedRegion(cellRangeAddress);
    }
    
    
    
    private void insertTotalForPayments(int celda)
    {    
        Row fila = sheet.createRow(celda);
        //suma de totales
        Row fila2 = sheet.createRow(celda+1);
        
        Cell celd1 = fila2.createCell(column.length-2);
        Cell celd2 = fila2.createCell(column.length-1);
        celd2.setCellStyle(style3);
        celd1.setCellStyle(style3);
        
        for(int i = 0; i < column.length; i++)
        {
            Cell celd = fila.createCell(i);
            celd.setCellStyle(style3);
            if(i == 0)
            {
                celd.setCellValue("Total");
            }
            else if (i == column.length-2)
            {
                celd.setCellType(Cell.CELL_TYPE_FORMULA);
                String strFormula = "SUM(I2:I"+celda+")";
                celd.setCellFormula(strFormula);
                
            }
            else if (i == column.length-1)
            {
                celd.setCellType(Cell.CELL_TYPE_FORMULA);
                String strFormula = "SUM(J2:J"+celda+")";
                celd.setCellFormula(strFormula);
            }
        }
        CellRangeAddress cellRangeAddress = new CellRangeAddress(celda,celda,0,column.length-3);
        sheet.addMergedRegion(cellRangeAddress);
        
        
        String strFormulaTotal = "SUM(I"+(celda+1)+":J"+(celda+1)+")";
        celd1.setCellFormula(strFormulaTotal);
        
        CellRangeAddress cellRangeAddress2 = new CellRangeAddress(celda+1,celda+1,column.length-2,column.length-1);
        sheet.addMergedRegion(cellRangeAddress2);
        
    }
    
    private void generateDocument(String route)
    {
        try 
        {
            try (FileOutputStream out = new FileOutputStream(new File(route))) {
                workbook.write(out);
            }
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null,"No se pudo guardar el archivo. Asegurese que no este abierto."," ",JOptionPane.WARNING_MESSAGE);
        }
    }
      
    
    private boolean VerifyIsIntegger(String value)
    {
        try
        {
            Double.valueOf(value);  
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
}