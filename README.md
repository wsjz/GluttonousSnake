# GluttonousSnake
贪吃蛇小实现<br>

关键问题<br>

蛇怎样移动？<br>
:GameController根据用户键盘按键事件得到方向 -> Grid改变方向，Snake移动（头部增加结点，尾部删除结点），创建新的Food -> GameView重绘制Gird上面的Snake和Food位置<br>

蛇怎么吃食物？(初次实现用方法二)<br>
方法一:蛇头与食物相邻，把食物所在结点添加到蛇身<br>
方法二:蛇移动到食物所在位置，就把移动时删除的尾部再添加回来<br>
