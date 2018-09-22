import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("unused")
public class Notepad  {
	
	JFrame f;
	JMenuBar m;
	JMenu file, edit, format, help;
	JMenuItem open, save, saveAs, copy, cut, paste;
	JMenuItem contact, about;
	JTextArea t;

	public Notepad() {
		// TODO Auto-generated constructor stub
		f = new JFrame();
		f.setTitle("Notepad using Swing");
		m = new JMenuBar();
		f.setJMenuBar(m);
		file = new JMenu("File");
		m.add(file);
		
		open = new JMenuItem("Open");
		file.add(open);
		save = new JMenuItem("Save");
		file.add(save);
		saveAs = new JMenuItem("Save As");
		file.add(saveAs);
		file.addSeparator();
		edit = new JMenu("Edit");
		m.add(edit);
		
		copy = new JMenuItem("Copy");
		edit.add(copy);
		cut = new JMenuItem("Cut");
		edit.add(cut);
		paste = new JMenuItem("Paste");
		edit.add(paste);
		
		
		format = new JMenu("Format");
		m.add(format);
		
		help = new JMenu("Help");
		m.add(help);
		
		contact = new JMenuItem("Contact Us");
		help.add(contact);
		about = new JMenuItem("About");
		help.add(about);
		
		
		NotepadListner l = new NotepadListner(this);
		open.addActionListener(l);
		save.addActionListener(l);
		saveAs.addActionListener(l);
		copy.addActionListener(l);
		cut.addActionListener(l);
		paste.addActionListener(l);
		contact.addActionListener(l);
		about.addActionListener(l);
		
		
		
		
		t = new JTextArea(200,200);
		f.add(t);
		
		f.setVisible(true);
		f.setSize(1000, 1000);
	}
	public static void main(String[] args) {
		Notepad n = new Notepad();
	}
}
