import org.apache.thrift.TException;
public class CrawlHandler implements Crawl.Iface {
  @Override
    public void crawl(crawlStruct param) throws org.apache.thrift.TException {
      System.out.println(param);
    }
}
