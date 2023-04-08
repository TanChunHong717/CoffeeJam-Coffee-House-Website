package org.example.restaurantwebsite.service;

import com.github.pagehelper.PageInfo;
import org.example.restaurantwebsite.pojo.Table;

import java.util.List;

public interface TableService {
    PageInfo<Table> getTablePage(Integer pageNum);
    List<Table> getAllTable();
    Table getTable(Integer tableId);
    void insertTable(Table table);
    void updateTable(Table table);
    void deleteTable(Integer tableId);
}
