package controller;

import model.Borrower;
import model.Living;
import model.Money;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IoSpending  {
    Scanner scanner = new Scanner(System.in);
    static ArrayList<Money>arrayList0 = new ArrayList<>();
    static ArrayList<Living> arrayList = new ArrayList<>();
    static ArrayList<Borrower> arrayList1 = new ArrayList<>();
//    public static void setArrayList(ArrayList<Living>list){
//        IoSpending.arrayList= list;
//    }

    public void addMoney(){
        Money money = new Money();
        while (true)
        try {
            System.out.println("Total money");
            double addMoney = Double.parseDouble(scanner.nextLine());
            money.setMoney(addMoney);
            break;
        }catch (NumberFormatException e){
            System.out.println("Enter the amount");
        }
        arrayList0.add(money);

    }
    public void editMoney (){
            boolean checkMoney = false;
//          int size = arrayList0.size();
//          for (int i = 0; i < size; i++) {
//
//          }
            System.out.println("Enter edit money");
            double money = Double.parseDouble(scanner.nextLine());
            checkMoney=true;
            arrayList0.get(1).setMoney(money);



    }
    public void showMoney(){
        for (Money money:arrayList0) {
            if (money instanceof Money){
                System.out.println(money.toString());
            }
        }
    }


    public void addSpending() {
        double totalMoney =0;
        Living living = new Living();
//        while (true)
//        try {
//            System.out.println("Total money");
//            double money = Double.parseDouble(scanner.nextLine());
//            living.setTotalMoney(money);
//            break;
//        }catch (NumberFormatException e){
//            System.out.println("Enter the amount");
//        }
        boolean check0 = false;
        do {
            System.out.println("Day speant money: dd/MM/yyyy");
            String day = scanner.nextLine();
            String regex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)" +
                    "(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)" +
                    "(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)" +
                    "(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(day);
            if (matcher.find()) {
                living.setDay(day);
                check0 = true;
            } else {
                System.out.println("Please enter");
            }

        } while (!check0);

        boolean check3 = false;
        do {
            System.out.print("Enter spend: ");
            String spend = scanner.nextLine();
            String regex = "[a-zA-Z]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(spend);
            if (matcher.find()) {
                living.setSpending(spend);
                check3 = true;
            } else {
                System.out.println("Please enter");
            }
        } while (!check3);


        while (true)
        try {
            System.out.println("Enter the amount spen");
            double price = Double.parseDouble(scanner.nextLine());
            if (totalMoney==price){
                totalMoney+=price;
                System.out.println("tổng tiền là: "+ totalMoney);
            }
            living.setPrice(price);
            break;
        }catch (NumberFormatException e){
            System.out.println("Please enter");
        }
        arrayList.add(living);
        IoFile.writeItem("spendfile.txt",living);


    }


    public void addBorrower() throws IOException {
        Borrower borrower = new Borrower();
        boolean check3 = false;
        do {
            System.out.print("Enter name the borrowers: ");
            String name = scanner.nextLine();
            String regex = "[a-zA-Z]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                borrower.setName(name);
                check3 = true;
            } else {
                System.out.println("Please enter");
            }
        } while (!check3);

        while (true){
            try {

                System.out.println("Enter age the borrowers: ");
                int age = Integer.parseInt(scanner.nextLine());
                    if (age<=0 || age>100){
                        System.out.println("Age no less than 0 and greater than 100");
                        continue;
                    }
                borrower.setAge(age);
                break;
            }catch (NumberFormatException e){
                System.out.println("Please enter");
            }
        }
        while (true)
        try {
            System.out.println("Enter number phone of the borrower: ");
            int phone = Integer.parseInt(scanner.nextLine());
            borrower.setPhone(phone);
            break;
        }catch (NumberFormatException e){
            System.out.println("Please enter");
        }

        boolean check7 = false;
        do {
            System.out.println("Enter the email of the borrower");
            String email = (scanner.nextLine());
            String regex = "^[a-zA-Z0-9][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (matcher.find()) {
                borrower.setEmail(email);
                check7 = true;
            } else {
                System.out.println("Please enter");
            }
        } while (!check7);
        while (true)
        try {
            System.out.println("Enter loan");
            double loan = Double.parseDouble(scanner.nextLine());
            borrower.setLoan(loan);
            break;
        }catch (NumberFormatException e){
            System.out.println("Please enter");
        }

        boolean check9 = false;
        do {
            System.out.println("Enter loan date: dd/MM/yyyy");
            String loanDay = scanner.nextLine();
            String regex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)" +
                    "(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)" +
                    "(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)" +
                    "(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(loanDay);
            if (matcher.find()) {
                borrower.setLoanDay(loanDay);
                check9 = true;
            } else {
                System.out.println("Please enter");
            }
        } while (!check9);

        boolean check10 = true;
        do {
            System.out.println("Enter pay date: dd/MM/yyyy");
            String payDay = scanner.nextLine();
            String regex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)" +
                    "(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)" +
                    "(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)" +
                    "(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(payDay);
            if (matcher.find()) {
                borrower.setPayDay(payDay);
                check10 = true;
            } else {
                System.out.println("Please enter");
            }
        } while (!check10);

        arrayList1.add(borrower);
        IoFile.writeBorrower("borrowerfile.txt",borrower);

    }

    public void showLiving() {
        for (Living living : arrayList) {
            if (living instanceof Living) {
                System.out.println(living.toString());
                System.out.println(living.getTotalMoney());


            }
        }
    }

    public void showBorrower() {
        for (Borrower borrower : arrayList1) {
            if (borrower instanceof Borrower) {
                System.out.println(borrower.toString());
            }

        }
    }

    public void deleteItem() {
        System.out.println("Delete spending: ");
        String item = scanner.nextLine();
        Living living = null;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (item.equals(arrayList.get(i).getSpending())) {
                living = arrayList.get(i);
            }
        }
        if (living != null) {
            System.out.println(" Speand is deleted:  " + living.getSpending());
            arrayList.remove(living);
        } else {
            System.out.println(" Spending dose not exist ");
        }
    }
    public void deleteLoan(){
        System.out.println("Delete borrower: ");
        String name = scanner.nextLine();
        Borrower borrower = null;
        int size1 = arrayList1.size();
        for (int i = 0; i < size1; i++) {
            if (name.equals(arrayList1.get(i).getName())) {
                borrower = arrayList1.get(i);
            }
        }
        if (borrower != null) {
            System.out.println("The borrower is deleted : " + borrower.getName());
            arrayList1.remove(borrower);
        } else {
            System.out.println("The borrower dose not exist ");
        }

    }
    public void editItem(){
        System.out.println("Enter edit spending ");
        String item = scanner.nextLine();
        boolean check = false;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (item.equals(arrayList.get(i).getSpending())){
//                System.out.println("Enter USD");
//                double editUSD = Double.parseDouble(scanner.nextLine());

                boolean check0 = false;
                do {
                    System.out.println("Enter day");
                    String editDay= scanner.nextLine();
                    String regex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)" +
                            "(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)" +
                            "(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)" +
                            "(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(editDay);
                    if (matcher.find()) {
                        arrayList.get(i).setDay(editDay);
                        check0 = true;
                    } else {
                        System.out.println("Please enter");
                    }

                } while (!check0);

                boolean check3 = false;
                do {
                    System.out.println("Enter item");
                    String editItem= scanner.nextLine();
                    String regex = "[a-zA-Z]";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(editItem);
                    if (matcher.find()) {
                        arrayList.get(i).setSpending(editItem);
                        check3 = true;
                    } else {
                        System.out.println("Please enter");
                    }
                } while (!check3);


                while (true)
                try {
                    System.out.println("Enter price ");
                    double editPrice =Double.parseDouble(scanner.nextLine());
                    check=true;
                    arrayList.get(i).setPrice(editPrice);
                    break;
                }catch (NumberFormatException e){
                    System.out.println("please enter");

                }
            }

        }if (!check){
            System.out.println("No spending. ");
        }

    }
    public void editBorrower(){
        System.out.println("Enter the name of the edit");
        String name = scanner.nextLine();
        boolean check = false;
        int size = arrayList1.size();
        for (int i = 0; i < size; i++) {
            if (name.equals(arrayList1.get(i).getName())){

                boolean check3 = false;
                do {
                    System.out.println("Enter Name");
                    String editName = (scanner.nextLine());
                    String regex = "[a-zA-Z]";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(editName);
                    if (matcher.find()) {
                        arrayList1.get(i).setName(editName);
                        check3 = true;
                    } else {
                        System.out.println("Please enter");
                    }
                } while (!check3);


                while (true){
                    try {

                        System.out.println("Enter Age");
                        int editAge= Integer.parseInt(scanner.nextLine());
                        if (editAge<=0 || editAge>100){
                            System.out.println("Age no less than 0 and greater than 100");
                            continue;
                        }
                        arrayList1.get(i).setAge(editAge);
                        break;
                    }catch (NumberFormatException e){
                        System.out.println("Please enter");
                    }
                }
                while (true)
                    try {
                        System.out.println("Enter Phone");
                        int editPhone= Integer.parseInt(scanner.nextLine());
                        arrayList1.get(i).setAge(editPhone);
                        break;
                    }catch (NumberFormatException e){
                        System.out.println("Please enter");
                    }

                boolean check7 = false;
                do {
                    System.out.println("Enter Email ");
                    String editEmail =(scanner.nextLine());
                    String regex = "^[a-zA-Z0-9][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(editEmail);
                    if (matcher.find()) {
                        arrayList1.get(i).setEmail(editEmail);
                        check7 = true;
                    } else {
                        System.out.println("Please enter");
                    }
                } while (!check7);

                while (true)
                    try {
                        System.out.println("Enter Loan");
                        double editLoan =Double.parseDouble(scanner.nextLine());
                        arrayList1.get(i).setLoan(editLoan);
                        break;
                    }catch (NumberFormatException e){
                        System.out.println("Please enter");
                    }

                boolean check9 = false;
                do {
                    System.out.println("Enter LoanDay");
                    String editLoanDay = scanner.nextLine();
                    String regex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)" +
                            "(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)" +
                            "(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)" +
                            "(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(editLoanDay);
                    if (matcher.find()) {
                        arrayList1.get(i).setLoanDay(editLoanDay);
                        check9 = true;
                    } else {
                        System.out.println("Please enter");
                    }
                } while (!check9);

                boolean check10 = true;
                do {
                    System.out.println("Enter PayDay");
                    String editPayDay = scanner.nextLine();
                    String regex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)" +
                            "(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)" +
                            "(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)" +
                            "(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(editPayDay);
                    if (matcher.find()) {
                        arrayList1.get(i).setPayDay(editPayDay);
                        check10 = true;
                    } else {
                        System.out.println("Please enter");
                    }
                } while (!check10);

            }
        }if (!check){
            System.out.println("No borrower name. ");
        }

    }
    public void searchItem(){
        boolean check =false;
        System.out.println("Enter seach the spending: ");
        String item = scanner.nextLine();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (item.equals(arrayList.get(i).getSpending())){
                System.out.println("The speanding search is : "+ arrayList.get(i));
            }
            break;
        }
        if (!check){
            System.out.println("No the speanding");
        }


    }public void searchBorrower(){
        boolean check =false;
        System.out.println("Enter the borrower search: ");
        String name = scanner.nextLine();
        int size = arrayList1.size();
        for (int i = 0; i < size; i++) {
            if (name.equals(arrayList1.get(i).getName())){
                System.out.println("The borrower is: "+ arrayList1.get(i));
            }
            break;
        }
        if (!check){
            System.out.println("No borrower name");
        }
    }
}
