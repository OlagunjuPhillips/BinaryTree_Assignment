public class Node<Type> {
    public Type key;
    public Node<Type> left, right;

    public Node(Type key){
        this.key = key;
        left = right = null;
    }
}
