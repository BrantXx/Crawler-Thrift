#Install Java lib files(cd lib/java && ant)
#Generate Java thrift file with "thrift -out . --gen java crawler.thrift"
#Generate PHP thrift file with "thrift -out . --gen php crawler.thrift"
#Compile Java with "javac -cp "lib/java/build/lib/*:lib/java/build/*" *.java"
#Run Server/Client
    #Java Server : "java -cp "lib/java/build/lib/*:lib/java/build:." Server"
    #Java Client : "java -cp "lib/java/build/lib/*:lib/java/build:." Client"
    #PHP Client : "php Client.php"

struct crawlStruct{
  1: string startingUrl;
  2: i32 maxUrlsToCrawl;
  3: string requestId;
}

service Crawl {
  void crawl(1:crawlStruct param);
}
