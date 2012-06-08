import play.api._
import org.squeryl.adapters.H2Adapter
import org.squeryl.{Session, SessionFactory}
import play.api.db.DB
import org.squeryl.PrimitiveTypeMode._
import models.Company
import java.io.FileInputStream
import models.Computer

object Global extends GlobalSettings {

    override def onStart(app: Application) {
        implicit val _app = app
        Logger.info("Initializing squeryl session factory.")
        SessionFactory.concreteFactory = Some(() => 
            Session.create(DB.getConnection(), new H2Adapter)
        )
        Logger.info("Application has started")

        if (app.mode== Mode.Dev || app.mode == Mode.Test) refreshDBSchema
    }
    
    def refreshDBSchema(implicit app:Application) = inTransaction {
        import com.codahale.jerkson.Json._
        import models.ComputerBase._
        
        Logger.info("Dropping db schema")
        drop
        Logger.info("Creating db schema")
        create
        Logger.info("Dumping initial data")
        
        val companiesJson = app.getFile("conf/init-data/company.json")

        for(company <- stream[Company](new FileInputStream(companiesJson))) {
            company.save
        }
        val computersJson = app.getFile("conf/init-data/computer.json")
                
        for(computer <- stream[Computer](new FileInputStream(computersJson))) {
            computer.save
        }
        
    }

    override def onStop(app: Application) {
        Logger.info("Application has stopped")
    }
}