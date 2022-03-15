package controllers;

import models.Operation;
import models.Polynomial;
import models.Result;
import views.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private MainView mainView;

    public MainController(MainView mainView){
        this.mainView = mainView;

        this.mainView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial firstPolynomial = new Polynomial(mainView.getFirstTextField());
                Polynomial secondPolynomial = new Polynomial(mainView.getSecondTextField());
                Polynomial result = Operation.addPoly(firstPolynomial,secondPolynomial);
                mainView.setResultTextField(result.toString());
            }
        });

        this.mainView.getSubtractButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial firstPolynomial = new Polynomial(mainView.getFirstTextField());
                Polynomial secondPolynomial = new Polynomial(mainView.getSecondTextField());
                Polynomial result = Operation.subtractPoly(firstPolynomial,secondPolynomial);
                mainView.setResultTextField(result.toString());
            }
        });

        this.mainView.getMultiplicateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial firstPolynomial = new Polynomial(mainView.getFirstTextField());
                Polynomial secondPolynomial = new Polynomial(mainView.getSecondTextField());
                Polynomial result = Operation.multiplicatePoly(firstPolynomial,secondPolynomial);
                mainView.setResultTextField(result.toString());
            }
        });

        this.mainView.getDivideButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial firstPolynomial = new Polynomial(mainView.getFirstTextField());
                Polynomial secondPolynomial = new Polynomial(mainView.getSecondTextField());
                try{
                    Result result = Operation.dividePoly(firstPolynomial,secondPolynomial);
                    mainView.setResultTextField(result.getQuotient().toString());
                    mainView.setRemainderTextField(result.getRemainder().toString());
                }
                catch (Exception ex){
                    if(ex.getMessage().equals("Impartire cu zero")){
                        mainView.showMessage("Division by 0");
                    }
                }
            }
        });

        this.mainView.getDerivateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial firstPolynomial = new Polynomial(mainView.getFirstTextField());
                Polynomial result = Operation.derivatePoly(firstPolynomial);
                mainView.setResultTextField(result.toString());
            }
        });

        this.mainView.getIntegrateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polynomial firstPolynomial = new Polynomial(mainView.getFirstTextField());
                Polynomial result = Operation.integratePoly(firstPolynomial);
                mainView.setResultTextField(result.toString());
            }
        });
    }
}
