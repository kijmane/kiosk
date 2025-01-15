package org;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 메뉴 항목들 생성
        // 버거 메뉴 항목 생성
        List<MenuItem> burgerMenu = Arrays.asList(
                new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
                new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
                new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
                new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거")
        );
        // 음료 메뉴 항목 생성
        List<MenuItem> drinkMenu = Arrays.asList(
                new MenuItem("Coke", 2.0, "콜라"),
                new MenuItem("Sprite", 1.8, "스프라이트")
        );
        // 디저트 메뉴 항목 생성
        List<MenuItem> dessertMenu = Arrays.asList(
                new MenuItem("Chocolate Shake", 4.5, "초콜릿 쉐이크"),
                new MenuItem("Vanilla Shake", 4.5, "바닐라 쉐이크")
        );

        // Kiosk 객체 생성 및 시작
        // Kiosk 객체를 생성하며 각 메뉴 항목 전달함
        Kiosk kiosk = new Kiosk(burgerMenu, drinkMenu, dessertMenu);
        // Kiosk 객체의 start() 메서드 호출 프로그램 실행함
        kiosk.start();
    }
}