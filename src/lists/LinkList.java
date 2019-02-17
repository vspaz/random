package lists;

public interface LinkList {
    void addFirst(Node node);
    void addLast(Node node);
    boolean removeFirst();
    boolean removeLast();
    boolean removeAny(int value);

    boolean contains(int value);
    void enumerate();
}
