interface Bank {
    double getInterestRate();
}

class SBI implements Bank {
    @Override
    public double getInterestRate() {
        return 6.5;
    }
}

class HDFC implements Bank {
    @Override
    public double getInterestRate() {
        return 7.0;
    }
}

public class BankInterest {
    public static void main(String[] args) {
        Bank sbi = new SBI();
        Bank hdfc = new HDFC();

        System.out.println("SBI Interest Rate: " + sbi.getInterestRate() + "%");
        System.out.println("HDFC Interest Rate: " + hdfc.getInterestRate() + "%");
    }
}