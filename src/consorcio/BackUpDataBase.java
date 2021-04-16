package consorcio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author leoasson
 */
public class BackUpDataBase
{
    AuxiliaryFunctions af = new AuxiliaryFunctions();
    
    public BackUpDataBase(){}
    
    public void GenerarBackupMySQL()
    {           
        SaveSqlFile file = new SaveSqlFile();    
        String route = file.getRoute();
        if(route != null)
        { 
                try
                {
                    Runtime runtime = Runtime.getRuntime();
                    File backupFile = new File(String.valueOf(route));
                    InputStreamReader irs;
                    BufferedReader br;
                    try (FileWriter fw = new FileWriter(backupFile)) {
                        Process child = runtime.exec("C:\\xampp\\mysql\\bin\\mysqldump --opt --password=administrador --user=admin "+ "--databases consorcio -R");
                        irs = new InputStreamReader(child.getInputStream());
                        br = new BufferedReader(irs);
                        String line;
                        while( (line=br.readLine()) != null ) {
                            fw.write(line + "\n");
                        }
                    }
                    irs.close();
                    br.close();

                }
                catch(IOException e)
                {
                    JOptionPane.showMessageDialog(null, "Error no se generó el archivo por el siguiente motivo: \n"+e.getMessage(), "Verificar",JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showMessageDialog(null, "Archivo generado correctamente","Exportación base de datos",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    

