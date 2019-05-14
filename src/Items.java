import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Items extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	QuestionDataAccess QDA=new QuestionDataAccess();
	Question Q=new Question();
	PersonDataaccess PDA=new PersonDataaccess();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Items(Item I) {
		QDA.getdatax(I.getID(), Q);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Desc = new JLabel(I.getDescription());
		Desc.setBounds(10, 34, 401, 383);
		contentPane.add(Desc);
		
		JLabel Description = new JLabel("Description");
		Description.setBounds(176, 9, 128, 14);
		contentPane.add(Description);
		
		JLabel Question = new JLabel(Q.getQuestion());
		Question.setBounds(486, 261, 289, 70);
		contentPane.add(Question);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(486, 342, 289, 58);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String answer = textField.getText();
				boolean status=QDA.Validation(answer);
				if(status ==true)
				{	Person P=new Person();
					PDA.getdata(I.getPosterID(), P);
					JOptionPane.showMessageDialog(null,"Oh We found ya"+" Please Contact With "+P.getEmail()+" "+P.getPhoneN());
				}
				else
				{
					JOptionPane.showMessageDialog(null,"STOP STEAING!!");
				}
			}
		});
		btnSubmit.setBounds(686, 417, 89, 23);
		contentPane.add(btnSubmit);
		
		JLabel Photo = new JLabel("");
		Photo.setBounds(664, 9, 111, 95);
		contentPane.add(Photo);
		ImageIcon image = new ImageIcon(I.getPic());
        Image im = image.getImage();
        Image myImg = im.getScaledInstance(Photo.getWidth(), Photo.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon newImage = new ImageIcon(myImg);
        Photo.setIcon(newImage);
	}

	

}
