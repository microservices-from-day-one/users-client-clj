(ns users-service.api.users-api
  (:require [users-service.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn users-api-index-with-http-info
  "Returns all users' data
  Returns all users' data"
  []
  (call-api "/users" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       []
             :auth-names    []}))

(defn users-api-index
  "Returns all users' data
  Returns all users' data"
  []
  (:data (users-api-index-with-http-info)))

(defn users-api-create-with-http-info
  "Creates a new user for the given data
  Creates a new user for the given data"
  ([email password ] (users-api-create-with-http-info email password nil))
  ([email password {:keys [name ]}]
   (call-api "/users" :post
             {:path-params   {}
              :header-params {}
              :query-params  {"email" email "name" name "password" password }
              :form-params   {}
              :content-types []
              :accepts       []
              :auth-names    []})))

(defn users-api-create
  "Creates a new user for the given data
  Creates a new user for the given data"
  ([email password ] (users-api-create email password nil))
  ([email password optional-params]
   (:data (users-api-create-with-http-info email password optional-params))))

(defn users-api-show-with-http-info
  "Returns a user's data for a given user by uuid
  Returns a user's data for a given user by uuid"
  [id ]
  (call-api "/users/{id}" :get
            {:path-params   {"id" id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       []
             :auth-names    []}))

(defn users-api-show
  "Returns a user's data for a given user by uuid
  Returns a user's data for a given user by uuid"
  [id ]
  (:data (users-api-show-with-http-info id)))
