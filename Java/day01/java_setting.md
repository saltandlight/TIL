##  System setting
Program Download

1. Java - JDK(Java Development tool Kit)
   java.sun.com
   java -version
2. Eclipse - UI Development Tool
   [www.eclipse.org](http://www.eclipse.org/)
3. Workspace
   프로그램 개발을 위한 디렉토리

코딩:

소프트웨어 실행되게 하기 위해서
이걸 만들기 위한 게 코딩

내가 뭐라고 썼는지 서로가 알게 하기 위한 게 코딩
그래서 코딩은 알파벳으로 되어있음.

컴파일: 컴퓨터가 알아듣게 소스를 번역
컴파일하면 기계가 안다.

내 맘대로 할 수가 없다.
자바를 만든 사람의 규칙이 있음.

트렌드:
지금의 코딩은 상당히 레귤레이션하게 코딩을 진행해야 함.

이클립스 실행 시 OS 조사를 해서 JDK가 있는지 확인!
소프트웨어가 커질수록 내가 만드는 코딩 문서는 많아짐.

워크스페이스 안에는 여러 개의 객체들이 있음.
프로젝트는 하나하나의 단위이다.

탐색기 하나=> 프로젝트 하나

eclipse는 OS에 jdk확인하고 함.
Prospective 확인 필요 없음.

프로젝트 안을 보면 src 가 있음.(코딩하라는 뜻)
자바는 'lib'가 장점,
라이브러리 안에서 대부분을 코딩할 수 있음.

자바는 TCP.IP라이브러리가 제공되어서 거기에있는 내용으로 코딩하면
쉽게 코딩이 가능함.

라이브러리에 있는 내용을 가지고 코딩을 한다.!(중요)

파이썬은 라이브러리 제공이 안 됨.
인터넷에서 찾아야 함.

1. Project

Java Programming

1. What is Java?

- Java vs C
- Java vs JavaScript

Oracle - Producrt and Training -> Documentation(자바에 대한 정보)

1. Development Environment

- JDK & Eclipse

1. Java Program

- variable

  1. primitive type(기본형)

  - char
  - boolean
  - number

  1. refrenece type
  2. 

- operator

- if, while, for(제어문)

- oop(function, 객체 등)

자바는 소스를 저장하자마자 컴파일을 한다.
컴파일 후에는 어셈블리어로 자동 번역
-> 컴퓨터가 인식
실행할 때는 클래스 파일이 실행이 된다.(클래스 파일로 바로 바뀜)

start point:

```java 
public static void main(String [] args)
```

여기가 스타트 포인트라고 제임스 구슬링이 정의함.

자바프로그래밍은 클래스 안에서만 코딩을 하게 되고,
시작점이 필요하다.
시작점; public static void main(String [] args)
이 앞에 있는 애들이 사용되지 않으면 의미가 없다.

```java
package day01;

public class Hello {
    int a;
	int b;
	public static void main(String [] args) {
		System.out.printf("Hello Java");
	}
	int c;
}
    
```

프로그램 컴파일, 실행
vj card 가 모니터에 쏨.
모니터로 출력한 내용이 콘솔에 찍히는 것

이 아이는 시작되자 마자 끝남.
public static void main 부분이 실행되고 바로 프로세스가 죽음.(종료)

패키지가 day01이므로 이 패키지 밑에 있는 클래스인 것.
-> bin 폴더 밑에 패키지 이름 밑에 클래스가 존재함.

java -classpath c:\java\day01\bin day01.Hello

ch01. 변수(Variable)

Variable1.java-----------------------------------------------------------

```java 
package day01;

//Java Application
public class Variable1 {
    public static void main(String[] args) {
	int a = 10; //Initialization
	int b = 20; //a,b가 메모리에 올라감.
	int c = 20;
	
	int temp = 0;
	/*min
	if(a < b) {
		temp = a;
		if(c < temp) temp=c;
	}
	else {
		temp = b;
		if(c < temp) temp=c;
	} 
	
	*/
	
	if(a < b) {
		temp=b;
		if(temp < c) temp = c;
	}
	else {
		temp=a;
		if(temp < c) temp=c;
	}
	
	System.out.println(temp);
	//7~10 line이 차례로 움직임
}
}
```

------

1. Java Programming
   -variable
   연산은 인트로 진행임.

   ```java
   package day01;
   
   public class Variable2 {
   public static void main(String[] args) {
   boolean b = true;
   char c = '한'; //Unicode 값이 들어감.
   byte by = 127;
   short sh = 10;
   int i1= 1200000000; //default
   int i2= 1200000000;
   int i = 20; //default
   long ll = 10;
   ll = i1+i2;
   	
   	System.out.println(ll);
   
   }
   
   }
   ```

이 경우 int 2개를 더했으나 24억이 되므로 32바이트 까지만 되고 짤림
이럴 경우 덧셈을 하기 전에 long 으로 바꾸고 계산

------

```java 
package day01;

public class Variable2 {
public static void main(String[] args) {
boolean b = true;
char c = '한'; //Unicode 값이 들어감.
byte by = 127;
short sh = 10;
int i1= 1200000000; //default
int i2= 1200000000;
int i = 20; //default
long ll = 2200000000000000000L;
//default 가 int형이므로 32바이트로까지만 선언이 됨.(2200000000000000000인 경우)...
//이런 경우 뒤에 L을 붙여서 선언에 에러가 나지 않게 함.
    	ll = (long)(i1+i2);
	System.out.println(ll);

}
}
```

