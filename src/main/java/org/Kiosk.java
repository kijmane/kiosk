package org;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Kiosk {
    private List<MenuItem> burgerMenu;
    private List<MenuItem> drinkMenu;
    private List<MenuItem> dessertMenu;
    private List<MenuItem> cart = new ArrayList<>();  // 장바구니 (구매할 메뉴를 담는 곳)

    // Kiosk 생성자 : 메뉴 항목들을 받고 각각의 메뉴를 초기화한다!
    public Kiosk(List<MenuItem> burgerMenu, List<MenuItem> drinkMenu, List<MenuItem> dessertMenu) {
        this.burgerMenu = burgerMenu;
        this.drinkMenu = drinkMenu;
        this.dessertMenu = dessertMenu;
    }

    // Kiosk 시작 메소드 (start())
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // MAIN MENU 출력 (사용자에게 메뉴 카테고리를 선택하도록 함)
            System.out.println("[ MAIN MENU ]");
            System.out.println("1. Burgers");
            System.out.println("2. Drinks");
            System.out.println("3. Desserts");
            System.out.println("0. 종료");
            System.out.print("카테고리를 선택하세요: ");
            int categoryChoice = scanner.nextInt();
            // 종료 조건
            if (categoryChoice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            // 각 메뉴에 맞는 서브 메뉴 호출
            if (categoryChoice == 1) {
                burgerMenu(scanner);
            } else if (categoryChoice == 2) {
                drinkMenu(scanner);
            } else if (categoryChoice == 3) {
                dessertMenu(scanner);
            }

            // 장바구니에 물건이 있다면 주문 메뉴 출력
            if (!cart.isEmpty()) {
                System.out.println("\n장바구니에 물건이 있습니다.");
                showOrderMenu(scanner);
            }
        }
    }

    // 햄버거 메뉴 선택 메서드
    private void burgerMenu(Scanner scanner) {
        System.out.println("[ BURGERS MENU ]");
        // burgerMenu 리스트의 모든 항목을 출력
        burgerMenu.forEach(item -> System.out.println(burgerMenu.indexOf(item) + 1 + ". " + item));
        System.out.println("0. 뒤로가기");
        System.out.print("메뉴를 선택하세요: ");
        int menuChoice = scanner.nextInt();
        // 선택한 메뉴 아이템
        MenuItem selectedItem = burgerMenu.get(menuChoice - 1);
        System.out.println("선택한 메뉴: " + selectedItem);
        System.out.print("장바구니에 추가하시겠습니까? (1. 확인, 2. 취소): ");
        int addChoice = scanner.nextInt();
        // 장바구니에 추가
        if (addChoice == 1) {
            cart.add(selectedItem);
            System.out.println(selectedItem.getName() + "이 장바구니에 추가되었습니다.");
        }
    }

    // 음료 메뉴 선택 메서드
    private void drinkMenu(Scanner scanner) {
        System.out.println("[ DRINKS MENU ]");
        // drinkMenu의 모든 항목 출력됨 (람다 사용)
        drinkMenu.forEach(item -> System.out.println(drinkMenu.indexOf(item) + 1 + ". " + item));
        System.out.println("0. 뒤로가기");
        System.out.print("메뉴를 선택하세요: ");
        int menuChoice = scanner.nextInt();

        if (menuChoice == 0) {
            return;
        }
        // 선택한 메뉴 아이템
        MenuItem selectedItem = drinkMenu.get(menuChoice - 1);
        System.out.println("선택한 메뉴: " + selectedItem);
        System.out.print("장바구니에 추가하시겠습니까? (1. 확인, 2. 취소): ");
        int addChoice = scanner.nextInt();
        // 장바구니에 추가
        if (addChoice == 1) {
            cart.add(selectedItem);
            System.out.println(selectedItem.getName() + "이 장바구니에 추가되었습니다.");
        }
    }

    // 디저트에 메뉴 선택 메서드
    private void dessertMenu(Scanner scanner) {
        System.out.println("[ DESSERTS MENU ]");
        // dessertMenu 리스트의 모든 항목을 출력 (람다 사용)
        dessertMenu.forEach(item -> System.out.println(dessertMenu.indexOf(item) + 1 + ". " + item));
        System.out.println("0. 뒤로가기");
        System.out.print("메뉴를 선택하세요: ");
        int menuChoice = scanner.nextInt();

        if (menuChoice == 0) {
            return;
        }
        // 선택한 메뉴 아이템
        MenuItem selectedItem = dessertMenu.get(menuChoice - 1);
        System.out.println("선택한 메뉴: " + selectedItem);
        System.out.print("장바구니에 추가하시겠습니까? (1. 확인, 2. 취소): ");
        int addChoice = scanner.nextInt();
        // 장바구니에 추가함
        if (addChoice == 1) {
            cart.add(selectedItem);
            System.out.println(selectedItem.getName() + "이 장바구니에 추가되었습니다.");
        }
    }

    // 장바구니 총합 계산 메서드 (스트림 사용)
    public double getTotalAmount() {
        // 스트림을 사용하여 장바구니 아이템들의 총합 계산
        return cart.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    // 할인 적용 메서드
    public void applyDiscount(Scanner scanner, double totalAmount) {
        System.out.println("[ 할인 정보 ]");
        System.out.println("1. 국가유공자 : 10%");
        System.out.println("2. 군인 : 5%");
        System.out.println("3. 학생 : 3%");
        System.out.println("4. 일반 : 0%");
        System.out.print("할인 정보를 입력해주세요: ");
        int userType = scanner.nextInt();

        double discount = 0;
        // 할인율 설정
        if (userType == 1) {
            discount = 0.1;  // 10%
        } else if (userType == 2) {
            discount = 0.05;  // 5%
        } else if (userType == 3) {
            discount = 0.03;  // 3%
        }
        // 할인 적용 후 금액 계산
        double discountedAmount = totalAmount * (1 - discount);
        System.out.println("주문이 완료되었습니다. 금액은 W " + String.format("%.1f", discountedAmount) + "입니다.");
    }

    // 주문 메뉴 출력 및 장바구니 확인
    private void showOrderMenu(Scanner scanner) {
        System.out.println("[ ORDER MENU ]");
        System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
        System.out.print("메뉴를 선택하세요: ");
        int orderChoice = scanner.nextInt();

        if (orderChoice == 4) {
            // 장바구니 항목 출력
            System.out.println("[ Orders ]");
            cart.forEach(item -> System.out.println(item)); // 스트림을 사용해서 장바구니 항목 출력
            double totalAmount = getTotalAmount();
            System.out.println("\n[ Total ]");
            System.out.println("W " + totalAmount);
            // 주문 확인
            System.out.println("1. 주문      2. 메뉴판");
            int orderConfirm = scanner.nextInt();
            if (orderConfirm == 1) {
                applyDiscount(scanner, totalAmount); // 할인 적용함
            }
        } else if (orderChoice == 5) {
            System.out.println("주문이 취소되었습니다.");
        }
    }
}