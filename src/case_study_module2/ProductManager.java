package case_study_module2;

import case_study_module2.model.Laptop;
import case_study_module2.model.Product;
import case_study_module2.model.Smartphone;
import case_study_module2.model.Tablet;
import case_study_module2.util.ReadAndWriteFile;

import java.io.IOException;
import java.util.*;

public class ProductManager implements Constants {
    static Scanner scanner = new Scanner(System.in);

    public void menu() {
        System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ CỬA HÀNG ĐIỆN THOẠI-----");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Hiển thị sản phẩm");
        System.out.println("3. Sửa danh sách sản phẩm");
        System.out.println("4. Xoá sản phẩm khỏi danh sách");
        System.out.println("5. Tìm kiếm sản phẩm");
        System.out.println("6. Sắp xếp sản phẩm");
        System.out.println("7. Thoát");
        System.out.print("Chọn một tùy chọn: ");
    }

    public void addProduct() {
        try {
            System.out.println("Chọn loại thiết bị: ");
            System.out.println("1. Thêm Laptop: ");
            System.out.println("2. Thêm Smartphone: ");
            System.out.println("3. Them Tablet: ");
            int choie = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập ID:");
            String id = scanner.nextLine();
            System.out.println("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();
            String brand = selectManufacturer(Constants.brandPath);
            System.out.println("Nhập giá sản phẩm: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Nhập kích thước màn hình: ");
            double screenSize = Double.parseDouble(scanner.nextLine());
            Product product = null;
            String fileName = "";
            switch (choie) {
                case 1:
                    System.out.println("Nhập kích thước RAM: ");
                    int ramSize = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhập dung lượng bộ nhớ: ");
                    int storageSizeLaptop = Integer.parseInt(scanner.nextLine());
                    product = new Laptop(id, name, brand, price, screenSize, ramSize, storageSizeLaptop);
                    fileName = Constants.laptopPath;
                    break;
                case 2:
                    System.out.println("Nhập hệ điều hành: ");
                    String operatingSystem = scanner.nextLine();
                    System.out.println("Nhập Dung lượng Pin: ");
                    int batteryCapacity = Integer.parseInt(scanner.nextLine());
                    product = new Smartphone(id, name, brand, price, screenSize, operatingSystem, batteryCapacity);
                    fileName = Constants.smartPhonePath;
                    break;
                case 3:
                    System.out.println("Có Mạng di động không?(true/false)");
                    boolean hasCellular = Boolean.parseBoolean(scanner.nextLine());
                    System.out.println("Nhập dung lượng bộ nhớ: ");
                    int storageSizeTablet = Integer.parseInt(scanner.nextLine());
                    product = new Tablet(id, name, brand, price, screenSize, hasCellular, storageSizeTablet);
                    fileName = Constants.tabletPath;
                    break;
                default:
                    System.out.println("Lựa chọn không hơp lệ");

            }

            List<Product> products = loadProductFromFile(fileName);
            products.add(product);
            saveProductToFile(fileName, products);
            System.out.println("Thêm sản phẩm thành công");
        }
       catch (IOException e) {
            e.printStackTrace();
       }
    }


    private static String selectManufacturer(String fileName) throws IOException {
        List<String> manufacturers = ReadAndWriteFile.readFile(fileName);
        System.out.println("Nhập thương hiệu");
        for (int i = 0; i < manufacturers.size(); i++) {
            System.out.println(i + 1 + ". " + manufacturers.get(i));
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice < 1 || choice > manufacturers.size()) {
            System.out.println("Lựa chọn không hợp lệ, mặc định chọn hãng sản xuất đầu tiên.");
            choice = 1;
        }
        return manufacturers.get(choice - 1);
    }

    public void showProducts() {
        System.out.println("Chọn loại sản phẩm muốn hiển thị: ");
        System.out.println("1. Máy tính xách tay: ");
        System.out.println("2. Điện thoại di động: ");
        System.out.println("3. Máy tính bảng: ");
        int choie = Integer.parseInt(scanner.nextLine());
        String fileName = "";
        switch (choie) {
            case 1:
                fileName = Constants.laptopPath;
                break;
            case 2:
                fileName = Constants.smartPhonePath;
                break;
            case 3:
                fileName = Constants.tabletPath;
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ");
                return;
        }
        try {
            List<Product> products = loadProductFromFile(fileName);
            for (Product product : products) {
                product.displayDetails();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void editProduct() {
        System.out.println("Chọn loại sản phẩm muốn sửa: ");
        System.out.println("1. Máy tính xách tay: ");
        System.out.println("2. Điện thoại di động: ");
        System.out.println("3. Máy tính bảng: ");
        int choice = Integer.parseInt(scanner.nextLine());
        String fileName = "";
        List<Product> products = new ArrayList<>();
        try {
            switch (choice) {
                case 1:
                    fileName = Constants.laptopPath;
                    products = loadProductFromFile(fileName);
                    break;
                case 2:
                    fileName = Constants.smartPhonePath;
                    products = loadProductFromFile(fileName);
                    break;
                case 3:
                    fileName = Constants.tabletPath;
                    products = loadProductFromFile(fileName);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Nhập ID sản phẩm muốn sửa: ");
        String idToEdit = scanner.nextLine();
        boolean found = false;

        for (Product product : products) {
            if (product.getId().equals(idToEdit)) {
                System.out.println("Nhập tên sản phẩm mới: ");
                product.setName(scanner.nextLine());
                System.out.println("Nhập thương hiệu mới: ");
                product.setBrand(scanner.nextLine());
                System.out.println("Nhập giá sản phẩm mới: ");
                product.setPrice(Double.parseDouble(scanner.nextLine()));
                System.out.println("Nhập kích thước màn hình mới: ");
                product.setScreenSize(Double.parseDouble(scanner.nextLine()));

                if (product instanceof Laptop) {
                    System.out.println("Nhập kích thước RAM mới: ");
                    ((Laptop) product).setRamSize(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Nhập dung lượng bộ nhớ mới: ");
                    ((Laptop) product).setStorageSize(Integer.parseInt(scanner.nextLine()));
                } else if (product instanceof Smartphone) {
                    System.out.println("Nhập hệ điều hành mới: ");
                    ((Smartphone) product).setOperatingSystem(scanner.nextLine());
                    System.out.println("Nhập dung lượng pin mới: ");
                    ((Smartphone) product).setBatteryCapacity(Integer.parseInt(scanner.nextLine()));
                } else if (product instanceof Tablet) {
                    System.out.println("Có mạng di động không? (true/false): ");
                    ((Tablet) product).setHasCellular(Boolean.parseBoolean(scanner.nextLine()));
                    System.out.println("Nhập dung lượng bộ nhớ mới: ");
                    ((Tablet) product).setStorageSize(Integer.parseInt(scanner.nextLine()));
                }

                found = true;
                break;
            }
        }
        try {
            if (found) {
                saveProductToFile(fileName, products);
                System.out.println("Sửa sản phẩm thành công.");
            } else {
                System.out.println("Không tìm thấy sản phẩm với ID đã nhập.");
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void searchProduct() {
        System.out.println("Nhập tên hoặc ID sản phẩm muốn tìm: ");
        String keyword = scanner.nextLine().toLowerCase();
        try {
            List<Product> allProducts = new ArrayList<>();
            allProducts.addAll(loadProductFromFile(Constants.laptopPath));
            allProducts.addAll(loadProductFromFile(Constants.smartPhonePath));
            allProducts.addAll(loadProductFromFile(Constants.tabletPath));

            List<Product> result = new ArrayList<>();
            for (Product product : allProducts) {
                if (product.getName().toLowerCase().contains(keyword) || product.getId().toLowerCase().contains(keyword)) {
                    result.add(product);
                }
            }

            if (!result.isEmpty()) {
                for (Product product : result) {
                    product.displayDetails();
                }
            } else {
                System.out.println("Không tìm thấy sản phẩm phù hợp.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sortProducts() {
        System.out.println("Chọn loại sắp xếp: ");
        System.out.println("1. Sắp xếp theo giá: ");
        System.out.println("2. Sắp xếp theo tên: ");
        int choice = Integer.parseInt(scanner.nextLine());
        try {
            List<Product> allProducts = new ArrayList<>();
            allProducts.addAll(loadProductFromFile(Constants.laptopPath));
            allProducts.addAll(loadProductFromFile(Constants.smartPhonePath));
            allProducts.addAll(loadProductFromFile(Constants.tabletPath));

            if (choice == 1) {
                allProducts.sort(Comparator.comparingDouble(Product::getPrice));
            } else if (choice == 2) {
                allProducts.sort(Comparator.comparing(Product::getName));
            } else {
                System.out.println("Lựa chọn không hợp lệ.");
                return;
            }

            for (Product product : allProducts) {
                product.displayDetails();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void deleteProduct() {
        System.out.println("Bạn muốn xoá sản phẩm nào?");
        System.out.println("1. Máy tính xách tay: ");
        System.out.println("2. Điện thoại di động: ");
        System.out.println("3. Máy tính bảng: ");
        int choice = Integer.parseInt(scanner.nextLine());
        String fileName = "";
        List<Product> products;
        try {
            switch (choice) {
                case 1:
                    fileName = Constants.laptopPath;
                    products = loadProductFromFile(fileName);
                    break;
                case 2:
                    fileName = Constants.smartPhonePath;
                    products = loadProductFromFile(fileName);
                    break;
                case 3:
                    fileName = Constants.tabletPath;
                    products = loadProductFromFile(fileName);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    return;
            }

            System.out.println("Nhập ID sản phẩm muốn xoá: ");
            String idToDelete = scanner.nextLine();
            boolean found = false;

            Iterator<Product> iterator = products.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getId().equals(idToDelete)) {
                    iterator.remove();
                    found = true;
                }
            }

            if (found) {
                saveProductToFile(fileName, products);
                System.out.println("Xoá sản phẩm thành công.");
            } else {
                System.out.println("Không tìm thấy sản phẩm với ID đã nhập.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static List<Product> loadProductFromFile(String fileName) throws IOException {
        List<String> data = ReadAndWriteFile.readFile(fileName);
        List<Product> products = new ArrayList<>();
        if (data.isEmpty()) {
            return products;
        }
        for (String line : data) {
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split(",");
            if (parts.length < 7) {
                continue;
            }
            if (parts.length == 7 && fileName.equals(laptopPath)) {
                products.add(new Laptop(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]),
                        Double.parseDouble(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6])));
            }
            if (parts.length == 7 && fileName.equals(smartPhonePath)) {
                products.add(new Smartphone(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]),
                        Double.parseDouble(parts[4]), parts[5], Integer.parseInt(parts[6])));
            }
            if (parts.length == 7 && fileName.equals(tabletPath)) {
                products.add(new Tablet(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]),
                        Double.parseDouble(parts[4]), Boolean.parseBoolean(parts[5]), Integer.parseInt(parts[6])));
            }

        }
        return products;

    }

    private static void saveProductToFile(String fileName, List<Product> products) throws IOException {
        List<String> productsToSave = new ArrayList<>();
        for (Product product : products) {
            productsToSave.add(product.getInfoToFile());
        }
        ReadAndWriteFile.writeFile(fileName, "", false);
        for (String line : productsToSave) {
            ReadAndWriteFile.writeFile(fileName, line, true);
        }
    }
}