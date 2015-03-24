cd D:\Documents\Kurse\DistributedSystems\Teaching\06_WebServices2\06_WebServices2

1) async
========
wsimport -b custom1.xml -keep -p ch.fhnw.ds.ws.currency.jaxws -d bin -s src http://www.webservicex.com/CurrencyConvertor.asmx?wsdl


2) unwrapped
============
wsimport -b custom2.xml -keep -p ch.fhnw.ds.ws.currency.jaxws.unwrapped -d bin -s src http://www.webservicex.com/CurrencyConvertor.asmx?wsdl

