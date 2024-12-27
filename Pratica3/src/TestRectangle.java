class Point {
    int x, y;

    Point() {
        x = y = 0;
    }

    Point(int x0, int y0) {
        x = x0;
        y = y0;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class Rectangle{
    Point infEsquerdo;
    Point supDireito;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public Rectangle(Point var1, Point var2){
        this.infEsquerdo = var1;
        this.supDireito = var2;
    }

    public int perimeter(){
        int var1 = supDireito.y - infEsquerdo.y;
        int var2 = supDireito.x - infEsquerdo.x;
        return ((2*var1) + (2*var2));
    }

    public int area(){
        int var1 = supDireito.y - infEsquerdo.y;
        int var2 = supDireito.x - infEsquerdo.x;
        return (var1 * var2);
    }

    public boolean pointInside(Point ponto){
        return ((ponto.x >= infEsquerdo.x && ponto.x <= supDireito.x && ponto.y >= infEsquerdo.y && ponto.y <= supDireito.y));
    }

    public boolean rectangleInside(Rectangle rec){
        return (rec.infEsquerdo.x >= infEsquerdo.x && rec.infEsquerdo.y >= infEsquerdo.y && rec.supDireito.x <= supDireito.x && rec.supDireito.y <= supDireito.y );
    }
}
class TestRectangle {
    public static void main(String[] args) {
        Point a = new Point(1,1);
        Point b = new Point(2,2);
        Point c = new Point(3,4);
        Point d = new Point(8,2);

        Rectangle amarelo  = new Rectangle(a, c);
        Rectangle laranja  = new Rectangle(2, 3, 9, 6);
        Rectangle verde    = new Rectangle(3, 4, 4, 5);
        Rectangle azul     = new Rectangle(5, 1, 6, 5);
        Rectangle vermelho = new Rectangle(7, 3, 9, 5);

        System.out.println("Perimetro do retangulo amarelo = " + amarelo.perimeter()); // 10
        System.out.println("Perimetro do retangulo laranja = " + laranja.perimeter()); // 20

        System.out.println("Area do retangulo amarelo = " + amarelo.area()); // 6
        System.out.println("Area do retangulo laranja = " + laranja.area()); // 21

        System.out.println("Ponto B dentro rectangulo amarelo? " + amarelo.pointInside(b)); // true
        System.out.println("Ponto D dentro rectangulo amarelo? " + amarelo.pointInside(d)); // false

        System.out.println("Retangulo verde dentro do laranja? " + laranja.rectangleInside(verde));       // true
        System.out.println("Retangulo azul dentro do laranja? " + laranja.rectangleInside(azul));         // false
        System.out.println("Retangulo vermelho dentro do laranja? " + laranja.rectangleInside(vermelho)); // true
    }
}
