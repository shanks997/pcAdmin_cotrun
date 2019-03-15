package loginFrame;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import netUtil.NetIO;
import utility.Constant;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel 
implements ActionListener {
	
	JLabel jAdmL = new JLabel("�û���:");
	JLabel jPwdL = new JLabel("��   ��:");
	JTextField jAdmT = new JTextField();
	JPasswordField jPwdT = new JPasswordField();
	JButton jLogin = new JButton("��¼");
	JButton jReset = new JButton("����");
	ImageIcon ii;
	JLabel background = new JLabel();
	
	public LoginPanel() {
		ii = new ImageIcon("res/img/login.png");
		background.setIcon(ii);
		background.setBounds(125, 10, ii.getIconWidth(), ii.getIconHeight());
		this.add(background);
		// ȷ��ͼƬ���ᱻ����
		ii.setImage(ii.getImage().getScaledInstance
				(ii.getIconWidth(), ii.getIconHeight(), Image.SCALE_DEFAULT));
		this.setLayout(null);
		jAdmL.setBounds(80, 170, 80, 30);
		jAdmT.setBounds(130,170,240,30);
		jPwdL.setBounds(80,210,80,30);
		jPwdT.setBounds(130,210,240,30);
		jLogin.setBounds(150,250,80,20);
		jReset.setBounds(260,250,80,20);
		this.add(jAdmL);
		this.add(jAdmT);
		this.add(jPwdL);
		this.add(jPwdT);
		this.add(jLogin);
		this.add(jReset);
		jLogin.addActionListener(this);
		jReset.addActionListener(this);
		this.setVisible(true);
		NetIO.initInfo();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == jReset) {
			jAdmT.setText("");
			jPwdT.setText("");
		} else if (arg0.getSource() == jLogin) {
			//����û��������뵽�ַ�����
			String str = jAdmT.getText().toString();
			str = str + "<#>" + jPwdT.getText().toString();
			if (NetIO.isManager(str)) {
				JOptionPane.showMessageDialog(null, "��¼�ɹ�!");
				// ��PC���������
//				PrimaryFrame.pf = new PrimaryFrame();
				Constant.manager = jAdmT.getText().toString();
			}
			else {
				jAdmT.setText("");
				jPwdT.setText("");
				JOptionPane.showMessageDialog(null, "�û����������������������");
			}
		}
	}
	
}
