package models;

public class Operation {
    public static Polynomial addPoly(Polynomial polynomial1, Polynomial polynomial2){
        int index1 = 0, index2 = 0;
        polynomial1.sortPoly(); polynomial2.sortPoly();
        Polynomial result = new Polynomial();
        while(index1 < polynomial1.getList().size() && index2 < polynomial2.getList().size()) {
            Monomial monomial1 = polynomial1.getList().get(index1);
            Monomial monomial2 = polynomial2.getList().get(index2);
            if(monomial1.getPow() > monomial2.getPow()){
                result.setList(monomial1);
                index1++;
            }
            else if (monomial1.getPow() == monomial2.getPow()){
                if(monomial1.getCoefficient()+monomial2.getCoefficient() != 0){
                    result.setList(new Monomial(monomial1.getCoefficient()+monomial2.getCoefficient(),
                            monomial1.getPow()));
                }
                index1++;index2++;
            }
            else{
                result.setList(monomial2);
                index2++;
            }
        }
        while(index1 < polynomial1.getList().size()) {
            result.setList(polynomial1.getList().get(index1++));
        }
        while(index2 < polynomial2.getList().size()) {
            result.setList(polynomial2.getList().get(index2++));
        }
        if(result.getList().size() == 0){
            result.setList(new Monomial (0,0));
        }
        return result;
    }

    public static Polynomial subtractPoly(Polynomial polynomial1, Polynomial polynomial2){
        int index1 = 0, index2 = 0;
        polynomial1.sortPoly(); polynomial2.sortPoly();
        Polynomial result = new Polynomial();
        while(index1 < polynomial1.getList().size() && index2 < polynomial2.getList().size()) {
            Monomial monomial1 = polynomial1.getList().get(index1);
            Monomial monomial2 = polynomial2.getList().get(index2);
            if(monomial1.getPow() > monomial2.getPow()){
                result.setList(monomial1);
                index1++;
            }
            else if (monomial1.getPow() == monomial2.getPow()){
                if(monomial1.getCoefficient()-monomial2.getCoefficient() != 0){
                    result.setList(new Monomial(monomial1.getCoefficient()-monomial2.getCoefficient(),
                                        monomial1.getPow()));
                }
                index1++;index2++;
            }
            else{
                result.setList(new Monomial(-monomial2.getCoefficient(), monomial2.getPow()));
                index2++;
            }
        }
        while(index1 < polynomial1.getList().size()) {
            result.setList(polynomial1.getList().get(index1++));
        }
        while(index2 < polynomial2.getList().size()) {
            result.setList(new Monomial(-polynomial2.getList().get(index2).getCoefficient(),
                                polynomial2.getList().get(index2++).getPow()));
        }
        if(result.getList().size() == 0){
            result.setList(new Monomial (0,0));
        }
        return result;
    }

    public static Polynomial multiplicatePoly(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial result = new Polynomial();
        polynomial1.sortPoly();
        polynomial2.sortPoly();
        for(Monomial monomial1 : polynomial1.getList()){
            for(Monomial monomial2 : polynomial2.getList()){
                result.setList(new Monomial(monomial1.getCoefficient() * monomial2.getCoefficient(),
                        monomial1.getPow() + monomial2.getPow()));
            }
        }
        result.sortPoly();
        for(int i = 0; i < result.getList().size() - 1; i++) {
            if(result.getList().get(i).getPow() == result.getList().get(i + 1).getPow()){
                result.getList().get(i).setCoefficient(result.getList().get(i).getCoefficient()
                        + result.getList().get(i + 1).getCoefficient());
                result.deleteIndexList(i+1);
            }
        }
        if(result.getList().size() == 0){
            result.setList(new Monomial (0,0));
        }
        return result;
    }

    public static Result dividePoly(Polynomial polynomial1, Polynomial polynomial2) throws Exception{
        Polynomial quotient = new Polynomial();
        polynomial1.sortPoly();
        polynomial2.sortPoly();
        if(polynomial2.toString().equals("0")){
            throw new Exception("Impartire cu zero");
        }
        Monomial monomialQuotient = new Monomial();
        Polynomial tempPolynomial = new Polynomial();
        while(polynomial1.getList().get(0).getPow() >= polynomial2.getList().get(0).getPow()){
            monomialQuotient.setCoefficient(polynomial1.getList().get(0).getCoefficient()
                                                / polynomial2.getList().get(0).getCoefficient());
            monomialQuotient.setPow(polynomial1.getList().get(0).getPow() - polynomial2.getList().get(0).getPow());
            quotient.setList(monomialQuotient);
            tempPolynomial.getList().removeAll(tempPolynomial.getList());
            tempPolynomial.setList(monomialQuotient);
            tempPolynomial = multiplicatePoly(polynomial2,tempPolynomial);
            polynomial1 = subtractPoly(polynomial1, tempPolynomial);
        }
        if(quotient.getList().size() == 0){
            quotient.setList(new Monomial (0,0));
        }
        if(polynomial1.getList().size() == 0){
            polynomial1.setList(new Monomial (0,0));
        }
        return new Result(quotient, polynomial1);
    }

    public static Polynomial derivatePoly(Polynomial polynomial){
        Polynomial result = new Polynomial();
        polynomial.sortPoly();
        for(Monomial monomial : polynomial.getList()){
            if(monomial.getPow() != 0){
                result.setList(new Monomial(monomial.getCoefficient() * monomial.getPow(),
                        monomial.getPow()-1));
            }
        }
        if(result.getList().size() == 0){
            result.setList(new Monomial (0,0));
        }
        return result;
    }

    public static Polynomial integratePoly(Polynomial polynomial){
        Polynomial result = new Polynomial();
        polynomial.sortPoly();
        for(Monomial monomial : polynomial.getList()){
            result.setList(new Monomial(monomial.getCoefficient()/(monomial.getPow() +1) ,
                    monomial.getPow() +1));
        }
        if(result.getList().size() == 0){
            result.setList(new Monomial (0,0));
        }
        return result;
    }
}
