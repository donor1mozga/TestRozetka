# TestRozetka

Выполнение тестового задания по сценарию.


## Сценарий 

Case 1
Main steps:
- Зайти на сайт “https://rozetka.com.ua/”.
- Пререйти в раздел “Смартфоны, ТВ и Электроника”
- перейти в раздел “Мобильные телефоны”
- Применить фильтр “От дешевых к дорогим” и проверить правильность сортировки.
- выбрать с первых трёх страниц поисковой выдачи название и цены всех девайсов с отметкой “Топ Продаж“.
- Записать полученные результаты в txt файл (C:\autodoc\result.txt)

## Стек технологий
* Java - 1.8;
* TestNG - 7.4.0;
* Selenide - 5.22.3;
* Maven - 3.8.1;
* Allure - 2.13.8;


## Шаблон проектирования 
* Page object


## Зависимости
Убедитесь, что в вашей системе установлены [Java](https://www.java.com/ru/) и [Maven](http://maven.apache.org/) , в противном случае следуйте инструкциям поставщика по их установке в вашей операционной системе.

## Запуск тестов

1. Клонируйте этот репозиторий на свой локальный компьютер.
2. Создайте папку "autodoc" на диске C://
2. Откройте терминал и перейдите в корневой каталог репозитория.
   
Используя Maven, вы теперь можете запускать тесты:

1 - Первичный запуск: 
* Команда:  mvn clean install

2 - Запуск тестов;
* Команда: mvn clean test

3 - Запуск демонстрации отчета выполнения тестов
* Команда: allure:serve

## Составление отчетов
 * Отчет последнего запуска тестов, лежит по адресу 
\target\surefire-reports\TestSuite> в формате  HTML и XML.
   
 * Отчет всех запусков тестов, лежит по адресу   
 ${basedir}\allure-results и вызывется командой 'allure:serve'
 
 * Документ с записями лежит по адресу
C://autodoc//result.txt
 




