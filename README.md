## Отчет по лабораторной работе № 3

#### № группы: `ПМ-2501`

#### Выполнила: `Глазачева Вера Андреевна`

#### Вариант: `4`

### Cодержание:

- [Условие задачи](#1-условие-задачи)
- [Алгоритм](#2-алгоритм)
- [Программа](#3-программа)
- [Анализ правильности решения](#4-анализ-правильности-решения)

### 1. Условие задачи

**Список покупок**

> Краткое описание: Разработать систему управления списком покупок с функциями анализа бюджета и стоимости товаров. Обеспечить возможность работы с данными о товарах, их ценах и доступных средствах, включая проверку соответствия стоимости покупок бюджету.

> **Описание функционала:**
> 1. **Создание списка покупок**
> Пользователь может создать список товаров с указанием их названий, цен, статусов «куплено/не куплено» и необходимого количества.
> 2. **Указание бюджета**
> При создании списка можно задать начальную сумму денег, доступных для покупок. Если бюджет не указан, он равен нулю.
> 3. **Добавление денег**
> Возможность увеличить доступный бюджет на указанную сумму.
> 4. **Проверка возможности покупки товара**
> Пользователь может проверить, достаточно ли у него денег для покупки определённого товара. Поиск товара может осуществляться по его номеру или названию.
> 5. **Покупка товара**
> Пользователь может приобрести товар из списка, если у него достаточно средств.
> 6. **Общая стоимость списка**
> Вычисление суммы всех товаров в списке, независимо от их статуса (куплено/не куплено).
> 7. **Общая стоимость оставшихся товаров**
> Подсчёт стоимости всех товаров, которые ещё не куплены.
> 8. **Возможность покупки всего списка**
> Проверка, можно ли купить все товары из списка при текущем бюджете.
> 9. **Подсчёт недостающей суммы**
> Если средств недостаточно для покупки списка товаров, отображается сумма, которая требуется для полной покупки. При наличии лишних средств результат не должен уходить в отрицательные значения.
> 10. **Функция «Купить всё»**
> Попытка автоматически приобрести все товары из списка, начиная с самого дешёвого или дорогого, в зависимости от настроек.
> 11. **Сортировка товаров по цене**
> Возможность упорядочить товары в списке по их стоимости, начиная с самого дешёвого или самого дорогого.
> 12. **Покупка определённого количества товаров**
> Пользователь может определить, сколько товаров из списка он может купить, начиная с самых дешёвых или самых дорогих, в зависимости от настроек.
> 13. **Функция нахождения самого дешёвого или дорогого товара**
> Вывод информации о самом дешёвом или дорогом не купленном товаре для упрощения взаимодействия.

### 2. Алгоритм

**1. Используемые структуры данных**

Используются два класса: Product, хранящий информацию об отдельном товаре (название - name(String), цена - price(double), необходимое количество - quantity(int), статус товара "куплен"/"не куплен" - bought(boolean)), ShoppingList, хранящий информацию о списке товаров и самом списке покупок (название -	name(String), бюджет - budget(double), список товаров -products(Product[100]), счетчик количества товаров в списке покупок - count(int)).

**2. Алгоритмы финансовых расчетов и операций**

3. Добавление денег (addBudget(double sum))

Увеличевает бюджет на указанную сумму, бюджет можно увеличить только на положительную сумму.

5. Покупка товара (buyProduct(String name) - по названию или (int n) - по номеру)

Покупается товар, если он не куплен и его покупка возможна, что проверяется вызовом соответствующего метода, предварительно найдя этот товар в списке покупок по названию или номеру, в зависимости от требований, если нужного товара не найдено, выводится соответствующее сообщение. 

6. Общая стоимость списка (listPrice())
   
Вычисляет общую стоимость всех товаров, независимо от статуса покупки, суммирует произведения цены товаров на их количество.

7. Стоимость оставшихся товаров (notBoughtListPrice())
   
Вычислияет общую стоимость товаров, статус которых "не куплен" (bought = false), суммирует произведения цены товаров на их количество тех товаров, которые удовлетворяют условию.

9. Подсчет недостающей суммы (missingSum())
   
Определяет, сколько не хватает для покупки всех оставшихся товаров, то есть вычисляет на сколько стоимость оставшихся товаров больше бюджета, при этом проверяя есть ли возможность купить все не купленные товары, и если да, то возвращает 0, так как бюджета хватает для покупки оставшихся товаров.

**3. Алгоритмы проверок**

4. Проверка возможности покупки товара (checkBuyProduct(String name) - по названию или (int n) - по номеру)

Проверяет хватает ли бюджета на покупку товара, предварительно найдя этот товар в списке покупок по названию или номеру, в зависимости от требований, если нужного товара не найдено, выводится соответствующее сообщение.

8. Возможность покупки всего списка (checkBuyAllList())

Выясняет хватает ли бюджеьа для покупки всех не купленных товаров, сравнивая бюджет и стоимость оставшихся, то есть не купленных, товаров (notBoughtListPrice()).
   
**4. Алгоритмы Сортировок** 

Создание отсортированных списков покупок из исходных, которые используются в других методах (getSortVListByPrice() - сортировка по возрастанию / getSortUListByPrice() - сортировка по убыванию). Создает новый список покупок ShoppingList l, копирует в него все товары из текущего списка, и сортирует этот новый список. Для сохранения статуса товара создаем методы Product и addProductL от четырех переменных.

11. Сортировки (SortVListByPrice() - сортировка по возрастанию / SortUListByPrice() - сортировка по убыванию) сортируют список товаров по их цене, изменяя сам список.

**5. Алгоритмы методов, в которых используются отсортированные списки товаров**

10. Купить все (buyAllListCheap() / buyAllListExpensive())

Покупаются товары, пока хватает бюджета начиная с самого дешевого или дорогого тоавра, в зависимости от настроек. Для применения настроек, но не изменении текущего списка покупок получаем новый список отсортированный в соответствии с настройками. Начиная с первого товара проверяется возможна ли покупка, если да, то товар покупается. Это продолжается до тех пор, пока хватает бюджета и список покупок не закончился.

12. Сколько товаров из списка можно купить по возрастанию или убыванию их цены (countBuyListCheap() / countBuyListExpensive())

Определяет, сколько товаров можно купить по заданным настройкам (начиная с самого дешевого или дорогого), не изменяя фактический бюджет. Для этого создаем временный бюджет, как бы он изменялся если бы покупались товары по заданным настройкам. Для применения настроек, но не изменении текущего списка покупок получаем новый список отсортированный в соответствии с настройками. Считаем количество первых товаров на покупку которых хватает временного бюджета и статус которых "не куплен". После липовой покупки уменьшаем временный бюджет до тех пор пока его хватает для покупки не купленных товаров, ведем подсчет липовых покупок.

13. Нахождение самого дешевого или дорогого товара (cheapProductCheap() / cheapProductExpensive())

Находит самый дешевый или дорогой не купленный товар, выбирая первый не купленный товар из отсортированного списка товаров, чтобы сам список не изменялся используем getSortVListByPrice() или getSortUListByPrice() соответственно. Если в списке товар со статусом "не куплен" не найден, выводится соответствующее сообщение.
  
### 3. Программа

**Класс для товара**
```java
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
```

**Класс для списка покупок**
```java
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
    public void addProductL(String name, double price, int quantity, boolean bought) { //добавление товаров в список покупок
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
    public Product[] getProducts() { //возвращает список покупок
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
```

### 4. Анализ правильности решения

**Класс для проверки правильности решения**
```java
public class Main {
    public static void main(String[] args) {
        ShoppingList list1 = new ShoppingList(466.87, "Продукты");
        list1.addProduct("Молоко", 56.6, 2);
        list1.addProduct("Творог",78.76,1);
        list1.addProduct("Хлеб", 23.5, 1);
        list1.addProduct("Яблоко", 9.83, 8);
        list1.addProduct("Помидор", 8.62, 6);
        list1.addProduct("Мясо", 312.49, 1);
        list1.addProduct("Греча", 48.2, 2);
        list1.addProduct("Каша", 54.17, 2);
        list1.addProduct("Сыр", 198.36, 1);
        System.out.printf("Список покупок %s, бюджет которого %.2f содержит в себе следующие товары:\n", list1.getName(), list1.getBudget());
        System.out.print(list1);
        System.out.printf("Общая стоимость списка покупок составляет %.2f.\n", list1.listPrice());
        System.out.printf("Начиная с самого дешевого товара можно купить %d товаров.\n", list1.countBuyListCheap());
        list1.sortVListByPrice();
        list1.buyAllListExpensive();
        list1.addBudget(158.47);
        System.out.printf("Для покупки оставшихся товаров нехватает %.2f.\n", list1.missingSum());
        list1.buyProduct(3);
        list1.cheapProductCheap();
        list1.buyProduct("Огурец");
        System.out.printf("Список покупок %s, после проделанных операций выглядит следующим образом:\n", list1.getName());
        System.out.print(list1);
        System.out.printf("Конечный бюджет списка покупок %s равен %.2f.\n", list1.getName(), list1.getBudget());
        System.out.println();
        ShoppingList list2 = new ShoppingList(28400, "Мебель");
        list2.addProduct("Шкаф", 15613.6, 1);
        list2.addProduct("Комод",7892.76,1);
        list2.addProduct("Тумба", 1370.5, 2);
        list2.addProduct("Стол", 3900.83, 1);
        list2.addProduct("Стул", 560.6, 4);
        list2.addProduct("Кровать",10089.79,1);
        System.out.printf("Список покупок %s, бюджет которого %.2f содержит в себе следующие товары:\n", list2.getName(), list2.getBudget());
        System.out.print(list2);
        System.out.printf("Начиная с самого дорогого товара можно купить %d товаров.\n", list2.countBuyListExpensive());
        list2.cheapProductExpensive();
        list2.buyProduct("Стол");
        System.out.printf("Оставшиеся товары %s купить.\n", list2.checkBuyAllList() ? "можно" : "нельзя");
        list2.buyAllListCheap();
        list2.sortUListByPrice();
        System.out.printf("Стоимость списка покупок, которые еще не куплены составляет %.2f.\n", list2.notBoughtListPrice());
        System.out.printf("Список покупок %s, после проделанных операций выглядит следующим образом:\n", list2.getName());
        System.out.print(list2);
        System.out.printf("Конечный бюджет списка покупок %s равен %.2f.\n", list2.getName(), list2.getBudget());
    }
}
```
Output:
```
Список покупок Продукты, бюджет которого 466,87 содержит в себе следующие товары:
Товар Молоко в количестве 2 ценой 56,60 за еденицу не куплен.
Товар Творог в количестве 1 ценой 78,76 за еденицу не куплен.
Товар Хлеб в количестве 1 ценой 23,50 за еденицу не куплен.
Товар Яблоко в количестве 8 ценой 9,83 за еденицу не куплен.
Товар Помидор в количестве 6 ценой 8,62 за еденицу не куплен.
Товар Мясо в количестве 1 ценой 312,49 за еденицу не куплен.
Товар Греча в количестве 2 ценой 48,20 за еденицу не куплен.
Товар Каша в количестве 2 ценой 54,17 за еденицу не куплен.
Товар Сыр в количестве 1 ценой 198,36 за еденицу не куплен.
Общая стоимость списка покупок составляет 1061,41.
Начиная с самого дешевого товара можно купить 5 товаров.
Для покупки оставшихся товаров нехватает 436,07.
Самый дешевый не купленный товар: Товар Помидор в количестве 6 ценой 8,62 за еденицу не куплен.
Товар с таким названием не найден.
Список покупок Продукты, после проделанных операций выглядит следующим образом:
Товар Помидор в количестве 6 ценой 8,62 за еденицу не куплен.
Товар Яблоко в количестве 8 ценой 9,83 за еденицу не куплен.
Товар Хлеб в количестве 1 ценой 23,50 за еденицу куплен.
Товар Греча в количестве 2 ценой 48,20 за еденицу не куплен.
Товар Каша в количестве 2 ценой 54,17 за еденицу не куплен.
Товар Молоко в количестве 2 ценой 56,60 за еденицу не куплен.
Товар Творог в количестве 1 ценой 78,76 за еденицу не куплен.
Товар Сыр в количестве 1 ценой 198,36 за еденицу не куплен.
Товар Мясо в количестве 1 ценой 312,49 за еденицу куплен.
Конечный бюджет списка покупок Продукты равен 289,35.

Список покупок Мебель, бюджет которого 28400,00 содержит в себе следующие товары:
Товар Шкаф в количестве 1 ценой 15613,60 за еденицу не куплен.
Товар Комод в количестве 1 ценой 7892,76 за еденицу не куплен.
Товар Тумба в количестве 2 ценой 1370,50 за еденицу не куплен.
Товар Стол в количестве 1 ценой 3900,83 за еденицу не куплен.
Товар Стул в количестве 4 ценой 560,60 за еденицу не куплен.
Товар Кровать в количестве 1 ценой 10089,79 за еденицу не куплен.
Начиная с самого дорогого товара можно купить 2 товаров.
Самый дорогой не купленный товар: Товар Шкаф в количестве 1 ценой 15613,60 за еденицу не куплен.
Оставшиеся товары нельзя купить.
Стоимость списка покупок, которые еще не куплены составляет 15613,60.
Список покупок Мебель, после проделанных операций выглядит следующим образом:
Товар Шкаф в количестве 1 ценой 15613,60 за еденицу не куплен.
Товар Кровать в количестве 1 ценой 10089,79 за еденицу куплен.
Товар Комод в количестве 1 ценой 7892,76 за еденицу куплен.
Товар Стол в количестве 1 ценой 3900,83 за еденицу куплен.
Товар Тумба в количестве 2 ценой 1370,50 за еденицу куплен.
Товар Стул в количестве 4 ценой 560,60 за еденицу куплен.
Конечный бюджет списка покупок Мебель равен 1533,22.
```
