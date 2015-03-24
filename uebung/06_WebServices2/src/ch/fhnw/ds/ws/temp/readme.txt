cd D:\Documents\Kurse\DistributedSystems\Teaching\06_WebServices2\06_WebServices2

wsgen -cp bin -keep -s src -d bin ch.fhnw.ds.ws.temp.server.TemperatureConversionsImpl

wsimport -keep -p ch.fhnw.ds.ws.temp.client.jaxws -d bin -s src http://localhost:19876/temp?wsdl

