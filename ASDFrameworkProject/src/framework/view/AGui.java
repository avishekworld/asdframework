package framework.view;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import framework.component.FinanceHandler;




public abstract class AGui  extends JFrame
{

    protected JTable JTable1;
    private JScrollPane JScrollPane1;
    AGui myframe;
    
    final int BUTTON_WIDTH=160;
    final int BUTTON_HEIGHT=30;
    final int V_GAP=20;
    final int H_GAP=10;
    
    JPanel creationButtonPanel;
    JPanel tablePanel;
    JPanel operationButtonPanel;
    FinanceHandler controller;
    
	public AGui(String title,FinanceHandler controller)
	{
		this.controller=controller;
		myframe=this;
		setTitle(title);
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		
		Container pane=getContentPane();
		pane.setLayout(new BorderLayout(V_GAP, H_GAP));
		
		creationButtonPanel = new JPanel();
		creationButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		tablePanel = new JPanel();
		operationButtonPanel = new JPanel();
		operationButtonPanel.setLayout(new BoxLayout(operationButtonPanel,BoxLayout.Y_AXIS));
		
		pane.add(BorderLayout.PAGE_START, creationButtonPanel);
		pane.add(BorderLayout.LINE_START, tablePanel);
		pane.add(BorderLayout.LINE_END, operationButtonPanel);
		
		setSize(700,550);

		loadViews();
		
		setVisible(true);
		
		
	}
	public final void loadViews()
	{
		
		generateCreationButtons();
		createTable();
		generateOperationButtons();
		
	}
	
	public abstract void modelUpdated();
	
	public void createTable()
	{
		  	JScrollPane1 = new JScrollPane();
		  	DefaultTableModel model = getTableModel();
		  	JTable1 = new JTable(model);
	        tablePanel.add(JScrollPane1);
	        JScrollPane1.setBounds(12,92,300,160);
	        JScrollPane1.getViewport().add(JTable1);
	        JTable1.setBounds(0, 0, 300, 0);
	        
	        getTableData();
	}
	
	/*JButton b1=new JButton("Creation Button");
	b1.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
	b1.setActionListener(new MyActionlIstener());
	creationButtonPanel.add(b1);*/
	public abstract void generateCreationButtons();
	
	/*JButton bo1=new JButton("Operation Button");
	bo1.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
	bo1.setActionListener(new MyActionlIstener());
	operationButtonPanel.add(bo1);
	operationButtonPanel.add(Box.createVerticalStrut(V_GAP));*/
	public abstract void generateOperationButtons();
	
	public abstract DefaultTableModel getTableModel();
	
	public abstract void getTableData();
	public FinanceHandler getController() {
		return controller;
	}
	

	




}
