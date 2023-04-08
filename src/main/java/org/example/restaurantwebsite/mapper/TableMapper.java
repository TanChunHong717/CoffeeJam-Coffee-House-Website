package org.example.restaurantwebsite.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.restaurantwebsite.pojo.Table;

import java.util.List;

public interface TableMapper {
    List<Table> getAllTable();
    Table getTable(@Param("tableId") Integer tableId);
    void insertTable(Table table);
    void updateTable(Table table);
    void deleteTable(@Param("tableId") Integer tableId);
}
