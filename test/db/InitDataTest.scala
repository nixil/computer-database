package db

import org.junit.Test
import play.api.test._
import play.api.test.Helpers._
import org.junit.Assert
import org.squeryl.SessionFactory
import org.squeryl.Session
import org.squeryl.adapters.H2Adapter
import play.api.db.DB
import models._
import org.squeryl.PrimitiveTypeMode._
import models.ComputerBase._
import anorm._
import anorm.SqlParser._
import org.junit.Assert._
import org.junit.Ignore

class InitDataTest extends SquerylUT{

    @Test def printDDL = withSquerylTx {
        ComputerBase.printDdl
    }
    
    @Test def companiesData = withSquerylTx {
        val companyCount = companies.count( _ => true)
        assertEquals(45, companyCount)
    }
    
    @Test def oneToManyRelation = withSquerylTx {
        val CM_2A = computers.filter( c => c.name.equalsIgnoreCase("CM-2a")).head
        assertEquals("Thinking Machines.", CM_2A.company.name) 
        val produced_by_unknown = computers.filter( c => c.name.equalsIgnoreCase("produced by unknown")).head
        assertEquals("Unknown", produced_by_unknown.company.name) 
    }
    
    @Test def computerData = withSquerylTx {
        val count = computers.count( _ => true)
        assertEquals(15, count)
    }
    
    @Test def listOrderBy = withSquerylTx {
        val first = from(computers)( c => select(c) orderBy(c.name asc)).head
        assertEquals("Apple II Plus", first.name)
        val last = from(computers)( c => select(c) orderBy(c.name desc)).head
        assertEquals("produced by unknown", last.name)
    }
    
    @Test def findNotExisted = withSquerylTx {
        val notExist = computers.where(_.id === Long.MaxValue).headOption
        assertEquals(None, notExist)
    }
    
    @Test def updateComputer = withSquerylTx {
        val computer = Computer(1,"Updated",None,None)
        computer.update
        assertEquals("Updated", computers.where(_.id === 1).single.name)
    }

}