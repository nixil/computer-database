
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
object createForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Computer],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(computerForm: Form[Computer]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.f) }};
Seq[Any](format.raw/*1.32*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.75*/(""" 

"""),_display_(Seq[Any](/*7.2*/main/*7.6*/ {_display_(Seq[Any](format.raw/*7.8*/("""
    
    <h1>Add a computer</h1>
    
    """),_display_(Seq[Any](/*11.6*/form(routes.Application.save())/*11.37*/ {_display_(Seq[Any](format.raw/*11.39*/("""
        
        <fieldset>
            """),_display_(Seq[Any](/*14.14*/inputText(computerForm("name"), '_label -> "Computer name"))),format.raw/*14.73*/("""
            """),_display_(Seq[Any](/*15.14*/inputText(computerForm("introduced"), '_label -> "Introduced date"))),format.raw/*15.81*/("""
            """),_display_(Seq[Any](/*16.14*/inputText(computerForm("discontinued"), '_label -> "Discontinued date"))),format.raw/*16.85*/("""

            """),_display_(Seq[Any](/*18.14*/select(
                computerForm("company"), 
                Company.options, 
                '_label -> "Company", '_default -> "-- Choose a company --",
                '_showConstraints -> false
            ))),format.raw/*23.14*/("""
            

        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Create this computer" class="btn primary"> or 
            <a href=""""),_display_(Seq[Any](/*30.23*/routes/*30.29*/.Application.list())),format.raw/*30.48*/("""" class="btn">Cancel</a> 
        </div>
        
    """)))})),format.raw/*33.6*/("""
    
""")))})))}
    }
    
    def render(computerForm:Form[Computer]) = apply(computerForm)
    
    def f:((Form[Computer]) => play.api.templates.Html) = (computerForm) => apply(computerForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jun 07 17:18:50 CST 2012
                    SOURCE: I:/play2project/computer-database/app/views/createForm.scala.html
                    HASH: 5b077858a82fbde1494e9b432791119b2d5172f0
                    MATRIX: 518->1|633->52|665->76|744->31|772->50|800->125|838->129|849->133|887->135|966->179|1006->210|1046->212|1124->254|1205->313|1255->327|1344->394|1394->408|1487->479|1538->494|1777->711|1996->894|2011->900|2052->919|2138->974
                    LINES: 19->1|22->5|22->5|23->1|25->4|26->5|28->7|28->7|28->7|32->11|32->11|32->11|35->14|35->14|36->15|36->15|37->16|37->16|39->18|44->23|51->30|51->30|51->30|54->33
                    -- GENERATED --
                */
            