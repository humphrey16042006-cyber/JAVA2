package LAB1;

// Lớp Product
class Product {
    private String id;
    private String name;
    private double basePrice;

    // Constructor
    public Product(String id, String name, double basePrice) {
        setId(id);
        setName(name);
        setBasePrice(basePrice);
    }

    // Getter/Setter có validate
    public String getId() { return id; }
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID khong duoc rong");
        }
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getBasePrice() { return basePrice; }
    public void setBasePrice(double basePrice) {
        if (basePrice < 0) {
            throw new IllegalArgumentException("Gia co ban phai >= 0");
        }
        this.basePrice = basePrice;
    }

    // Method
    public double finalPrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return "Product[id=" + id + ", name=" + name + ", basePrice=" + basePrice + "]";
    }
}

// Lớp ImportedProduct
class ImportedProduct extends Product {
    private double importTaxRate; // 0 → 1
    private double shippingFee;   // >=0

    public ImportedProduct(String id, String name, double basePrice, double importTaxRate, double shippingFee) {
        super(id, name, basePrice);
        setImportTaxRate(importTaxRate);
        setShippingFee(shippingFee);
    }

    public double getImportTaxRate() { return importTaxRate; }
    public void setImportTaxRate(double importTaxRate) {
        if (importTaxRate < 0 || importTaxRate > 1) {
            throw new IllegalArgumentException("Thuế nhập khẩu phải trong khoảng 0-1");
        }
        this.importTaxRate = importTaxRate;
    }

    public double getShippingFee() { return shippingFee; }
    public void setShippingFee(double shippingFee) {
        if (shippingFee < 0) {
            throw new IllegalArgumentException("Phi van chuyen phai >= 0");
        }
        this.shippingFee = shippingFee;
    }

    @Override
    public double finalPrice() {
        return getBasePrice() + getBasePrice() * importTaxRate + shippingFee;
    }

    @Override
    public String toString() {
        return "ImportedProduct[id=" + getId() + ", name=" + getName() + ", finalPrice=" + finalPrice() + "]";
    }
}

// Main
public class PS47882_Lab1bai1 {
    public static void main(String[] args) {
        Product p1 = new Product("P01", "Ban", 500);
        Product p2 = new Product("P02", "Ghe", 300);
        ImportedProduct p3 = new ImportedProduct("P03", "Laptop", 1000, 0.1, 50);
        ImportedProduct p4 = new ImportedProduct("P04", "Dien thoại", 800, 0.15, 30);
        Product p5 = new Product("P05", "Quat", 200);

        Product[] products = {p1, p2, p3, p4, p5};

        // In danh sách
        for (Product p : products) {
            System.out.println(p + " | Final Price = " + p.finalPrice());
        }

        // Tìm sản phẩm có giá cao nhất
        Product maxProduct = products[0];
        for (Product p : products) {
            if (p.finalPrice() > maxProduct.finalPrice()) {
                maxProduct = p;
            }
        }
        System.out.println("San pham co gia cao nhat: " + maxProduct);
    }
}