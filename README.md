# jpa-bootstrap

## 1단계 - Metadata
### 요구사항 1 - @Entity 엔터티 어노테이션이 있는 클래스만 가져오기
- AnnotationBinder
  - 상위패키지에 있는 @Entity가 달린 클래스를 모두 scan한다.
  - 패키지에 클래스를 찾을 수 없는 경우 빈 list를 반환한다.
  - 패키지에 entity 클래스를 찾을 수 없는 경우 빈 list를 반환한다.

### 요구사항 2 - scanner 로 찾은 Entity Class 정보를 통해 MetamodelImpl 에 데이터를 채워넣어보자
- MetaModel
  - AnnotationBinder를 통해 값을 세팅할 수 있다.
    - Map<Class<?>, EntityClass> entityClassMap = new ConcurrentHashMap<>();
