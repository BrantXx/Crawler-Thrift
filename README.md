# Crawler-Thrift

## Requirements
Thrift compiler, Java and Apache Ant.

**PHP 5.6 is required if running PHP client.**

## Installation

### Ubuntu
sudo apt install thrift-compiler ant

### Thrift From Source
https://thrift.apache.org/docs/install/

### After Installing Thrift
- Clone the repo
- Navigate into lib/java/
- Run ant

## Usage
  1. Generate Java thrift file
    - ``` thrift -out . --gen java crawler.thrift ```
  2. **(optional)** Generate PHP thrift file
    - ``` thrift -out . --gen php crawler.thrift ```
  3. Compile Java
    - ``` javac -cp "lib/java/build/lib/*:lib/java/build/*" *.java ```
  4. Run Server/Client
    - Java Server
      - ``` java -cp "lib/java/build/lib/*:lib/java/build:." Server ```
    - Java Client
      - ``` java -cp "lib/java/build/lib/*:lib/java/build:." Client ```
    - PHP Client
      - ``` php Client.php ```
