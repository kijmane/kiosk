package org;
public enum UserType {
    VETERAN(10), // 국가유공자: 10% 할인
    SOLDIER(5),  // 군인: 5% 할인
    STUDENT(3),  // 학생: 3% 할인
    GENERAL(0);  // 일반인: 0% 할인
    // 할인율을 변수에 저장함
    private final int discountRate;
    // 사용자 유형에 대해 할인율 초기화함
    UserType(int discountRate) {
        this.discountRate = discountRate;
    }
    // 할인율을 반환하는 메서드
    public int getDiscountRate() {
        return discountRate;
    }
}