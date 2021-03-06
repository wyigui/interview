package ReferenceQueue;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class TestRef {
    public static void main(String[] args) {
        //创建一个对象
        Person person = new Person("Sunny");
        //创建一个引用队列
        ReferenceQueue<Person> rq = new ReferenceQueue<>();
        //创建一个虚引用，让此虚引用引用到person对象
        PhantomReference<Person> pr = new PhantomReference<>(person, rq);
        //切断person引用变量和对象的引用
        System.out.println(rq.poll() == pr);
        person = null;
        //试图取出虚引用所引用的对象
        //发现程序并不能通过虚引用访问被引用对象，所以此处输出为null
        System.out.println(pr.get());
        //强制垃圾回收
        System.gc();
        System.runFinalization();
        //因为一旦虚引用中的对象被回收后，该虚引用就会进入引用队列中
        //所以用队列中最先进入队列中引用与pr进行比较，输出true
        System.out.println(rq.poll() == pr);
        StringBuilder stringBuilder = new StringBuilder();
    }


}

class Person {
    private String name;
    private int age;

    public Person(String name) {
        this.name = name;
    }
}
