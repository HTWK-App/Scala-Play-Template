package resources

import play.api.mvc.Result
import play.api.mvc.Results.InternalServerError
import play.api.mvc.Results.Ok

import play.api.libs.json.JsObject

object ResultGenerator {

  /**
   * @TODO write some scaladoc
   */
  def getResult(ContentType: String): Result = {

    ContentType match {
      case controllers.v1.JSON =>
        /* @TODO Place your application code here */
        val result: JsObject = ???
        Ok(result).withHeaders("Cache-Control" -> "public, max-age=604800") //in seconds
      case _ =>
        InternalServerError
    }
  }
}
