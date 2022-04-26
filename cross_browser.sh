#!/bin/bash
mvn test -DxmlFile=smoke_parallel.xml -Dbrowser=edge
mvn test -DxmlFile=smoke_parallel.xml -Dbrowser=chrome
mvn test -DxmlFile=smoke_parallel.xml -Dbrowser=firefox