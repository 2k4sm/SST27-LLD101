public class Demo07 {
    public static void main(String[] args) {
        // Using segregated interfaces
        Printer printer = new BasicPrinter();
        printer.print("Hello");

        Scanner scanner = new BasicScanner();
        scanner.scan("/tmp/out");

        FaxMachine fax = new BasicFax();
        fax.fax("123-456-7890");

        // Multi-function machine
        MultiFunctionMachine mfm = new MultiFunctionMachine();
        mfm.print("Document");
        mfm.scan("/tmp/scan");
        mfm.fax("987-654-3210");
    }
}
