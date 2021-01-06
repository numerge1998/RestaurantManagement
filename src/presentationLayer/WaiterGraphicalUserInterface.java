package presentationLayer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import businessLayer.MenuItem;
import businessLayer.Order;
import businessLayer.Restaurant;
import businessLayer.RestaurantProcessing;

public class WaiterGraphicalUserInterface {


	private JFrame frame = new JFrame();
	private JPanel label = new JPanel();
	private RestaurantProcessing res = new Restaurant();
	private Restaurant res1 = new Restaurant();
	private ChefGraphicalUserInterface c = new ChefGraphicalUserInterface();
	
	JTable tabl = new JTable();
	JScrollPane sp = new JScrollPane();
	
	private JButton createOrder = new JButton("new order");
	private JButton viewOrder = new JButton("view order");
	private JButton bill = new JButton("compute bill");
	private JButton select = new JButton("select menu");
	private JButton rem = new JButton("remove menu");
	
	private JLabel table1 = new JLabel("masa:");
	private JLabel date = new JLabel("data:");
	private JLabel idOrder = new JLabel("id order:");
	private JLabel selP = new JLabel("select prod:");
	
	private JTextField tab = new JTextField();
	private JTextField dat = new JTextField();
	private JTextField idOrd = new JTextField();
	private JTextField selectM = new JTextField();
	
	@SuppressWarnings("rawtypes")
	public static TableModel toTableModel(Map map) {
	     DefaultTableModel model = new DefaultTableModel (
	    		   new Object[] { "Key", "Value" }, 0
	    		  );
	    		  for (Iterator it = map.entrySet().iterator(); it.hasNext();) {
	    		   Map.Entry entry = (Map.Entry)it.next();
	    		   model.addRow(new Object[] { entry.getKey(), entry.getValue() });
	    		  }
	    		  return model;
	}
	
	public WaiterGraphicalUserInterface() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(730,500);
		frame.setLocation(416, 0);
		label.setLayout(null);
		
		createOrder.setBounds(10, 10, 130, 20);
		viewOrder.setBounds(10, 40, 130, 20);
		bill.setBounds(10, 70, 130, 20);
		select.setBounds(10, 100, 130, 20);
		rem.setBounds(10, 130, 130, 20);
	
		table1.setBounds(150, 10, 90, 20);
		date.setBounds(150, 40, 90, 20);
		idOrder.setBounds(150, 70, 90, 20);
		selP.setBounds(150, 100, 90, 20);
		
		tab.setBounds(250, 10, 140, 20);
		dat.setBounds(250, 40, 140, 20);
		idOrd.setBounds(250, 70, 140, 20);
		selectM.setBounds(250, 100, 140, 20);
		
		createOrder.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				res1.addObserver(c);
				int id = Integer.parseInt(idOrd.getText());
				int masa = Integer.parseInt(tab.getText());
				Order ord = new Order(id,dat.getText(),masa);
				res1.createOrder(ord, Restaurant.getMeniuSel());
				
			}
			
		});
		
		select.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(selectM.getText());
				res1.selectMenu(id);
			}
			
		});
		
		rem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(selectM.getText());
				res1.deletMenu(id);
			}
			
		});
		
		viewOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				
				
				HashMap<Order, List<MenuItem>> comanda = Restaurant.getComanda();
				tabl = new JTable(toTableModel(comanda));
				label.remove(sp);
				sp=new JScrollPane(tabl);
				sp.setBounds(10, 170, 620, 280);
				label.add(sp);
			}
			
		});
		
		bill.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(idOrd.getText());
				res.generateBill(id);

			}
			
		});
		
		label.add(createOrder);
		label.add(viewOrder);
		label.add(bill);
		label.add(select);
		label.add(rem);
		
		label.add(table1);
		label.add(date);
		label.add(idOrder);
		label.add(selP);
		
		label.add(tab);
		label.add(dat);
		label.add(idOrd);
		label.add(selectM);
		
		sp=new JScrollPane(tabl);
		sp.setBounds(10, 170, 620, 280);
		label.add(sp);
		
		frame.setContentPane(label);
		frame.setVisible(true);
	}
}
