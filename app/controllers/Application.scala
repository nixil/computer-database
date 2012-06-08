package controllers

import models._
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._
import play.api._
import views._
import org.squeryl.PrimitiveTypeMode._
import models.ComputerBase._

/**
 * Manage a database of computers
 */
object Application extends SquerylController {

    /**
     * This result directly redirect to the application home.
     */
    val Home = Redirect(routes.Application.list(0, 2, ""))
    
    /**
     * Describe the computer form (used in both edit and create screens).
     */
    val computerForm = Form(
        mapping(
                    "id" -> longNumber,
                  "name" -> nonEmptyText,
            "introduced" -> optional(date("yyyy-MM-dd")),
          "discontinued" -> optional(date("yyyy-MM-dd")),
               "company" -> optional(longNumber)
        )(Computer.apply)(Computer.unapply)
    )

    // -- Actions

    /**
     * Handle default path requests, redirect to computers list
     */
    def index = Action { Home }

    /**
     * Display the paginated list of computers.
     *
     * @param page Current page number (starts from 0)
     * @param orderBy Column to be sorted
     * @param filter Filter applied on computer names
     */
    def list(page: Int, orderBy: Int, filter: String) = TxAction { implicit request =>
        Ok(html.list(
            Computer.list(page = page, orderBy = orderBy, filter = ("%"+filter+"%") ),
            orderBy, filter
        ))
    }

    /**
     * Display the 'edit form' of a existing Computer.
     *
     * @param id Id of the computer to edit
     */
    def edit(id: Long) = TxAction { request =>
        val computer = computers.where(_.id === id).single
        Ok(html.editForm(id, computerForm.fill(computer)))
    }

    /**
     * Handle the 'edit form' submission
     *
     * @param id Id of the computer to edit
     */
    def update(id: Long) = TxAction { implicit request =>
        computerForm.bindFromRequest.fold(
            formWithErrors => BadRequest(html.editForm(id, formWithErrors)),
            computer => {
                computer.update
                Home.flashing("success" -> "Computer %s has been updated".format(computer.name))
            }
        )
    }

    /**
     * Display the 'new computer form'.
     */
    def create = TxAction { implicit request =>
        Ok(html.createForm(computerForm))
    }

    /**
     * Handle the 'new computer form' submission.
     */
    def save = TxAction { implicit request =>
        computerForm.bindFromRequest.fold(
            formWithErrors => BadRequest(html.createForm(formWithErrors)),
            computer => {
                computer.save
                Home.flashing("success" -> "Computer %s has been created".format(computer.name))
            }
        )
    }

    /**
     * Handle computer deletion.
     */
    def delete(id: Long) = TxAction { implicit request =>
        computers.delete(id)
        Home.flashing("success" -> "Computer has been deleted")
    }

}

