/**
 * 
 */
package ru.transpult.juniortest.controllers;

import javax.transaction.SystemException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kirill@krushnyakov.ru
 *
 */

@Controller
//@RequestMapping("/")
public class IndexController {

    
    @RequestMapping("/")
    public String index() throws SystemException {
	return "resources/index2";
    }
}
