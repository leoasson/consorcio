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
public class SaveExcelFile 
{
    String name;
    String route;
    
    public SaveExcelFile(String name) 
    {
        this.name = name;
    }
    
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
                        //System.out.println(fileToSave.getAbsolutePath());
                        fireActionPerformed(APPROVE_SELECTION);
                        cancelSelection();
                    }
                }
                else 
                {
                    if(fileToSave.getAbsolutePath().endsWith(".xls"))
                    {
                        route = fileToSave.getAbsolutePath();
                        fireActionPerformed(APPROVE_SELECTION);
                        cancelSelection();
                    }
                    else
                    {
                        route = fileToSave.getAbsolutePath()+ ".xls";
                        fireActionPerformed(APPROVE_SELECTION);
                        cancelSelection();
                    }
                }
            }
        };
        fileChooser.setDialogTitle("Guardar informe");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Libro de excel 93-2003 .xls","xls","excel");             
        fileChooser.setFileFilter(filter);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setSelectedFile(new File(name+".xls"));
        fileChooser.showSaveDialog(null);
    }
    
    public String getRoute()
    {
        save();
        return route;
    }
    
}

