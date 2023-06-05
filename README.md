# ExtractPic

## MVC

가장 널리 사용되는 소프트웨어 디자인 패턴 중 하나.

애플리케이션을 세 가지 역할(Model, View, Controller)로 구분하는 것

### 각각의 역할

1. **Model**: 애플리케이션의 데이터 로직을 담당한다. 일반적으로 데이터베이스에 저장된 데이터에 대한 CRUD(Create, Read, Update, Delete) 작업을
   처리하며, 이와 관련된 모든 연산이나 데이터 처리를 담당한다.
2. **View**: 이는 사용자에게 보여지는 인터페이스를 의미한다. 데이터의 시각적 표현을 담당하며, 사용자의 액션을 컨트롤러에 전달하는 역할을 한다.
3. **Controller**: 이는 사용자의 요청을 처리하고, 그에 따라 모델과 뷰를 업데이트하는 역할을 한다. 사용자의 입력을 받아 모델의 상태를 변경하거나, 모델의 변경을
   뷰에
   반영하도록 지시한다.

### Android에서 MVC 패턴 적용

1. **Model**: 데이터베이스에 저장된 데이터, 웹 서비스, 내부 저장소 등을 포함하여 앱의 데이터를 관리한다.
2. **View**: 사용자 인터페이스를 구성한다. Android에서는 주로 XML 파일을 이용하여 뷰를 정의하고, 사용자에게 보여지는 화면을 생성하고 업데이트한다.
3. **Controller**: **Android에서 Activity나 Fragment와 같은 컴포넌트가 주로 수행**한다. 사용자의 입력을 받아 모델을 업데이트하고, 데이터
   변경을 뷰에
   반영하도록 지시한다.

### 그러나

Android에서 MVC 패턴의 전통적인 구현은 일부 문제를 야기할 수 있다. **컨트롤러의 역할이 Activity나 Fragment에 의해 수행**되므로, 이러한 컴포넌트들이
너무 많은
책임을 짊어져서 코드가 복잡해지는 경향이 있다.

이를 'Massive View Controller' 문제라고 부르며, 이로 인해 다른 패턴인 MVP(Model-View-Presenter)나 MVVM(
Model-View-ViewModel)이 더 널리 사용되는 경향이 있다.

### 장단점

장점

- 가장 구현하기 쉽고 단순함
- 개발기간이 짧다
- Model과 View를 분리
- Model의 비종속성으로 재사용 가능

단점

- Controller에 많은 코드가 생긴다
- 시간이 지남에 따라 유지보수의 어려움
- View와 Model의 결합도 상승
- 테스트코드 작성의 어려움

## MVP

애플리케이션을 Model, View, Presenter 세 가지 요소로 분리하는 소프트웨어 디자인 패턴

### 각각의 역할

1. Model: 애플리케이션의 데이터와 비즈니스 로직을 캡슐화한다. 이는 애플리케이션의 "상태"를 나타내며, 이는 데이터베이스, 파일 시스템, 웹 서비스 등 다양한 소스에서 올
   수 있다. (데이터 관리, 비지니스 로직 수행)
2. View: 사용자 인터페이스(UI)와 사용자 상호작용을 처리한다. Android에서는 대개 Activity, Fragment 또는 그들의 구성 요소를 의미한다. (유저에게 보일 화면을 표현, Presenter에 의존적)
3. Presenter: Model과 View 사이의 '접착제' 역할을 한다. 이는 Model에서 데이터를 가져와 View에 표시하는 역할을 담당하며, 사용자의 상호 작용을
   처리하고 이를 Model의 상태변경으로 변환한다. (Model과 View를 연결, View에 Interface로 연결)

MVP 패턴의 주요 이점은 관심사의 분리라는 원칙에 따라 코드를 구성할 수 있다는 것이다. 이로 인해 애플리케이션의 다양한 구성 요소를 독립적으로 개발, 테스트 및 유지 관리할 수
있다.

MVP 패턴은 Android 개발에서 흔히 사용되는 패턴 중 하나인데, Android 애플리케이션의 생명주기와 관련된 복잡성을 관리하고 UI 로직과 비즈니스 로직을 명확하게
분리하기 때문이다. 이는 유지 관리하 용이하고, 테스트 가능하며, 코드 재사용성이 높아진다.

### 장점

- View와 Model 간의 의존성이 없음
- UI와 비즈니스 로직 분리
- Unit Test 수월

### 단점

- View와 Presenter가 1:1 관계
- View가 많아지면 Presenter도 많아짐
- 기능이 추가될수록 Presenter가 비대해짐