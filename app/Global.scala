import akka.actor.PoisonPill

import play.libs.Akka

import play.api.Application
import play.api.GlobalSettings
import play.api.Logger
import play.api.mvc.WithFilters

import play.filters.gzip.GzipFilter

object Global extends WithFilters(new GzipFilter()) with GlobalSettings {

  override def onStart(app: Application) {
    Logger.info("Application has started")
    /* @TODO Place your init code here */
  }

  override def onStop(app: Application) {
    Logger.info("Application shutdown...")
    /* @TODO Place your exit code here */
    Akka.system.actorSelection("*").tell(PoisonPill, null)
  }
}
