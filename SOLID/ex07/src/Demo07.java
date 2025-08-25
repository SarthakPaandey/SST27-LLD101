public class Demo07 {
    public static void main(String[] args) {
        Printer p = new BasicPrinter();
        p.print("Hello");

        MultiFunctionMachine mfp = new MultiFunctionMachine();
        mfp.print("Report");
        mfp.scan("/tmp/out");
        mfp.fax("123-456");
    }
}
