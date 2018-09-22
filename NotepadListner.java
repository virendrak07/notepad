import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.awt.datatransfer.*;
import java.awt.Toolkit;

@SuppressWarnings("unused")
public class NotepadListner implements ActionListener
{

	Notepad n1;
	Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
	JFileChooser fileChooser = new JFileChooser();
	public NotepadListner(Notepad n1) {
		this.n1 = n1;
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == n1.open)
		{

			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(n1.f);
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				FileReader reader;

				try {
					reader = new FileReader(selectedFile);
					n1.t.read(reader, selectedFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		//Save Operation
		else if(e.getSource() == n1.save) 
		{
			int retval = fileChooser.showSaveDialog(n1.save);
			if (retval == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				if (file == null) {
					return;
				}
				if (!file.getName().toLowerCase().endsWith(".txt")) {
					file = new File(file.getParentFile(), file.getName() + ".txt");
				}
				try {
					n1.t.write(new OutputStreamWriter(new FileOutputStream(file),
							"utf-8"));
					//		        Desktop.getDesktop().open(file);
				} catch (Exception e3) {
					e3.printStackTrace();
				}


			}
		}


			else if (e.getSource() == n1.saveAs) 
			{



			}


			//Copy Operation
			else if (e.getSource() == n1.copy) 
			{
				String ctc = n1.t.getSelectedText();
				StringSelection stringSelection = new StringSelection(ctc);

				clpbrd.setContents(stringSelection, null);
			}

			//Cut Operation
			else if (e.getSource() == n1.cut)
			{
				String selection = n1.t.getSelectedText();
				if (selection == null)
					return;
				StringSelection clipString = new StringSelection(selection);
				clpbrd.setContents(clipString, clipString);
				n1.t.replaceRange("", n1.t.getSelectionStart(), n1.t.getSelectionEnd());
			}
			


			//Paste Operation
			else if (e.getSource() == n1.paste)
			{
				Transferable clipData = clpbrd.getContents(n1);
				try
				{
					String clipString = (String)clipData.getTransferData(DataFlavor.stringFlavor);
					n1.t.replaceRange(clipString,n1.t.getSelectionStart(),n1.t.getSelectionEnd());
				}catch(Exception ex)
				{
					System.err.println("Not Working");
				}
			}

			
			
			else if (e.getSource() == n1.contact)
			{
				JOptionPane.showMessageDialog(n1.f,"Ezio Enterprises \nPune");
			}

			else if (e.getSource() == n1.about)
			{
				JOptionPane.showMessageDialog(n1.f,"JAVA SWING NOTEPAD \nVersion: Beta 1.0");
			}



		}



	}


