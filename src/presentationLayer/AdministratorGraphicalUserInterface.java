package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import businessLayer.BaseProduct;
import businessLayer.CompositeProduct;
import businessLayer.MenuItem;
import businessLayer.Restaurant;
import businessLayer.RestaurantProcessing;
import dataLayer.RestaurantSerializator;

public class AdministratorGraphicalUserInterface {

	JFrame frame = new JFrame();
	JPanel label = new JPanel();
	RestaurantProcessing res = new Restaurant();
	
	public String col[] = {"name", "price", "id"};
	
	JButton addMenu = new JButton("addCompProd");
	JButton addMenu1 = new JButton("addBaseProd");
	JButton editMenu = new JButton("editMenuItem");
	JButton deleteMenu = new JButton("deleteMenuItem");
	JButton viewMenu = new JButton("viewMenu");
	private JButton select = new JButton("select comp");
	private JButton rem = new JButton("remove comp");
	
	JTable table = new JTable();
	JScrollPane sp = new JScrollPane();
	
	JLabel numeProdus = new JLabel("nume produs:");
	JLabel pretProdus = new JLabel("pret produs:");
	JLabel idProdus = new JLabel("id produs:");
	
	JTextField numeProd = new JTextField();
	JTextField pretProd = new JTextField();
	JTextField idProd = new JTextField();
	

	public AdministratorGraphicalUserInterface() {
		Restaurant res = new Restaurant();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(430,500);
		label.setLayout(null);
		
		addMenu.setBounds(10, 10, 130, 20);
		editMenu.setBounds(10, 40, 130, 20);
		deleteMenu.setBounds(10, 70, 130, 20);
		viewMenu.setBounds(10, 100, 130, 20);
		addMenu1.setBounds(10, 130, 130, 20);
		
		numeProdus.setBounds(150, 10, 90, 20);
		pretProdus.setBounds(150, 40, 90, 20);
		idProdus.setBounds(150, 70, 90, 20);
		select.setBounds(150, 100, 130, 20);
		
		numeProd.setBounds(250, 10, 140, 20);
		pretProd.setBounds(250, 40, 140, 20);
		idProd.setBounds(250, 70, 140, 20);
		rem.setBounds(150, 130, 130, 20);
		
		select.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(idProd.getText());
				Restaurant.selectComp(id);
			}
			
		});
		
		addMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(idProd.getText());
				int pret = Integer.parseInt(pretProd.getText());
				CompositeProduct produs = new CompositeProduct(numeProd.getText(),pret,id);
				produs.setProduct((ArrayList<MenuItem>) Restaurant.getCompSel());
				pretProd.setText(produs.computePrice() + "");
				res.addMenuItem(produs);
			}
			
		});
		
		addMenu1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(idProd.getText());
				int pret = Integer.parseInt(pretProd.getText());
				MenuItem produs = new BaseProduct(numeProd.getText(),pret,id);
				
				res.addMenuItem(produs);
			}
			
		});
		
		editMenu.addActionListener(new ActionListener( ) {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(idProd.getText());
				int pret = Integer.parseInt(pretProd.getText());
				res.editMenuItem(id, numeProd.getText(), pret);
				
			}
			
		});
		
		deleteMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(idProd.getText());
				res.deleteMenuItem(id);
			}
			
		});
		
		rem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = Integer.parseInt(idProd.getText());
				Restaurant.deletComp(id);
			}
			
		});
		
		viewMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel tableModel = new DefaultTableModel(col, 0);
				table = new JTable(tableModel);
				ArrayList<MenuItem> men = (ArrayList<MenuItem>) RestaurantSerializator.getMen();
				for(MenuItem l: men)
				{
					Object [] ob = {l.getName(),l.getPrice(),l.getId()};
					tableModel.addRow(ob);
				}
				label.remove(sp);
				sp=new JScrollPane(table);
				sp.setBounds(10, 170, 320, 280);
				label.add(sp);
				
			}
			
		});
		
		label.add(addMenu);
		label.add(addMenu1);
		label.add(editMenu);
		label.add(deleteMenu);
		label.add(viewMenu);
		label.add(select);
		label.add(rem);
		
		label.add(numeProdus);
		label.add(pretProdus);
		label.add(idProdus);
		
		label.add(numeProd);
		label.add(pretProd);
		label.add(idProd);
		
		sp=new JScrollPane(table);
		sp.setBounds(10, 170, 320, 280);
		label.add(sp);
		
		frame.setContentPane(label);
		frame.setVisible(true);
	}
	
}
