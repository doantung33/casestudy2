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
                System.out.println("3. Show spending");
                System.out.println("4. Show borrowers");
                System.out.println("5. Edit spending");
                System.out.println("6. Edit borrowers");
                System.out.println("7. Delete speanding");
                System.out.println("8. Delete borrowers");
                System.out.println("9. Seach spending");
                System.out.println("10.Seach borrowers");
                System.out.println("0. Exit");
                n = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                continue;
            }
            switch (n){
                case 1:
                    ioSpending.addSpending();
                    break;
                case 2:
                    ioSpending.addBorrower();
                    break;
                case 3:
                    ioSpending.showLiving();
                    break;
                case 4:
                    ioSpending.showBorrower();
                    break;
                case 5:
                    ioSpending.editItem();
                    break;
                case 6:
                    ioSpending.editBorrower();
                    break;
                case 7:
                    ioSpending.deleteItem();
                    break;
                case 8:
                    ioSpending.deleteLoan();
                    break;
                case 9:
                    ioSpending.searchItem();
                    break;
                case 10:
                    ioSpending.searchBorrower();
                case 11:
                    ioSpending.addMoney();
                    break;
                case 12:
                    ioSpending.editMoney();
                    break;
                case 13:
                    ioSpending.showMoney();
                    break;
//                case 11:
//                    IoFile.dataLiving();
//                    break;
                case 0:
                    exit= true;
                    break;

            }
        }while (!exit);


    }
}
