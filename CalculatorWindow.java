/**********************************************************************
*   Program:                  Mortgage Payment Calculator (SR-MF-003)
*   Purpose:                  Week 3 Individual Assignment
*   Programmer:           	  Charlie Pittman
*   Class:                    PRG/421
*   Instructor:               Vince Anderson
*   Creation Date:            March 2, 2012
*********************************************************************
*   Programmer         Modification Date    Modification Purpose
*   -----------------  ------------------   --------------------------
*  Charlie Pittman	   2/26/12              Week 2 Assignment (Change4)
*  Charlie Pittman	   3/2/12			    Week 3 Assignment (Change5)
* 											- APR and Years from menu
* 											- Values in an array
**********************************************************************
*  Program Summary:
*  Program calculates and displays what the monthly payment
*  is for a mortgage based on the amount, APR, and 
*  term of the mortgage, as entered/selected by the user.
**********************************************************************/

import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

public class CalculatorWindow extends javax.swing.JFrame {
	//Creates the calculator window
    public CalculatorWindow() {
    
    //create a bunch of fields, buttons, labels. 
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

		//what happens when the user clicks close? Yep, it closes.  
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		//Name the Window
        setTitle("Mortgage Payment Calculator");
        //Labeling for Fields and Buttons
        jLabel1.setText("Mortgage Amount");
        //field 4 is for output, so it isn't editable
        jFormattedTextField4.setEditable(false);
        jFormattedTextField4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
       
        jLabel4.setText("Monthly Payment");

		 //Calculate button and listener.
        jButton1.setText("Calculate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
	
		 //Reset button and listener.
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

		//A button group
        buttonGroup1.add(jRadioButton1);
        //Create tRadio Buttons & TXT, add to Button Group
        jRadioButton1.setText("7 Years at at 5.35%");
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("15 years at 5.5%");
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("30 years at 5.75%");
        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Custom terms:");
                   
		jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));
        
        jScrollPane1.setViewportView(jTable1);
        
        jLabel2.setText("years at");

        jLabel3.setText("%");

   //Laying out everything in the window.  Productivity hint 18.1 "Use a GUI builder."    
                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(jLabel3)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();

    }
   

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // On click of calculate button, the monthly payment is calculated
        // and output to the monthly payment text box
        // Element 3 will be used for "custom terms"
		
        double apr [] = new double[4];
		int years [] = new int[4];
		apr[0] = .0535;  
		apr[1] = .055;   
		apr[2] = .0575;
		apr[3] = 0  ;
		years[0] = 7;	
		years[1] = 15;	
		years[2] = 30;	
		years[3] = 0;
        int loan = 0;
		//Get string from the field, convert to double and store
        Double mortgageAmt = Double.parseDouble(jTextField1.getText());
              
        //Set variables based on the radio button selected      
        if (jRadioButton1.isSelected()) {
            loan = 0;
            }
        else if (jRadioButton2.isSelected()) {
            loan = 1;
            }
        else if (jRadioButton3.isSelected()) {
            loan = 2; 
            }
        else if (jRadioButton4.isSelected()) {
            loan = 3; 
            years[loan] = Integer.parseInt(jTextField2.getText());
            apr[loan] = Double.parseDouble(jTextField3.getText());
			apr[loan] = apr[loan]/100;
            }
                     
        Double monthlyinterest = apr[loan] / 12;
        int months = years[loan] * 12;
        double pmt;
        
        //Calculate payment
        pmt = mortgageAmt * ((apr[loan] / 12) / (1 - Math.pow(1 + (apr[loan] / 12), -(months))));

		//convert the answer to a string, and put it in field 4 in
        //decimal format dollars and cents
        DecimalFormat money = new DecimalFormat("$0.00");
         String strpmt = Double.toString(pmt);
        jFormattedTextField4.setText(money.format(pmt));
		
		//Create a table with just the headers
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Month", "Interest", "Principal", "Balance"
            }
        ));
        
        int currentmonth=1;  				  //used as counter and for first record in each row
		double currentprincipal = 0; 		  //the amount of the payment that goes towards the balance
		double currentintrest=0;  			  //the amount of the payment that is interest
			 
		// for loop that runs once for each month of the loan using 
		// current month as the counter and incrementing at the end of each loop
		for(currentmonth = 1 ; currentmonth <= months; currentmonth++)
			{ 
			currentintrest = mortgageAmt * monthlyinterest ;   //determine how much of the payment is interest
			currentprincipal = pmt - currentintrest;        //determine how much of the payment is principal
			mortgageAmt = mortgageAmt - currentprincipal;       //determine what the new loan balance is.

			DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
			//add rows to the table
			model.addRow(new Object[]{(currentmonth), money.format(currentintrest), money.format(currentprincipal), money.format(mortgageAmt)});
		}
	}
    
	// Reset the Fields & Buttons when reset is pressed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        //System.out.println("Reset Form");
        jTextField1.setText("");
        jFormattedTextField4.setText("");
        //jTextArea1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        buttonGroup1.clearSelection();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
           new Object [][] {
                },
            new String [] {
                }
        ));
    }

    public static void main(String args[]) {  
     
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CalculatorWindow().setVisible(true);
            }
        });
    }

    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    
}
