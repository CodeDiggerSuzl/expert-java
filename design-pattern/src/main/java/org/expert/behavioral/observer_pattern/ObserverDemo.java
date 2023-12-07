package org.expert.behavioral.observer_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者设计模式是一种行为型设计模式，它用于在对象之间建立一种一对多的依赖关系，使得当一个对象状态发生改变时，所有依赖它的对象都能得到通知并自动更新。
 * <p>
 * 该模式包括以下角色：
 * <p>
 * 1. Subject（主题）：它是被观察的对象，它维护一组观察者对象，并在状态发生改变时通知观察者。
 * 2. Observer（观察者）：它定义了一个更新接口，使得在接收到主题通知时能够更新自己的状态。
 * 3. ConcreteSubject（具体主题）：它是主题的具体实现，负责维护其状态，并在状态改变时通知观察者。
 * 4. ConcreteObserver（具体观察者）：它是观察者的具体实现，实现更新接口以便接收主题的通知并进行相应的更新操作。
 * <p>
 * 观察者设计模式可以在许多场景中使用，例如事件处理系统、发布-订阅系统等。它通过解耦主题和观察者之间的关系，提高了系统的灵活性和可扩展性。
 */
public class ObserverDemo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer = new ConcreteObserver(subject);

        subject.setState(10); // 输出：Observer state updated to: 10

        subject.unregisterObserver(observer);

        subject.setState(20); // 输出：Observer state updated to: 20
    }
}

// 主题接口
interface Subject {
    void registerObserver(Observer observer);

    void unregisterObserver(Observer observer);

    void notifyObservers();
}

// 具体主题类
class ConcreteSubject implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// 观察者接口
interface Observer {
    void update();
}

// 具体观察者类
class ConcreteObserver implements Observer {
    private final ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    public void update() {
        int observerState = subject.getState();
        System.out.println("Observer state updated to: " + observerState);
    }
}

