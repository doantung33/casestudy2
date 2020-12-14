package view;

import controller.IoFile;
import controller.IoSpending;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        IoSpending ioSpending = new IoSpending();
//        IoSpending.setArrayList(IoFile.dataLiving());
        boolean exit= false;
        int n = 0;
        do {
            try {
                System.out.println("Menu");
                System.out.println("1. Spending");
                System.out.println("2. Borrower");
                System.out.println("0. Exit");
                n = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                continue;
            }
            switch (n){
                case 1:
                    boolean check = false;
                    do {
                        try {
                            System.out.println("mơi bạn chọn");
                            System.out.println("1. Add spending");
                            System.out.println("2. Show spending");
                            System.out.println("3. Edit spending");
                            System.out.println("4. Delete speanding");
                            System.out.println("5. Seach spending");
                            System.out.println("0. Menu");
                            n=Integer.parseInt(scanner.nextLine());
                        }catch (NumberFormatException e){
                            System.out.println("Invalid input");
                            continue;
                        }
                        switch (n){
                            case 1:
                                ioSpending.addSpending();
                                break;
                            case 2:
                                ioSpending.showLiving();
                                break;
                            case 3:
                                ioSpending.editItem();
                                break;
                            case 4:
                                ioSpending.deleteItem();
                                break;
                            case 5:
                                ioSpending.searchItem();
                                break;
                            case 0:
                                check= true;
                                continue;

                        }
                    }while (!check);
                case 2:
                    boolean check0=false;
                    do {
                        try {
                            System.out.println("chon đi");
                            System.out.println("1. Add borrower");
                            System.out.println("2. Show borrowers");
                            System.out.println("3. Edit spending");
                            System.out.println("4. Delete borrowers");
                            System.out.println("5. Seach borrowers");
                            System.out.println("0. Menu");
                            n= Integer.parseInt(scanner.nextLine());
                        }catch (NumberFormatException e){
                            System.out.println("Invalid input");
                            continue;
                        }
                        switch (n){
                            case 1:
                                ioSpending.addBorrower();
                                break;
                            case 2:
                                ioSpending.showBorrower();
                                break;
                            case 3:
                                ioSpending.editBorrower();
                                break;
                            case 4:
                                ioSpending.deleteLoan();
                                break;
                            case 5:
                                ioSpending.searchBorrower();
                                break;
                            case 0:
                                check0=true;
                                break;
                        }
                    }while (!check0);

//                case 11:
//                    ioSpending.addMoney();
//                    break;
//                case 12:
//                    ioSpending.editMoney();
//                    break;
//                case 13:
//                    ioSpending.showMoney();
//                    break;
//                case 14:
//                    IoFile.dataLiving();
//                    break;
                case 0:
                    exit= true;
                    break;

            }
        }while (!exit);


    }
}
