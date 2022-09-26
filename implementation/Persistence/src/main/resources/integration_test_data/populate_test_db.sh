#!/bin/bash

###################################################
# Populate test database
###################################################

dbname=dao_test
scriptdir=$(dirname $0)

echo "SELECT 'CREATE DATABASE ${dbname}' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = '${dbname}')\gexec" | psql
psql -d postgresql://postgres@localhost/${dbname} --file "${scriptdir}"/schema.sql
psql -d postgresql://postgres@localhost/${dbname} --file "${scriptdir}"/test_transaction.sql
