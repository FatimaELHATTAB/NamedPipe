

public abstract class Filter<I, O> extends ThreadedRunner {
	protected Pipe<I> input;
	protected Pipe<O> output;

	public Filter(Pipe<I> input, Pipe<O> output) {
		this.input = input;
		this.output = output;
	}

	@Override
	public void run() {
		transformBetween(input, output);
	}
	public void put(String string) {
		// TODO Auto-generated method stub
		output.put((O)string) ;
	}
	
	public String get() {
		// TODO Auto-generated method stub
		try {
			return (String)input.nextOrNullIfEmptied() ;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		} 
	}
	protected abstract void transformBetween(Pipe<I> input, Pipe<O> output);
}
