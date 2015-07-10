package controllers

import play.api.libs.concurrent.Execution.Implicits.defaultContext

import play.api.mvc.Accepting
import play.api.mvc.Action
import play.api.mvc.Controller

import resources.ResultGenerator.getResult

object v1 extends Controller {

  val RDF = "application/rdf+xml"
  val Turtle = "text/turtle"
  val N3 = "text/n3"
  val JSON = "application/json"

  val AcceptsRDFXML = Accepting(RDF)
  val AcceptsTurtle = Accepting(Turtle)
  val AcceptsN3 = Accepting(N3)

  /**
   * @TODO write some scaladoc
   */
  def index = Action.async { implicit request =>
    scala.concurrent.Future {
      render {
        case Accepts.Json() => getResult(JSON)
        case AcceptsRDFXML() => getResult(RDF).withHeaders("Content-Type" -> (RDF + "; charset=utf-8"))
        case AcceptsTurtle() => getResult(Turtle).withHeaders("Content-Type" -> (Turtle + "; charset=utf-8"))
        case AcceptsN3() => getResult(N3).withHeaders("Content-Type" -> (N3 + "; charset=utf-8"))
      }
    }
  }
}
