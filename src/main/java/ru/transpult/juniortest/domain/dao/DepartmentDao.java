package ru.transpult.juniortest.domain.dao;

import ru.transpult.juniortest.domain.entities.DepartmentEntity;
import ru.transpult.juniortest.pojo.Department;

import java.util.List;

/**
 * Created by RuAV on 21.06.2017.
 */
public interface DepartmentDao {

    /**
     * Получить департамент по номеру id
     * @param id идентификатор департамента
     * @return возращает департамент, если
     * он есть в базе, или же пустой объект,
     * если его нет в бд
     */
    Department getById(int id);

    /**
     * Получить список департаментов по части имени или фамилии
     * @param names часть имени или фамилии
     * @return возвращает список департаментов, если
     * они есть в базе, или же пустой лист,
     * если никого не найдено в бд
     */
    List<Department> getByNames(String names);

    /**
     * Получить список всех департаментов
     * @return возвращает список департаментов, если
     * они есть в базе, или же пустой список,
     * если никого нет в бд
     */
    List<Department> getAll();

    /**
     * Удалить департамент по id
     * @param id идентификатор удаляемого департамента
     */
    void removeById(int id);

    /**
     * Добавить нового департамента в базу
     * @param department Новый департамент для добавления
     */
    void add(Department department);

    /**
     * Обновить департамента в базе
     * @param department Экземпляр измененного департамента
     */
    void update(Department department);

}
