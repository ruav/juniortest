package ru.transpult.juniortest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.transpult.juniortest.pojo.Employee;
import ru.transpult.juniortest.services.EmployeeService;

import java.util.List;

/**
 * Created by RuAV on 21.06.2017.
 */

@Controller
@RequestMapping("/backend/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/all")
    public @ResponseBody List<Employee> getAll() {
        return employeeService.getAll();
    }

}
