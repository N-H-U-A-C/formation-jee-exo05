package dev.cb.dogs.controller;

import dev.cb.dogs.business.model.Dog;
import dev.cb.dogs.business.service.DogService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "dogServlet", value = "/dog/*")
public class DogServlet extends HttpServlet {

    private DogService dogService;

    @Override
    public void init() {
        dogService = new DogService();
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("inputName");
        String breed = req.getParameter("inputBreed");
        LocalDate birthDate = LocalDate.parse(req.getParameter("inputBirthDate"));
        dogService.save(new Dog(name, breed, birthDate));
        resp.sendRedirect("list");
    }

    private void displayForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/dogs/add.jsp").forward(req, resp);
    }

    private void displayDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Optional<Dog> optionalDog = dogService.getById(id);
        req.setAttribute("dog", optionalDog.orElse(new Dog("Error", "Error", LocalDate.now())));
        getServletContext().getRequestDispatcher("/dogs/detail.jsp").forward(req, resp);
    }

    private void displayList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dog> dogs = dogService.getAll();
        req.setAttribute("dogs", dogs);
        getServletContext().getRequestDispatcher("/dogs/list.jsp").forward(req, resp);
    }
}
