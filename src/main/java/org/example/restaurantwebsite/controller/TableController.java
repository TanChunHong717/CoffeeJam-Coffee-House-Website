package org.example.restaurantwebsite.controller;

import com.github.pagehelper.PageInfo;
import org.example.restaurantwebsite.pojo.Table;
import org.example.restaurantwebsite.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class TableController {
    private TableService tableService;

    @Autowired
    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("/table/page/{pageNum}")
    public String getTablePage(@PathVariable("pageNum") Integer pageNum, Model model) {
        PageInfo<Table> page = tableService.getTablePage(pageNum);
        model.addAttribute("page", page);
        return "table_list";
    }

    @GetMapping("/table/{tableId}")
    public String getTable(@PathVariable("tableId") Integer tableId, Model model) {
        Table table = tableService.getTable(tableId);
        model.addAttribute("table", table);
        return "table_update";
    }

    @PostMapping("/table")
    public String insertTable(Table table) {
        tableService.insertTable(table);
        return "redirect:/admin/table/page/1";
    }

    @PutMapping("/table")
    public String updateTable(Table table) {
        tableService.updateTable(table);
        return "redirect:/admin/table/page/1";
    }

    @DeleteMapping("/table/{pageNum}/{tableId}")
    public String deleteTable(@PathVariable("pageNum") Integer pageNum, @PathVariable("tableId") Integer tableId) {
        tableService.deleteTable(tableId);
        return "redirect:/admin/table/page/" + pageNum;
    }
}
