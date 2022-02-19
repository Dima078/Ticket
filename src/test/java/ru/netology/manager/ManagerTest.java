package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.Repository;
import ru.netology.ticket.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Repository repo = new Repository();
    private Manager manager = new Manager(repo);
    private Ticket ticket1 = new Ticket(1, 900, "DME", "EGO", 90);
    private Ticket ticket2 = new Ticket(2, 1100, "DME", "EGO", 100);
    private Ticket ticket3 = new Ticket(3, 1500, "LED", "GOJ", 105);
    private Ticket ticket4 = new Ticket(4, 800, "DME", "EGO", 150);
    private Ticket ticket5 = new Ticket(5, 1300, "LED", "GOJ", 200);

    private Ticket ticket6 = new Ticket(6, 1200, "ZKD", "MOW", 200);
    private Ticket ticket7 = new Ticket(7, 1200, "ZKD", "MOW", 180);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    void searchBy() {
        Ticket[] expected = {ticket4, ticket1, ticket2};
        Ticket[] actual = manager.searchBy("DME", "EGO");
    }

    @Test
    void searchByTest() {
        Ticket[] expected = {ticket5, ticket3};
        Ticket[] actual = manager.searchBy("LED", "GOJ");
    }

    @Test
    void searchByTestSame() {
        Ticket[] expected = {ticket6, ticket7};
        Ticket[] actual = manager.searchBy("ZKD", "MOW");
    }

    @Test
    void searchByTestFrom() {
        Ticket[] expected = null;
        Ticket[] actual = manager.searchBy("LED", "EGO");
    }

    @Test
    void searchByEmpty() {
        Ticket[] expected = null;
        Ticket[] actual = manager.searchBy("KUF", "OGZ");
    }
}