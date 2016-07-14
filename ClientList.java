import java.util.ArrayList;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;

public class ClientList {
  public static void main(String [] args) {

    ArrayList<crawlStruct> crawlList = new ArrayList<crawlStruct>();
    crawlStruct list1 = new crawlStruct("starting_url",1,"request_id");
    crawlStruct list2 = new crawlStruct("starting_url",2,"request_id");
    crawlStruct list3 = new crawlStruct("starting_url",3,"request_id");
    crawlStruct list4 = new crawlStruct("starting_url",4,"request_id");
    crawlStruct list5 = new crawlStruct("starting_url",5,"request_id");
    crawlList.add(list1);
    crawlList.add(list2);
    crawlList.add(list3);
    crawlList.add(list4);
    crawlList.add(list5);

    try {
       TTransport transport;
       transport = new TSocket("localhost", 9090);
       transport.open();
       TProtocol protocol = new TBinaryProtocol(transport);
       Crawl.Client client = new Crawl.Client(protocol);
       client.crawlList(crawlList);
       transport.close();
    } catch (TException x) {
      x.printStackTrace();
    }
  }
}
