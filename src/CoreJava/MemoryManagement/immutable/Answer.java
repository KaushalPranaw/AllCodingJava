package CoreJava.MemoryManagement.immutable;

import java.util.*;

public class Answer {

    // Change these boolean values to control whether you see
    // the expected result and/or hints.
    static boolean showExpectedResult = false;
    static boolean showHints = false;

    // Create a new ImmutableCollectionHolder with a list
    static ImmutableCollectionHolder createImmutableCollectionHolder(List<String> strings) {
        return new ImmutableCollectionHolder(strings);
    }

}

class ImmutableCollectionHolder {
    private final List<String> items;

    public ImmutableCollectionHolder(List<String> items) {
        List<String> list=new ArrayList<>();
        list.addAll(items);
        this.items = Collections.unmodifiableList(list);
    }

    public List<String> getItems() {
        return items;
    }

    /*WeakReference<Person> p=new WeakReference<>(new Person());
    Person p1=p.get();

    SoftReference<Person> p=new SoftReference<>(new Person());
    Person p1=p.get();

    PhantomReference<Person> p=new PhantomReference<>(new Person(), new ReferenceQueue<>());
    Person p1=p.get();*/
}