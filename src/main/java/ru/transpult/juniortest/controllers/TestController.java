/**
 * 
 */
package ru.transpult.juniortest.controllers;

import javax.transaction.SystemException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.transpult.juniortest.services.FooService;

/**
 * @author kirill@krushnyakov.ru
 *
 */

@Controller
@RequestMapping("/backend/test")
public class TestController {

    
    @Autowired
    private FooService fooService;
    
    @ResponseBody
    @RequestMapping("/")
    public boolean index() throws SystemException {
	return fooService.bar();
    }
}
