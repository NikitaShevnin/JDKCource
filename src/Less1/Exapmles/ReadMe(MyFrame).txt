В данном примере, при создании кнопки "Нажми меня" мы вызываем .addActionListener()
и передаем анонимный класс, реализующий ActionListener. Затем, в методе actionPerformed()
этого анонимного класса, мы выполняем код, который должен быть выполнен при нажатии кнопки.
В данном случае, просто выводим текст в консоль.

Когда пользователь нажимает кнопку, происходит событие, которое вызывает метод
actionPerformed(). Это позволяет вам реагировать на действия пользователя и выполнять
соответствующий код.

Метод .addActionListener() может быть использован для добавления слушателя событий
ActionListener к другим компонентам, таким как меню, флажки, элементы списка и т.д.
Это позволяет разработчикам реагировать на события и обрабатывать их в своих приложениях.