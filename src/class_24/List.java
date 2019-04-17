package class_24;

public interface List {
    void addFirst(Node node);
    boolean removeFirst();

    void addLast(Node node);
    boolean removeLast();

    boolean removeAny(int value);

    boolean contains(int value);
    void enumerate();
}
