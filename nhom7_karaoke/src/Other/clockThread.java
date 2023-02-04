package Other;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class clockThread extends Thread {
	private JLabel lbl;
	public clockThread(JLabel lbl) {
		this.lbl = lbl;
	}
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
		while(true) {
			Date now = new Date();
			String st = sdf.format(now);
			lbl.setText(st);
			
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
