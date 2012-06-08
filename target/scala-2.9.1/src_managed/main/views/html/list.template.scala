
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
object list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Page[Computer],Int,String,play.api.mvc.Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(currentPage: Page[Computer], currentOrderBy: Int, currentFilter: String)(implicit flash: play.api.mvc.Flash):play.api.templates.Html = {
        _display_ {
def /*16.2*/header/*16.8*/(orderBy: Int, title: String):play.api.templates.Html = {_display_(

Seq[Any](format.raw/*16.41*/("""
    <th class="col"""),_display_(Seq[Any](/*17.20*/orderBy)),format.raw/*17.27*/(""" header """),_display_(Seq[Any](/*17.36*/if(scala.math.abs(currentOrderBy) == orderBy){/*17.83*/{if(currentOrderBy < 0) "headerSortDown" else "headerSortUp"}})),format.raw/*17.144*/("""">
        <a href=""""),_display_(Seq[Any](/*18.19*/link(0, Some(orderBy)))),format.raw/*18.41*/("""">"""),_display_(Seq[Any](/*18.44*/title)),format.raw/*18.49*/("""</a>
    </th>
""")))};def /*6.2*/link/*6.6*/(newPage: Int, newOrderBy: Option[Int] = None) = {{
    routes.Application.list(newPage, newOrderBy.map { orderBy =>
        if(orderBy == scala.math.abs(currentOrderBy)) -currentOrderBy else orderBy
    }.getOrElse(currentOrderBy), currentFilter)
    
}};
Seq[Any](format.raw/*1.111*/("""

"""),format.raw/*5.42*/("""
"""),format.raw/*11.2*/("""

"""),format.raw/*15.37*/("""
"""),format.raw/*20.2*/("""

"""),_display_(Seq[Any](/*22.2*/main/*22.6*/ {_display_(Seq[Any](format.raw/*22.8*/("""
    
    <h1>"""),_display_(Seq[Any](/*24.10*/Messages("computers.list.title", currentPage.total))),format.raw/*24.61*/("""</h1>

    """),_display_(Seq[Any](/*26.6*/flash/*26.11*/.get("success").map/*26.30*/ { message =>_display_(Seq[Any](format.raw/*26.43*/("""
        <div class="alert-message warning">
            <strong>Done!</strong> """),_display_(Seq[Any](/*28.37*/message)),format.raw/*28.44*/("""
        </div>
    """)))})),format.raw/*30.6*/("""

    <div id="actions">
        
        """),_display_(Seq[Any](/*34.10*/helper/*34.16*/.form(action=routes.Application.list())/*34.55*/ {_display_(Seq[Any](format.raw/*34.57*/("""
            <input type="search" id="searchbox" name="f" value=""""),_display_(Seq[Any](/*35.66*/currentFilter)),format.raw/*35.79*/("""" placeholder="Filter by computer name...">
            <input type="submit" id="searchsubmit" value="Filter by name" class="btn primary">
        """)))})),format.raw/*37.10*/("""
        
        <a class="btn success" id="add" href=""""),_display_(Seq[Any](/*39.48*/routes/*39.54*/.Application.create())),format.raw/*39.75*/("""">Add a new computer</a>
        
    </div>
    
    """),_display_(Seq[Any](/*43.6*/Option(currentPage.items)/*43.31*/.filterNot(_.isEmpty).map/*43.56*/ { computers =>_display_(Seq[Any](format.raw/*43.71*/("""
        
        <table class="computers zebra-striped">
            <thead>
                <tr>
                    """),_display_(Seq[Any](/*48.22*/header(2, "Computer name"))),format.raw/*48.48*/("""
                    """),_display_(Seq[Any](/*49.22*/header(3, "Introduced"))),format.raw/*49.45*/("""
                    """),_display_(Seq[Any](/*50.22*/header(4, "Discontinued"))),format.raw/*50.47*/("""
                    """),_display_(Seq[Any](/*51.22*/header(5, "Company"))),format.raw/*51.42*/("""
                </tr>
            </thead>
            <tbody>

                """),_display_(Seq[Any](/*56.18*/computers/*56.27*/.map/*56.31*/ { computer =>_display_(Seq[Any](format.raw/*56.45*/(""" 
                        <tr>
                            <td><a href=""""),_display_(Seq[Any](/*58.43*/routes/*58.49*/.Application.edit(computer.id))),format.raw/*58.79*/("""">"""),_display_(Seq[Any](/*58.82*/computer/*58.90*/.name)),format.raw/*58.95*/("""</a></td>
                            <td>
                                """),_display_(Seq[Any](/*60.34*/computer/*60.42*/.introduced.map(_.format("yyyy MMM dd")).getOrElse/*60.92*/ {_display_(Seq[Any](format.raw/*60.94*/(""" <em>-</em> """)))})),format.raw/*60.107*/("""
                            </td>
                            <td>
                                """),_display_(Seq[Any](/*63.34*/computer/*63.42*/.discontinued.map(_.format("yyyy MMM dd")).getOrElse/*63.94*/ {_display_(Seq[Any](format.raw/*63.96*/(""" <em>-</em> """)))})),format.raw/*63.109*/("""
                            </td>
                            <td>
                                """),_display_(Seq[Any](/*66.34*/computer/*66.42*/.company.name)),format.raw/*66.55*/("""
                            </td>
                        </tr>
                """)))})),format.raw/*69.18*/("""

            </tbody>
        </table>

        <div id="pagination" class="pagination">
            <ul>
                """),_display_(Seq[Any](/*76.18*/currentPage/*76.29*/.prev.map/*76.38*/ { page =>_display_(Seq[Any](format.raw/*76.48*/("""
                    <li class="prev">
                        <a href=""""),_display_(Seq[Any](/*78.35*/link(page))),format.raw/*78.45*/("""">&larr; Previous</a>
                    </li> 
                """)))}/*80.18*/.getOrElse/*80.28*/ {_display_(Seq[Any](format.raw/*80.30*/("""
                    <li class="prev disabled">
                        <a>&larr; Previous</a>
                    </li>
                """)))})),format.raw/*84.18*/("""
                <li class="current">
                    <a>Displaying """),_display_(Seq[Any](/*86.36*/(currentPage.offset + 1))),format.raw/*86.60*/(""" to """),_display_(Seq[Any](/*86.65*/(currentPage.offset + computers.size))),format.raw/*86.102*/(""" of """),_display_(Seq[Any](/*86.107*/currentPage/*86.118*/.total)),format.raw/*86.124*/("""</a>
                </li>
                """),_display_(Seq[Any](/*88.18*/currentPage/*88.29*/.next.map/*88.38*/ { page =>_display_(Seq[Any](format.raw/*88.48*/("""
                    <li class="next">
                        <a href=""""),_display_(Seq[Any](/*90.35*/link(page))),format.raw/*90.45*/("""">Next &rarr;</a>
                    </li> 
                """)))}/*92.18*/.getOrElse/*92.28*/ {_display_(Seq[Any](format.raw/*92.30*/("""
                    <li class="next disabled">
                        <a>Next &rarr;</a>
                    </li>
                """)))})),format.raw/*96.18*/("""
            </ul>
        </div>
        
    """)))}/*100.6*/.getOrElse/*100.16*/ {_display_(Seq[Any](format.raw/*100.18*/("""
        
        <div class="well">
            <em>Nothing to display</em>
        </div>
        
    """)))})),format.raw/*106.6*/("""

        
""")))})),format.raw/*109.2*/("""

            """))}
    }
    
    def render(currentPage:Page[Computer],currentOrderBy:Int,currentFilter:String,flash:play.api.mvc.Flash) = apply(currentPage,currentOrderBy,currentFilter)(flash)
    
    def f:((Page[Computer],Int,String) => (play.api.mvc.Flash) => play.api.templates.Html) = (currentPage,currentOrderBy,currentFilter) => (flash) => apply(currentPage,currentOrderBy,currentFilter)(flash)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jun 07 11:26:01 CST 2012
                    SOURCE: I:/play2project/computer-database/app/views/list.scala.html
                    HASH: 4b4e27a5ffc3ff0997aa0188cab8d7b49318f4fb
                    MATRIX: 542->1|712->609|726->615|823->648|879->668|908->675|953->684|1008->731|1093->792|1150->813|1194->835|1233->838|1260->843|1298->239|1309->243|1594->110|1623->237|1651->497|1681->607|1709->859|1747->862|1759->866|1798->868|1849->883|1922->934|1969->946|1983->951|2011->970|2062->983|2179->1064|2208->1071|2260->1092|2339->1135|2354->1141|2402->1180|2442->1182|2544->1248|2579->1261|2759->1409|2852->1466|2867->1472|2910->1493|3000->1548|3034->1573|3068->1598|3121->1613|3277->1733|3325->1759|3383->1781|3428->1804|3486->1826|3533->1851|3591->1873|3633->1893|3751->1975|3769->1984|3782->1988|3834->2002|3943->2075|3958->2081|4010->2111|4049->2114|4066->2122|4093->2127|4205->2203|4222->2211|4281->2261|4321->2263|4367->2276|4504->2377|4521->2385|4582->2437|4622->2439|4668->2452|4805->2553|4822->2561|4857->2574|4971->2656|5131->2780|5151->2791|5169->2800|5217->2810|5326->2883|5358->2893|5443->2959|5462->2969|5502->2971|5672->3109|5781->3182|5827->3206|5868->3211|5928->3248|5970->3253|5991->3264|6020->3270|6100->3314|6120->3325|6138->3334|6186->3344|6295->3417|6327->3427|6408->3489|6427->3499|6467->3501|6633->3635|6700->3683|6720->3693|6761->3695|6899->3801|6943->3813
                    LINES: 19->1|21->16|21->16|23->16|24->17|24->17|24->17|24->17|24->17|25->18|25->18|25->18|25->18|27->6|27->6|33->1|35->5|36->11|38->15|39->20|41->22|41->22|41->22|43->24|43->24|45->26|45->26|45->26|45->26|47->28|47->28|49->30|53->34|53->34|53->34|53->34|54->35|54->35|56->37|58->39|58->39|58->39|62->43|62->43|62->43|62->43|67->48|67->48|68->49|68->49|69->50|69->50|70->51|70->51|75->56|75->56|75->56|75->56|77->58|77->58|77->58|77->58|77->58|77->58|79->60|79->60|79->60|79->60|79->60|82->63|82->63|82->63|82->63|82->63|85->66|85->66|85->66|88->69|95->76|95->76|95->76|95->76|97->78|97->78|99->80|99->80|99->80|103->84|105->86|105->86|105->86|105->86|105->86|105->86|105->86|107->88|107->88|107->88|107->88|109->90|109->90|111->92|111->92|111->92|115->96|119->100|119->100|119->100|125->106|128->109
                    -- GENERATED --
                */
            