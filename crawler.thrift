struct crawlStruct{
  1: string startingUrl
  2: i32 maxUrlsToCrawl
  3: string requestId
}

service Crawl {
  void crawl(1: crawlStruct param)
  void crawlList(1: list<crawlStruct> paramList)
}
