import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Node<T> { //not an inner class for ease of testing
    T       data;
    Node<T> left;
    Node<T> right;

    public Node(T data) {
        this(data, null, null);
    }

    public Node(T data, Node<T> left, Node<T> right) {
        this.data  = data;
        this.left  = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "" + this.data;
    }
}

public class BinaryTree<T>
{
    private Node<T> overallRoot;

    /** Construct an empty tree */
    public BinaryTree() { }

    /** Construct a binary tree given a pre-built tree */
    public BinaryTree(Node<T> overallRoot) {
        this.overallRoot = overallRoot;
    }

    public Node<T> getRoot() { return this.overallRoot; }


    public void reflect()
    {
        reflect(overallRoot);
    }

    private void reflect(Node root) {
        if (root == null) {
            return;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        reflect(root.left);
        reflect(root.right);
    }

    public Node build(int levels, String s) {
        if (levels == 0) {
            return null;
        }
        Node root = new Node(s);
        root.left = build(levels - 1, s);
        root.right = build(levels - 1, s);
        return root;
    }

    public void save(String fileName)
    {
        save(overallRoot, fileName);
    }

    public void save(Node root, String fileName) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName));
            saveHelper(root, out);
            out.close();
        } catch (IOException io) {
            System.out.println("Error caught");
        }
    }

    private void saveHelper(Node root, PrintWriter out) {
        if (root == null) {
            out.print("$ ");
            return;
        }

        out.print(root.data + " ");
        saveHelper(root.left, out);
        saveHelper(root.right, out);
    }

    public void load(String file) {
        Scanner in = null;
        try {
            in = new Scanner(new File(file));
        } catch (IOException io) {
            System.out.print("Can't print to file");
        }
        this.overallRoot = this.load(in);
    }

    private Node<T> load(Scanner in)
    {
        if (!in.hasNextLine())
            return null;
        String s = in.nextLine().trim();
        if (s.equals("$"))
            return null;
        Node<T> n = new Node<>((T) (Integer) Integer.parseInt(s));

        n.left = this.load(in);
        n.right = this.load(in);

        return n;
    }

\