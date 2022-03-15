package models;

public class Result {
    private Polynomial quotient, remainder;

    public Result(Polynomial quotient, Polynomial remainder) {
        this.quotient = quotient;
        this.remainder = remainder;
    }

    public Polynomial getQuotient() {
        return quotient;
    }

    public Polynomial getRemainder() {
        return remainder;
    }
}
