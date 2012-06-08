package controllers

import org.squeryl.PrimitiveTypeMode._
import play.api.Logger
import views._
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._
import play.api._

trait SquerylController extends Controller{

    def TxAction(f: Request[AnyContent] => Result) = {
        Action {request =>
            try{
                inTransaction {
                    Logger.info("Calling action in squery transation manager.")
                    f(request)
                }
            }catch {
                case ex => NotFound(html.NotFound(ex.getMessage()))
            }
        }
    }
}