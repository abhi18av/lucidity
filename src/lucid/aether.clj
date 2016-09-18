(ns lucid.aether
  (:require [lucid.aether
             [artifact :as artifact]
             [local-repo :as local]
             [session :as session]
             [system :as system]
             [request :as request]
             [result :as result]]))

(defonce +defaults+
  {:repositories {"central" {:name "central"
                             :url "http://central.maven.org/maven2/"}
                  "clojars" {:name "clojars"
                             :url "http://clojars.org/repo"}}})

(defrecord Aether [])

(defmethod print-method Aether
  [v w]
  (.write w (str "#aether" (into {} v))))

(defn aether
  ([] (map->Aether +defaults+))
  ([config] (map->Aether ())))

(defn flatten-values
  [node]
  (cond (map? node)
        (cons (key (first node))
                    (flatten-values (val (first node))))
        
        (vector? node)
        (mapcat (fn [item]
                  (cond (map? item)
                        (flatten-values item)

                        (vector? item)
                        [item]))
                node)))

(defn resolve-dependencies
  ([coords]
   (resolve-dependencies (aether) coords))
  ([aether coords]
   (let [system  (system/repository-system)
         request (request/dependency-request aether coords)
         session (->> (select-keys aether [:local-repo])
                      (session/session system))]
     (-> (.resolveDependencies system session request)
         (result/summary)
         (flatten-values)
         (set)))))
