# TigerGraph JDBC Driver Sample Code

Simple starting introduction to the TigerGraph JDBC Driver

## Quickstart

1. Install maven and java if not already installed (`brew install maven`)
1. Clone this repository and enter the directory
1. Spin up a TigerGraph on-prem box and create a graph
1. Enter the graph name in [Connect.java](src/main/java/Connect.java)
1. Build the project with maven (`mvn package`)
1. Execute the project (`mvn exec:java -Dexec.mainClass=Connect`)
