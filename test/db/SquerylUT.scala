package db

import play.api.test.FakeApplication
import play.api.test._
import play.api.test.Helpers._
import org.squeryl.PrimitiveTypeMode._
import org.junit.Assert._

trait SquerylUT {

    val app = FakeApplication(additionalConfiguration = inMemoryDatabase());
    
    def withSquerylTx[T](block: => T) = running(app)(inTransaction(block))
    
}