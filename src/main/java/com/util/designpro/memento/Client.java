package com.util.designpro.memento;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState(1);
        careTaker.addMemento(originator.saveMemento());
        originator.setState(2);
        careTaker.addMemento(originator.saveMemento());
        Memento memento = careTaker.getMemento(1);
        System.out.println(memento.getState());
    }
}
