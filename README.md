# ToDo管理システムのバックエンド

## 機能概要
 - ログイン・ログアウト機能
 - 通常のCRUD
 - ToDoのステータス管理
 - 認証・認可機能


## 技術スタック
当システムは以下の構成で対応する

frontend：React JS

backend：Java SpringBoot


## システムの起動方法
以下の手順でシステムを起動してください

```
$ pwd
todo-management
$ cd docker
$ docker compose up
```

## システムの終了方法・volumeの除去
以下の手順でシステムを終了してください

```
$ pwd
todo-management
$ cd docker
$ docker compose down
# volumeを削除する場合（sqlの情報を更新する場合など）は以下のコマンドを実行
$ docker compose down --volume
```


## ディレクトリ構成
```
todo-management
  ┣ docker ... Docker環境に関するファイルを格納
  ┃  ┣ conf
  ┃  ┃  ┗ my.cnf
  ┃  ┣ .env
  ┃  ┣ docker-compose.yml
  ┃  ┗ Dockerfile
  ┣ oas ... Swaggerに関するファイルを格納
  ┃  ┣ api
  ┃  ┃  ┣ common
  ┃  ┃  ┃  ┗ common.yml
  ┃  ┃  ┗ titodo_todo.yml
  ┃  ┗ config.json
  ┣ sql ... MySQLに関するDDL・DMLのファイルを格納
  ┃  ┗ init.sql ... DDLファイル
  ┣ src ... java sourceに関するファイルを格納
  ┃  ┣ main
  ┃  ┃  ┣ java
  ┃  ┃  ┃  ┣ domain ... Domainに関するパッケージを格納
  ┃  ┃  ┃  ┃  ┣ dao ... MyBatisに接続するMapperを格納する
  ┃  ┃  ┃  ┃  ┣ entity ... MyBatisGeneratorで生成されたentityを格納、基本的にDBのテーブルと1:1となる
  ┃  ┃  ┃  ┃  ┣ injector ... Dto→Entity(Model)、Entity(Model)→Dtoの変換を実行
  ┃  ┃  ┃  ┃  ┣ model ... entityでは表現仕切れない
  ┃  ┃  ┃  ┃  ┗ repository ... DBに接続するためのInterfaceを格納
  ┃  ┃  ┃  ┗ service
  ┃  ┃  ┃     ┣ usecase ... ControllerとRepositoryを繋げるファイルを格納、Repositoryと1:1となる
  ┃  ┃  ┃     ┃  ┗ common ... 特例のControllerと関係なく共通で実装する
  ┃  ┃  ┃     ┗ damainservice ... ビジネスロジックを格納する、Controllerと1:1となる
  ┃  ┃  ┃        ┗ common ... 特定のControllerと関係なく共通で実装するビジネスロジック
  ┃  ┃  ┣ respurces ... MyBatisを用いたDBアクセスに関連するファイルを格納
  ┃  ┃  ┗ restapi ... openApiGenerateで生成されたAPIのInterfaceを格納
  ┃  ┗ test
  ┃  ┃  ┣ java
  ┃  ┃  ┣ respurces
  ┃  ┃  ┗ restapi
  ┣ .gitignore
  ┣ build.gradle ... gradleの設定周りのファイル
  ┣ gradlew ... GradleWrapperスクリプト、非Gradle環境下でもgradleコマンドを実行するのと同様のビルドが実行可能となる
  ┣ README.md ... 本ファイル
  ┗ settings.gradle ... build.gradleから読み込まれる設定情報のファイル
```