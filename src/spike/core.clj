(ns spike.core
  (:use [ring.adapter.jetty])
  (:require [spike.middleware.logging :as logging]))

; (use 'ring.adapter.jetty)


; (def application-routes
;   (-> rts
;     logging/wrap-logging))


(defn core-app [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "Test"})

(def app (logging/wrap-logging core-app))


; (run-jetty app {:port 8080})
