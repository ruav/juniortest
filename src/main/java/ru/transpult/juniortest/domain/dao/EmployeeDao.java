package ru.transpult.juniortest.domain.dao;

import ru.transpult.juniortest.pojo.Employee;

import java.util.List;

/**
 * Created by RuAV on 21.06.2017.
 */
public interface EmployeeDao {

    /**
     * Получить сотрудника по номеру id
     * @param id идентификатор сотрудника
     * @return возращает сотрудника, если
     * он есть в базе, или же пустой объект,
     * если его нет в бд
     */
    Employee getById(int id);

    /**
     * Получить список сотрудников по части имени или фамилии
     * @param names часть имени или фамилии
     * @return возвращает список сотрудников, если
     * они есть в базе, или же пустой лист,
     * если никого не найдено в бд
     */
    List<Employee> getByNames(String names);

    /**
     * Получить список всех сотрудников
     * @return возвращает список сотрудников, если
     * они есть в базе, или же пустой список,
     * если никого нет в бд
     */
    List<Employee> getAll();

    /**
     * Удалить сотрудника по id
     * @param id идентификатор удаляемого сотрудника
     */
    void removeById(int id);

    /**
     * Добавить нового сотрудника в базу
     * @param employee Новый сотрудник для добавления
     */
    void add(Employee employee);

    /**
     * Обновить сотрудника в базе
     * @param employee Экземпляр измененного сотрудника
     */
    void update(Employee employee);

}
