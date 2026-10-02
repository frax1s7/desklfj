#!/bin/sh
# Поиск файлов по расширению. Запуск: sh 7.sh txt
if [ -z "$1" ]; then
  echo "Укажи расширение, например: sh 7.sh txt"
  exit 1
fi
find . -type f -name "*.$1"
