## 基于学校实验的后台管理系统

采用前后端分离的方式，在网页上可进行对数据表的操作

#### 技术栈

前端主要采用的是 vue

后端采用的是 springboot 框架

#### 运行方法

先在前端项目中，输入以下指令安装必要依赖
```
npm install
```

然后使用 IDEA 打开后端项目运行，再输入以下指令运行前端
```sh
npm run dev
```
前提当然要先创建好数据表

创建 users 表：
```sql
CREATE TABLE IF NOT EXISTS users (
        username varchar(10) NOT NULL,
        pass varchar(8) NOT NULL,
        PRIMARY KEY (username));
```

创建 person 表：
```sql
CREATE TABLE IF NOT EXISTS person (
        username varchar(10) NOT NULL,
        name varchar(20) NOT NULL,
        age int,
        teleno char(11),
        PRIMARY KEY (username));
```