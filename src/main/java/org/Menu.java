package org;
import java.util.List;
public class Menu {
    // 카테고리 이름 (버거, 음료, 디저트 등)
    private String categoryName;
    // 해당 카테고리 내의 메뉴 항목 리스트
    private List<MenuItem> menuItems;
    // 생성자 : 카테고리 이름과 메뉴 항목 리스트를 초기화
    public Menu(String categoryName, List<MenuItem> menuItems) {
        this.categoryName = categoryName;
        this.menuItems = menuItems;
    }
    // 카테고리 이름 반환
    public String getCategoryName() {
        return categoryName;
    }
    // 카테고리의 메뉴 항목 리스트 반환
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
    // 카테고리 메뉴 항목들을 번호와 함께 출력하는 메서드!
    public void displayMenu() {
        // 메뉴 항목 리스트를 순회하고 번호와 함께 출력함
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i));
        }
    }
}