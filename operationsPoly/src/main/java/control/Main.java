package control;

import view.View;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
      	View v = new View();
		v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		v.setResizable(true);
		v.setSize(700,500);
		v.setVisible(true);
			
		
       
	}
}
