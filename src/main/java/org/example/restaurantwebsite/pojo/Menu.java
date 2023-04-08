package org.example.restaurantwebsite.pojo;

public class Menu {
    private Integer menuId;
    private String menuName;
    private Float menuPrice;
    private String menuImageUrl;

    public Menu() {
    }

    public Menu(Integer menuId, String menuName, Float menuPrice, String menuImageUrl) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuImageUrl = menuImageUrl;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Float getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(Float menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuImageUrl() {
        return menuImageUrl;
    }

    public void setMenuImageUrl(String menuImageUrl) {
        this.menuImageUrl = menuImageUrl;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", menuImageUrl='" + menuImageUrl + '\'' +
                '}';
    }
}
