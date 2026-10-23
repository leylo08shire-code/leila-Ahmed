
abstract class Account {
    private String accountNumber;
    protected double balance;

    // Constructor-ka Account
    Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    abstract void withdraw(double amount);

    void deposit(double amount) {
        if (amount <= 0) refuse("deposit must be more than 0");
        else balance += amount;
    }

    void refuse(String why) {
        System.out.println("" + accountNumber + " refused: " + why);
    }

    void show() {
        System.out.println("" + accountNumber + " balance: " + balance);
    }
}


class Savings extends Account {
    Savings(String n, double b) { super(n, b); }

    @Override
    void withdraw(double amount) {
        if (balance - amount < 50) refuse("must keep at least 50");
        else balance -= amount;
    }
}

class Current extends Account {
    Current(String n, double b) { super(n, b); }

    @Override
    void withdraw(double amount) {
        if (balance - amount < -200) refuse("overdraft limit is 200");
        else balance -= amount;
    }
}

class StudentAmount extends Account {
    StudentAmount(String n, double b) {
        super(n, b);
    }

    @Override
    void withdraw(double amount) {
        if (amount > 100) {
            refuse("max 100 per withdrawal");
        } else if (amount > balance) {
            refuse("not enough money");
        } else {
            balance -= amount;
        }
    }
}


 class AccountDemo {
    public static void main(String[] args) {

        Account acc1 = new Savings("SAV-1", 200);
        Account acc2 = new Current("CUR-1", 200);
        Account acc3 = new StudentAmount("STU-1", 200);

        acc1.deposit(50); acc1.withdraw(300); acc1.show();
        acc2.deposit(50); acc2.withdraw(300); acc2.show();
        acc3.deposit(50); acc3.withdraw(300); acc3.show();
    }
}