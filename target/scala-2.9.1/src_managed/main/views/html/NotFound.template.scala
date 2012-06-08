
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object NotFound extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(msg: String):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.15*/("""

<!DOCTYPE html>
<html>
    <head>
        <title>Computers database</title>
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*7.70*/routes/*7.76*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*7.119*/(""""> 
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*8.70*/routes/*8.76*/.Assets.at("stylesheets/main.css"))),format.raw/*8.110*/(""""> 
    </head>
    <body>
        <header class="topbar">
            <h1 class="fill">
                <a href=""""),_display_(Seq[Any](/*13.27*/routes/*13.33*/.Application.index())),format.raw/*13.53*/("""">
                    404: Resource Not Found
                </a>
            </h1>
        </header>
        
        <section id="main">
            <p>"""),_display_(Seq[Any](/*20.17*/msg)),format.raw/*20.20*/("""</p>
        </section>
        
    </body>
</html>"""))}
    }
    
    def render(msg:String) = apply(msg)
    
    def f:((String) => play.api.templates.Html) = (msg) => apply(msg)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jun 07 16:13:46 CST 2012
                    SOURCE: I:/play2project/computer-database/app/views/NotFound.scala.html
                    HASH: 702058e9c0cea1c2294e3dbedac221fd42e444c5
                    MATRIX: 508->1|598->14|786->167|800->173|865->216|974->290|988->296|1044->330|1200->450|1215->456|1257->476|1457->640|1482->643
                    LINES: 19->1|22->1|28->7|28->7|28->7|29->8|29->8|29->8|34->13|34->13|34->13|41->20|41->20
                    -- GENERATED --
                */
            