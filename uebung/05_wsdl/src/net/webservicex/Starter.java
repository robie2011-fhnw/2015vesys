package net.webservicex;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.ws.BindingProvider;

public class Starter {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		CurrencyConvertor service = new CurrencyConvertor();
		CurrencyConvertorSoap port = service.getCurrencyConvertorSoap();
		BindingProvider bp = (BindingProvider) port;
		
		bp.getRequestContext()
			.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8080/CurrencyConverter.asmx?wsdl");
		
		double conversionRate = port.conversionRate(Currency.CHF, Currency.USD);
		System.out.println(conversionRate);
	}

}
