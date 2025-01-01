```scala
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

def processData(data: String)(implicit ec: ExecutionContext): Future[Int] = Future { 
  if (data.isEmpty) throw new IllegalArgumentException("Data cannot be empty")
  data.length 
}.recover { 
  case e: IllegalArgumentException => 0 // Or handle the exception differently
}

object Main extends App {
  implicit val ec = scala.concurrent.ExecutionContext.global

  val futureResult = processData("")

  futureResult.onComplete { 
    case Success(result) => println(s"Success: $result")
    case Failure(exception) => println(s"Failure: ${exception.getMessage}")
  }
  
  Thread.sleep(1000) // Keep the main thread alive to allow the future to complete
  println("Program finished")
}
```