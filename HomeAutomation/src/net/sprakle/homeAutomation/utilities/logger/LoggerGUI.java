package net.sprakle.homeAutomation.utilities.logger;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import net.sprakle.homeAutomation.main.Config;
import net.sprakle.homeAutomation.userInterface.Window.Window;
import net.sprakle.homeAutomation.userInterface.Window.WindowPosition;

public class LoggerGUI {
	Window logWindow;

	JTextPane textPane;
	JScrollPane scrollPane;

	LoggerGUI() {
		String name = Config.getString("config/system/name");
		String version = Config.getString("config/system/version");
		String title = name + " v" + version + "- Log";
		logWindow = new Window(title, 600, 800, WindowPosition.NORTHWEST);

		Container cp = logWindow.getContentPane();

		textPane = new JTextPane();
		textPane.setEditable(false);

		scrollPane = new JScrollPane(textPane);
		cp.add(scrollPane, BorderLayout.CENTER);

		logWindow.validate();
	}

	void println(String text, LogSource source) {

		/*********** Prefix ***********/

		// create attribute
		SimpleAttributeSet prefixAttributes = new SimpleAttributeSet();
		prefixAttributes = new SimpleAttributeSet();

		// set attribute color
		StyleConstants.setForeground(prefixAttributes, source.getColor());

		// set bold (for prefix)
		StyleConstants.setBold(prefixAttributes, true);

		// get doc to apply attribute
		Document prefixDoc = textPane.getStyledDocument();

		// set prefix
		String prefix = source + ": ";

		// append the line
		try {
			prefixDoc.insertString(prefixDoc.getLength(), prefix, prefixAttributes);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}

		/*********** Text ***********/

		// create attribute
		SimpleAttributeSet attributes = new SimpleAttributeSet();
		attributes = new SimpleAttributeSet();

		// set attribute color
		StyleConstants.setForeground(attributes, source.getColor());

		// get doc to apply attribute
		Document doc = textPane.getStyledDocument();

		// apply new line
		text += "\n";

		// append the line
		try {
			doc.insertString(doc.getLength(), text, attributes);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}

		// scroll down
		JScrollBar vertical = scrollPane.getVerticalScrollBar();

		try {
			vertical.setValue(vertical.getMaximum());
		} catch (NullPointerException e) {
			// sometimes throws an exception, it seems to be only when the window is minimised
		}
	}
}
