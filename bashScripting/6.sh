#!/bin/sh
# Генератор случайного пароля из 8 символов
pass=$(LC_ALL=C tr -dc 'A-Za-z0-9' < /dev/urandom | head -c 8)
echo "Пароль: $pass"
