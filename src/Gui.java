

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton SOMME = new JButton("SOMME");
	private JButton PRODUIT = new JButton("PRODUIT");
	private JButton FACTORIEL = new JButton("FACTORIEL");
	private JButton QUITTER = new JButton("QUITTER");
	private JButton TRACE = new JButton("TRACE");
	private JFormattedTextField NOMBRE1= new JFormattedTextField(NumberFormat.getIntegerInstance());
	private JFormattedTextField NOMBRE2 = new JFormattedTextField(NumberFormat.getIntegerInstance());
	private static JLabel RESULTAT = new JLabel("...");
	private static JLabel TRACERT = new JLabel("...");
	FilterA filtre  = null ; 
	public Gui(FilterA filtreA){
		filtre = filtreA ;
	    this.setTitle("TP1 ELHATTAB FATIMA");
	    this.setSize(400, 500);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //JPanel pan = new JPanel();
	    //premiere partie
	    JPanel pan = new JPanel();
	    
	    JLabel label1 = new JLabel("Nombre 1");
	    JLabel label2 = new JLabel("Nombre 2");
	    NOMBRE1.setPreferredSize(new Dimension(80,30));
	    NOMBRE2.setPreferredSize(new Dimension(80,30));
	    pan.add(label1) ; 
	    pan.add(NOMBRE1) ; 
	    pan.add(label2) ; 
	    pan.add(NOMBRE2) ; 
	    // premieres 
	    JPanel pan2 = new JPanel();
	    pan2.add(new JLabel("LES FORMES ET LES VUES")) ;
	    //les boutons
	    JPanel pan3 = new JPanel();
	    pan3.add(SOMME);
	    pan3.add(PRODUIT) ; 
	    pan3.add(FACTORIEL);
	    JPanel pan4 = new JPanel();
	    pan4.add(RESULTAT) ;
	    JPanel pan44 = new JPanel();
	    pan44.add(new JLabel("RESULTATS")) ; 
	    JPanel pan5 = new JPanel();
	    pan5.add(QUITTER) ; 
	    pan5.add(TRACE) ; 
	    JPanel pan6 = new JPanel();
	    pan6.add(TRACERT) ;
	    this.setLayout(new GridLayout(7,1));
	    this.getContentPane().add(pan2) ;
	    this.getContentPane().add(pan);
	    this.getContentPane().add(pan3);
	    this.getContentPane().add(pan44);
	    this.getContentPane().add(pan4);
	    this.getContentPane().add(pan5);
	    this.getContentPane().add(pan6);
	    //On prévient notre JFrame que notre JPanel sera son content pane
	    //this.setContentPane(pan);  
	    this.setVisible(true);
	    
	    
	    //traitement 
	  //Nous ajoutons notre fenêtre à la liste des auditeurs de notre bouton
	    SOMME.addActionListener(this);
	    PRODUIT.addActionListener((ActionListener) this);
	    FACTORIEL.addActionListener((ActionListener) this);
	    QUITTER.addActionListener((ActionListener) this);
	    TRACE.addActionListener((ActionListener) this);
	        //SOMME.addActionListener(this);
	  }
		
		public void actionPerformed(ActionEvent arg0) {
		  if(arg0.getSource() == SOMME) {
		    System.out.println("Vous avez cliqué sur le bouton +");
		    if(NOMBRE1.getValue() != null && NOMBRE2.getValue() != null) {
		    filtre.put("+");
		    filtre.put(String.valueOf(NOMBRE1.getValue()));
		    filtre.put(String.valueOf(NOMBRE2.getValue()));
		    System.out.println(String.valueOf(NOMBRE1.getValue()));
		    }
		  } 
		  if(arg0.getSource() == PRODUIT) {
		    System.out.println("Vous avez cliqué sur le bouton x");
		    if(NOMBRE1.getValue() != null && NOMBRE2.getValue() != null) {
		    filtre.put("x");
		    filtre.put(String.valueOf(NOMBRE1.getValue()));
		    filtre.put(String.valueOf(NOMBRE2.getValue()));
		    System.out.println("Vous avez cliqué sur le bouton +");
		    }
		  }
		  if(arg0.getSource() == FACTORIEL) {
			    System.out.println("Vous avez cliqué sur le bouton x");
			    if(NOMBRE1.getValue() != null ) {
			    filtre.put("!");
			    filtre.put(String.valueOf(NOMBRE1.getValue()));
			    System.out.println("Vous avez cliqué sur le bouton +");
			    }
			  }
		  if(arg0.getSource() == TRACE) {
			    filtre.put("trace") ;
		  }	
		  if(arg0.getSource() == QUITTER) {
			    this.dispose();
		  }	
		}

		public static void setRESULTAT(String res) {
			RESULTAT.setText(res);
		}
		
		public static void setTRACE(String res) {
			TRACERT.setText(res);
		}
		
		
		
}
