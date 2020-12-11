package model;

import java.io.Serializable;

public class Borrower implements Serializable {
    private String name;
    private int age ;
    private int phone;
    private String email;
    private double loan;
    private String loanDay;
    private String payDay;
//    private Living living;

    public Borrower() {

    }

    public Borrower(String name, int age, int phone, String email, double loan, String loanDay, String payDay) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.loan = loan;
        this.loanDay = loanDay;
        this.payDay = payDay;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public void setLoanDay(String loanDay){
        this.loanDay=loanDay;
    }
    public String getLoanDay(){
        return loanDay;
    }
    public void setPayDay(String payDay){
        this.payDay=payDay;
    }
    public String getPayDay() {
        return payDay;
    }



    @Override
    public String toString() {
        return "Borrower [ " +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", loan='" + loan + " USD"+'\'' +
                ", loanDay='" + loanDay + '\'' +
                ", payDay='" + payDay + '\'' +
                " ]";
    }
}
