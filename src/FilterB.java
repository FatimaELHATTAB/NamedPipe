import java.util.LinkedList;
import java.util.Queue;

public class FilterB extends Filter{

	
	static boolean trace = false ; 
	Pipe inputT ; 
	public FilterB(Pipe input, Pipe output) {
		super(input, output);
		//inputT = input2 ;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void transformBetween(Pipe input, Pipe output) {
		// TODO Auto-generated method stub
		while(true) {
		String operation = null; 
		Queue  equ = new LinkedList<String>() ;
		if((operation = get()) != null) {
		
		System.out.printf("operation"+ operation);
		int resultat = 0; 
		if(operation != null) {
		switch(operation) {
		case "+": 
			put("op");
			
			String nb1 = get() ; 
			String nb2 = get() ; 
			put(operation) ; 
			put(nb1) ; 
			put(nb2) ; 
			
			resultat = somme(Integer.parseInt(nb1),Integer.parseInt(nb2)) ; 
			break ; 
		case "x":
			put("op");
			String nb3 = get() ; 
			String nb4 = get() ; 
			put(operation) ; 
			put(nb3) ; 
			put(nb4) ; 
			resultat = produit(Integer.parseInt(nb3),Integer.parseInt(nb4)) ; 
			break; 
		case "!": 
			put("op");
			String nb5 = get() ; 
			resultat = factoriel(Integer.parseInt(nb5)) ;
			put(operation) ; 
			put(nb5) ;  
			break; 
		case "trace":
			System.out.println("traceeeeeeeeeeeee");
			put("afficher") ; 
			
		}
		String result = Integer.toString(resultat);
		put(result) ;
		Gui.setRESULTAT(result);
		}
		}}
	}
	private int somme(int A,int B) {
		System.out.print(""+(A+B));
		return A+B ; 
	}
	
	private int produit(int A,int B) {
		System.out.print(""+(A*B));
		return A*B ; 
	}
	
	private int factoriel(int A) {
		 	int f = 1;
	        for (int i=1; i<=A; i++)
	        f=f*i;
	        return(f);
	}
	}
