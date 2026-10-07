#!/bin/sh
# Создание структуры папок для веб-проекта
mkdir -p my-project/css my-project/js
touch my-project/index.html my-project/css/style.css my-project/js/script.js
echo "Структура создана:"
find my-project | sort
