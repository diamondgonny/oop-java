package academy.pocu.comp2500.lab2;

public class ComplexNumber {
    public double real;
    public double imaginary;

    // 매개변수 수가 적은 생성자에서, 매개변수 수가 많은 생성자를 호출하는 방식
    public ComplexNumber(double real, double imaginary) {
        // this(real, imaginary); <- Error, Recursive constructor invocation
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber(double real) {
        this(real,0.0);
    }

    public ComplexNumber() {
        this(0.0,0.0);
    }

    // 클래스와 달리, 기본자료형은 참조형이 아닌 값형 (feat. equals())
    public boolean isReal() {
        return this.imaginary == 0.0;
    }

    public boolean isImaginary() {
        return this.real == 0.0;
    }

    public ComplexNumber getConjugate() {
        return new ComplexNumber(real, imaginary * -1);
    }

    // 새로운 개체(ComplexNumber)를 만들어서, 복소수의 사칙연산 결과를 반환함
    public ComplexNumber add(ComplexNumber num) {
        return new ComplexNumber(this.real + num.real, this.imaginary + num.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber num) {
        return new ComplexNumber(this.real - num.real, this.imaginary - num.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber num) {
        ComplexNumber product = new ComplexNumber();
        product.real = this.real * num.real - this.imaginary * num.imaginary;
        product.imaginary = this.real * num.imaginary + this.imaginary * num.real;
        return product;
    }

    public ComplexNumber divide(ComplexNumber num) {
        ComplexNumber quotient = new ComplexNumber();
        ComplexNumber boonja = this.multiply(num.getConjugate());
        quotient.real = boonja.real / (num.real * num.real + num.imaginary * num.imaginary);
        quotient.imaginary = boonja.imaginary / (num.real * num.real + num.imaginary * num.imaginary);
        return quotient;
    }
}
