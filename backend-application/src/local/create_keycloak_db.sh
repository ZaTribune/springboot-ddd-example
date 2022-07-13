#!/bin/bash

set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE USER keycloak WITH ENCRYPTED PASSWORD 'keycloak';
	CREATE DATABASE keycloak_db;
	GRANT ALL PRIVILEGES ON DATABASE keycloak_db TO keycloak;
EOSQL