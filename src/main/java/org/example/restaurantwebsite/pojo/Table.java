package org.example.restaurantwebsite.pojo;

public class Table {
    private Integer tableId;
    private Integer tableSpace;
    private String tableName;

    public Table() {
    }

    public Table(Integer tableId) {
        this.tableId = tableId;
    }

    public Table(Integer tableId, Integer tableSpace, String tableName) {
        this.tableId = tableId;
        this.tableSpace = tableSpace;
        this.tableName = tableName;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getTableSpace() {
        return tableSpace;
    }

    public void setTableSpace(Integer tableSpace) {
        this.tableSpace = tableSpace;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableId=" + tableId +
                ", tableSpace=" + tableSpace +
                ", tableName='" + tableName + '\'' +
                '}';
    }
}
