package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);


    @Test
    void shouldFindABookByName() {

        Book firstBook = new Book(1, "firstNameBook", 111, "Ivanov");
        Book secondBook = new Book(2, "secondNameBook", 222, "Kuznetsov");
        Book thirdBook = new Book(3, "thirdNameBook", 333, "Smirnov");
        Book fourthBook = new Book(4, "fourthNameBook", 444, "Popov");
        Book fifthBook = new Book(5, "fifthNameBook", 555, "Petrov");

        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(fourthBook);
        manager.add(fifthBook);


        Product[] actual = manager.searchBy("secondNameBook");
        Product[] expected = new Product[]{secondBook};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTheSmartphoneByName() {

        Smartphone firstSmartphone = new Smartphone(1, "firstNameSmartphone", 111, "Apple");
        Smartphone secondSmartphone = new Smartphone(2, "secondNameSmartphone", 222, "Samsung");
        Smartphone thirdSmartphone = new Smartphone(3, "thirdNameSmartphone", 333, "Honor");
        Smartphone fourthSmartphone = new Smartphone(4, "fourthNameSmartphone", 444, "Xiaomi");
        Smartphone fifthSmartphone = new Smartphone(5, "fifthNameSmartphone", 555, "Huawei");

        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
        manager.add(thirdSmartphone);
        manager.add(fourthSmartphone);
        manager.add(fifthSmartphone);

        Product[] actual = manager.searchBy("fourthNameSmartphone");
        Product[] expected = new Product[]{fourthSmartphone};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindABookByAuthor() {

        Book firstBook = new Book(1, "firstNameBook", 111, "Ivanov");
        Book secondBook = new Book(2, "secondNameBook", 222, "Kuznetsov");
        Book thirdBook = new Book(3, "thirdNameBook", 333, "Smirnov");
        Book fourthBook = new Book(4, "fourthNameBook", 444, "Popov");
        Book fifthBook = new Book(5, "fifthNameBook", 555, "Petrov");

        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(fourthBook);
        manager.add(fifthBook);


        Product[] actual = manager.searchBy("Smirnov");
        Product[] expected = new Product[]{thirdBook};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTheSmartphoneByManufacture() {

        Smartphone firstSmartphone = new Smartphone(1, "firstNameSmartphone", 111, "Apple");
        Smartphone secondSmartphone = new Smartphone(2, "secondNameSmartphone", 222, "Samsung");
        Smartphone thirdSmartphone = new Smartphone(3, "thirdNameSmartphone", 333, "Honor");
        Smartphone fourthSmartphone = new Smartphone(4, "fourthNameSmartphone", 444, "Xiaomi");
        Smartphone fifthSmartphone = new Smartphone(5, "fifthNameSmartphone", 555, "Huawei");

        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
        manager.add(thirdSmartphone);
        manager.add(fourthSmartphone);
        manager.add(fifthSmartphone);

        Product[] actual = manager.searchBy("Huawei");
        Product[] expected = new Product[]{fifthSmartphone};

        assertArrayEquals(expected, actual);
    }

}
