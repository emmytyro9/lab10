package coinmachine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;



public class CoinGUI extends JFrame {

	private JTextField textField;

	public CoinGUI() {
		initialize() ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initialize() {
		
		this.setLayout(new FlowLayout()) ;

		Container containerA = new Container() ;
		this.add(containerA) ;
		BoxLayout layout = new BoxLayout(containerA , BoxLayout.Y_AXIS) ;
		containerA.setLayout(layout) ;
		
		Container containerB = new Container() ;
		containerA.add(containerB) ;
		BoxLayout layout2 = new BoxLayout(containerB , BoxLayout.X_AXIS) ;
		containerB.setLayout(layout2) ;
		
		Container containerC = new Container() ;
		containerA.add(containerC) ;
		BoxLayout layout3 = new BoxLayout(containerC , BoxLayout.X_AXIS) ;
		containerC.setLayout(layout3) ;
		
		JLabel lblcoins = new JLabel("#Coins: ");
		lblcoins.setFont(new Font("Century", Font.BOLD, 18));
		lblcoins.setBounds(21, 11, 86, 31);
		containerB.add(lblcoins);
		
		textField = new JTextField();
		textField.setFont(new Font("Century", Font.PLAIN, 11));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(129, 19, 150, 20);
		containerB.add(textField);
		textField.setColumns(10);
		
		JLabel lblAcceptingCoins = new JLabel("Accepting coins");
		lblAcceptingCoins.setBounds(115, 62, 74, 14);
		containerC.add(lblAcceptingCoins);
		
		
		
		pack() ;
	}

	public void run() {
		this.setVisible(true) ;
	}
}
