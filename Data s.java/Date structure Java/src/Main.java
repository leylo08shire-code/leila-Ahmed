class BankAccount {
    private String accountNumber;
    protected double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Basic rule: you cannot take out more than you have
    void withdraw(double amount) {
        if (amount > balance) refuse("not enough money");
        else balance -= amount;
    }

    void refuse(String why) {
        System.out.println(" " + accountNumber + " refused: " + why);
    }

    void show() {
        System.out.println(" " + accountNumber + " balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    SavingsAccount(String n, double b) { super(n, b); }

    @Override
    void withdraw(double amount) {                 // must keep at least 50
        if (balance - amount < 50) refuse("must keep at least 50");
        else balance -= amount;
    }
}

class CurrentAccount extends BankAccount {
    CurrentAccount(String n, double b) { super(n, b); }

    @Override
    void withdraw(double amount) {                 // may go down to -200
        if (balance - amount < -200) refuse("overdraft limit is 200");
        else balance -= amount;
    }
}

class StudentAccount extends BankAccount {
    StudentAccount(String n, double b) { super(n, b); }

    @Override
    void withdraw(double amount) {                 // max 100 at a time
        if (amount > 100) refuse("max 100 per withdrawal");
        else super.withdraw(amount);               // reuse the parent's rule
    }
}

 class WithdrawOverrideDemo {
    public static void main(String[] args) {
        SavingsAccount s = new SavingsAccount("SAV-1", 200);
        CurrentAccount c = new CurrentAccount("CUR-1", 200);
        StudentAccount t = new StudentAccount("STU-1", 200);

        System.out.println("Each account has 200. Each runs withdraw(300):");
        s.withdraw(300); s.show();
        c.withdraw(300); c.show();
        t.withdraw(300); t.show();

        System.out.println("Student tries withdraw(80):");
        t.withdraw(80);  t.show();
    }
}
