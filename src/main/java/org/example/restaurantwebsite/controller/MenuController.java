package org.example.restaurantwebsite.controller;

import com.github.pagehelper.PageInfo;
import org.example.restaurantwebsite.pojo.Menu;
import org.example.restaurantwebsite.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class MenuController {
    private MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menu/page/{pageNum}")
    public String getMenuPage(@PathVariable("pageNum") Integer pageNum, Model model) {
        PageInfo<Menu> page = menuService.getMenuPage(pageNum);
        model.addAttribute("page", page);
        return "menu_list";
    }

    @GetMapping("/menu/{menuId}")
    public String getMenu(@PathVariable("menuId") Integer menuId, Model model) {
        Menu menu = menuService.getMenu(menuId);
        model.addAttribute("menu", menu);
        return "menu_update";
    }

    @PostMapping("/menu")
    public String addMenu(HttpSession session, Menu menu, MultipartFile photo) throws IOException {
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");

        File file = new File(photoPath);
        if(!file.exists()) {
            file.mkdir();
        }

        String filename = photo.getOriginalFilename();
        String finalFileName = UUID.randomUUID() + filename.substring(filename.lastIndexOf("."));
        String finalPath = photoPath + File.separator + finalFileName;
        photo.transferTo(new File(finalPath));

        menu.setMenuImageUrl("../../../photo/" + finalFileName);
        menuService.insertMenu(menu);
        return "redirect:/admin/menu/page/1";
    }

    @PutMapping("/menu")
    public String updateMenu(Menu menu) {
        menuService.updateMenu(menu);
        return "redirect:/admin/menu/page/1";
    }

    @DeleteMapping("/menu/{pageNum}/{menuId}")
    public String deleteMenu(@PathVariable("pageNum") Integer pageNum, @PathVariable("menuId") Integer menuId) {
        menuService.deleteMenu(menuId);
        return "redirect:/admin/menu/page/" + pageNum;
    }
}
