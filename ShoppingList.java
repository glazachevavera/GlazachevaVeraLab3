class ShoppingList {
    private String name;
    private double budget;
    private Product[] products = new Product[100];
    private int count = 0;
    public void addProduct(String name, double price, int quantity) { //добавление товаров в список покупок
        if (this.count < products.length) {
            products[this.count] = new Product(name, price, quantity);
            this.count += 1;
        }
        else {
            System.out.println("Нельзя добавить товар в список покупок, так как список покупок заполнен целиком.");
        }
    }
    public void addProductL(String name, double price, int quantity, boolean bought) {
        if (this.count < products.length) {
            products[this.count] = new Product(name, price, quantity, bought);
            this.count += 1;
        }
    }
    public ShoppingList(double budget, String name) { //создание бюджета
        if (budget <= 0) {
            this.budget = 0;
        }
        else {
            this.budget = budget;
        }
        this.name = name;
    }
    public ShoppingList() {
        budget = 0;
    }
    public double getBudget() { //возвращает бюджет
        return budget;
    }
    public String getName() { //возвращает название списка покупок
        return this.name;
    }
    public int getCount() { //возвращает количество товаров в списке покупок
        return this.count;
    }
    public Product[] getProducts() {
        return products;
    }
    public void addBudget(double sum) { //увеличивает бюджет
        if (sum > 0) {
            this.budget += sum;
        }
    }
    public boolean checkBuyProduct(String name) { //проверяет достаточно ли бюджета для покупки товара по названию
        int i = 0;
        while (i < this.count && !products[i].getName().equals(name)) {
            i++;
        }
        if (i == this.count) {
            System.out.println("Товар с таким названием не найден.");
            return false;
        }
        else {
            Product p = products[i];
            return p.getPrice() * p.getQuantity() <= budget;
        }
    }
    public boolean checkBuyProduct(int n) { //проверяет достаточно ли бюджета для покупки товара по номеру
        if (n > this.count) {
            System.out.println("Товар с таким номером не найден.");
            return false;
        }
        else {
            Product p = products[n-1];
            return p.getPrice() * p.getQuantity() <= budget;
        }
    }
    public void buyProduct(String name) { //покупает товар, если его покупка возможна по названию
        int i = 0;
        while (i < this.count && !products[i].getName().equals(name)) {
            i++;
        }
        if (i == this.count) {
            System.out.println("Товар с таким названием не найден.");
        }
        else {
            Product p = products[i];
            if (!p.getBought() && checkBuyProduct(name)) {
                this.budget -= p.getPrice() * p.getQuantity();
                p.setBought(true);
            }
        }
    }
    public void buyProduct(int n) { //покупает товар, если его покупка возможна по номеру
        if (n > this.count) {
            System.out.println("Товар с таким номером не найден.");
        }
        else {
            Product p = products[n-1];
            if (!p.getBought() && checkBuyProduct(n)) {
                this.budget -= p.getPrice() * p.getQuantity();
                p.setBought(true);
            }
        }
    }
    public double listPrice() { //считает общую стоимость списка покупок
        double sum = 0;
        for (int i = 0; i < this.count; i++) {
            sum += products[i].getPrice()*products[i].getQuantity();
        }
        return sum;
    }
    public double notBoughtListPrice() { //считает стоимость списка покупок, которые еще не куплены
        double sum = 0;
        for (int i = 0; i < this.count; i++) {
            if (!products[i].getBought()) {
                sum += products[i].getPrice() * products[i].getQuantity();
            }
        }
        return sum;
    }
    public boolean checkBuyAllList() { //проверяет можно ли купить весь список покупок
        return notBoughtListPrice() <= getBudget();
    }
    public double missingSum() { //считает недостающую сумму, если покупка невозможна
        if (!checkBuyAllList()) {
            return notBoughtListPrice()-getBudget();
        }
        else {
            return 0;
        }
    }
    public void sortUListByPrice() { //сортирует список покупок по убыванию цены товара
        for (int i = 1; i < this.count; i++) {
            for (int j = 0; j < this.count-i; j++) {
                if (products[j].getPrice() < products[j+1].getPrice()) {
                    Product p = products[j+1];
                    products[j+1] = products[j];
                    products[j] = p;
                }
            }
        }
    }
    public ShoppingList getSortUListByPrice() { //возвращает отсортированный список покупок по убыванию цены товара
        ShoppingList l = new ShoppingList(this.budget, this.name);
        for (int i = 0; i < this.count; i++) {
            l.addProductL(products[i].getName(), products[i].getPrice(), products[i].getQuantity(), products[i].getBought());
        }
        for (int i = 1; i < this.count; i++) {
            for (int j = 0; j < this.count-i; j++) {
                if (l.getProducts()[j].getPrice() < l.getProducts()[j+1].getPrice()) {
                    Product p = l.getProducts()[j+1];
                    l.getProducts()[j+1] = l.getProducts()[j];
                    l.getProducts()[j] = p;
                }
            }
        }
        return l;
    }
    public void sortVListByPrice() { //сортирует список покупок по возрастанию цены товара
        for (int i = 1; i < this.count; i++) {
            for (int j = 0; j < this.count-i; j++) {
                if (products[j].getPrice() > products[j+1].getPrice()) {
                    Product p = products[j+1];
                    products[j+1] = products[j];
                    products[j] = p;
                }
            }
        }
    }
    public ShoppingList getSortVListByPrice() { //возвращает отсортированный список покупок по возрастанию цены товара
        ShoppingList l = new ShoppingList(this.budget, this.name);
        for (int i = 0; i < this.count; i++) {
            l.addProductL(products[i].getName(), products[i].getPrice(), products[i].getQuantity(), products[i].getBought());
        }
        for (int i = 1; i < l.count; i++) {
            for (int j = 0; j < l.count-i; j++) {
                if (l.getProducts()[j].getPrice() > l.getProducts()[j+1].getPrice()) {
                    Product p = l.getProducts()[j+1];
                    l.getProducts()[j+1] = l.getProducts()[j];
                    l.getProducts()[j] = p;
                }
            }
        }
        return l;
    }
    public void buyAllListCheap() { //покупает товары пока хватает бюджета, начиная с самого дешевого товара
        ShoppingList l = getSortVListByPrice();
        int i = 0;
        while (i < this.count && checkBuyProduct(l.getProducts()[i].getName())) {
            buyProduct(l.getProducts()[i].getName());
            i++;
        }
    }
    public void buyAllListExpensive() { //покупает товары пока хватает бюджета, начиная с самого дорогого товара
        ShoppingList l = getSortUListByPrice();
        int i = 0;
        while (i < this.count && checkBuyProduct(l.getProducts()[i].getName())) {
            buyProduct(l.getProducts()[i].getName());
            i++;
        }
    }
    public int countBuyListCheap() { //считает сколько товаров можно купить, начиная с самого дешевого товара
        ShoppingList l = getSortVListByPrice();
        int i = 0;
        int count = 0;
        double budget = getBudget();
        while (i < this.count && budget >= l.getProducts()[i].getPrice()*l.getProducts()[i].getQuantity()) {
            if (!l.getProducts()[i].getBought()) {
                budget -= l.getProducts()[i].getPrice()*l.getProducts()[i].getQuantity();
            }
            i++;
            count++;
        }
        return count;
    }
    public int countBuyListExpensive() { //считает сколько товаров можно купить, начиная с самого дорогого товара
        ShoppingList l = getSortUListByPrice();
        int i = 0;
        int count = 0;
        double budget = getBudget();
        while (i < this.count && budget >= l.getProducts()[i].getPrice()*l.getProducts()[i].getQuantity()) {
            if (!l.getProducts()[i].getBought()) {
                budget -= l.getProducts()[i].getPrice()*l.getProducts()[i].getQuantity();
            }
            i++;
            count++;
        }
        return count;
    }
    public void cheapProductCheap() { //выводит информацию о самом дешевом товаре, который не куплен
        ShoppingList l = getSortVListByPrice();
        int i = 0;
        while (i < this.count && l.getProducts()[i].getBought()) {
            i++;
        }
        if (i == this.count) {
            System.out.println("Все товары куплены.");
        }
        else {
            System.out.println("Самый дешевый не купленный товар: " + l.getProducts()[i]);
        }
    }
    public void cheapProductExpensive() { //выводит информацию о самом дорогом товаре, который не куплен
        ShoppingList l = getSortUListByPrice();
        int i = 0;
        while (i < this.count && l.getProducts()[i].getBought()) {
            i++;
        }
        if (i == this.count) {
            System.out.println("Все товары куплены.");
        }
        else {
            System.out.println("Самый дорогой не купленный товар: " + l.getProducts()[i]);
        }
    }
    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < this.count; i++) {
            string += String.format("%s\n",products[i]);
        }
        return string;
    }
}
