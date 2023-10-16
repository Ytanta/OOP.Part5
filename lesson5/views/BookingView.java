package geekbrains.lesson5.views;

import geekbrains.lesson5.models.Table;
import geekbrains.lesson5.presenters.View;
import geekbrains.lesson5.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private ViewObserver observer;

    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    /**
     * Отобразить столики на экране приложения
     *
     * @param tables коллекция столиков
     */
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер бронирования
     */
    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0){
            System.out.printf("Столик успешно забронирован. Номер вашей брони: #%d\n", reservationNo);
        }
        else {
            System.out.println("Не удалось забронировать столик, повторите попытку позже.");
        }
    }


    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    public void reservationTable(Date orderDate, int tableNo, String name){
        if (observer != null)
            observer.onReservationTable(orderDate, tableNo, name);

    }

    /**
     * TODO: Доработать в рамках домашней работы
     * Действие клиента, отмена бронирования столика
     * @param oldReservation идентификатор бронирования (старый)
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    @Override
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        if (observer != null) {
            observer.onUpdateReservetionTable(oldReservation, reservationDate, tableNo, name);
        }
    }

    @Override
    public void showСhangeReservationTable(int newReservationNumber, int newNumberTable) {
        if (newReservationNumber > 0) {
            System.out.printf(
                    "Изменение брони прошло успешно. По номеру брони №%d изменен номер столика. Новый номер столика №%d\n",
                    newReservationNumber, newNumberTable);
        } else {
            System.out.println("Что-то пошло не так, попробуйте повторить попытку позже.");
        }
    }
}

