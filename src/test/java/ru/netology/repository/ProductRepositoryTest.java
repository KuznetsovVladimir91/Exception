package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();

    Product first = new Product(111, "name1", 100);
    Product second = new Product(222, "name2", 200);
    Product third = new Product(333, "name3", 300);

    @Test
    void shouldThrowException() {

        repository.save(first);
        repository.save(second);
        repository.save(third);

        assertThrows(NotFoundException.class, () -> repository.removeById(444));
    }

    @Test
    void shouldRemoveTheProduct() {

        repository.save(first);
        repository.save(second);
        repository.save(third);

        repository.removeById(111);

        Product[] expected = new Product[]{second, third};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

}
