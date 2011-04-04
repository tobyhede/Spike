(ns spike.middleware.logging
  (:require [clojure.contrib.logging :as logging]))


(defn- log [msg & vals]
  (let [line (apply format msg vals)]
    (logging/info line)
  )
)

(defn wrap-logging [handler]
  (fn [{:keys [request-method uri] :as req}]
    (let [resp (handler req)]
      (log "%s %s" request-method uri)
        resp)))

