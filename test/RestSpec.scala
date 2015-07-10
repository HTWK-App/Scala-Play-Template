import scala.concurrent.Future

import org.junit.runner.RunWith

import org.specs2.matcher._
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

import play.api.mvc.Result

import play.api.test.FakeRequest
import play.api.test.Helpers._
import play.api.test.WithApplication

@RunWith(classOf[JUnitRunner])
class RestSpec extends Specification {

  "Application" should {

    "respond with NotFound on a bad request" in new WithApplication {
      route(FakeRequest(GET, "/boum")) must beNone
    }

    "respond with JSON (utf-8) by default" in {
      val ContentType = "application/json"

      val result = ???
      checkDefaults(ContentType,result)
    }

    "respond with RDF/XML (utf-8) by request" in {
      val ContentType = "application/rdf+xml"

      val result = ???
      checkDefaults(ContentType,result)
    }

    "respond with Turtle (utf-8) by request" in {
      val ContentType = "text/turtle"

      val result = ???
      checkDefaults(ContentType,result)
    }

    "respond with N3 (utf-8) by request" in {
      val ContentType = "text/n3"

      val result = ???
      checkDefaults(ContentType,result)
    }

    "contain all elements in JSON responses" in {
      val result: Future[Result] = ???
      contentAsString(result) must contain("")
    }
  }

  def checkDefaults(ContentType: String, result: Future[Result]) = {
    status(result) must equalTo(OK)
    charset(result) must beSome("utf-8")
    contentType(result) must beSome(ContentType)
  }
}
