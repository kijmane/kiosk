package org;

public class MenuItem {
    private String name;
    private double price;
    private String description;
    // 생성자 : 메뉴 항목의 이름, 가격, 설명을 초기화
    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getter , Setter 메서드
    // 메뉴 항목 이름을 반환함
    public String getName() {
        return name;
    }
    // 메뉴 항목 이름을 설정함
    public void setName(String name) {
        this.name = name;
    }
    // 메뉴 항목 가격을 반환함
    public double getPrice() {
        return price;
    }
    // 메뉴 항목 가격을 설정함
    public void setPrice(double price) {
        this.price = price;
    }
    // 메뉴 항목 설명을 반환함
    public String getDescription() {
        return description;
    }
    // 메뉴 항목의 설명 설정함
    public void setDescription(String description) {
        this.description = description;
    }
    // toString 메서드 : 메뉴 항목의 이름이나 가격, 설명을 문자열로 반환함
    @Override
    public String toString() {
        return name + " | W " + price + " | " + description;
    }
}