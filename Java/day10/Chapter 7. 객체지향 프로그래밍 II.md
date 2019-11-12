# Chapter 7. 객체지향 프로그래밍 II

- heterogeneous

 Shape s = new Triangle

 new Rectangle

 new Circle

- polymorphism(다형성_

  Shape shape = Triangle ...

  의미는 같지만 표현되어지는 게 다름.!

  getArea함수를 불러도 객체가 삼각형인지 원인지에 다라 달라짐!

  하나의 메세지에 대해 각 클래스가 가지고 있는 고유한 방법으로 응답할 수 있는 능력

  - 현업에서 자바를 쓰는 이유

    약속하고 만들 수 있어서!

## 1.4 단일 상속

## 1.5 Object 클래스- 모든 클래스의 조상

모든 클래스들은 자동적으로 Object 클래스로부터 상속받게 함.

toString도 Object의 메소드인데 매번 여기에 오버라이딩하는 것

## 2. 오버라이딩

## 2.1 오버라이딩이란?

```
inheritance관계여야 함.
자손 클래스에서 조상 클래스의 메서드를 재정의하는 것을 말함.
(리턴타입, 함수 매개변수 타입 다 같아야 함)
```

## 2.2 오버라이딩의 조건

- 이름이 같아야 한다.

- 매개변수가 같아야 한다.

- 반환타입이 같아야 한다.

- 조상 클래스의 메서드를 자손 클래스에서 오버라이딩할 때

  ```
  1. 접근 제어자를 조상 클래스의 메서드보다 좁은 범위로 변경 불가능
  2. 예외는 조상 클래스의 메서드보다 많이 선언할 수 없음.
  3. 인스턴스메서드를 static메서드 또는 그 반대로 변경할 수 없다.
  
     static은 오버라이딩할 수 없음.
  ```

## 2.3 오버로딩 vs. 오버라이딩

## 2.4 super

하위 클래스에서 상위 클래스에 있는 함수를 호출할 때 사용함.

super. 하면 상위 클래스에 있는 함수를 다 쓸 수 있음.

# 3. package와 import

## 3.1 패키지(package)

java.lang 패키지는 import 안 해도 됨. 그러나 나머지는 import해줘야 함.

## 3.2 패키지의 선언

package 패키지명;

<- 이런 식으로 선언

## 3.3 import 문

## 3.4 import 문의 선언

- 일반적인 소스파일의 구성

1. package 문
2. import 문
3. 클래스 선언

- import문을 선언하는 방법

  ```
  import 패키지명.클래스명;
  or
  import 패키지명.*;
  ```

- import 사용(이 편이 퍼포먼스가 더 빠름)

  ```
  import java.util.Calender;
  import java.util.Date;
  import java.util.ArrayList;
  ```

- import문을 쓰지 않는 경우

  ```
  java.util.Date today = new java.util.Date();
  java.text.SimpleDateFormat date
  		  = new java.text.SimpleDateFormat("yyyy/MM/dd");
  java.text.SimpleDateFormat time
  		  = new java.text.SimpleDateFormat("hh:mm:ss a");
  ```

## 3.5 static import 문

static import문을 사용하면 static 멤버를 호출할 때 클래스 이름을 생략 가능

```
import static java.lang.Integer.*; //Intger 클래스의 모든 static 케서드
import static java.lang.Math.random; //괄호 안 붙여도 됨.
import static java.lang.System.out; //System.out을 out만으로 참조 가능
```

# 4. 제어자(modifier)

## 4.1 제어자란?

제어자; 클래스, 변수 또는 메서드의 선언부에 함께 사용 -> 부가적 의미 부여

접근 제어자, 그 외의 제어자로 나뉨

접근 제어자; public, protected, default, private

그 외; static, final, ...

instance :객체, static: 클래스

## 4.2 static-클래스의, 공통적인

static; '클래스의' 또는 '공통적인'의 의미를 가짐.

 클래스변수는 인스턴스에 관계없이 같은 값을 가짐.

static이 사용될 수 있는 곳-멤버변수, 메섣, 초기화 블럭

## 4.3 final- 마지막의, 변경될 수 없는

final; '마지막의' 또는 '변경될 수 없는'의 의미를 가짐

 모든 대상에 사용 가능, 오버라이딩할 수 없음.(함수의 경우)

 상속할 수 없음(클래스의 경우)

## 4.4 abstract - 추상의, 미완성의

abstract: '미완성'의 의미를 가짐. 메서드의 선언부만 작성, 실제 수행내용은 구현하지 않은 추상 메서 드를 선언하는데 사용

## 4.5 접근 제어자

protected; 같은 패키지 내에서 사용 가능, 자손 클래스에서 접근 가능

default: 같은 패키지 내에서만 접근이 가능

함수에서도 private을 씀.(자손 클래스에서 해당사항이 없을 때)

- 접근 제어자를 이용한 캡슐화(사용하는 이유)

  외부로부터 데이터 보호

  외부에는 불필요한 내부적으로만 사용되는 부분 감추려고

## 4.6 제어자의 조합

1. 메서드에 static과 abstract를 함께 사용할 수 없다.

static은 오버라이딩 안 됨

1. abstract와 final을 동시에 사용할 수 없다.

abstract는 상속, final은 상속 안 됨.

1. abstract메서드의 접근 제어자가 private일 수 없다.

   자손 클래스에서 접근 못함.

2. 메서드에 private과 final을 같이 사용할 필요 없다.

   private메서드는 오버라이딩 안 됨

# 5. 다형성(polymorphism)

## 5.1 다형성이란?

여러 가지 형태를 가질 수 있는 능력을 의미

자바에서는 한 타입의 참조변수로 여러 타입의 객체를 참조할 수 있도록 함

-> 다형성을 프로그램적으로 구현

-> 조상클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조할 수 있게 함

자손타입-> 조상타입:형변환 생략가능 Shape s = new Circle()

자손타입<- 조상타입:형변환 생략 불가 Circle c = (Circle)shape

객체가 어느 곳에 속했는지 알고 싶을 때, instanceof 라는 것을 씀.

...

## 5.5 매개변수의 다형성

제품 종류마다 메서드를 써주는 게 있는데 하나 변경될 때마다 계속 다 변경해주지 않고

이런 식으로 변경

```
void buy(Product p){
    money=money-p.price;
    bonusPoint=bonusPoint+p.bonusPoint;
}
```

그러나 현실세계에서는 specialization이 있으므로 아주 골때림.

-> 새로운 기술!

## 5.6 여러 종류의 객체를 배열로 다루기

```
//heterogenous
Product p[] = new Product[3];
p[0]=new Tv();
p[1]=new Computer();
p[2]=new Audio();
```

그런데 현업에선 객체배열 잘 안씀(배열의 단점 때문에)

- Abstraction

- Interface

- Generic

- Collection API

  배열 같은 경우 한계가 있음.

  1. SET - 중복 불가, 순서 없음

  1111을 집어넣으면 1만 들어감.

  1. LIST - 순서 있음, 속도 느림
  2. Hash - Key, Value

  이 세 개는 최상위 클래스

Set이라는 애는 기능만 정의(고유한 기능들..!, abstract class 같음)

java.util 패키지에 있음.