package loginFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class LoginFrame extends JFrame {
	
	LoginPanel jLoginPanel = new LoginPanel();
	String lookAndFeel;
	ImageIcon img;
	public  static LoginFrame lf;
	public LoginFrame() {
		img = new ImageIcon("res/img/icon_launch.png");
		this.setTitle("PC端——登陆界面");
		jLoginPanel.setBackground(Color.WHITE);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		int x = (int) ((dim.width - 500) / 2);
		int y = (int) ((dim.height - 320) / 2);
		this.add(jLoginPanel);
		this.setBounds(x, y, 500, 320);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		try {
			lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
			UIManager.setLookAndFeel(lookAndFeel); // 设置外观风格
		} catch (Exception e) { e.printStackTrace(); }
		this.setIconImage(img.getImage());
	}
	
	public static void main(String args[]) {
		lf = new LoginFrame();
	}

}
