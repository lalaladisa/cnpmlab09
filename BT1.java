package NguyenDangTanDuy_51704036;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BT1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BT1 frame = new BT1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BT1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Input URL:");
		lblNewLabel.setBounds(33, 11, 76, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Result:");
		lblNewLabel_1.setBounds(36, 70, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JTextField textField = new JTextField();
		textField.setText("https://dantri.com.vn/the-gioi.htm");
		textField.setBounds(93, 8, 331, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(89, 70, 335, 180);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Click");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();
				String getData="";
				try {
					String encoding = "ISO-8859-1";
					URL u = new URL(str);
					java.net.URLConnection uc = u.openConnection();
					String contentType = uc.getContentType();
					int encodingStart = contentType.indexOf("charset=");
					if(encodingStart !=-1) {
						encoding = contentType.substring(encodingStart+8);
					}
					java.io.InputStream in = new BufferedInputStream(uc.getInputStream());
					Reader r = new InputStreamReader(in, encoding);
					int c;
					while((c=r.read())!=-1) {
						getData += (char)c;
						
					}
					textArea.setText(getData);
				}catch(MalformedURLException ex) {
					textArea.setText("");
					Component fame = null;
					JOptionPane.showMessageDialog(fame, "Could not find the URL: "+str, "MalformedURLException", JOptionPane.WARNING_MESSAGE);
				}catch(IOException ex) {
					textArea.setText("");
					Component fame = null;
					JOptionPane.showInputDialog(fame, "I/O devices disconnect","IOException", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(203, 39, 89, 23);
		contentPane.add(btnNewButton);
	}
}//end
