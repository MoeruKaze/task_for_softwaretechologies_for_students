package org.softwaretechnologies;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import static java.lang.Integer.MAX_VALUE;

public class Money {
    private final MoneyType type;
    private final BigDecimal amount;

    public Money(MoneyType type, BigDecimal amount) {
        this.type = type;
        this.amount = amount;
    }

    /**
     * Money равны, если одинаковый тип валют и одинаковое число денег до 4 знака после запятой.
     * Округление по правилу: если >= 5, то в большую сторону, интаче - в меньшую
     * Пример округления:
     * BigDecimal scale = amount.setScale(4, RoundingMode.HALF_UP);
     *
     * @param o объект для сравнения
     * @return true - равно, false - иначе
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money othermoney = (Money) o;
        if (type != othermoney.type) return false;
        if (amount == null && othermoney.amount == null) return true;
        if (amount == null || othermoney.amount == null) return false;
        BigDecimal thisScaled = this.amount.setScale(4,RoundingMode.HALF_UP);
        BigDecimal otherScaled = othermoney.amount.setScale(4,RoundingMode.HALF_UP);

        return thisScaled.equals(otherScaled);
    }

    /**
     * Формула:
     * (Если amount null 10000, иначе количество денег окрукленные до 4х знаков * 10000) + :
     * если USD , то 1
     * если EURO, то 2
     * если RUB, то 3
     * если KRONA, то 4
     * если null, то 5
     * Если amount округленный до 4х знаков * 10000 >= (Integer.MaxValue - 5), то хеш равен Integer.MaxValue
     * Округление по правилу: если >= 5, то в большую сторону, иначе - в меньшую
     * Пример округления:
     * BigDecimal scale = amount.setScale(4, RoundingMode.HALF_UP);
     *
     * @return хеш код по указанной формуле
     */
    @Override
    public int hashCode() {
        BigDecimal scaledAmount = amount != null ? amount.setScale(4, RoundingMode.HALF_UP) : null;

        long amountPart;
        if (scaledAmount == null) amountPart = 10000L;
        else {
            amountPart = (long)(scaledAmount.doubleValue()*10000.0);
        }

        int currencyCod;
        if (type == null) {
            currencyCod = 5;
        }
        else{
            switch (type) {
                case USD: currencyCod = 1; break;
                case EURO: currencyCod = 2; break;
                case RUB: currencyCod = 3; break;
                case KRONA: currencyCod = 4; break;
                default: currencyCod = 5; break;
            }
        }
        long hash = amountPart + currencyCod;
        if (hash >= (MAX_VALUE)-5) return MAX_VALUE;
        return (int) hash;
    }

    /**
     * Верните строку в формате
     * Тип_ВАЛЮТЫ: количество.XXXX
     * Тип_валюты: USD, EURO, RUB или KRONA
     * количество.XXXX - округленный amount до 4х знаков.
     * Округление по правилу: если >= 5, то в большую сторону, интаче - в меньшую
     * BigDecimal scale = amount.setScale(4, RoundingMode.HALF_UP);
     * <p>
     * Если тип валюты null, то вернуть:
     * null: количество.XXXX
     * Если количество денег null, то вернуть:
     * Тип_ВАЛЮТЫ: null
     * Если и то и то null, то вернуть:
     * null: null
     *
     * @return приведение к строке по указанному формату.
     */
    @Override
    public String toString() {
        String typeStr = (type == null) ? "null" : type.toString();
        String amountStr = (amount == null) ? "null" : (amount.setScale(4, RoundingMode.HALF_UP).toString());
        String str = type.toString()+": "+amount.setScale(4, RoundingMode.HALF_UP).toString();
        return typeStr + ": " + amountStr;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public MoneyType getType() {
        return type;
    }

    public static void main(String[] args) {
        Money money = new Money(MoneyType.USD, BigDecimal.valueOf(0.0000));
        Money money1 = new Money(MoneyType.USD, BigDecimal.valueOf(1.0000));
        System.out.println(money.equals(money1));
        System.out.println(money.hashCode());
        System.out.println(money1.hashCode());
    }
}
