import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilterC extends Filter {

	
	public FilterC(Pipe input, Pipe output) {
		super(input, output);
		// TODO Auto-generated constructor stub
	}
	public void sauvegarder(String nomFichier) {
		FileOutputStream fos = null ; 
		try {
			fos = new FileOutputStream(new File(nomFichier)) ;
			char op = get().charAt(0) ; 
			fos.write((byte)op) ; 
			fos.write(Integer.parseInt(get())) ;
			if(op != '!') {
			fos.write((byte)',') ;
			fos.write(Integer.parseInt(get())) ;
			}
			fos.write((byte)'=') ;
			fos.write(Integer.parseInt(get())) ;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
            if (fos != null)
               fos.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
	}
	public void restaurer(String nomFichier) {
		FileInputStream fis = null ; 
		String operation = null ; 
		try {
			fis = new FileInputStream(new File(nomFichier)) ;
			int content;
			while ((content = fis.read()) != -1) {
				// convert to char and display it
				//read operation 
				char op = (char) content ; 
				if (op != '!') {
					int op1 = (int)fis.read() ; 
					fis.read();
					int op2= (int)fis.read(); 
					fis.read() ; 
					int rsl = (int)fis.read(); 
					operation =  String.valueOf(op1) + String.valueOf(op) + String.valueOf(op2) + " = " + String.valueOf(rsl) ; 
					
				}else {
					int op1 = (int)fis.read() ; 
					
					fis.read() ; 
					int rsl = (int)fis.read(); 
					operation =  String.valueOf(op1) + String.valueOf(op)  + " = " + String.valueOf(rsl) ;
					
				}
				System.out.println(operation);
				Gui.setTRACE(operation) ;
				put(operation) ;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
            if (fis != null)
               fis.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
		
	}
	@Override
	protected void transformBetween(Pipe input, Pipe output) {
		// TODO Auto-generated method stub
		String salut = this.get(); 
		System.out.println("saluut"+salut);
		if(salut=="afficher") {
			System.out.println("affffffiiicheerrr");
			restaurer("TP1.txt") ; 
		}else {
			sauvegarder("TP1.txt") ;
		}
	}
}
