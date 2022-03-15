package models;

public class Monomial implements Comparable{
    private float coefficient;
    private int pow;

    public Monomial() {
        this.coefficient = 0;
        this.pow = 0;
    }

    public Monomial(float coefficient, int pow) {
        this.coefficient = coefficient;
        this.pow = pow;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public int getPow() {
        return pow;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public void setPow(int pow) {
        this.pow = pow;
    }

    @Override
    public String toString() {
        String leftString, rightString;
        if(coefficient == 1){
            leftString = "";
        }
        else{
            if(coefficient == -1){
                leftString = "-";
            }
            else {
                if ((int) coefficient == coefficient * 100 / 100) {
                    leftString = String.format("%.0f", coefficient);
                } else {
                    leftString = String.format("%.2f", coefficient);
                }
            }
        }
        if(pow >= 2){
            rightString = "x^" + pow;
        }
        else {
            if(pow == 1){
                rightString = "x";
            }
            else{
                rightString = "";
                if(coefficient == 1){
                    leftString = "1";
                }
                if(coefficient == -1){
                    leftString = "-1";
                }
            }
        }
        return leftString + rightString;
    }

    @Override
    public int compareTo(Object monomial) {
        return ((Monomial)monomial).getPow() - this.pow;
    }
}
