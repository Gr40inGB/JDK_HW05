Death lock исключается путём строгой иерархии объектов блокировки (вилок) ()

```java
public class Philosopher extends Thread {

    private String name;
    private Fork forkFirst;
    private Fork forkSecond;
    public int placeOnTable;
    public int needToEatCount = 3;

    public Philosopher(int placeOnTable, String name, Fork leftFork, Fork rightFork) {
        this.placeOnTable = placeOnTable;
        this.name = name;
        forkFirst = leftFork.compareTo(rightFork) < 0 ? leftFork : rightFork;
        forkSecond = leftFork.compareTo(rightFork) > 0 ? leftFork : rightFork;
    }

    @Override
    public void run() {
        while (needToEatCount > 0) {
            synchronized (forkFirst) {
                synchronized (forkSecond) {
                    eat();
                    needToEatCount--;
                }
            }
            think();
        }
    }

```
организовал некую визуализацию потоков

eat 500  / think 500

```
[1. Aristotle [Fork 0, Fork 1], 2. Plato [Fork 1, Fork 2], 3. Socrates [Fork 2, Fork 3], 4. Confucius [Fork 3, Fork 4], 5. Immanuel Kant [Fork 0, Fork 4]]


 + - eating; . - thinking; ' ' - waiting

1.                 ++++++++++++++++................                ++++++++++++++++................++++++++++++++++................
2. ++++++++++++++++................                ++++++++++++++++................++++++++++++++++.................
3.                                  ++++++++++++++++................++++++++++++++++................                 ++++++++++++++++.................
4.                 ++++++++++++++++................++++++++++++++++................                +++++++++++++++++................
5. ++++++++++++++++................++++++++++++++++................                ++++++++++++++++.................
```
eat 500  / think 200
```
 + - eating; . - thinking; ' ' - waiting

1. ++++++++++++++++......                                           ++++++++++++++++......          +++++++++++++++++......
2.                 ++++++++++++++++......          ++++++++++++++++......         ++++++++++++++++.......
3. ++++++++++++++++......          ++++++++++++++++......          ++++++++++++++++......
4.                 ++++++++++++++++......          ++++++++++++++++......                          +++++++++++++++++......
5.                                  ++++++++++++++++......                          ++++++++++++++++......          +++++++++++++++++......
```

eat 200  / think 500

```
 + - eating; . - thinking; ' ' - waiting

1. ++++++................+++++++.................++++++................
2.       ++++++.................++++++.................++++++................
3. ++++++................+++++++................+++++++................
4.              ++++++.................++++++................++++++................
5.       ++++++.................++++++.................++++++................
```