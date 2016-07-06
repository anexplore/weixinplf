#!/bin/bash

mvn post-clean
mvn install -Dmaven.test.skip=true
