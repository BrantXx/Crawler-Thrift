import org.apache.thrift.TException;
import java.util.ArrayList;
import java.util.List;

public class CrawlHandler implements Crawl.Iface {
  @Override
  public void crawl(crawlStruct param) throws org.apache.thrift.TException {
    System.out.println(param);
  }
  @Override
  public void crawlList(List<crawlStruct> paramList) throws org.apache.thrift.TException {
    for(crawlStruct x : paramList){
      System.out.println(x);
    }
  }
}
