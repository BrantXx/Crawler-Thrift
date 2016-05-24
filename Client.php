<?php
error_reporting(E_ALL);

require_once __DIR__.'/lib/php/lib/Thrift/ClassLoader/ThriftClassLoader.php';
require_once('Crawl.php');
require_once('Types.php');

use Thrift\ClassLoader\ThriftClassLoader;
use Thrift\Protocol\TBinaryProtocol;
use Thrift\Transport\TSocket;
use Thrift\Transport\THttpClient;
use Thrift\Transport\TBufferedTransport;
use Thrift\Exception\TException;

$GEN_DIR = realpath(dirname(__FILE__));

$loader = new ThriftClassLoader();
$loader->registerNamespace('Thrift', __DIR__ . '/lib/php/lib');
$loader->registerDefinition('Crawl', $GEN_DIR);
$loader->register();

$startingUrl = "starting_url";		# Starting URL
$maxUrlsToCrawl = 20;			# Max Urls to Crawl
$requestId = "request_id";		# Request ID

try {
  $crawlToServer= new crawlStruct();
  $crawlToServer->startingUrl = $startingUrl;
  $crawlToServer->maxUrlsToCrawl = $maxUrlsToCrawl;
  $crawlToServer->requestId = $requestId;
  $socket	= new TSocket('localhost', 9090);
  $transport	= new TBufferedTransport($socket, 1024, 1024);
  $protocol	= new TBinaryProtocol($transport);
  $client	= new CrawlClient($protocol);
  $transport->open();
  $client->crawl($crawlToServer);
  $transport->close();
} catch (TException $tx) {
  print 'TException: '.$tx->getMessage()."\n";
}
?>
