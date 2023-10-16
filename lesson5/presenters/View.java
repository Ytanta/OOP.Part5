package geekbrains.lesson5.presenters;

import geekbrains.lesson5.models.Table;

import java.util.Collection;
import java.util.Date;

public interface View {

    /**
     * Отображение списка столиков в приложении
     * @param tables список столиков
     */
    void showTables(Collection<Table> tables);

    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер бронирования
     */
    void showReservationTableResult(int reservationNo);
    void showСhangeReservationTable(int reservationNo, int tableNo);


    /**
     * Добавить наблюдателя за представлением
     * @param observer наблюдатель
     */
    void setObserver(ViewObserver observer);

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    void reservationTable(Date orderDate, int tableNo, String name);
    void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);




}
