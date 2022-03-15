package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial{
    private ArrayList<Monomial> list;

    public Polynomial() {
        this.list = new ArrayList<>();
    }

    public Polynomial(String string){
        this.list = new ArrayList<>();

        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == '-'){
                string = string.substring(0,i) + '+' + string.substring(i);
                i++;
            }
        }
        if(string.charAt(0) != '+'){
            string = "+" + string;
        }
        Pattern pattern1 = Pattern.compile("[+]([^+]+)"); //get each polynomial
        Matcher matcher1 = pattern1.matcher(string);

        while(matcher1.find()) {
            Pattern pattern2 = Pattern.compile("(.*?)[x][ ^](.+)"); // monomial with ^
            Matcher matcher2 = pattern2.matcher(matcher1.group(1));
            if(matcher2.find()){
                if(matcher2.group(1).equals("")){// coefficient 1
                    this.setList(new Monomial(1, Integer.parseInt(matcher2.group(2))));
                }
                else{
                    if(matcher2.group(1).equals("-")){// coefficient -1
                        this.setList(new Monomial(-1, Integer.parseInt(matcher2.group(2))));
                    }
                    else{
                        this.setList(new Monomial(Float.parseFloat(matcher2.group(1)), Integer.parseInt(matcher2.group(2))));
                    }
                }
            }
            else{
                Pattern pattern3 = Pattern.compile("(.*?)[x]"); // monomial pow 1
                Matcher matcher3 = pattern3.matcher(matcher1.group(1));
                if(matcher3.find()){
                    if(matcher3.group(1).equals("")){//coefficient 1
                        this.setList(new Monomial(1, 1));
                    }
                    else {
                        if(matcher3.group(1).equals("-")){//coefficient -1
                            this.setList(new Monomial(-1, 1));
                        }
                        else {
                            this.setList(new Monomial(Float.parseFloat(matcher3.group(1)), 1));
                        }
                    }
                }
                else{//polynomial pow 0
                    this.setList(new Monomial(Float.parseFloat(matcher1.group(1)), 0));
                }
            }
        }
    }

    public void sortPoly(){
       Collections.sort(this.list);
    }

    public ArrayList<Monomial> getList() {
        return list;
    }

    public void setList(Monomial monomial) {
        Monomial addMonomial = new Monomial(monomial.getCoefficient(), monomial.getPow());
        this.list.add(addMonomial);
    }

    public void deleteIndexList(int Index) {
        this.list.remove(Index);
    }

    @Override
    public String toString() {
        String result = new String();
        for(Monomial monomial : list){
            if(monomial.getCoefficient() > 0){
                result += "+";
            }
            result += monomial.toString();
        }
        if(result.charAt(0) == '+')
            return result.substring(1);
        else return result;
    }
}
