## Notes regarding keycloak deployment

### Database
* Keycloak is integrated with the main postgres instance of our backend, but connected to a different database.  
* Keycloak can access this database via a dedicated user.  
* Both Keycloak's user and database are initialized within this script file [create_keycloak_db](create_keycloak_db.sh) and mounted on start.
* Scripts in `/docker-entrypoint-initdb.d` are only run if you start 
the container with a data directory that is empty; any pre-existing database 
will be left untouched on container startup.   
* One common problem is that if one of your `/docker-entrypoint-initdb.d`
scripts fails (which will cause the entrypoint script to exit) and your orchestrator restarts the container with the already initialized data directory, it will not continue on with your scripts.

* Any `*.sql` files will be executed by `POSTGRES_USER`, which defaults to the postgres **superuser**. So it is recommended that any `psql` commands that are run inside a `*.sh` script be executed
as `POSTGRES_USER` by using the `--username "$POSTGRES_USER"` flag.  
* This newly created user is supposed to be able to connect without a password due to the presence of
trust authentication for Unix socket connections made inside the container (**tested and failed -> needs a password on user creation**).

### Initial Configuration
* This file [realm-export.json](keycloak-init/realm-export.json) is used as a backup for realm configuration. It can be loaded from the admin console.