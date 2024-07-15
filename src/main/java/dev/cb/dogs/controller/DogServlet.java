package dev.cb.dogs.controller;

import dev.cb.dogs.model.Dog;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "dogServlet", value = "/dog/*")
public class DogServlet extends HttpServlet {

    private List<Dog> dogs;

    @Override
    public void init() {
        dogs = new ArrayList<>();
//        dogs.add(new Dog("Médor", "Pug", LocalDate.parse("2020-10-10")));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pathInfo = req.getPathInfo().substring(1);
        switch (pathInfo) {
            case "list":
                displayList(req, resp);
                break;
            case "detail":
                displayDetail(req, resp);
                break;
            case "add":
                displayForm(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("inputName");
        String breed = req.getParameter("inputBreed");
        LocalDate birthDate = LocalDate.parse(req.getParameter("inputBirthDate"));
        Dog Dog = new Dog(name, breed, birthDate);
        dogs.add(Dog);

        displayList(req, resp);
    }

    private void displayForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/dogs/add.jsp").forward(req, resp);
    }

    private void displayDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("dog", dogs.get(id - 1));
        getServletContext().getRequestDispatcher("/dogs/detail.jsp").forward(req, resp);
    }

    private void displayList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dogs", dogs);
        getServletContext().getRequestDispatcher("/dogs/list.jsp").forward(req, resp);
    }
}
