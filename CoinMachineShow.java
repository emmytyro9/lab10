package coinmachine;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.awt.Dialog.ModalExclusionType;

public class CoinMachineShow extends JFrame{
	private JLabel balance ;
	private JLabel status ;
	private JButton one ;
	private JButton five ;
	private JButton ten ;
	private int count ;
	private int amount = 0 ;
	private JProgressBar progressBar;

	public CoinMachineShow() {
		initialize();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void run() {
		this.pack() ;
		this.setVisible(true) ;
	}



	private void initialize() {

		getContentPane().setLayout(new FlowLayout()) ;

		Container containerA = new Container() ;
		containerA.setBounds(0, 0, 0, 0);
		BoxLayout layout = new BoxLayout(containerA , BoxLayout.Y_AXIS) ;
		containerA.setLayout(layout) ;
		getContentPane().add(containerA) ;

		Container containerB = new Container() ;
		containerB.setBounds(0, 0, 0, 0);
		BoxLayout layout2 = new BoxLayout(containerB , BoxLayout.X_AXIS) ;
		containerB.setLayout(layout2) ;
		containerA.add(containerB) ;

		Container containerC = new Container() ;
		containerC.setBounds(0, 0, 0, 0);
		BoxLayout layout3 = new BoxLayout(containerC , BoxLayout.X_AXIS) ;
		containerC.setLayout(layout3) ;
		containerA.add(containerC) ;

		balance = new JLabel("Balance:        ");
		balance.setBounds(30, 11, 95, 44);
		balance.setFont(new Font("Century", Font.BOLD, 20));
		containerB.add(balance);

		status = new JLabel("Status:");
		status.setBounds(160, 21, 95, 25);
		status.setFont(new Font("Century", Font.BOLD, 20));
		containerB.add(status);

		progressBar = new JProgressBar();
		containerB.add(progressBar);
		progressBar.setMaximum(10);

		ClassLoader loader = this.getClass().getClassLoader() ;
		URL url = loader.getResource("images/1baht.png") ;
		ImageIcon img = new ImageIcon(url) ;
		one = new JButton(img) ;
		one.setBounds(0, 0, 0, 0);
		AddActionListenner(one) ;

		ClassLoader loader2 = this.getClass().getClassLoader() ;
		URL url2 = loader2.getResource("images/5baht.png") ;
		ImageIcon img2 = new ImageIcon(url2) ;
		five = new JButton(img2) ;
		AddActionListenner(five) ;

		ClassLoader loader3 = this.getClass().getClassLoader() ;
		URL url3 = loader.getResource("images/10baht.png") ;
		ImageIcon img3 = new ImageIcon(url3) ;
		ten = new JButton(img3) ;
		AddActionListenner(ten) ;

		JPanel all = new JPanel();
		all.setBorder(BorderFactory.createTitledBorder("Insert Money")) ;
		containerC.add(all) ;
		all.add(one) ;
		all.add(five) ;
		all.add(ten) ;

	}

	public void AddActionListenner(JButton button) {
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				CoinMachine machine = new CoinMachine(10) ;
				Demo demo = new Demo() ;

				Coin oneBaht = new Coin(1) ;
				Coin fiveBaht = new Coin(5) ;
				Coin tenBaht = new Coin(10) ;

				if(button == one) {
					if(count < 10) {
						machine.insert(oneBaht) ;
						count += machine.getCount() ;
						amount += machine.getBalance() ;
						progressBar.setValue(count) ;
						balance.setText("Balance: " + amount + "      ") ;
						System.out.println("1" + "\n" + oneBaht +" inserted");
						if(count <= 9)
						System.out.print("Values of coins to insert: ");
					}
					else if(count == 10)
						System.out.println("Machine is Full.");
				}
				
				if(button == five) {
					if(count < 10) {
						machine.insert(fiveBaht) ;
						count += machine.getCount() ;
						amount += machine.getBalance() ;
						progressBar.setValue(count) ;
						balance.setText("Balance: " + amount + "      ") ;
						System.out.println("5" + "\n" + fiveBaht +" inserted");
						if(count <= 9)
						System.out.print("Values of coins to insert: ");
					}
					else if(count == 10)
						System.out.println("Machine is Full.");
				}
				if(button == ten) {
					if(count < 10) {
						machine.insert(tenBaht) ;
						count += machine.getCount() ;
						amount += machine.getBalance() ;
						progressBar.setValue(count) ;
						balance.setText("Balance: " + amount + "      ") ;
						System.out.println("10" + "\n" + tenBaht +" inserted");
						if(count <= 9)
						System.out.print("Values of coins to insert: ");
					}
					else if(count == 10)
						System.out.println("Machine is Full.");
				}
			}
		});
	}
}