


public class ExampleRunner {
    public static void main(String[] args) {
        // create pipes
        final Pipe<Integer> genToFilter = new PipeImpl<Integer>();
        final Pipe<String> filterToOut = new PipeImpl<String>();
        final Pipe<String> filterToOut2 = new PipeImpl<String>();
        final Pipe<String> filterToOut3 = new PipeImpl<String>();

        // create components that use the pipes
        final Generator<Integer> generator = new ExampleGenerator(genToFilter);
        final Filter<Integer, String> filter = new FilterA(genToFilter, filterToOut);
        final Filter<Integer, String> filterB = new FilterB(filterToOut,filterToOut2);
        final Filter<Integer, String> filterC = new FilterC(filterToOut2, filterToOut3);
        final Sink<String> sink = new ExampleSink(filterToOut3);

        // start all components
        generator.start();
        filter.start();
        filterB.start();
        filterC.start();
        sink.start();

        System.out.println("runner finished");
    }
}
