package ru.netology.manager;

import ru.netology.repository.Repository;
import ru.netology.ticket.Ticket;

import java.util.Arrays;

public class Manager {
    private Repository repository;

    public Repository getRepository() {
        return repository;
    }

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Ticket item) {
        repository.save(item);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                int length = result.length + 1;
                Ticket[] tmp = new Ticket[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
                Arrays.sort(result);
            }
        }
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().contains(from) && ticket.getTo().contains(to)) {
            return true;
        } else {
            return false;
        }
    }

}
