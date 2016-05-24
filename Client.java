import org.apache.thrift.TException;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;

public class Client {
  public static void main(String [] args) {

    crawlStruct crawlToServer = new crawlStruct("starting_url",20,"request_id");

    try {
       TTransport transport;
       transport = new TSocket("localhost", 9090);
       transport.open();
       TProtocol protocol = new TBinaryProtocol(transport);
       Crawl.Client client = new Crawl.Client(protocol);
       client.crawl(crawlToServer);
       transport.close();
    } catch (TException x) {
      x.printStackTrace();
    }
  }
}
