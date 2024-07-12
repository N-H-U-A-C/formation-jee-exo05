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
import java.util.Optional;

@WebServlet(name = "dogServlet", value = "/dog/*")
public class DogServlet extends HttpServlet {

    private List<Dog> dogs;

    @Override
    public void init() {
        dogs = new ArrayList<>();
        dogs.add(new Dog(1L, "Médor", "Pug", LocalDate.parse("2020-10-10")));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // TODO refactor with optional
//        Optional<String> optionalId = Optional.ofNullable(req.getPathInfo());
//        if (optionalId.isPresent()) {
//            Long id = Long.valueOf(optionalId.get().substring(1));
//        } else {
//            req.setAttribute("dogs", dogs);
//            req.getRequestDispatcher("/dogs/list.jsp").forward(req, resp);
//        }

        String pathInfo = req.getPathInfo().substring(1);
        System.out.println(pathInfo);
        switch (pathInfo) {
            case "list":
                System.out.println("list - switch");
                req.setAttribute("dogs", dogs);
                getServletContext().getRequestDispatcher("/dogs/list.jsp").forward(req, resp);
                break;
            case "detail":
                System.out.println("detail - switch");
                getServletContext().getRequestDispatcher("/dogs/detail.jsp").forward(req, resp);
                break;
            case "add":
                System.out.println("add - switch");
                getServletContext().getRequestDispatcher("/dogs/add.jsp").forward(req, resp);
                break;
        }
    }
}
