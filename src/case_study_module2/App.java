package case_study_module2;

import java.io.IOException;
import java.util.Scanner;

public class App implements Constants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManager productManager = new ProductManager();

        while (true) {

                productManager.menu();
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case ADDPRODUCT:
                        productManager.addProduct();
                        break;
                    case SHOWPRODUCT:
                        productManager.showProducts();
                        break;
                    case EDITPRODUCT:
                        productManager.editProduct();
                        break;
                    case DELETEPRODUCT:
                        productManager.deleteProduct();
                        break;
                    case SEACHPRODUCT:
                        productManager.searchProduct();
                        break;
                    case SORTPRODUCT:
                        productManager.sortProducts();
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
