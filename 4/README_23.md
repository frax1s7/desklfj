# Bash scripting

Самостоятельная работа по Bash-программированию.
Выполнено в VS Code + Git-Bash и Ubuntu WSL. Все скрипты лежат в папке [`bashScripting`](bashScripting).

## Скрипты

| Файл | Описание |
|------|----------|
| `1.sh` | Спрашивает имя и выводит приветствие |
| `2.sh` | Калькулятор суммы двух чисел |
| `3.sh` | Проверка числа на чётность |
| `4.sh` | Создаёт структуру папок для веб-проекта |
| `5.sh` | Считает количество строк в файле |
| `6.sh` | Генератор случайного пароля из 8 символов |
| `7.sh` | Поиск файлов по расширению в текущей папке |
| `10.sh` | GitHub Repository Analyzer: статистика репозитория с цветным выводом |

## Запуск

В Git-Bash:

```bash
cd bashScripting
sh 1.sh
sh 2.sh
sh 3.sh
sh 4.sh
sh 5.sh файл.txt
sh 6.sh
sh 7.sh txt
```

`10.sh` запускается в Ubuntu WSL (нужен `curl`):

```bash
sudo apt install curl
chmod +x 10.sh
./10.sh tensorflow/tensorflow
```

## Скриншоты

### 1.sh: приветствие
![1](/4/screenshots/Screenshot_1.png)

### 2.sh: сумма
![2](/4/screenshots/Screenshot_2.png)

### 3.sh: чётность
![3](/4/screenshots/Screenshot_3.png)

### 4.sh: структура проекта
![4](/4/screenshots/Screenshot_4.png)

### 5.sh: счётчик строк
![5](/4/screenshots/Screenshot_5.png)

### 6.sh: генератор паролей
![6](/4/screenshots/Screenshot_6.png)

### 7.sh: поиск файлов
![7](/4/screenshots/Screenshot_7.png)

### 8.sh: GitHub Repository Analyzer
![8](/4/screenshots/Screenshot_8.png)

## Как работает 10.sh

- проверяет наличие `curl` (без `jq` и других внешних библиотек);
- запрашивает данные через публичный GitHub API;
- звёзды выводятся жёлтым, форки зелёным, issues красным (если больше 100) или жёлтым;
- обрабатывает ошибки: неверный репозиторий (404), превышение лимита (403/429), нет интернета.
