# SavePos
Minecraft mod for saving player position. You can find coordinates of all your saved positions.

EN-US

NEW in 1.1:
Fixed a bug where any zero-coordinate or zero-tip interfered with the output of not-zero-coordinates with /pos get.

Requirements:
Fabric Loader >= 0.14.21
Fabric API = any

Try a new command - /pos.
Syntax:  /pos [get\set] [cell(integer) 1..32] [tip(string, for "set")]

Example:

You're standing on 17.0x, 64.0y, 20.0z;
You can write:  /pos set 1 HelloWorld
And there's a message in chat:
"Cell 1: 17.0 64.0 20.0
  Tip: HelloWorld"
  
If you forgot these coordinates, try writing:  /pos get 1
Message in chat:
"Cell 1: 17.0 64.0 20.0
  Tip: HelloWorld"

You can save coordinates of your favourite locations in the game and lavel the coordinates so as not to forget.

RU-RU

НОВОЕ в 1.1:
Исправлена ошибка, при которой любая нулевая координата или нулевая пометка мешала выводу ненулевых координат при /pos get.

Требования:
Fabric Loader >= 0.14.21
Fabric API = любой

Попробуйте новую команду - /pos.
Синтаксис:  /pos [get\set] [cell(число) 1..32] [tip(строка, для "set")]

Пример:

Вы стоите на 17.0x, 64.0y, 20.0z;
Вы можете написать:  /pos set 1 ПриветМир
И появится сообщени в чате:
"Ячейка 1: 17.0 64.0 20.0
  Пометка: ПриветМир"
  
Если вы забыли эти координаты, напишите:  /pos get 1
Сообщение в чате:
"Ячейка 1: 17.0 64.0 20.0
  Пометка: ПриветМир"

Вы можете сохранять координаты ваших любимых локаций в игре и давать координатам обозначения, чтобы не забыть.
