package gui;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
//awt
//swing
public class GUITest extends JFrame{
	public GUITest() {
		
		super("버튼테스트");
		setSize(500,700);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Button btn = new Button("Click!");
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Click!")) {
					System.out.println("나 눌렸어...");
				}
				
			}
		});
		
		setLayout(new FlowLayout());
		
		int x = (d.width-this.getWidth())/2;
		int y = (d.height-this.getHeight())/2;
		
		setLocation(x,y);
		
		add(btn);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("닫힙니다.");
				System.exit(0);
			}
		});
		setVisible(true);
	}
	public static void main(String[] args) {
		new GUITest();
	}
}
