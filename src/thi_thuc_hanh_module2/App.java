package thi_thuc_hanh_module2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartPhoneManager smartPhoneManager = new SmartPhoneManager();
        while (true) {
            smartPhoneManager.menu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case Constants.ADDSMARTPHONE:
                    smartPhoneManager.addSmartPhone();
                    break;
                case Constants.DELETESMARTPHONE:
                    smartPhoneManager.deleteSmartPhone();
                case Constants.CHECKLISTSMARTPHONE:
                    smartPhoneManager.showSmartPhone();
                    break;
                case Constants.SEARCHSMARTPHONE:
                    smartPhoneManager.searchSmartPhone();
                case Constants.EXIT:
                    System.out.println("Thoát chương trình: ");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

}
