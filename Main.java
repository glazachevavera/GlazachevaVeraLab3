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
