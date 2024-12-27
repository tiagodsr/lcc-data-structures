class BigNumber {
    String numero;

    public BigNumber(String numero) {
        this.numero = numero;
    }

    public boolean equals(BigNumber other) {
        return this.numero.equals(other.numero);
    }

    @Override
    public String toString() {
        return this.numero;
    }

    public BigNumber add(BigNumber other) {
        String resultado = adicionarStrings(this.numero, other.numero);
        return new BigNumber(resultado);
    }

    public BigNumber multiply(BigNumber other) {
        String resultado = multiplicarStrings(this.numero, other.numero);
        return new BigNumber(resultado);
    }

    private String adicionarStrings(String num1, String num2) {
        StringBuilder resultado = new StringBuilder();

        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digito1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digito2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;

            int soma = digito1 + digito2 + carry;
            carry = soma / 10;
            resultado.append(soma % 10);
        }

        return resultado.reverse().toString();
    }
    private String multiplicarStrings(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] resultado = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int multiplicacao = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int soma = multiplicacao + resultado[i + j + 1];

                resultado[i + j + 1] = soma % 10;
                resultado[i + j] += soma / 10;
            }
        }

        StringBuilder resultadoStr = new StringBuilder();
        for (int num : resultado) {
            if (!(resultadoStr.length() == 0 && num == 0)) {
                resultadoStr.append(num);
            }
        }

        return (resultadoStr.length() == 0) ? "0" : resultadoStr.toString();
    }
}

class TestBigNumber {
    public static void main(String[] args) {
        BigNumber n1 = new BigNumber("1234567890");
        System.out.println(n1); // Escreve "1234567890"

        BigNumber n2 = new BigNumber("42");
        BigNumber n3 = new BigNumber("1234567890");
        System.out.println(n1.equals(n2)); // Escreve "false"
        System.out.println(n1.equals(n3)); // Escreve "true"

        BigNumber n4 = new BigNumber("46711237126582920746212");
        BigNumber n5 = new BigNumber("8765432110");
        BigNumber n6 = n1.add(n3);
        System.out.println(n6); // Escreve "2469135780"
        BigNumber n7 = n1.add(n4);
        System.out.println(n7); // Escreve "46711237126584155314102"
        BigNumber n8 = n1.add(n5);
        System.out.println(n8); // Escreve "10000000000"

        BigNumber n9 = n1.multiply(n3);
        System.out.println(n9); // Escreve "1524157875019052100"
        BigNumber n10 = n1.multiply(n4);
        System.out.println(n10); // Escreve "57668193458655139375688174332680"
    }
}
