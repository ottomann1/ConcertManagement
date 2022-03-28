package com.example.databasefxx;

import DAO.CustomerDAO;
import DAO.TicketDAO;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TicketDAO ticketDAO = new TicketDAO();
        System.out.println(ticketDAO.readAll());
    }
}
