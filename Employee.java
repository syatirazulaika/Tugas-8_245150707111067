package PraktikumDelapan;

import java.text.NumberFormat;
import java.util.Locale;

public class Employee implements Payable {
    private int registrationNumber;
    private String name;
    private int salaryPerMonth;
    private Invoice[] invoices;

    public Employee(int registrationNumber, String name, int salaryPerMonth, Invoice[] invoices) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = invoices;
    }

    @Override
    public double getPayableAmount() {
        double totalBelanja = 0;
        for (Invoice invoice : invoices) {
            totalBelanja += invoice.getPayableAmount();
        }
        return salaryPerMonth - totalBelanja;
    }

    public void displayInfo() {
        NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        System.out.println("==== DATA KARYAWAN ====");
        System.out.println("NIP         : " + registrationNumber);
        System.out.println("Nama        : " + name);
        System.out.println("Gaji Bulan  : " + currency.format(salaryPerMonth));

        System.out.println("\n==== DETAIL BELANJA ====");
        System.out.printf("%-20s %-10s %-15s %-15s%n", "Produk", "Qty", "Harga/Item", "Total");
        System.out.println("-------------------------------------------------------------");
        for (Invoice invoice : invoices) {
            System.out.printf("%-20s %-10d %-15s %-15s%n",
                invoice.getProductName(),
                invoice.getQuantity(),
                currency.format(invoice.getPricePerItem()),
                currency.format(invoice.getPayableAmount()));
        }

        System.out.println("-------------------------------------------------------------");
        System.out.println("Sisa Gaji Setelah Belanja : " + currency.format(getPayableAmount()));
    }
}
