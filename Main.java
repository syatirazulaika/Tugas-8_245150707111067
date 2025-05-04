package PraktikumDelapan;

public class Main {
    public static void main(String[] args) {
        Invoice[] invoices = new Invoice[] {
            new Invoice("Beras", 2, 50000),
            new Invoice("Minyak Goreng", 1, 30000),
            new Invoice("Sabun", 3, 10000)
        };

        Employee emp = new Employee(101, "Syatira Zulaikanisa", 1000000, invoices);

        emp.displayInfo();
    }
}

