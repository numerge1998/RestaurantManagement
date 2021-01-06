package presentationLayer;


import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;


@SuppressWarnings("deprecation")
public class ChefGraphicalUserInterface implements Observer{

	@Override
	public void update(Observable o, Object comanda) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Trebuie sa gatesti!!!", "Comanda Noua", 0);
	}


}
