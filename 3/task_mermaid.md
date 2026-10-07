# Mermaid: примеры блок-схем, графиков и диаграмм

Каждый пример — отдельный блок ```` ```mermaid ````. Файл открывается в GitHub, GitLab, Obsidian, VS Code (с расширением Markdown Preview Mermaid Support) и на mermaid.live.

## Оглавление

1. Блок-схемы (flowchart)
2. Диаграмма последовательности (sequence)
3. Диаграмма классов (class)
4. Диаграмма состояний (state)
5. ER-диаграмма
6. Пользовательский путь (journey)
7. Диаграмма Ганта
8. Круговая диаграмма (pie)
9. Квадрантная диаграмма
10. Диаграмма требований
11. Git-граф
12. Ментальная карта (mindmap)
13. Временная шкала (timeline)
14. Sankey
15. XY-график (столбцы и линии)
16. Блочная диаграмма
17. Пакетная диаграмма
18. Канбан
19. Архитектурная диаграмма
20. C4-диаграмма

---

## 1. Блок-схемы (flowchart)

### 1.1. Базовая схема

```mermaid
flowchart TD
    A([Начало]) --> B[Ввод данных]
    B --> C{Данные верны?}
    C -- Да --> D[Обработка]
    C -- Нет --> E[Сообщение об ошибке]
    E --> B
    D --> F[/Вывод результата/]
    F --> G([Конец])
```

### 1.2. Направления: LR, RL, TB, BT

```mermaid
flowchart LR
    A[Слева] --> B[Направо] --> C[Конец]
```

### 1.3. Все формы узлов

```mermaid
flowchart LR
    n1[Прямоугольник]
    n2(Скруглённый)
    n3([Стадион])
    n4[[Подпрограмма]]
    n5[(База данных)]
    n6((Круг))
    n7>Флажок]
    n8{Ромб}
    n9{{Шестиугольник}}
    n10[/Параллелограмм/]
    n11[\Параллелограмм наоборот\]
    n12[/Трапеция\]
    n13[\Трапеция наоборот/]
    n14(((Двойной круг)))
    n1 --> n2 --> n3 --> n4
    n5 --> n6 --> n7 --> n8
    n9 --> n10 --> n11 --> n12 --> n13 --> n14
```

### 1.4. Типы связей

```mermaid
flowchart LR
    A --> B
    A --- C
    A -.-> D
    A ==> E
    A -- текст --> F
    A -. пунктир .-> G
    A == жирная ==> H
    A --o I
    A --x J
    A <--> K
    A ~~~ L
```

### 1.5. Подграфы (subgraph)

```mermaid
flowchart TB
    subgraph Клиент
        direction LR
        U[Пользователь] --> UI[Интерфейс]
    end
    subgraph Сервер
        direction LR
        API[API] --> DB[(База)]
    end
    UI --> API
    DB --> UI
```

### 1.6. Стилизация

```mermaid
flowchart LR
    A[Успех]:::ok --> B[Внимание]:::warn --> C[Ошибка]:::err
    classDef ok fill:#c8e6c9,stroke:#2e7d32,color:#000
    classDef warn fill:#fff9c4,stroke:#f9a825,color:#000
    classDef err fill:#ffcdd2,stroke:#c62828,color:#000
    linkStyle 0 stroke:#2e7d32,stroke-width:3px
```

### 1.7. Алгоритм: чётное или нечётное

```mermaid
flowchart TD
    S([Старт]) --> IN[/Ввести n/]
    IN --> C{n mod 2 = 0?}
    C -- Да --> E[/Вывести: чётное/]
    C -- Нет --> O[/Вывести: нечётное/]
    E --> F([Конец])
    O --> F
```

### 1.8. Цикл

```mermaid
flowchart TD
    A([Старт]) --> B[i = 1, s = 0]
    B --> C{i <= 10?}
    C -- Да --> D[s = s + i]
    D --> E[i = i + 1]
    E --> C
    C -- Нет --> F[/Вывести s/]
    F --> G([Конец])
```

---

## 2. Диаграмма последовательности (sequence)

```mermaid
sequenceDiagram
    autonumber
    actor U as Пользователь
    participant B as Браузер
    participant S as Сервер
    participant D as База данных

    U->>B: Открывает страницу
    B->>S: GET /profile
    activate S
    S->>D: SELECT * FROM users
    D-->>S: Данные пользователя
    S-->>B: 200 OK (JSON)
    deactivate S
    B-->>U: Показывает профиль

    Note over B,S: Соединение по HTTPS

    alt Пользователь авторизован
        S-->>B: Данные профиля
    else Нет авторизации
        S-->>B: 401 Unauthorized
    end

    loop Каждые 30 секунд
        B->>S: Проверка обновлений
    end

    par Параллельно
        S->>D: Записать лог
    and
        S->>B: Отправить ответ
    end
```

---

## 3. Диаграмма классов (class)

```mermaid
classDiagram
    class Animal {
        <<abstract>>
        +String name
        +int age
        +makeSound() void
        +move() void
    }
    class Dog {
        +String breed
        +makeSound() void
        +fetch() void
    }
    class Cat {
        +bool isIndoor
        +makeSound() void
    }
    class Owner {
        +String fullName
        +adopt(Animal a) void
    }
    class Shelter {
        -List~Animal~ animals
        +addAnimal(Animal a) void
    }

    Animal <|-- Dog : наследование
    Animal <|-- Cat
    Owner "1" --> "0..*" Animal : владеет
    Shelter o-- Animal : агрегация
    Shelter *-- Owner : композиция
```

---

## 4. Диаграмма состояний (state)

```mermaid
stateDiagram-v2
    [*] --> Ожидание
    Ожидание --> Загрузка : запрос
    Загрузка --> Успех : данные получены
    Загрузка --> Ошибка : таймаут
    Ошибка --> Загрузка : повтор
    Успех --> [*]

    state Загрузка {
        [*] --> Соединение
        Соединение --> Передача
        Передача --> [*]
    }

    state fork_state <<fork>>
    Успех --> fork_state
    fork_state --> Кэш
    fork_state --> Лог

    note right of Ошибка
        После 3 ошибок
        показываем сообщение
    end note
```

---

## 5. ER-диаграмма

```mermaid
erDiagram
    STUDENT ||--o{ ENROLLMENT : "записан"
    COURSE ||--o{ ENROLLMENT : "включает"
    TEACHER ||--o{ COURSE : "ведёт"
    GROUP ||--|{ STUDENT : "состоит из"

    STUDENT {
        int id PK
        string full_name
        string email UK
        int group_id FK
    }
    COURSE {
        int id PK
        string title
        int hours
        int teacher_id FK
    }
    ENROLLMENT {
        int student_id FK
        int course_id FK
        int grade
    }
    TEACHER {
        int id PK
        string full_name
    }
    GROUP {
        int id PK
        string name
    }
```

---

## 6. Пользовательский путь (journey)

```mermaid
journey
    title Покупка в интернет-магазине
    section Поиск
      Открыть сайт: 5: Клиент
      Найти товар: 4: Клиент
    section Выбор
      Прочитать отзывы: 3: Клиент
      Добавить в корзину: 5: Клиент
    section Оплата
      Ввести данные: 2: Клиент
      Оплатить: 3: Клиент, Банк
    section Доставка
      Получить заказ: 5: Клиент, Курьер
```

---

## 7. Диаграмма Ганта

```mermaid
gantt
    title План проекта
    dateFormat YYYY-MM-DD
    axisFormat %d.%m
    excludes weekends

    section Анализ
    Сбор требований      :done,    a1, 2026-10-01, 5d
    Проектирование       :active,  a2, after a1, 7d

    section Разработка
    Backend              :         b1, after a2, 14d
    Frontend             :         b2, after a2, 12d
    Интеграция           :crit,    b3, after b1, 5d

    section Тестирование
    Тесты                :         c1, after b3, 7d
    Релиз                :milestone, c2, after c1, 0d
```

---

## 8. Круговая диаграмма (pie)

```mermaid
pie showData
    title Время за день
    "Учёба" : 8
    "Сон" : 7
    "Игры" : 3
    "Спорт" : 1
    "Прочее" : 5
```

---

## 9. Квадрантная диаграмма

```mermaid
quadrantChart
    title Приоритизация задач
    x-axis Низкая срочность --> Высокая срочность
    y-axis Низкая важность --> Высокая важность
    quadrant-1 Сделать сразу
    quadrant-2 Запланировать
    quadrant-3 Отложить
    quadrant-4 Делегировать
    Экзамен: [0.85, 0.9]
    Курсовая: [0.4, 0.8]
    Соцсети: [0.7, 0.2]
    Уборка: [0.2, 0.3]
```

---

## 10. Диаграмма требований

```mermaid
requirementDiagram
    requirement login_req {
        id: 1
        text: Пользователь должен входить по логину и паролю
        risk: high
        verifymethod: test
    }
    functionalRequirement session_req {
        id: 1.1
        text: Сессия истекает через 30 минут
        risk: medium
        verifymethod: inspection
    }
    element auth_module {
        type: module
        docref: auth.md
    }

    login_req - contains -> session_req
    auth_module - satisfies -> login_req
```

---

## 11. Git-граф

```mermaid
gitGraph
    commit id: "init"
    commit id: "README"
    branch develop
    checkout develop
    commit id: "feature A"
    commit id: "feature B"
    branch hotfix
    checkout hotfix
    commit id: "fix bug"
    checkout main
    merge hotfix tag: "v1.0.1"
    checkout develop
    commit id: "feature C"
    checkout main
    merge develop tag: "v1.1.0"
```

---

## 12. Ментальная карта (mindmap)

```mermaid
mindmap
  root((Информационные системы))
    Программирование
      Python
      SQL
      Алгоритмы
    Базы данных
      Реляционные
      NoSQL
    Математика
      Линейная алгебра
      Дискретная математика
    Английский
      Grammar
      Vocabulary
```

---

## 13. Временная шкала (timeline)

```mermaid
timeline
    title История языков программирования
    1957 : Fortran
    1972 : C
    1991 : Python
    1995 : Java
         : JavaScript
    2009 : Go
    2015 : Rust 1.0
```

---

## 14. Sankey

```mermaid
sankey-beta

Зарплата,Аренда,30
Зарплата,Еда,25
Зарплата,Транспорт,10
Зарплата,Накопления,20
Зарплата,Развлечения,15
```

---

## 15. XY-график (столбцы и линия)

```mermaid
xychart-beta
    title "Продажи по месяцам"
    x-axis [янв, фев, мар, апр, май, июн]
    y-axis "Тыс. руб." 0 --> 100
    bar [20, 35, 50, 45, 70, 90]
    line [20, 35, 50, 45, 70, 90]
```

---

## 16. Блочная диаграмма

```mermaid
block-beta
    columns 3
    A["Frontend"] B["Backend"] C["База данных"]
    D["Интернет"]:3
    A --> B
    B --> C
```

---

## 17. Пакетная диаграмма

```mermaid
packet-beta
    0-15: "Порт источника"
    16-31: "Порт назначения"
    32-63: "Порядковый номер"
    64-95: "Номер подтверждения"
    96-99: "Смещение"
    100-105: "Резерв"
    106-111: "Флаги"
    112-127: "Окно"
```

---

## 18. Канбан

```mermaid
kanban
  todo[К выполнению]
    t1[Написать конспект]
    t2[Подготовить доклад]
  doing[В работе]
    t3[Лабораторная по SQL]
  done[Готово]
    t4[Сдать реферат]
```

---

## 19. Архитектурная диаграмма

```mermaid
architecture-beta
    group cloud(cloud)[Облако]

    service web(server)[Веб-сервер] in cloud
    service api(server)[API] in cloud
    service db(database)[База данных] in cloud
    service disk(disk)[Хранилище] in cloud

    web:R --> L:api
    api:R --> L:db
    db:B -- T:disk
```

---

## 20. C4-диаграмма

```mermaid
C4Context
    title Система учёта студентов
    Person(student, "Студент", "Смотрит расписание и оценки")
    Person(teacher, "Преподаватель", "Выставляет оценки")
    System(portal, "Учебный портал", "Веб-приложение")
    System_Ext(mail, "Почтовый сервис", "Отправка уведомлений")

    Rel(student, portal, "Использует")
    Rel(teacher, portal, "Использует")
    Rel(portal, mail, "Отправляет письма")
```

---

> Примечание: типы с суффиксом `-beta` (sankey, xychart, block, packet, architecture) и `kanban`, `C4Context` появились в новых версиях Mermaid. Если диаграмма не отрисовывается, обновите Mermaid или проверьте код на mermaid.live.
