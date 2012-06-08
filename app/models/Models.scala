package models

import java.util.{Date}
import org.squeryl.KeyedEntity
import org.squeryl.Schema
import org.squeryl.PrimitiveTypeMode._

case class Company(id: Long,
                    name: String) extends KeyedEntity[Long] {
    
    lazy val computers = ComputerBase.companyToComputer.left(this).toList
}

case class Computer(id: Long,
                    name: String,
                    introduced: Option[Date],
                    discontinued: Option[Date],
                    companyId: Option[Long] = None) extends KeyedEntity[Long] {
    
    def this() = this(0, "", Some(new Date()), Some(new Date()), Some(0L)) 
    
    lazy val company = ComputerBase.companyToComputer.right(this).headOption.getOrElse(Company.unknown)
}

/**
 * Helper for pagination.
 */
case class Page[A](items: Seq[A], page: Int, offset: Long, total: Long) {
    lazy val prev = Option(page - 1).filter(_ >= 0)
    lazy val next = Option(page + 1).filter(_ => (offset + items.size) < total)
}

object ComputerBase extends Schema {
    val companies = table[Company]("company")
    val computers = table[Computer]("computer")
    
    val companyToComputer = oneToManyRelation(companies, computers)
                                .via((company,computer) => computer.companyId === company.id )
}

object Computer {
    
    import ComputerBase._

    def list(page: Int, orderBy: Int, pageSize: Int = 10, filter:String = "%") = {
        val offset    = pageSize * page
        val items     = computers.page(offset, pageSize).where(c => c.name like filter).toSeq
        val totalRows = computers.count(c => true)
        Page(items, page, offset, totalRows)
    }
    
}

object Company {
    val unknown = Company(0L, "Unknown")

    lazy val options = {
        ComputerBase.companies.toSeq.map(c => c.id.toString -> c.name )
    }
}
