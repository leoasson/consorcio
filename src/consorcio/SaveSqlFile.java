package consorcio;

import java.io.File;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_SELECTION;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author leoasson
 */
public class SaveSqlFile 
{
    AuxiliaryFunctions af = new AuxiliaryFunctions();
    String route;
    
    public SaveSqlFile() 
    {}
    
    public void save()
    {
        JFileChooser fileChooser; 
        fileChooser = new JFileChooser(".") {
            @Override
            public void approveSelection() 
            {
                File fileToSave = getSelectedFile();
                if(getSelectedFile().exists()) 
                {
                    if (JOptionPane.showConfirmDialog(null, "El archivo ya existe.\n Desea sobrescribirlo?", "Advertencia",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION)
                    {
                        route = fileToSave.getAbsolutePath();
                        fireActionPerformed(APPROVE_SELECTION);
                        cancelSelection();
                    }
                }
                else 
                {
                    if(fileToSave.getAbsolutePath().endsWith(".sql"))
                    {
                        route = fileToSave.getAbsolutePath();
                        fireActionPerformed(APPROVE_SELECTION);
                        cancelSelection();
                    }
                    else
                    {
                        route = fileToSave.getAbsolutePath()+ ".sql";
                        fireActionPerformed(APPROVE_SELECTION);
                        cancelSelection();
                    }
                }
            }
        };
        fileChooser.setDialogTitle("Guardar Base de datos");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(" Base de datos .sql","sql","sql");             
        fileChooser.setFileFilter(filter);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setSelectedFile(new File("backupBD-"+af.getActualDateInString()+".sql"));
        fileChooser.showSaveDialog(null);
    }
    
    public String getRoute()
    {
        save();
        return route;
    }
    
}

