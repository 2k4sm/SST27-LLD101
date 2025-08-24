public class BasicFax implements FaxMachine {
    @Override
    public void fax(String number) {
        System.out.println("Faxing to number: " + number);
    }
}
