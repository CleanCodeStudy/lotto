package com.javabom.lotto.domain.number;

import java.util.Objects;

public class OrderGameNumber {
    private static final int MIN_ORDER_NUMBER = 1;
    private static final int MAX_ORDER_NUMBER = 7;

    private final int order;
    private final GameNumber gameNumber;

    private OrderGameNumber(final int order, final GameNumber gameNumber) {
        this.order = order;
        this.gameNumber = gameNumber;
    }

    public static OrderGameNumber of(int order, final GameNumber gameNumber) {
        checkOrderRange(order);
        return new OrderGameNumber(order, gameNumber);
    }

    public static OrderGameNumber of(int order, final String strGameNumber) {
        return OrderGameNumber.of(order, GameNumber.valueOf(strGameNumber));
    }

    private static void checkOrderRange(final int order) {
        if (order < MIN_ORDER_NUMBER || order > MAX_ORDER_NUMBER) {
            throw new IllegalArgumentException(String.format("%d, 게임 숫자의 인덱스 범위는 1-6 이어야 합니다.", order));
        }
    }

    public boolean equalsOfNumber(final OrderGameNumber orderGameNumber) {
        return this.gameNumber.equals(orderGameNumber.gameNumber);
    }

    public GameNumber numberValue() {
        return this.gameNumber;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderGameNumber)) return false;
        final OrderGameNumber that = (OrderGameNumber) o;
        return order == that.order &&
                Objects.equals(gameNumber, that.gameNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, gameNumber);
    }
}
