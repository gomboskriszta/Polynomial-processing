package view;
import javax.swing.*;    
import model.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * 
 * @author Gombos Kriszta
 * This class implements the GUI of the application.
 * Here are the text fileds, buttons and the window set.
 *
 */

public class View extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textBox1, textBox2,textBox3,textBox4;
	private JPanel p1,p2,p3,p4,p5,p6,p7,pi,p8;
	private JLabel l1,l3,l5,l6,li;
	private JButton close,reset,btnAdaugare1,btnAdaugare2,btnAdunare,btnScadere,btnInmultire,btnImpartire,btnDerivare,btnIntegrare;
	private ArrayList<Monom> polinom1,polinom2;
	private String text;
	private Polynom polinomRezultat;
	
	
	public View()
	{
			   
		super("Procesarea polinoamelor");
		
		//Indications
		
		li = new JLabel("Introduce the polynomials in the form: a1x^n+a2x^(n-1)+....+a(n-1)x^1+an");
		pi=new JPanel();
		pi.add(li);
		
		//The first polynomial
		l1 = new JLabel("Polynomial 1");
		textBox1 = new JTextField(null,50);
		textBox1.setMaximumSize( new Dimension(500,20) );
		p1 = new JPanel();
		btnAdaugare1 = new JButton("Apply");
		
		
		p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));
		p1.add(Box.createHorizontalStrut(20));
		p1.add(l1);
		p1.add(Box.createHorizontalStrut(20));
		p1.add(textBox1);
		p1.add(Box.createHorizontalStrut(20));
		p1.add(btnAdaugare1);
		p1.add(Box.createHorizontalStrut(20));
		
		
		//Set the button for derivation and integration
		p2 = new JPanel();
		Dimension d = new Dimension(60,30);
		Dimension d2 = new Dimension(100,30);
		
		btnDerivare = new JButton("Derivate");
	    btnIntegrare = new JButton("Integrate");
	    btnDerivare.setMaximumSize(d2);
		btnIntegrare.setMaximumSize(d2);
		
		p2.add(btnDerivare);
		p2.add(Box.createHorizontalStrut(20));
		p2.add(btnIntegrare);
		p2.add(Box.createHorizontalStrut(20));
		
		
		//The second polynomial
		l3 = new JLabel("Polynomial 2");
		textBox2 = new JTextField();
		textBox2.setMaximumSize( new Dimension(500,20) );
		p3 = new JPanel();
		btnAdaugare2 = new JButton("Apply");
		
		
		p3.setLayout(new BoxLayout(p3,BoxLayout.X_AXIS));
		p3.add(Box.createHorizontalStrut(20));
		p3.add(l3);
		p3.add(Box.createHorizontalStrut(20));
		p3.add(textBox2);
		p3.add(Box.createHorizontalStrut(20));
		p3.add(btnAdaugare2);
		p3.add(Box.createHorizontalStrut(20));

		
		//Add the buttons +,-,*,/
		p4 = new JPanel();
		p4.setLayout(new BoxLayout(p4,BoxLayout.X_AXIS));
		
		//buttons
		btnAdunare = new JButton("+");
		btnScadere = new JButton("-");
		btnInmultire = new JButton("*");
		btnImpartire = new JButton("/");
       	
		btnAdunare.setMaximumSize(d);
		btnScadere.setMaximumSize(d);
		btnInmultire.setMaximumSize(d);
		btnImpartire.setMaximumSize(d);
		
        
        p4.add(btnAdunare);
		p4.add(Box.createHorizontalStrut(20));
		p4.add(btnScadere);
		p4.add(Box.createHorizontalStrut(20));
		p4.add(btnInmultire);
		p4.add(Box.createHorizontalStrut(20));
		p4.add(btnImpartire);
		p4.add(Box.createHorizontalStrut(20));
		
        
		
		//Add text filed for result and set the result
		
				l5 = new JLabel("Result: ");
				textBox3 = new JTextField();
				textBox3.setMaximumSize( new Dimension(300,20) );
				textBox3.setEditable(false);
				p5 = new JPanel();
				p5.setLayout(new BoxLayout(p5,BoxLayout.X_AXIS));
				p5.add(l5);
				p5.add(Box.createHorizontalStrut(20));
				p5.add(textBox3);
				p5.add(Box.createHorizontalStrut(50));
				
				
				//Do the same for rest
				l6 = new JLabel("Rest (for division): ");
				textBox4 = new JTextField();
				textBox4.setMaximumSize(new Dimension(100,20));
				textBox4.setEditable(false);
				p6 = new JPanel();
				p6.setLayout(new BoxLayout(p6,BoxLayout.X_AXIS));
				p6.add(l6);
				p6.add(Box.createHorizontalStrut(10));
				p6.add(textBox4);
				p6.add(Box.createHorizontalStrut(10));
				
				//reset and close
				reset = new JButton("Reset");
				reset.addActionListener(
						new ActionListener()
						{ 
							public void actionPerformed(ActionEvent e){
								
								textBox1.setText("");
								textBox2.setText("");
								textBox3.setText("");
								
								polinom1.clear();
								polinom2.clear();
							}
							
				
						});
				close = new JButton("Close");
				close.addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e){System.exit(1);}});
				p7 = new JPanel();
				p7.setLayout(new BoxLayout(p7,BoxLayout.X_AXIS));
				p7.add(reset);
				p7.add(Box.createHorizontalStrut(20));
				p7.add(close);
				
				p8 = new JPanel();
				
				p8.setLayout(new BoxLayout(p8,BoxLayout.Y_AXIS));
				p8.add(Box.createVerticalStrut(30));
				p8.add(pi);
				p8.add(p1);
				p8.add(p2);
				p8.add(p3);
				p8.add(p4);
				p8.add(p5);
				p8.add(p6);
				p8.add(p7);
				p8.add(Box.createVerticalStrut(20));
				pi.add(Box.createVerticalStrut(0));
				p1.setBackground(Color.pink.brighter());
				p2.setBackground(Color.pink.brighter());
				p3.setBackground(Color.pink.brighter());
				p4.setBackground(Color.pink.brighter());
				p5.setBackground(Color.pink.brighter());
				p6.setBackground(Color.pink.brighter());
				p7.setBackground(Color.pink.brighter());
				pi.setBackground(Color.pink.brighter());
				p8.setBackground(Color.pink.brighter());
				
				l1.setForeground(Color.black);
				l3.setForeground(Color.black);
				l5.setForeground(Color.black);
				l6.setForeground(Color.black);
				li.setForeground(Color.black);
				
				this.add(p8);		
	
			
		polinom1 = new ArrayList<Monom>();
		polinom2 = new ArrayList<Monom>();
		
		
		///action listeners for the buttons in the case of the first polynomial
	
		btnAdaugare1.addActionListener(new ActionListener(){
		  
			
			public void actionPerformed(ActionEvent e) {
			
	            text = textBox1.getText();
	            int[] vectorCoef = new int[30];
	            int[] vectorGrad = new int[30];
	            int dim1=0,dim2=0;
	            if(text.length()<3)
	            {
	            	String[] tokens = text.split(" ");
	            	int x = Integer.parseInt(tokens[0]);
	            	polinom1.add(new MonomInt(x,0));
	            }
	            
	            else
	            {
	            //extract coefficients
	            
			    String[] partsCoef = text.split("x\\^\\d+\\+?");
			    for (String part1 : partsCoef) {
			    	int x = Integer.parseInt(part1);
			         vectorCoef[dim1++]=x;
			        
			    }
			   
			    
			    //extract the powers
			    
			    int y;
			    String[] partsGrad = text.split("(-|\\+)");
			    for (String term : partsGrad) {
				    String[] parts = term.split("\\^");
				    if(parts.length > 1)
				    {
				    	//System.out.println(parts[1]);
				         y = Integer.parseInt(parts[1]);
				        // System.out.println(y);
				         vectorGrad[dim2++] = y;
				    }
				    
				    else
				    {
				    	
				    	vectorGrad[dim2++] = 0;
				    }
				    
				    
				}
			    if(vectorGrad[0]==0){
			    	for(int j=0;j<dim2-1;j++)
			    	{
					System.out.println(vectorCoef[j]+" "+vectorGrad[j+1]);
					polinom1.add(new MonomInt(vectorCoef[j],vectorGrad[j+1]));
					}
			    }
				if(vectorGrad[0]!=0)
					{
					for(int j=0;j<dim2;j++)
			    	{
						System.out.println(vectorCoef[j]+" "+vectorGrad[j]);
						polinom1.add(new MonomInt(vectorCoef[j],vectorGrad[j]));
					}
				}
	            }
	            
				System.out.println(polinom1);
				
			}
	    	    	    
		});

		
		
		//action listener for the button for the second polynomial
		
		btnAdaugare2.addActionListener(new ActionListener(){
		  
			
			public void actionPerformed(ActionEvent e) {
			
	            text = textBox2.getText();
	            int[] vectorCoef2 = new int[30];
	            int[] vectorGrad2 = new int[30];
	            int dim1=0,dim2=0;
	            
	            if(text.length()<3)
	            {
	            	String[] tokens = text.split(" ");
	            	int x = Integer.parseInt(tokens[0]);
	            	polinom2.add(new MonomInt(x,0));
	            }
	            
	            else
	            {
	            
	            
	            //extract coefficients
	            
			    String[] partsCoef = text.split("x\\^\\d+\\+?");
			    for (String part1 : partsCoef) {
			    	int x = Integer.parseInt(part1);
			         vectorCoef2[dim1++]=x;
			        
			    }
			   
			    
			    //extract powers
			    
			    int y;
			    String[] partsGrad = text.split("(-|\\+)");
			    for (String term : partsGrad) {
				    String[] parts = term.split("\\^");
				    if(parts.length > 1)
				    {
				    	//System.out.println(parts[1]);
				         y = Integer.parseInt(parts[1]);
				        // System.out.println(y);
				         vectorGrad2[dim2++] = y;
				    }
				    
				    else
				    {
				    	
				    	vectorGrad2[dim2++] = 0;
				    }
				    
				    
				}
			    if(vectorGrad2[0]==0){
			    	for(int j=0;j<dim2-1;j++)
			    	{
					System.out.println(vectorCoef2[j]+" "+vectorGrad2[j+1]);
					polinom2.add(new MonomInt(vectorCoef2[j],vectorGrad2[j+1]));
					}
			    }
				if(vectorGrad2[0]!=0)
					{
					for(int j=0;j<dim2;j++)
			    	{
						System.out.println(vectorCoef2[j]+" "+vectorGrad2[j]);
						polinom2.add(new MonomInt(vectorCoef2[j],vectorGrad2[j]));
					}
				}
	            }
				
				System.out.println(polinom2);	
			}	    	    
		});
		
		
		
		//add button
		
		
		btnAdunare.addActionListener(new ActionListener(){
		  
			
			public void actionPerformed(ActionEvent e) {
			
	          
	            
				polinomRezultat = new Polynom(polinom1); 
				Polynom p2 = new Polynom(polinom2);
				//System.out.println(polinomRezultat.adunare(polinom1, polinom2));	
				textBox3.setText(polinomRezultat.add(p2).toString());
			}	    	    
		});
		
		
		//subtract button
		
		btnScadere.addActionListener(new ActionListener(){
		  
			
			public void actionPerformed(ActionEvent e) {
			
	          
	            
				polinomRezultat = new Polynom(polinom1); 
				 Polynom p2 = new Polynom(polinom2);
				//System.out.println(polinomRezultat.adunare(polinom1, polinom2));	
				textBox3.setText(polinomRezultat.subtract(p2).toString());
			}	    	    
		});
		
		//multiply button
		
		btnInmultire.addActionListener(new ActionListener(){
		  
			
			public void actionPerformed(ActionEvent e) {
			
	          
	            
				polinomRezultat = new Polynom(polinom1); 
				  Polynom p2 = new Polynom(polinom2);
				//System.out.println(polinomRezultat.adunare(polinom1, polinom2));	
				textBox3.setText(polinomRezultat.multiply(p2).toString());
			}	    	    
		});
		
		
		//division button
		
			btnImpartire.addActionListener(new ActionListener(){
		  
			
			public void actionPerformed(ActionEvent e) {
			
	          
	            
				polinomRezultat = new Polynom(polinom1); 
				  Polynom p2 = new Polynom(polinom2);
				//System.out.println(polinomRezultat.adunare(polinom1, polinom2));	
				textBox3.setText(polinomRezultat.divide(p2).get(0).toString());
				textBox4.setText(polinomRezultat.divide(p2).get(1).toString());
			}	    	    
		});
		
		//derivate button
		
		btnDerivare.addActionListener(new ActionListener(){
		  
			
			public void actionPerformed(ActionEvent e) {
			
	          
	            
				polinomRezultat = new Polynom(polinom1); 
				  
				//System.out.println(polinomRezultat.adunare(polinom1, polinom2));	
				textBox3.setText(polinomRezultat.derivate().toString());
			}	    	    
		});
		
		//integrate button
		
		btnIntegrare.addActionListener(new ActionListener(){
		  
			
			public void actionPerformed(ActionEvent e) {
			
	          
	            
				polinomRezultat = new Polynom(polinom1); 
				  
				//System.out.println(polinomRezultat.adunare(polinom1, polinom2));	
				textBox3.setText(polinomRezultat.integrate().toString());
			}	    	    
		});
		
	}		
}
	


