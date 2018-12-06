package ca.csf.io;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 * 
 */
public class XMLJFileChooser extends JFileChooser {
	
	private static final long serialVersionUID = 5982173541462928123L;
	
	public XMLJFileChooser() {
		this.setFileFilter(new FileFilter() {			
			@Override
			public String getDescription() {
				return "Fichier XML (*.xml)";
			}			
			@Override
			public boolean accept(File p_Fichier) {
				return p_Fichier.isDirectory() || p_Fichier.getPath().endsWith(".xml");
			}
		});
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getSelectedFile() {
		File fichier = super.getSelectedFile();
		if (fichier != null && !this.accept(fichier)) {
			fichier = new File(super.getSelectedFile() + ".xml");
		}				
		return fichier;
	}
}