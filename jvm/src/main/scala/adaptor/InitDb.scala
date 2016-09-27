package adaptor

import scalikejdbc._

/**
  * Created by ryota on 2016/08/19.
  */
object InitDb {
  def main(args: Array[String]): Unit = {
    println("InitDb")
    Class.forName("com.mysql.jdbc.Driver")
    ConnectionPool.singleton("jdbc:mysql://127.0.0.1:3306/board", "root", "")
    implicit val session = AutoSession

    /*
    データベースの作成
     */
//    sql"""create database board
//      """.execute.apply()

    /*
    テーブルの生成
     */
//    sql"""create table topics (
//            id serial not null primary key,
//            name varchar(64),
//            created_at timestamp not null
//          )
//      """.execute.apply()
//
//
//    sql"""create table posts (
//            id serial not null primary key,
//            comment_text varchar(64),
//            created_at timestamp not null
//          )
//      """.execute.apply()
//
//    sql"""create table comments (
//            id serial not null primary key,
//            text varchar(64),
//            created_at timestamp not null
//          )
//      """.execute.apply()

  }
}
