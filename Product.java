class Product {
    private String name;
    private double price;
    private boolean bought;
    private int quantity;
    public Product(String name, double price, int quantity) { //создание товара
        this.name = name;
        this.price = price;
        this.bought = false;
        this.quantity = quantity;
    }
    public Product(String name, double price, int quantity, boolean bought) { //создание товара
        this.name = name;
        this.price = price;
        this.bought = bought;
        this.quantity = quantity;
    }
    public String getName() { //возвращает название товара
        return this.name;
    }
    public double getPrice() { //возвращает цену товара
        return this.price;
    }
    public boolean getBought() { //возвращает статус товара
        return this.bought;
    }
    public int getQuantity() { //возвращает необходимое количество товара
        return this.quantity;
    }
    public void setBought(boolean bought) { //устанавливает статус товара
        this.bought = bought;
    }
    @Override
    public String toString() {
        return String.format("Товар %s в количестве %d ценой %.2f за еденицу %s.", this.name, this.quantity, this.price, this.bought ? "куплен" : "не куплен");
    }
}
