package org;
public enum UserType {
    VETERAN(10), // 국가유공자: 10% 할인
    SOLDIER(5),  // 군인: 5% 할인
    STUDENT(3),  // 학생: 3% 할인
    GENERAL(0);  // 일반인: 0% 할인

    private final int discountRate;

    UserType(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getDiscountRate() {
        return discountRate;
    }
}