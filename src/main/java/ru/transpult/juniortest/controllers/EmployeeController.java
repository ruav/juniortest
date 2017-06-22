package ru.transpult.juniortest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(path = "/create", method = RequestMethod.PUT)
    public @ResponseBody int create(@RequestParam(name = "edit", defaultValue = "0") int editId,
                                    @RequestParam(name = "remove", defaultValue = "0") int removeId,
                                    @RequestParam(name = "adminconfig", defaultValue = "0") int adminId,
                                    @RequestParam(name = "isadmin", defaultValue = "false") boolean isadmin) {

        int result = 0;

        Employee employee = new Employee();

        try {
            employeeService.add(employee);
        } catch (Exception e){
            result = -1;
        }

        return result;
    }

    @RequestMapping("/find/{name}")
    public @ResponseBody List<Employee> findByName(@PathVariable String name){
        return employeeService.getByNames(name);
    }

}
