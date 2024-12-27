import java.util.ArrayList;

class ArrayListIntSet implements IntSet {
    private ArrayList<Integer> ALIS;
    private int tamanho;

    public ArrayListIntSet(int maxSize) {
        this.ALIS = new ArrayList<>();
        this.tamanho = maxSize;
    }

    public boolean contains(int x) {
        return ALIS.contains(x);
    }

    public boolean add(int x) {
        if (!ALIS.contains(x) && ALIS.size() < tamanho) {
            ALIS.add(x);
            return true;
        }
        return false;
    }

    public boolean remove(int x) {
        return ALIS.remove(Integer.valueOf(x));
    }

    public int size() {
        return ALIS.size();
    }

    public void clear() {
        ALIS.clear();
    }

    public boolean equals(IntSet s) {
        if (this.size() != s.size()) {
            return false;
        }
        for (int num : ALIS) {
            if (!s.contains(num)) {
                return false;
            }
        }
        return true;
    }

    public IntSet intersection(IntSet s) {
        ArrayListIntSet resultSet = new ArrayListIntSet(this.tamanho);
        for (int num : ALIS) {
            if (s.contains(num)) {
                resultSet.add(num);
            }
        }
        return resultSet;
    }
}

public class TestED247 {
    public static void main(String[] args) {
        IntSet s1 = new ArrayListIntSet(100);
        IntSet s2 = new ArrayListIntSet(100);

        for (int i=1; i<=5; i++)
            s1.add(i);
        System.out.println("s1 = " + s1 + " | tamanho = " + s1.size());

        for (int i=3; i<=7; i++)
            s2.add(i);
        System.out.println("s2 = " + s2 + " | tamanho = " + s2.size());

        IntSet s3 = s1.intersection(s2);
        System.out.println("s3 = " + s3 + " | tamanho = " + s3.size());

        IntSet s4 = s2.intersection(s1);
        System.out.println("s4 = " + s4 + " | tamanho = " + s4.size());

        System.out.println("s1.equals(s2) = " + s1.equals(s2));
        System.out.println("s3.equals(s4) = " + s3.equals(s4));
    }
}