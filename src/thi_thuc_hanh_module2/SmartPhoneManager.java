package thi_thuc_hanh_module2;

import case_study_module2.util.ReadAndWriteFile;
import thi_thuc_hanh_module2.model.GenuineSmartPhone;
import thi_thuc_hanh_module2.model.HandedSmartPhone;
import thi_thuc_hanh_module2.model.SmartPhone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SmartPhoneManager {
    public static Scanner scanner = new Scanner(System.in);

    public void menu() {
        System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI-----");
        System.out.println("1. Thêm mới");
        System.out.println("2. Xoá");
        System.out.println("3. Xem danh sách điện thoại");
        System.out.println("4. Tìm kiếm");
        System.out.println("5. Thoát ");
        System.out.print("Chọn một tùy chọn: ");
    }

    public void addSmartPhone() {
        try {
            System.out.println("Chọn loại thiết bị: ");
            System.out.println("1.Thêm điện thoại chính hãng");
            System.out.println("2.Thêm điện thoại sách tay");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Thêm id");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Thêm tên");
            String name = scanner.nextLine();
            System.out.println("Them giá");
            double price = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Thêm so lượng ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Thêm thương hiệu");
            String brand = scanner.nextLine();
            SmartPhone smartPhone = null;
            String fileName = "";
            switch (choice) {
                case 1:
                    System.out.println("thêm thời gian bảo hành");
                    String warrantyPeriod = scanner.nextLine();
                    System.out.println("thêm phạm vi bảo hành");
                    String warrantyScope = scanner.nextLine();
                    fileName = Constants.genuineSmartPhonePath;
                    smartPhone = new GenuineSmartPhone(id, name, price, quantity, brand, warrantyPeriod, warrantyScope);
                    break;
                case 2:
                    System.out.println("1. Thêm quốc gia xách tay");
                    String portableCountry = scanner.nextLine();
                    System.out.println("2. Thêm trạng thái");
                    String status = scanner.nextLine();
                    fileName = Constants.handedSmartPhonePath;
                    smartPhone = new HandedSmartPhone(id, name, price, quantity, brand, portableCountry, status);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
            List<SmartPhone> smartPhones = loadProductFromFile(fileName);
            smartPhones.add(smartPhone);
            saveProductToFile(fileName, smartPhones);
            System.out.println("thêm sản phẩm thành công");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showSmartPhone() {
        System.out.println("Chọn loại sản phẩm muốn hiển thị: ");
        System.out.println("1. Điện thoại Chính hãng: ");
        System.out.println("2. Điện thoại xách tay: ");

        int choie = Integer.parseInt(scanner.nextLine());
        String fileName = "";
        switch (choie) {
            case 1:
                fileName = Constants.genuineSmartPhonePath;
                break;
            case 2:
                fileName = Constants.handedSmartPhonePath;
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ");
                return;
        }
        try {
            List<SmartPhone> smartPhones = loadProductFromFile(fileName);
            for (SmartPhone product : smartPhones) {
                System.out.println(product.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void deleteSmartPhone() {
        System.out.println("Bạn muốn xoá sản phẩm nào?");
        System.out.println("1. Điện thoại chính hãng: ");
        System.out.println("2. Điện thoại xách tay: ");

        int choice = Integer.parseInt(scanner.nextLine());
        String fileName = "";
        List<SmartPhone> smartPhones;
        try {
            switch (choice) {
                case 1:
                    fileName = Constants.genuineSmartPhonePath;
                    smartPhones = loadProductFromFile(fileName);
                    break;
                case 2:
                    fileName = Constants.handedSmartPhonePath;
                    smartPhones = loadProductFromFile(fileName);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    return;
            }

            System.out.println("Nhập ID sản phẩm muốn xoá: ");
            int idToDelete = scanner.nextInt();
            scanner.nextLine();
            boolean found = false;

            Iterator<SmartPhone> iterator = smartPhones.iterator();
            while (iterator.hasNext()) {
                SmartPhone product = iterator.next();
                if (product.getId() == idToDelete) {
                    iterator.remove();
                    found = true;
                }
            }

            if (found) {
                saveProductToFile(fileName, smartPhones);
                System.out.println("Xoá sản phẩm thành công.");
            } else {
                System.out.println("Không tìm thấy sản phẩm với ID đã nhập.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void searchSmartPhone() {
        System.out.println("Nhập ID sản phẩm muốn tìm: ");
        int idToSearch = scanner.nextInt();
        scanner.nextLine();
        try {
            List<SmartPhone> allSmartPhone = new ArrayList<>();
            allSmartPhone.addAll(loadProductFromFile(Constants.genuineSmartPhonePath));
            allSmartPhone.addAll(loadProductFromFile(Constants.handedSmartPhonePath));

            List<SmartPhone> result = new ArrayList<>();
            for (SmartPhone smartPhone : allSmartPhone) {
                if (smartPhone.getId() == idToSearch) {
                    result.add(smartPhone);
                }
            }

            if (!result.isEmpty()) {
                for (SmartPhone smartPhone : result) {
                    System.out.println(smartPhone.toString());
                }
            } else {
                System.out.println("Không tìm thấy sản phẩm phù hợp.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static List<SmartPhone> loadProductFromFile(String fileName) throws IOException {
        List<String> data = ReadAndWriteFile.readFile(fileName);
        List<SmartPhone> smartPhones = new ArrayList<>();
        if (data.isEmpty()) {
            return smartPhones;
        }
        for (String line : data) {
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split(",");
            if (parts.length < 7) {
                continue;
            }
            if (parts.length == 7 && fileName.equals(Constants.genuineSmartPhonePath)) {
                smartPhones.add(new GenuineSmartPhone(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]),
                        parts[4], parts[5], parts[6]));
            }
            if (parts.length == 7 && fileName.equals(Constants.handedSmartPhonePath)) {
                smartPhones.add(new HandedSmartPhone(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]),
                        parts[4], parts[5], parts[6]));
            }

        }
        return smartPhones;

    }

    private static void saveProductToFile(String fileName, List<SmartPhone> products) throws IOException {
        List<String> productsToSave = new ArrayList<>();
        for (SmartPhone product : products) {
            productsToSave.add(product.getInfoToFile());
        }
        ReadAndWriteFile.writeFile(fileName, "", false);
        for (String line : productsToSave) {
            ReadAndWriteFile.writeFile(fileName, line, true);
        }
    }
}
