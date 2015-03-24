cd D:\Documents\Kurse\DistributedSystems\Teaching\06_WebServices2\06_WebServices2

wsgen -cp bin -keep -s src -d bin ch.fhnw.ds.ws.graph.server.GraphServiceImpl

wsimport -keep -p ch.fhnw.ds.ws.graph.client.jaxws -d bin -s src http://localhost:9877/graph?wsdl


