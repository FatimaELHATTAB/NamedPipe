

public class FilterA extends SimpleFilter<Integer, String> {

	public FilterA(Pipe input, Pipe output) {
		super(input, output);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String transformOne(Integer in) {
		// TODO Auto-generated method stub
		Gui gui = new Gui(this) ;
		return null;
	}

	

}
