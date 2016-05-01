package coinmachine;

import java.util.Observable;
import java.util.Observer;

public class CoinCount implements Observer{
	private CoinGUI coin_gui = new CoinGUI() ;
	private CoinMachineShow coinShow = new CoinMachineShow();
	private CoinMachine machine ;
	
	public CoinCount(){
		coin_gui.run();
		coinShow.run();
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println(machine.getCount());
//		machine = (CoinMachine) arg0 ;
		if( arg1 != null) {
			System.out.println("eiei") ;
			coin_gui.getText().setText(Integer.toString(((CoinMachine)arg0 ).getCount()));;
		}
		
		coin_gui.getText().setText(String.valueOf(machine.getCount()));
	}
}
