/**
 * 
 */
package ru.transpult.juniortest.domain.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author kirill@krushnyakov.ru
 *
 */

@Entity
@Table(name = "tests")
public class Test {

    @Id
    private long id;

    private int x;

    public Test() {

    }
    
    public long getId() {
	return id;
    }
    
    
    public void setId(long id) {
	this.id = id;
    }

    public int getX() {
	return x;
    }

    public void setX(int x) {
	this.x = x;
    }

    
    
}
