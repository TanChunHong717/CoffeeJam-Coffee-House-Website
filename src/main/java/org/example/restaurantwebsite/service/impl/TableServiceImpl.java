package org.example.restaurantwebsite.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.restaurantwebsite.mapper.TableMapper;
import org.example.restaurantwebsite.pojo.Menu;
import org.example.restaurantwebsite.pojo.PageSize;
import org.example.restaurantwebsite.pojo.Table;
import org.example.restaurantwebsite.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TableServiceImpl implements TableService {
    private TableMapper tableMapper;

    @Autowired
    public TableServiceImpl(TableMapper tableMapper) {
        this.tableMapper = tableMapper;
    }

    @Override
    public PageInfo<Table> getTablePage(Integer pageNum) {
        PageHelper.startPage(pageNum, PageSize.PAGE_NUMBER);
        List<Table> tableList = tableMapper.getAllTable();
        return new PageInfo<Table>(tableList, PageSize.NAVIGATES_PAGE_NUMBER);
    }

    @Override
    public List<Table> getAllTable() {
        return tableMapper.getAllTable();
    }

    @Override
    public Table getTable(Integer tableId) {
        return tableMapper.getTable(tableId);
    }

    @Override
    public void insertTable(Table table) {
        tableMapper.insertTable(table);
    }

    @Override
    public void updateTable(Table table) {
        tableMapper.updateTable(table);
    }

    @Override
    public void deleteTable(Integer tableId) {
        tableMapper.deleteTable(tableId);
    }
}
