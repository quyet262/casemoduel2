package case_study_module2;

import java.io.IOException;
import java.util.Scanner;

public class App implements Constants{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            ProductManager.menu();
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case ADDPRODUCT:
                   ProductManager.addProduct();
                    break;
                case SHOWPRODUCT:
                    ProductManager.showProducts();
                    break;
                case EDITPRODUCT:
                    ProductManager.editProduct();
                    break;
                case DELETEPRODUCT:
                    ProductManager.deleteProduct();
                    break;
                case SEACHPRODUCT:
                    ProductManager.searchProduct();
                    break;
                case SORTPRODUCT:
                    ProductManager.sortProducts();
                    break;
                case EXIT:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
