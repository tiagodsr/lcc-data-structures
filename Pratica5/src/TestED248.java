import java.util.*;

class BooleanArrayIntSet implements IntSet {
    private boolean[] set;
    private int size;

    public BooleanArrayIntSet(int n) {
        set = new boolean[n + 1];
        size = 0;
    }

    @Override
    public boolean contains(int x) {
        if (x < 1 || x >= set.length) return false;
        return set[x];
    }

    @Override
    public boolean add(int x) {
        if (x < 1 || x >= set.length) return false;
        if (!set[x]) {
            set[x] = true;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int x) {
        if (x < 1 || x >= set.length) return false;
        if (set[x]) {
            set[x] = false;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 1; i < set.length; i++) {
            set[i] = false;
        }
        size = 0;
    }

    @Override
    public boolean equals(IntSet s) {
        if (s instanceof BooleanArrayIntSet) {
            BooleanArrayIntSet other = (BooleanArrayIntSet) s;
            if (this.size != other.size) return false;

            for (int i = 1; i < set.length; i++) {
                if (this.set[i] != other.set[i]) return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public IntSet intersection(IntSet s) {
        if (s instanceof BooleanArrayIntSet) {
            BooleanArrayIntSet auxiliar = (BooleanArrayIntSet) s;
            int maxSize = Math.min(this.set.length, auxiliar.set.length) - 1;
            BooleanArrayIntSet result = new BooleanArrayIntSet(maxSize);

            for (int i = 1; i <= maxSize; i++) {
                if (this.set[i] && auxiliar.set[i]) {
                    result.add(i);
                }
            }
            return result;
        }
        return null;
    }
}

public class TestED248 {
    public static void main(String[] args) {
        int n = 1000000;
        IntSet s = new BooleanArrayIntSet(n); // Criar array de booleanos para numeros no intervalo [1,n]
        boolean tmp;

        System.out.println("Adicionando todos os numeros entre 1 e " + n + "...");
        for (int i=1; i<=n; i++)
            tmp = s.add(i);

        System.out.println("Adicionando novamente todos os numeros entre 1 e " + n + "...");
        for (int i=1; i<=n; i++)
            tmp = s.add(i);

        System.out.println("Verificando se todos os numeros entre 1 e " + n + " existem...");
        for (int i=1; i<=n; i++)
            tmp = s.contains(i);

        System.out.println("Removendo todos os numeros entre 1 e " + n + "...");
        for (int i=1; i<=n; i++)
            tmp = s.remove(i);
    }
}
