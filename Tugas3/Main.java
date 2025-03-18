package Tugas3;

class BankAccount {
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getter untuk mengambil nama pemilik akun
    public String getAccountHolder() {
        return accountHolder;
    }

    // Getter untuk mengambil saldo
    public double getBalance() {
        return balance;
    }

    // Method untuk menambahkan saldo (Deposit)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method Overloading: Withdraw tanpa fee
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: " + balance);
        }
    }

    // Method Overloading: Withdraw dengan fee
    public void withdraw(double amount, double fee) {
        double totalAmount = amount + fee;
        if (totalAmount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= totalAmount;
            System.out.println("Withdrawal successful! New balance: " + balance);
        }
    }
}

// Class Main untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        // Membuat akun dengan nama dan saldo awal yang sudah ditentukan
        BankAccount account = new BankAccount("Aqim", 1000);

        // Menampilkan informasi akun
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Initial Balance: " + account.getBalance());

        // Melakukan deposit sebesar 500
        account.deposit(500);

        // Melakukan withdraw sebesar 300 tanpa fee
        account.withdraw(300);

        // Melakukan withdraw sebesar 300 dengan fee 50
        account.withdraw(300, 50);
    }
}
