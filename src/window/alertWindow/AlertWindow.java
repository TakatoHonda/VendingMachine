package window.alertWindow;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


public class AlertWindow extends JFrame{
	private JLabel label;
	private Timer timer;
	private AlertWindow aw = this;  
	public AlertWindow(String errorName){
		setSize(470,250);
		setTitle(errorName);
		setLayout(null);
		setUndecorated(true);
		setAlwaysOnTop(true);
		setResizable(false);
		label = new JLabel("<html>"+errorName+"<br>"+"Return coins."+"</html>");
		label.setBounds(200, 100, 470, 250);
		add(label);
		timer = new Timer(2000, new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
                aw.setVisible(false);
                aw.dispose();
            }
		});
		timer.setRepeats(false);
        timer.start();

	}
}
