package org.dfb.sparkPrj

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession

object DataOpsApp extends App{
  val (inputFile, outputFile) = (args(0), args(1))

    println(s"INPUT : ${inputFile}")
    println(s"OUTPUT : ${outputFile}")

val spark = SparkSession
  .builder()
  .appName("Spark SQL basic example")
  .getOrCreate()

import spark.implicits._

  //def load(sc : SparkContext, filename:String) : \/[String, Tabular[Option[String]]] =
  import org.apache.hadoop.fs.{FileSystem, Path}
  import scalaz.{Scalaz, -\/, \/, \/-}

  def delimeter : Char = ','

  object logger{
    def info(o : Object): Unit = {println(0)}
  }

  def extractNext(delimeter: Char, remaining : List[Char]) :(List[Char], Option[List[Char]]) =
    remaining match{
      case Nil => (List.empty, None)
      case remaining =>
        ( remaining.takeWhile(_ != delimeter),
          remaining.dropWhile(_ != delimeter) match {
            case Nil => None
            case remaining => Some(remaining.tail)
          }
        )
    }



  def splitRow(delimeter : Char, row: String) : Seq[Option[String]] = {
    import Scalaz._

    unfold(Some(row.toList) : Option[List[Char]]) {
      case Some(remaining : List[Char]) => Some(extractNext(delimeter, remaining))
      case None => none
    } map {
      case Nil => None
      case chars => Some(String.valueOf(chars.toArray))
    } toList

  }


  def split(row:String) : Seq[Option[String]] = splitRow(delimeter, row)


  val blockSize :Int = 128
  val fileName = "sparkfiles/data/csv/2008.csv"
  val fs = FileSystem.get(sc.hadoopConfiguration)
  val path = new Path(fileName)

  val fileSize = fs.getFileStatus(path).getLen
  logger.info(s"file size : $fileName = $fileSize")

  val numPartition = (fileSize/(blockSize * 1020 * 1024)).toInt + 1

  val _data  = sc.textFile(fileName)

  val data = _data.repartition(numPartition)


  val startRows = _data.take(1).toList

  def isStartRow(row: String) = startRows.exists(row == _)

  val headerRow = split(startRows.last).toList.map(r => r.getOrElse(""))

  val dataRows = data.filter(isStartRow(_)).map()
}



