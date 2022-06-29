# TigerGraph JDBC Driver Sample Code

Sample code for using and executing the TigerGraph JDBC Driver for a Fraud Detection Graph

## Overview

This project is a sample repository on how to use the JDBC Driver to query the AMLSim graph. 

## Quickstart

1. Install maven and java if not already installed (`brew install maven`)
1. Clone this repository and enter the directory
1. Spin up a TigerGraph on-prem box and create the AMLSim TigerGraph Graph
1. Build the project with maven (`mvn package`)
1. Execute the project (`mvn exec:java -Dexec.mainClass=Connect`)
